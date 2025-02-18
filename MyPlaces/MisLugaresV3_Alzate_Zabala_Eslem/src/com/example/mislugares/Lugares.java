package com.example.mislugares;

import java.util.ArrayList;
import java.util.List;


public class Lugares {

    protected static List<Lugar> vectorLugares = ejemploLugares();
    private long fecha;
    private TipoLugar tipo;
    private GeoPunto posicion;
    private Lugar lugar;

    public Lugares() {
        vectorLugares = ejemploLugares();
    }

    static Lugar elemento(int id) {
        return vectorLugares.get(id);
    }

    static void anyade(Lugar lugar) {
        vectorLugares.add(lugar);
    }

    static int nuevo() {
        Lugar lugar = new Lugar();
        vectorLugares.add(lugar);
        return vectorLugares.size() - 1;
    }

    static void borrar(int id) {
        vectorLugares.remove(id);
    }

    public static int size() {
        return vectorLugares.size();
    }

    public static ArrayList<Lugar> ejemploLugares() {
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        
        lugares.add(new Lugar("CIPFP Mislata",
                "C/ Dolors Ibaturri,32 46920 Mislata (SPAIN)", -0.421328, 39.481856,
                TipoLugar.EDUCACION, 961205925, "http://www.fpmislata.com",
                "Uno de los mejores lugares para formarse.", 5));

        lugares.add(new Lugar("Al de siempre",
                "P.Industrial Junto Molí Nou - 46722, Benifla (Valencia)",
                -0.190642, 38.925857, TipoLugar.BAR, 636472405, "",
                "No te pierdas el arroz en calabaza.", 3));

        lugares.add(new Lugar("androidcurso.com",
                "ciberespacio", 0.0, 0.0, TipoLugar.EDUCACION,
                962849300, "http://androidcurso.com",
                "Amplia tus conocimientos sobre Android.", 5));

        lugares.add(new Lugar("Barranco del Infierno",
                "Vía Verde del río Serpis. Villalonga (Valencia)",
                -0.295058, 38.867180, TipoLugar.NATURALEZA,
                0, "http://sosegaos.blogspot.com.es/2009/02/lorcha-villalonga-via-verde-del-rio.html",
                "Espectacular ruta para bici o andar", 4));

        lugares.add(new Lugar("La Vital",
                "Avda. de La Vital, 0 46701 Gandía (Valencia)",
                -0.1720092, 38.9705949, TipoLugar.COMPRAS,
                962881070, "http://www.lavital.es/",
                "El típico centro comercial", 2));

        return lugares;

    }
}
