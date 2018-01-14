package com.mapbox.services.android.navigation.testapp.main;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.exceptions.InvalidLatLngBoundsException;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerMode;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin;
import com.mapbox.mapboxsdk.style.layers.RasterLayer;
import com.mapbox.mapboxsdk.style.sources.RasterSource;
import com.mapbox.mapboxsdk.style.sources.TileSet;
import com.mapbox.services.Constants;
import com.mapbox.services.android.navigation.testapp.R;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationViewOptions;
import com.mapbox.services.android.navigation.ui.v5.listeners.NavigationListener;
import com.mapbox.services.android.navigation.ui.v5.listeners.RouteListener;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.ui.v5.route.OnRouteSelectionChangeListener;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.mapbox.services.android.telemetry.location.LocationEngine;
import com.mapbox.services.android.telemetry.location.LocationEngineListener;
import com.mapbox.services.android.telemetry.location.LostLocationEngine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.services.android.telemetry.location.LocationEnginePriority.HIGH_ACCURACY;

public class NavigationViewActivity extends AppCompatActivity implements OnMapReadyCallback,
        MapboxMap.OnMapLongClickListener, LocationEngineListener, Callback<DirectionsResponse>,OnRouteSelectionChangeListener,NavigationListener,RouteListener,View.OnClickListener,MapboxMap.OnMapClickListener{

    private static final int CAMERA_ANIMATION_DURATION = 1000;

    private LocationLayerPlugin locationLayer;
    private LocationEngine locationEngine;
    private NavigationMapRoute mapRoute;
    private MapboxMap mapboxMap;
    private NavigationViewOptions navigationViewOptions;

    @BindView(R.id.mapViewMain)
    MapView mapViewMain;
    @BindView(R.id.btnStartNavigation)
    Button btnStartNAvigation;

    private Marker currentMarker;
    private Point currentLocation;
    private Point destination;
    private DirectionsRoute route;
    private RasterSource webMapSource;

    private boolean locationFound;
    private boolean shouldSimulateRoute = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        ButterKnife.bind(this);
        mapViewMain.onCreate(savedInstanceState);
        mapViewMain.getMapAsync(this);
        navigationViewOptions = NavigationViewOptions.builder()
                .navigationListener(this)
                .routeListener(this)
                .build();

        btnStartNAvigation.setOnClickListener(this);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng point) {
        destination = Point.fromLngLat(point.getLongitude(), point.getLatitude());
        setCurrentMarkerPosition(point);
        if (currentLocation != null) {
            fetchRoute();
        }
    }

    private void fetchRoute() {
        NavigationRoute.builder()
                .accessToken(Mapbox.getAccessToken())
                .origin(currentLocation)
                .destination(destination)
                .alternatives(true)
                .baseUrl("http://route.map.ir/")
                .build()
                .getRoute(this);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        this.mapboxMap.setOnMapLongClickListener(this);
        initMap();
        initLocationEngine();
        initLocationLayer();
        initMapRoute();

    }

    private void initMap() {

        for (int i = 0; i < mapboxMap.getLayers().size(); i++) {
            mapboxMap.removeLayer(mapboxMap.getLayers().get(i));
        }

        for (int i = 0; i < mapboxMap.getSources().size(); i++) {
            mapboxMap.removeSource(mapboxMap.getSources().get(i));
        }

        for (int i = 0; i < mapboxMap.getAnnotations().size(); i++) {
            mapboxMap.removeAnnotation(mapboxMap.getAnnotations().get(i));
        }

        webMapSource = new RasterSource(
                "web-map-source",
                new TileSet("tileset", "http://map.ir/shiveh?" +
                        "bbox={bbox-epsg-3857}" +
                        "&service=WMS" +
                        "&version=1.1.0" +
                        "&EXCEPTIONS=application/vnd.ogc.se_inimage" +
                        "&request=GetMap" +
                        "&layers=Shiveh:ShivehNOPOI" +
                        "&width=256" +
                        "&height=256" +
                        "&srs=EPSG:3857" +
                        "&format=image/png"), 256);

        mapboxMap.addSource(webMapSource);

        // Add the web map source to the map.
        RasterLayer webMapLayer = new RasterLayer("web-map-layer", "web-map-source");
        mapboxMap.addLayer(webMapLayer);
        mapboxMap.getUiSettings().setLogoEnabled(false);
        mapboxMap.getUiSettings().setCompassEnabled(true);
    }

    @SuppressLint("MissingPermission")
    private void initLocationEngine() {
        locationEngine = new LostLocationEngine(this);
        locationEngine.setPriority(HIGH_ACCURACY);
        locationEngine.setInterval(0);
        locationEngine.setFastestInterval(1000);
        locationEngine.addLocationEngineListener(this);
        locationEngine.activate();

        if (locationEngine.getLastLocation() != null) {
            Location lastLocation = locationEngine.getLastLocation();
            onLocationChanged(lastLocation);
            currentLocation = Point.fromLngLat(lastLocation.getLongitude(), lastLocation.getLatitude());
        }
    }

    @SuppressLint("MissingPermission")
    private void initLocationLayer() {
        locationLayer = new LocationLayerPlugin(mapViewMain, mapboxMap, locationEngine);
        locationLayer.setLocationLayerEnabled(LocationLayerMode.COMPASS);
    }

    private void initMapRoute() {
        mapRoute = new NavigationMapRoute(mapViewMain, mapboxMap, "web-map-layer");
//        mapRoute.setOnRouteSelectionChangeListener(this);
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
        if (validRouteResponse(response)) {
            route = response.body().routes().get(0);
            mapRoute.addRoutes(response.body().routes());
//            boundCameraToRoute();
        }
    }

    private boolean validRouteResponse(Response<DirectionsResponse> response) {
        return response.body() != null && !response.body().routes().isEmpty();
    }

    private void launchNavigationWithRoute() {
        NavigationViewOptions.Builder optionsBuilder = NavigationViewOptions.builder()
                .shouldSimulateRoute(shouldSimulateRoute);
        if (route != null) {
            optionsBuilder.directionsRoute(route);
            NavigationLauncher.startNavigation(this, optionsBuilder.origin(currentLocation).destination(destination).directionsRoute(route).build());
        }
    }

    public void boundCameraToRoute() {
        if (route != null) {
            List<Point> routeCoords = LineString.fromPolyline(route.geometry(),
                    Constants.PRECISION_5).coordinates();
            List<LatLng> bboxPoints = new ArrayList<>();
            for (Point point : routeCoords) {
                bboxPoints.add(new LatLng(point.latitude(), point.longitude()));
            }
            if (bboxPoints.size() > 1) {
                try {
                    LatLngBounds bounds = new LatLngBounds.Builder().includes(bboxPoints).build();
                    animateCameraBbox(bounds, CAMERA_ANIMATION_DURATION, new int[]{50, 500, 50, 335});
                } catch (InvalidLatLngBoundsException exception) {
                    Toast.makeText(this, "Valid route not found.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void animateCameraBbox(LatLngBounds bounds, int animationTime, int[] padding) {
        mapboxMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,
                padding[0], padding[1], padding[2], padding[3]), animationTime);
    }

    @Override
    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

    }

    @SuppressWarnings({"MissingPermission"})
    @Override
    protected void onStart() {
        super.onStart();
        mapViewMain.onStart();
        if (locationLayer != null) {
            locationLayer.onStart();
        }
    }

    @SuppressWarnings({"MissingPermission"})
    @Override
    public void onResume() {
        super.onResume();
        mapViewMain.onResume();
        if (locationEngine != null) {
            locationEngine.addLocationEngineListener(this);
            if (!locationEngine.isConnected()) {
                locationEngine.activate();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mapViewMain.onPause();
        if (locationEngine != null) {
            locationEngine.removeLocationEngineListener(this);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapViewMain.onLowMemory();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapViewMain.onStop();
        if (locationLayer != null) {
            locationLayer.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapViewMain.onDestroy();
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates();
            locationEngine.deactivate();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapViewMain.onSaveInstanceState(outState);
    }

    private void setCurrentMarkerPosition(LatLng position) {
        if (position != null) {
            if (currentMarker == null) {
                MarkerViewOptions markerViewOptions = new MarkerViewOptions()
                        .position(position);
                currentMarker = mapboxMap.addMarker(markerViewOptions);
            } else {
                currentMarker.setPosition(position);
            }
        }
    }

    @Override
    public void onNewPrimaryRouteSelected(DirectionsRoute directionsRoute) {
        route = directionsRoute;
    }

    @Override
    public void onCancelNavigation() {

    }

    @Override
    public void onNavigationFinished() {

    }

    @Override
    public void onNavigationRunning() {

    }

    @Override
    public boolean allowRerouteFrom(Point offRoutePoint) {
        return false;
    }

    @Override
    public void onOffRoute(Point offRoutePoint) {

    }

    @Override
    public void onRerouteAlong(DirectionsRoute directionsRoute) {

    }

    @Override
    public void onFailedReroute(String errorMessage) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartNavigation:
                launchNavigationWithRoute();
                break;
        }
    }

    @Override
    public void onMapClick(@NonNull LatLng point) {

    }
}
