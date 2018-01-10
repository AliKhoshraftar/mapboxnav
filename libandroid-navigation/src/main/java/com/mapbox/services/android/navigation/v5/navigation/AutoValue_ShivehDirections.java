package com.mapbox.services.android.navigation.v5.navigation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Ali on 2018-01-07.
 */

public class AutoValue_ShivehDirections extends ShivehDirections {

    private final String user;
    private final String profile;
    private final String coordinates;
    private final String baseUrl;
    private final String accessToken;
    private final Boolean alternatives;
    private final String geometries;
    private final String overview;
    private final String radius;
    private final String bearing;
    private final Boolean steps;
    private final Boolean continueStraight;
    private final String annotation;
    private final String language;
    private final Boolean roundaboutExits;
    private final String clientAppName;
    private final Boolean voiceInstructions;
    private final Boolean bannerInstructions;
    private final String voiceUnits;
    private final String exclude;

    private AutoValue_ShivehDirections(String user, String profile, String coordinates, String baseUrl, @Nullable String accessToken, @Nullable Boolean alternatives, @Nullable String geometries, @Nullable String overview, @Nullable String radius, @Nullable String bearing, @Nullable Boolean steps, @Nullable Boolean continueStraight, @Nullable String annotation, @Nullable String language, @Nullable Boolean roundaboutExits, @Nullable String clientAppName, @Nullable Boolean voiceInstructions, @Nullable Boolean bannerInstructions, @Nullable String voiceUnits, @Nullable String exclude) {
        this.user = user;
        this.profile = profile;
        this.coordinates = coordinates;
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
        this.alternatives = alternatives;
        this.geometries = geometries;
        this.overview = overview;
        this.radius = radius;
        this.bearing = bearing;
        this.steps = steps;
        this.continueStraight = continueStraight;
        this.annotation = annotation;
        this.language = language;
        this.roundaboutExits = roundaboutExits;
        this.clientAppName = clientAppName;
        this.voiceInstructions = voiceInstructions;
        this.bannerInstructions = bannerInstructions;
        this.voiceUnits = voiceUnits;
        this.exclude = exclude;
    }

    @NonNull
    String user() {
        return this.user;
    }

    @NonNull
    String profile() {
        return this.profile;
    }

    @NonNull
    String coordinates() {
        return this.coordinates;
    }

    @NonNull
    String baseUrl() {
        return this.baseUrl;
    }

    @Nullable
    String accessToken() {
        return this.accessToken;
    }

    @Nullable
    Boolean alternatives() {
        return this.alternatives;
    }

    @Nullable
    String geometries() {
        return this.geometries;
    }

    @Nullable
    String overview() {
        return this.overview;
    }

    @Nullable
    String radius() {
        return this.radius;
    }

    @Nullable
    String bearing() {
        return this.bearing;
    }

    @Nullable
    Boolean steps() {
        return this.steps;
    }

    @Nullable
    Boolean continueStraight() {
        return this.continueStraight;
    }

    @Nullable
    String annotation() {
        return this.annotation;
    }

    @Nullable
    String language() {
        return this.language;
    }

    @Nullable
    Boolean roundaboutExits() {
        return this.roundaboutExits;
    }

    @Nullable
    String clientAppName() {
        return this.clientAppName;
    }

    @Nullable
    Boolean voiceInstructions() {
        return this.voiceInstructions;
    }

    @Nullable
    Boolean bannerInstructions() {
        return this.bannerInstructions;
    }

    @Nullable
    String voiceUnits() {
        return this.voiceUnits;
    }

    @Nullable
    String exclude() {
        return this.exclude;
    }

    public String toString() {
        return "MapboxDirections{user=" + this.user + ", profile=" + this.profile + ", coordinates=" + this.coordinates + ", baseUrl=" + this.baseUrl + ", accessToken=" + this.accessToken + ", alternatives=" + this.alternatives + ", geometries=" + this.geometries + ", overview=" + this.overview + ", radius=" + this.radius + ", bearing=" + this.bearing + ", steps=" + this.steps + ", continueStraight=" + this.continueStraight + ", annotation=" + this.annotation + ", language=" + this.language + ", roundaboutExits=" + this.roundaboutExits + ", clientAppName=" + this.clientAppName + ", voiceInstructions=" + this.voiceInstructions + ", bannerInstructions=" + this.bannerInstructions + ", voiceUnits=" + this.voiceUnits + ", exclude=" + this.exclude + "}";
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof ShivehDirections)) {
            return false;
        } else {
            boolean var10000;
            label173: {
                ShivehDirections that = (ShivehDirections) o;
                if(this.user.equals(that.user()) && this.profile.equals(that.profile()) && this.coordinates.equals(that.coordinates()) && this.baseUrl.equals(that.baseUrl())) {
                    label167: {
                        if(this.accessToken == null) {
                            if(that.accessToken() != null) {
                                break label167;
                            }
                        } else if(!this.accessToken.equals(that.accessToken())) {
                            break label167;
                        }

                        if(this.alternatives == null) {
                            if(that.alternatives() != null) {
                                break label167;
                            }
                        } else if(!this.alternatives.equals(that.alternatives())) {
                            break label167;
                        }

                        if(this.geometries == null) {
                            if(that.geometries() != null) {
                                break label167;
                            }
                        } else if(!this.geometries.equals(that.geometries())) {
                            break label167;
                        }

                        if(this.overview == null) {
                            if(that.overview() != null) {
                                break label167;
                            }
                        } else if(!this.overview.equals(that.overview())) {
                            break label167;
                        }

                        if(this.radius == null) {
                            if(that.radius() != null) {
                                break label167;
                            }
                        } else if(!this.radius.equals(that.radius())) {
                            break label167;
                        }

                        if(this.bearing == null) {
                            if(that.bearing() != null) {
                                break label167;
                            }
                        } else if(!this.bearing.equals(that.bearing())) {
                            break label167;
                        }

                        if(this.steps == null) {
                            if(that.steps() != null) {
                                break label167;
                            }
                        } else if(!this.steps.equals(that.steps())) {
                            break label167;
                        }

                        if(this.continueStraight == null) {
                            if(that.continueStraight() != null) {
                                break label167;
                            }
                        } else if(!this.continueStraight.equals(that.continueStraight())) {
                            break label167;
                        }

                        if(this.annotation == null) {
                            if(that.annotation() != null) {
                                break label167;
                            }
                        } else if(!this.annotation.equals(that.annotation())) {
                            break label167;
                        }

                        if(this.language == null) {
                            if(that.language() != null) {
                                break label167;
                            }
                        } else if(!this.language.equals(that.language())) {
                            break label167;
                        }

                        if(this.roundaboutExits == null) {
                            if(that.roundaboutExits() != null) {
                                break label167;
                            }
                        } else if(!this.roundaboutExits.equals(that.roundaboutExits())) {
                            break label167;
                        }

                        if(this.clientAppName == null) {
                            if(that.clientAppName() != null) {
                                break label167;
                            }
                        } else if(!this.clientAppName.equals(that.clientAppName())) {
                            break label167;
                        }

                        if(this.voiceInstructions == null) {
                            if(that.voiceInstructions() != null) {
                                break label167;
                            }
                        } else if(!this.voiceInstructions.equals(that.voiceInstructions())) {
                            break label167;
                        }

                        if(this.bannerInstructions == null) {
                            if(that.bannerInstructions() != null) {
                                break label167;
                            }
                        } else if(!this.bannerInstructions.equals(that.bannerInstructions())) {
                            break label167;
                        }

                        if(this.voiceUnits == null) {
                            if(that.voiceUnits() != null) {
                                break label167;
                            }
                        } else if(!this.voiceUnits.equals(that.voiceUnits())) {
                            break label167;
                        }

                        if(this.exclude == null) {
                            if(that.exclude() == null) {
                                break label173;
                            }
                        } else if(this.exclude.equals(that.exclude())) {
                            break label173;
                        }
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        }
    }

    public int hashCode() {
        int h = 1;
        h = h * 1000003;
        h ^= this.user.hashCode();
        h *= 1000003;
        h ^= this.profile.hashCode();
        h *= 1000003;
        h ^= this.coordinates.hashCode();
        h *= 1000003;
        h ^= this.baseUrl.hashCode();
        h *= 1000003;
        h ^= this.accessToken == null?0:this.accessToken.hashCode();
        h *= 1000003;
        h ^= this.alternatives == null?0:this.alternatives.hashCode();
        h *= 1000003;
        h ^= this.geometries == null?0:this.geometries.hashCode();
        h *= 1000003;
        h ^= this.overview == null?0:this.overview.hashCode();
        h *= 1000003;
        h ^= this.radius == null?0:this.radius.hashCode();
        h *= 1000003;
        h ^= this.bearing == null?0:this.bearing.hashCode();
        h *= 1000003;
        h ^= this.steps == null?0:this.steps.hashCode();
        h *= 1000003;
        h ^= this.continueStraight == null?0:this.continueStraight.hashCode();
        h *= 1000003;
        h ^= this.annotation == null?0:this.annotation.hashCode();
        h *= 1000003;
        h ^= this.language == null?0:this.language.hashCode();
        h *= 1000003;
        h ^= this.roundaboutExits == null?0:this.roundaboutExits.hashCode();
        h *= 1000003;
        h ^= this.clientAppName == null?0:this.clientAppName.hashCode();
        h *= 1000003;
        h ^= this.voiceInstructions == null?0:this.voiceInstructions.hashCode();
        h *= 1000003;
        h ^= this.bannerInstructions == null?0:this.bannerInstructions.hashCode();
        h *= 1000003;
        h ^= this.voiceUnits == null?0:this.voiceUnits.hashCode();
        h *= 1000003;
        h ^= this.exclude == null?0:this.exclude.hashCode();
        return h;
    }

    public ShivehDirections.Builder toBuilder() {
        return new AutoValue_ShivehDirections.Builder(this);
    }

    static final class Builder extends ShivehDirections.Builder {
        private String user;
        private String profile;
        private String coordinates;
        private String baseUrl;
        private String accessToken;
        private Boolean alternatives;
        private String geometries;
        private String overview;
        private String radius;
        private String bearing;
        private Boolean steps;
        private Boolean continueStraight;
        private String annotation;
        private String language;
        private Boolean roundaboutExits;
        private String clientAppName;
        private Boolean voiceInstructions;
        private Boolean bannerInstructions;
        private String voiceUnits;
        private String exclude;

        Builder() {
        }

        private Builder(ShivehDirections source) {
            this.user = source.user();
            this.profile = source.profile();
            this.coordinates = source.coordinates();
            this.baseUrl = source.baseUrl();
            this.accessToken = source.accessToken();
            this.alternatives = source.alternatives();
            this.geometries = source.geometries();
            this.overview = source.overview();
            this.radius = source.radius();
            this.bearing = source.bearing();
            this.steps = source.steps();
            this.continueStraight = source.continueStraight();
            this.annotation = source.annotation();
            this.language = source.language();
            this.roundaboutExits = source.roundaboutExits();
            this.clientAppName = source.clientAppName();
            this.voiceInstructions = source.voiceInstructions();
            this.bannerInstructions = source.bannerInstructions();
            this.voiceUnits = source.voiceUnits();
            this.exclude = source.exclude();
        }

        public ShivehDirections.Builder user(String user) {
            if(user == null) {
                throw new NullPointerException("Null user");
            } else {
                this.user = user;
                return this;
            }
        }

        public ShivehDirections.Builder profile(String profile) {
            if(profile == null) {
                throw new NullPointerException("Null profile");
            } else {
                this.profile = profile;
                return this;
            }
        }

        ShivehDirections.Builder coordinates(String coordinates) {
            if(coordinates == null) {
                throw new NullPointerException("Null coordinates");
            } else {
                this.coordinates = coordinates;
                return this;
            }
        }

        public ShivehDirections.Builder baseUrl(String baseUrl) {
            if(baseUrl == null) {
                throw new NullPointerException("Null baseUrl");
            } else {
                this.baseUrl = baseUrl;
                return this;
            }
        }

        public ShivehDirections.Builder accessToken(@Nullable String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public ShivehDirections.Builder alternatives(@Nullable Boolean alternatives) {
            this.alternatives = alternatives;
            return this;
        }

        public ShivehDirections.Builder geometries(@Nullable String geometries) {
            this.geometries = geometries;
            return this;
        }

        public ShivehDirections.Builder overview(@Nullable String overview) {
            this.overview = overview;
            return this;
        }

        ShivehDirections.Builder radius(@Nullable String radius) {
            this.radius = radius;
            return this;
        }

        ShivehDirections.Builder bearing(@Nullable String bearing) {
            this.bearing = bearing;
            return this;
        }

        public ShivehDirections.Builder steps(@Nullable Boolean steps) {
            this.steps = steps;
            return this;
        }

        public ShivehDirections.Builder continueStraight(@Nullable Boolean continueStraight) {
            this.continueStraight = continueStraight;
            return this;
        }

        ShivehDirections.Builder annotation(@Nullable String annotation) {
            this.annotation = annotation;
            return this;
        }

        ShivehDirections.Builder language(@Nullable String language) {
            this.language = language;
            return this;
        }

        public ShivehDirections.Builder roundaboutExits(@Nullable Boolean roundaboutExits) {
            this.roundaboutExits = roundaboutExits;
            return this;
        }

        public ShivehDirections.Builder clientAppName(@Nullable String clientAppName) {
            this.clientAppName = clientAppName;
            return this;
        }

        public ShivehDirections.Builder voiceInstructions(@Nullable Boolean voiceInstructions) {
            this.voiceInstructions = voiceInstructions;
            return this;
        }

        public ShivehDirections.Builder bannerInstructions(@Nullable Boolean bannerInstructions) {
            this.bannerInstructions = bannerInstructions;
            return this;
        }

        public ShivehDirections.Builder voiceUnits(@Nullable String voiceUnits) {
            this.voiceUnits = voiceUnits;
            return this;
        }

        public ShivehDirections.Builder exclude(@Nullable String exclude) {
            this.exclude = exclude;
            return this;
        }

        ShivehDirections autoBuild() {
            String missing = "";
            if(this.user == null) {
                missing = missing + " user";
            }

            if(this.profile == null) {
                missing = missing + " profile";
            }

            if(this.coordinates == null) {
                missing = missing + " coordinates";
            }

            if(this.baseUrl == null) {
                missing = missing + " baseUrl";
            }

            if(!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            } else {
                return new AutoValue_ShivehDirections(this.user, this.profile, this.coordinates, this.baseUrl, this.accessToken, this.alternatives, this.geometries, this.overview, this.radius, this.bearing, this.steps, this.continueStraight, this.annotation, this.language, this.roundaboutExits, this.clientAppName, this.voiceInstructions, this.bannerInstructions, this.voiceUnits, this.exclude);
            }
        }
    }

}
