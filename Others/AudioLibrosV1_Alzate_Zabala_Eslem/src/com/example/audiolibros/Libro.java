package com.example.audiolibros;

public class Libro {
	private String titulo;
	private String autor;
	private int recursoImagen;
	private String urlAudio;
	private String genero;
	private Boolean novedad;
	private Boolean leido;
	public final static String Servidor = "http://www.leemp3.com/leemp3/";
	public final static String G_TODOS = "Todos	los	géneros";
	public final static String G_CUENTO = "Cuento";
	public final static String G_POESIA = "Poesia";
	public final static String G_NARRATIVA = "Narrativa";
	public final static String G_CIENCIA_FICCION = "Ciencia	Ficción";
	public final static String G_MISTERIO = "Cuento	de	Misterio";
	public final static String G_AVENTURA = "Aventuras";

	public Libro(String titulo, String autor, int recursoImagen,
			String urlAudio, String genero, Boolean novedad, Boolean leido) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.recursoImagen = recursoImagen;
		this.urlAudio = urlAudio;
		this.genero = genero;
		this.novedad = novedad;
		this.leido = leido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getRecursoImagen() {
		return recursoImagen;
	}

	public void setRecursoImagen(int recursoImagen) {
		this.recursoImagen = recursoImagen;
	}

	public String getUrlAudio() {
		return urlAudio;
	}

	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getNovedad() {
		return novedad;
	}

	public void setNovedad(Boolean novedad) {
		this.novedad = novedad;
	}

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public String getServidor() {
		return Servidor;
	}
}
