package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Menu {				//se encarga de las funcionalidades del menú y del dibujo de este y de los fondos.
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	
	int cuantosTicks = 0;
	int ticksFuera = 0;
	boolean contar = false;
	boolean cortar = false;
	
	boolean aRose = false;
	boolean aNuez = false;
	boolean aChile = false;
	
	public Menu(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj; 
	}

	public boolean sobre(int masX, int menosX, int masY, int menosY) {
		int mX = entorno.mouseX();
		int mY = entorno.mouseY();
		if(mX >= masX && mX <= menosX && mY >= masY && mY <= menosY) {
			return true;
		}
		else {
			return false;
	}
	}

	public void dibujarMenu() {
		if(estado.esInicio()) {
			if(!sobre(680, 910, 610, 710)) {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Portada.png"), 700, 400, 0);
			}
			else {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Portada2.png"), 700, 400, 0);
				if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))
						estado.setEstado(2);
			}
		}
		if(estado.esDerrota()) {
			entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pastoDerrota.png"), 700, 400, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBladeD1.png"), 102, 82, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezD1.png"), 300, 82, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), 470, 82, 0);
		}
		if(estado.esPausa()) {
			if(!sobre(700, 1369, 580, 760)) {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Refrigerio.png"), 700, 400, 0);
			}
			else {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Refrigerio2.png"), 700, 400, 0);
				if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))
						contar = true;
				if(contar) {
					contar = false;
					contarTicks(true);
					cortar = true;
				}
				if(cortar) {
					contarTicks(false);
						if(cuantosTicks >= 20) {
							cortar = false;
							estado.setEstado(2);
						}
					}
				}
			}
		if(estado.esJuego()) {


			entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto1.png"), 700, 400, 0);
			if(!sobre(1038, 1263, 38, 122)) {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Pausa.png"), 1150, 80, 0);
			}
			else {
				entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Pausa2.png"), 1150, 80, 0);
				if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))
					estado.setEstado(3);
			}

			//reloj.mostrarTiempo(50, 650, 50);
			entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto1.png"), 700, 400, 0);
			entorno.dibujarImagen(Herramientas.cargarImagen("mapa/MenuSuperior9.png"), 700, 90, 0, 1);
			
			if(!aNuez)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezBoton1.png"), 300, 82, 0);
			else
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezBoton2.png"), 300, 82, 0);

			if(!aRose)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade1.png"), 102, 82, 0);
			else
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade2.png"), 102, 82, 0);
			
			if(!aChile)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), 470, 82, 0);
			else
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chileSelected.png"), 470, 82, 0);
			
		}
	}
	public void contarTicks(boolean iniciar) {
		if(entorno == null) {
			return;
		}
		if(iniciar) {
			ticksFuera = entorno.numeroDeTick();
		}
		else{
			cuantosTicks = entorno.numeroDeTick() - ticksFuera;
		}
	}
}
