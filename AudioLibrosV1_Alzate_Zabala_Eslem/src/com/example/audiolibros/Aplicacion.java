package com.example.audiolibros;

import java.util.ArrayList;

import android.app.Application;

public class Aplicacion extends Application {
	private ArrayList<Libro> listaLibros;
	private AdaptadorLibros adaptador;

	@Override
	public void onCreate() {
		listaLibros = new ArrayList<Libro>();
		Libro a = new Libro("En	el	bosque", "Akutagawa", R.drawable.enelbosque,
				Libro.Servidor + "1\\En	el	bosque_akutagawa.mp3",
				Libro.G_CUENTO, false, false);
		listaLibros.add(a);
		Libro b = new Libro("Escritos	en	prosa", "Baralt,	Rafael	María",
				R.drawable.escritosenprosa, Libro.Servidor
						+ "2\\prosa_baralt.mp3", Libro.G_POESIA, false, false);
		listaLibros.add(b);
		Libro c = new Libro("Oración	Cívica", "Barreda,	Gabino",
				R.drawable.oracioncivica, Libro.Servidor
						+ "2\\oracion_barreda.mp3", Libro.G_NARRATIVA, false,
				false);
		listaLibros.add(c);
		Libro d = new Libro("Tres	fechas", "Bécquer,	Gustavo	Adolfo",
				R.drawable.tresfechas, Libro.Servidor
						+ "1\\Tres	flechas_becquer.mp3", Libro.G_CUENTO, false,
				false);
		listaLibros.add(d);
		Libro e = new Libro("Abrete	sésamo", "Beliaev,	Alexander",
				R.drawable.abretesesamo, Libro.Servidor
						+ "8\\abrete	sesamo_beliaev.mp3",
				Libro.G_CIENCIA_FICCION, false, false);
		listaLibros.add(e);
		Libro f = new Libro("Estudio	en	escarlata", "Conan	Doyle,	Arthur",
				R.drawable.estudioenescarlata, Libro.Servidor
						+ "6\\estudio_escarlata_conandoyle.mp3",
				Libro.G_POESIA, false, false);
		listaLibros.add(f);
		Libro g = new Libro("Oliver	Twits", "Dickens,	Charles",
				R.drawable.olivertwist, Libro.Servidor
						+ "7\\Oliver	Twist_dickens.mp3", Libro.G_AVENTURA,
				false, false);
		listaLibros.add(g);
		Libro h = new Libro("Antes	del	Adán", "London,	Jack",
				R.drawable.antesdeladan, Libro.Servidor
						+ "9\\antesdeadan_london.mp3", Libro.G_AVENTURA, false,
				false);
		listaLibros.add(h);
		adaptador = new AdaptadorLibros(this, listaLibros);
	}

	public AdaptadorLibros getAdaptador() {
		return this.adaptador;
	}

	public ArrayList<Libro> getListaLibros() {
		return this.listaLibros;
	}
}