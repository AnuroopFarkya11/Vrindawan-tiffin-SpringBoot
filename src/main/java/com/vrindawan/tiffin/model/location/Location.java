package com.vrindawan.tiffin.model.location;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
public class Location {

    private GeoJsonPoint coordinates;

}

