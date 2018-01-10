package com.mapbox.services.android.navigation.testapp.old;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.services.android.navigation.testapp.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class NavigationApplication extends Application {

  private static final String LOG_TAG = NavigationApplication.class.getSimpleName();
  private static final String DEFAULT_MAPBOX_ACCESS_TOKEN = "pk.eyJ1IjoiYWxpa2hvc2hyYWZ0YXIiLCJhIjoiY2o1eDBxcjZwMGV3ejM0cWw5dG12bmpkMiJ9.DdlQAVKqK5T79uUknkL4lg";

  @Override
  public void onCreate() {
    super.onCreate();

    // Leak canary
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    // Set access token
    String mapboxAccessToken = Utils.getMapboxAccessToken(getApplicationContext());
    if (TextUtils.isEmpty(mapboxAccessToken) || mapboxAccessToken.equals(DEFAULT_MAPBOX_ACCESS_TOKEN)) {
      Log.w(LOG_TAG, "Warning: access token isn't set.");
    }

    Mapbox.getInstance(getApplicationContext(), DEFAULT_MAPBOX_ACCESS_TOKEN);
  }

}
