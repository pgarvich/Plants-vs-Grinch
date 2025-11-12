package juego;
import java.awt.Color;
import java.awt.Font;

import entorno.Entorno;

public class Reloj {

	int segundos = 0;
	int minutos = 0;
	int milisegundos = 0;
	int estadoAnterior = 1;
	int fueraDeJuego = 0;
	int enJuego;
	int enPausa = 0;
	int cero100 = 0;
	
	public Reloj(int enJuego) {
		this.enJuego = enJuego;
	}

	public boolean ciclos(int indice, int divisor) { //Dividimos el tiempo por el divisor
		int resto = getTiempo() % divisor;
		return (resto < indice);
	}
	
	public void tiempoObjeto(Entorno entorno, boolean iniciar, boolean parar, boolean continuar, boolean correr) {
		if(iniciar)
			fueraDeJuego = entorno.tiempo();
		if(parar)
			enPausa = entorno.tiempo();
		if(continuar) {
			enPausa = entorno.tiempo() - enPausa;
			fueraDeJuego = fueraDeJuego + enPausa;		
		}
		if(correr) 
			enJuego = entorno.tiempo() - fueraDeJuego;
	}
	
	public void mostrarTiempo(Entorno entorno, int tamanio, int posX, int posY){
		int segundos = (enJuego / 1000) % 60;
		int minutos = enJuego / 60000;
		//int decimas = enJuego % 100;
		String texto = String.format("%02d:%02d", minutos, segundos);
		entorno.cambiarFont("Comic Sans MS", tamanio, Color.yellow);
		entorno.escribirTexto(texto, posX, posY);
	}
	public int getTiempo() {
		return enJuego;
	}
	
}