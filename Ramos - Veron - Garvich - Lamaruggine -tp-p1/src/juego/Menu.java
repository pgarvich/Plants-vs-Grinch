package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Menu {				//se encarga de las funcionalidades del menú y del dibujo de este y de los fondos.
	private Entorno entorno;
	private Estado estado;
	
	int cuantosTicks = 0;
	int ticksFuera = 0;
	boolean contar = false;
	boolean cortar = false;
	
	boolean aRose = false;
	boolean aNuez = false;
	int rosasPosibles;
	int nuecesPosibles;
	int chilesPosibles;
	boolean aChile = false;
	
	public Menu(Entorno entorno, Estado estado) {
		this.entorno = entorno;
		this.estado = estado;
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
		
		if(estado.esVictoria()) {
			entorno.dibujarImagen(Herramientas.cargarImagen("mapa/PastoV.png"), 700, 400, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseV1.png"), 102, 82, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezV1.png"), 300, 82, 0);
			
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), 470, 82, 0);
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
		    // Dibujar fondos (solo una vez cada uno)
		    entorno.dibujarImagen(Herramientas.cargarImagen("mapa/pasto1.png"), 700, 400, 0);
		    entorno.dibujarImagen(Herramientas.cargarImagen("mapa/MenuSuperior9.png"), 700, 90, 0, 1);
		    
		    // 1. DIBUJAR BOTONES BASE PRIMERO
		    // Botón de nuez
		    if(!aNuez)
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezBoton1.png"), 300, 82, 0);
		    else
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezBoton2.png"), 300, 82, 0);
		    
		    // Botón de rosa
		    if(!aRose)
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade1.png"), 102, 82, 0);
		    else
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade2.png"), 102, 82, 0);
		    
		    // Botón de chile
		    if(!aChile)
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), 470, 82, 0);
		    else
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chileSelected.png"), 470, 82, 0);
		    
		    // 2. DIBUJAR NÚMEROS ENCIMA DE LOS BOTONES
		    // Números para nueces (en posición 300, 82)
		    if(nuecesPosibles >= 7) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n7.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 6) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n6.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 5) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n5.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 4) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n4.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 3) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n3.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 2) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n2.png"), 300, 82, 0);
		    }
		    else if(nuecesPosibles >= 1) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/n1.png"), 300, 82, 0);
		    }
		    
		    // Números para rosas (en posición 102, 82)
		    if(rosasPosibles >= 5) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/r5.png"), 102, 82, 0);
		    }
		    else if(rosasPosibles >= 4) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/r4.png"), 102, 82, 0);
		    }
		    else if(rosasPosibles >= 3) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/r3.png"), 102, 82, 0);
		    }
		    else if(rosasPosibles >= 2) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/r2.png"), 102, 82, 0);
		    }
		    else if(rosasPosibles >= 1) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/r1.png"), 102, 82, 0);
		    }
		    
		    if(chilesPosibles >= 3) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/c3.png"), 470, 82, 0);
		    }
		    else if(chilesPosibles >= 2) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/c2.png"), 470, 82, 0);
		    }
		    else if(chilesPosibles >= 1) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("personajes/c1.png"), 470, 82, 0);
		    }
		    
		    // 3. DIBUJAR BOTÓN DE PAUSA (último, para que esté encima de todo)
		    if(!sobre(1038, 1263, 38, 122)) {
		        entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Pausa.png"), 1150, 80, 0);
		    }
		    else {
		        entorno.dibujarImagen(Herramientas.cargarImagen("mapa/Pausa2.png"), 1150, 80, 0);
		        if(entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))
		            estado.setEstado(3);
		    }
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
