package org.example.asteroides;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
	private Drawable drawable; // Imagen que dibujaremos
	private double cenX, cenY; // Posición el centro el gráfico
	private int ancho, alto; // Dimensiones de la imagen
	private double incX, incY; // Velocidad desplazamiento
	private int angulo, rotacion;// Ángulo y velocidad rotación
	private int radioColision; // Para determinar colisión
	private double xAnterior, yAnterior; // Posición anterior
	private int radioInval; // Radio usado en invalidate()
	// Donde dibujamos el gráfico (usada en view.ivalidate)
	private View view;
	// Para determinar el espacio a borrar (view.ivalidate)
	public static final int MAX_VELOCIDAD = 20;

	// Constructor de la clase Grafico
	public Grafico(View view, Drawable drawable) {
		this.view = view;
		this.drawable = drawable;
		// Podemos consultar el tamaño preferido de un Drawable mediante
		// los métodosgetIntrinsicHeight() y getIntrinsicWidth().
		ancho = drawable.getIntrinsicWidth();
		alto = drawable.getIntrinsicHeight();
		// Radio de la colision: ((ancho/2)+(alto/2))/2
		radioColision = (alto + ancho) / 4;

		radioInval = (int) Math.hypot(ancho / 2, alto / 2);
	}

	// Dibuja
	public void dibujaGrafico(Canvas canvas) {
		// Calcula los puntos iniciales del cuadrado
		int x = (int) cenX - ancho / 2;
		int y = (int) cenY - alto / 2;

		// Guarda la matriz de transformacion de canvas
		canvas.save();
		// Indica al drawable los limites del cuadrado
		drawable.setBounds(x, y, x + ancho, y + alto);

		// Se aplica una rotacion al canvas
		canvas.rotate((float) angulo, (float) cenX, (float) cenY);

		// Se dibuja el objeto en el canvas
		drawable.draw(canvas);

		// Se restaura el canvas para que la rotación intriducida no se aplica a
		// nuevas operaciones futuras
		canvas.restore();
		// Mandamos redibujar la vista
		view.invalidate((int) cenX - radioInval, (int) cenY - radioInval,
				(int) cenX + radioInval, (int) cenY + radioInval);
		view.invalidate((int) xAnterior - radioInval, (int) yAnterior
				- radioInval, (int) xAnterior + radioInval, (int) yAnterior
				+ radioInval);

		// Almacenamos la posicion anterior
		xAnterior = cenX;
		yAnterior = cenY;
	}

	// Metodo que modificar la posición y ángulo del Grafico según la
	// velocidad de translación (incX, incY) y la velocidad de rotación
	public void incrementaPos(double factor) {

		cenX += incX * factor;
		// Si salimos de la pantalla, corregimos posición
		if (cenX < -ancho / 2) {
			cenX = view.getWidth() - ancho / 2;
		}
		if (cenX > view.getWidth() - ancho / 2) {
			cenX = -ancho / 2;
		}
		cenY += incY * factor;
		if (cenY < -alto / 2) {
			cenY = view.getHeight() - alto / 2;
		}
		if (cenY > view.getHeight() - alto / 2) {
			cenY = -alto / 2;
		}
		angulo += rotacion * factor; // Actualizamos ángulo
	}

	// Verifica si ha colisionado con otro grafico
	public boolean verificaColision(Grafico g) {
		return (distancia(g) < (this.radioColision + g.radioColision));
	}

	public double distancia(Grafico g) {
		return Math.hypot(cenX - g.cenX, cenY - g.cenY - g.cenY);
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public double getCenX() {
		return cenX;
	}

	public void setCenX(double cenX) {
		this.cenX = cenX;
	}

	public double getCenY() {
		return cenY;
	}

	public void setCenY(double cenY) {
		this.cenY = cenY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public double getIncX() {
		return incX;
	}

	public void setIncX(double incX) {
		this.incX = incX;
	}

	public double getIncY() {
		return incY;
	}

	public void setIncY(double incY) {
		this.incY = incY;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getRotacion() {
		return rotacion;
	}

	public void setRotacion(int rotacion) {
		this.rotacion = rotacion;
	}

	public int getRadioColision() {
		return radioColision;
	}

	public void setRadioColision(int radioColision) {
		this.radioColision = radioColision;
	}

	public double getxAnterior() {
		return xAnterior;
	}

	public void setxAnterior(double xAnterior) {
		this.xAnterior = xAnterior;
	}

	public double getyAnterior() {
		return yAnterior;
	}

	public void setyAnterior(double yAnterior) {
		this.yAnterior = yAnterior;
	}

	public int getRadioInval() {
		return radioInval;
	}

	public void setRadioInval(int radioInval) {
		this.radioInval = radioInval;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public static int getMaxVelocidad() {
		return MAX_VELOCIDAD;
	}
}
