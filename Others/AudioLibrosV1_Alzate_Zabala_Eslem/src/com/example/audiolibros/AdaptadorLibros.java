package com.example.audiolibros;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorLibros extends BaseAdapter {
	private LayoutInflater layoutInflater;
	private ArrayList<Libro> listaLibros;

	public AdaptadorLibros(Context contexto, ArrayList<Libro> listaLibros) {
		// Instancia el layout correspondiente, asignado al contexto
		layoutInflater = (LayoutInflater) contexto
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.listaLibros = listaLibros;
	}

	public View getView(int position, View vistaReciclada, ViewGroup parent) {
		// Declaramos las variables que vamos a usar en la vista
		ImageView imageView;
		TextView audiolibroTextView;
		// Obtenemos el elemento
		Libro libro = listaLibros.get(position);
		// Obtenemos la vista a partir del layout elemento_selector
		View view = vistaReciclada;
		if (vistaReciclada == null) {
			view = layoutInflater.inflate(R.layout.elemento_selector, null);
		}
		// Asignamos el nombre del libro, así como la imagen
		audiolibroTextView = (TextView) view.findViewById(R.id.titulo);
		audiolibroTextView.setText(libro.getTitulo());
		imageView = (ImageView) view.findViewById(R.id.imageView1);
		imageView.setImageResource(libro.getRecursoImagen());
		imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		// Devolvemos la vista
		return view;
	}

	public int getCount() {
		return listaLibros.size();
	}

	public Object getItem(int position) {
		return listaLibros.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}