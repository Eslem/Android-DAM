package com.example.mislugares;

public class GeoPunto {

    private final int longitud;
    private final int latitud;

    public GeoPunto(double longitud, double latitud) {
        this.longitud = (int) (longitud * 1E6);
        this.latitud = (int) (latitud * 1E6);
    }
}
