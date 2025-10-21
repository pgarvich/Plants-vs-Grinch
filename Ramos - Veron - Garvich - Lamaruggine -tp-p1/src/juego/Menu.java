package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Menu {				//se encarga de las funcionalidades del menú y del dibujo de este y de los fondos.
	Entorno entorno;
	Estado estado;
	Reloj reloj;
	
	public Menu(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
	}

	
	public void dibujarMenu() {
		if(estado.esJuego()) {
			reloj.mostrarTiempo(50, 650, 50);
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto1.png"), 700, 400, 0);
		}
	}
}
