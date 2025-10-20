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
			
			if(reloj.ciclos(200, 400))
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto1.png"), 400, 303, 0);
			else
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto2.png"), 400, 303, 0);
		}
	}
}
