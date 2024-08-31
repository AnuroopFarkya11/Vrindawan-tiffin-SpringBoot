package com.vrindawan.tiffin.model.location;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class Location {

    private GeoJsonPoint coordinates;

    public Location(double latitude, double longitude) {
        this.coordinates = new GeoJsonPoint(longitude, latitude);
    }

    public GeoJsonPoint getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GeoJsonPoint coordinates) {
        this.coordinates = coordinates;
    }
}

