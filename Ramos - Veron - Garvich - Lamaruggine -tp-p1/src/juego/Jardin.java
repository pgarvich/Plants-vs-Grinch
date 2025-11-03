package juego;
import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Jardin {

	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
<<<<<<< HEAD
	Rosa[] rosa;
	Nuez [] nuez;
	BolaDeFuego[] bFuego;
=======
	private Rosa[] rosa;
	private Nuez [] nuez;
	private Chile[] chile;
	private BolaDeFuego[] bFuego;
>>>>>>> 0d417b7 (chile (planta explosiva) añadida)
	private Menu menu;
	private Cripta cripta;
	
	int[] xs = {180, 305, 435, 565, 693, 820, 948, 1073, 1198, 1325};
	int[] ys = {220, 350, 480, 610, 740};
	int abono = 100;
	boolean aRosa = false;
	boolean aNuez = false;
	boolean aChile = false;
	int conteoRosa = 0;
	int conteoNuez = 0;
	int conteoBFuego = 0;
	int ticksFuera;
	int cuantosTicks;
	int regaloPerdido;

	
	int plantaSeleccionada = -1;
	String tipoPlantaSeleccionada = "";
	boolean moviendoPlanta = false;
	
	boolean izquierdaPres = false;
	boolean derechaPres = false;
	boolean arribaPres = false;
	boolean abajoPres = false;

	
	
	public Jardin(Entorno entorno, Estado estado, Reloj reloj, Menu menu, Cripta cripta) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		this.menu = menu;
		this.cripta = cripta;
		
		this.nuez = new Nuez[50];
		this.rosa = new Rosa[50];
		this.chile = new Chile[20];
		this.bFuego = new BolaDeFuego[100];
		
		for(int i = 0; i < nuez.length; i++) {
			nuez[i] = new Nuez(this.entorno, this.estado, this.reloj);
		}
		
		for(int i = 0; i < rosa.length; i++) {
			rosa[i] = new Rosa(this.entorno, this.estado, this.reloj);
		}
	}
	public void posiblesPlantas() {
		menu.nuecesPosibles = abono / 40;
		menu.rosasPosibles = abono / 60;
	}
	
	
	public void dibujarRegalos() {
		if(estado.esDerrota()) {
			if(cripta.regalo1)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 226, 0);
			if(cripta.regalo2)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 353, 0);
			if(cripta.regalo3)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 482, 0);
			if(cripta.regalo4)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 612, 0);
			if(cripta.regalo5)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 736, 0);
		}
		
		if(estado.esJuego() || estado.esVictoria()) {
		if (reloj.ciclos(200, 1200)) {			//1er regalo
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 226, 0);
		}
		else if (reloj.ciclos(400,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 220, 0);
		}
		else if (reloj.ciclos(600,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 216, 0);
		}
		else if (reloj.ciclos(800,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 210, 0);
		}
		else if (reloj.ciclos(1000,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 204, 0);
		}
		else {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 198, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//segundo
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 353, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 347, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 341, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 335, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 329, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 323, 0);
		}
		
		if (reloj.ciclos(200, 1200)) { //tercero
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 482, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 476, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 470, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 464, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 458, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 452, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//cuarto
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 612, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 606, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 600, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 594, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 588, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 582, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//quinto
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 736, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 730, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 724, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 718, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 712, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 706, 0);
		}
		}
	}
	
	public void victoriaPlanta() {
		if(cripta.zombiesMuertos == 50) {
			estado.setEstado(5);
		}
	}
	
	public void dibujarPlantas() {
		 if(estado.esVictoria()) {
		        // Dibujar plantas en estado de derrota
		        for(int i = 0; i < nuez.length; i++) {        
		            if (nuez[i] == null) continue;
		            if(nuez[i].vivo) {
		                if (reloj.ciclos(300, 600)) {
		                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezV1.png"), nuez[i].posX, nuez[i].posY, 0);
		                }
		                else {
		                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezV2.png"), nuez[i].posX, nuez[i].posY, 0.1);
		                }             
		            }
		        }
		        
		        for(int i = 0; i < rosa.length; i++) {        
		            Rosa r = rosa[i];
		            if (r == null) continue;
		            if(r.vivo) {
		                if (reloj.ciclos(300, 600)) {
		                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseV1.png"), rosa[i].posX, rosa[i].posY, 0);
		                } else {
		                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseV2.png"), rosa[i].posX, rosa[i].posY, 0);
		                }             
		            }
		        }
		    }
		 
	    if(estado.esDerrota()) {
	        // Dibujar plantas en estado de derrota
	        for(int i = 0; i < nuez.length; i++) {        
	            if (nuez[i] == null) continue;
	            if(nuez[i].vivo) {
	                if (reloj.ciclos(300, 600)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezD1.png"), nuez[i].posX, nuez[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuezD2.png"), nuez[i].posX, nuez[i].posY, 0.1);
	                }             
	            }
	        }
	        
	        for(int i = 0; i < rosa.length; i++) {        
	            Rosa r = rosa[i];
	            if (r == null) continue;
	            if(r.vivo) {
	                if (reloj.ciclos(300, 600)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBladeD1.png"), rosa[i].posX, rosa[i].posY, 0);
	                } else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBladeD2.png"), rosa[i].posX, rosa[i].posY, 0);
	                }             
	            }
	        }
	        
	        for(int i = 0; i < chile.length; i++) {
	        	if(chile[i] == null) continue;
                entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), chile[i].posX, chile[i].posY, 0);
	        }
	    }


	    if(estado.esJuego()) {
	        // Dibujar nueces durante el juego
	        for(int i = 0; i < nuez.length; i++) {
	            if (nuez[i] == null) continue;
	            if(nuez[i].vivo) {
	                if (reloj.ciclos(300, 600)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuez1.png"), nuez[i].posX, nuez[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/nuez1.png"), nuez[i].posX+5, nuez[i].posY-5, 0.1);
	                }
	                if (i == plantaSeleccionada && tipoPlantaSeleccionada.equals("nuez")) {
	                    Color marco = new Color(255, 255, 0, 100);
	                    entorno.dibujarRectangulo(nuez[i].posX, nuez[i].posY, 125, 125, 0, marco);
	                }
	            }
	        }

	        // Dibujar rosas durante el juego (SOLO DIBUJO, sin lógica de disparo)
	        for(int i = 0; i < rosa.length; i++) {
	            Rosa r = rosa[i];
	            if (r == null) continue;
	            if(r.vivo) {
	                // ELIMINAR TODO EL BLOQUE DE DISPARO - eso va a Combate
	                if (reloj.ciclos(300, 600)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade1.png"), rosa[i].posX, rosa[i].posY, 0);
	                } else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade2.png"), rosa[i].posX, rosa[i].posY, 0);
	                }             
	            }
	            if (i == plantaSeleccionada && tipoPlantaSeleccionada.equals("rosa")) {
	                Color marco = new Color(255, 255, 0, 100);
	                entorno.dibujarRectangulo(r.posX, r.posY, 125, 125, 0, marco);
	            }
	        }
	        
	        //dibujar chiles
	        for(int i = 0; i < chile.length; i++) {
	        	if(chile[i] == null) continue;
                entorno.dibujarImagen(Herramientas.cargarImagen("personajes/chile.png"), chile[i].posX, chile[i].posY, 0);
                if (i == plantaSeleccionada && tipoPlantaSeleccionada.equals("chile")) {
                    Color marco = new Color(255, 255, 0, 100);
                    entorno.dibujarRectangulo(chile[i].posX, chile[i].posY, 125, 125, 0, marco);
                }
	        }
	    }
	}

	public void spawnPlanta() {
		int mX = entorno.mouseX();
		int mY = entorno.mouseY();
		int posibleX;
		int posibleY;
		posiblesPlantas();
		
		if(40 < mX && mX < 165 && 20 < mY && mY < 145 && abono >= 60 && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			aRosa = true;
			aNuez = false;
			aChile = false;
			menu.aNuez = false;
			menu.aChile = false;
		}
		
		if(250 < mX && mX < 350 && 20 < mY && mY < 145 && abono >= 40 && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			aNuez = true;
			aRosa = false;
			aChile = false;
			menu.aRose = false;
			menu.aChile = false;
		}
		
		if(420 <mX && mX < 520 && 20 < mY && mY < 145 && abono >= 120 && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			aChile = true;
			aRosa = false;
			aNuez = false;
			menu.aRose = false;
			menu.aNuez = false;
		}
		
		if(aNuez) {
			menu.aNuez = true;
		}
		
		if(aRosa) {
			menu.aRose = true;
		}
		
		if(aChile) {
			menu.aChile = true;
		}
		
			if(120 < mX && mX < 240) {
				posibleX = 180;
			}
			else if(240 < mX && mX < 370) {
				posibleX= 305;
			}
			else if(370 < mX && mX < 500) {
				posibleX = 435;
			}
			else if(500 < mX && mX < 630) {
				posibleX = 565;
			}
			else if(630 < mX && mX < 755) {
				posibleX = 693;
			}
			else if(755 < mX && mX < 885) {
			    posibleX = 820;
			}
			else if(885 < mX && mX < 1010) {
				posibleX = 948;
			}
			else if(1010 < mX && mX < 1135) {
				posibleX = 1073;
			}
			else if(1135 < mX && mX < 1260) {
				posibleX = 1198;
			}
			else if(1260 < mX && mX < 1390) {
				posibleX = 1325;
			}
			else {
				return;
			}
			
			if(170 < mY && mY < 288) {
				posibleY = 220;
			}
			else if(288 < mY && mY < 415) {
				posibleY = 350;
			}
			else if(415 < mY && mY < 545) {
				posibleY = 480;
			}
			else if(545 < mY && mY < 670) {
				posibleY = 610;
			}
			else if(670 < mY && mY < 800) {
				posibleY = 740;
			}
			else {
				return;
			}
			
			for(int i = 0; i < rosa.length; i++){
				if((rosa[i].posX == posibleX && rosa[i].posY == posibleY) || (nuez[i].posX == posibleX && nuez[i].posY == posibleY)) {
					return;
				}
			}
			
			for(int i = 0; i < chile.length; i++) {
				if(chile[i] != null && chile[i].posX == posibleX && chile[i].posY == posibleY) return;
			}
			
			if(aRosa == true && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && mY >= 170) {
				rosa[conteoRosa].posX = posibleX;
				rosa[conteoRosa].posY = posibleY;
				rosa[conteoRosa].vivo = true;
				conteoRosa += 1;
				abono -= 60;

				if(abono < 60) {
					aRosa = false;
					menu.aRose = false;
				}
			}
			
			if(aNuez == true && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && mY >= 170) {
				nuez[conteoNuez].posX = posibleX;
				nuez[conteoNuez].posY = posibleY;
				nuez[conteoNuez].vivo = true;
				conteoNuez += 1;
				abono -= 40;

				if(abono < 40) {
					aNuez = false;
					menu.aNuez = false;
				}
			}
			
			if(aChile == true && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && mY >= 170) {
				Chile c = new Chile(entorno, estado, reloj, posibleX, posibleY);
				for (int i = 0; i < chile.length; i++) {
					if(chile[i] == null) {
						chile[i] = c;
						abono -= c.abonoN;
						break;
					}
				}
				if(abono < c.abonoN) {
					aChile = false;
					menu.aChile = false;
				}
			}
			
		
	}
	
	public void moverPlanta() {
	    int mX = entorno.mouseX();
	    int mY = entorno.mouseY();

	    if (!moviendoPlanta) {
	        if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && mY >= 170) {
	            int posibleX = obtenerPosicionXDesdeMouse(mX);
	            int posibleY = obtenerPosicionYDesdeMouse(mY);
	            if (posibleX == -1 || posibleY == -1) return;

	            // Primero verificar rosas
	            for (int i = 0; i < rosa.length; i++) {
	                if (rosa[i] != null && rosa[i].vivo && rosa[i].posX == posibleX && rosa[i].posY == posibleY) {
	                    plantaSeleccionada = i;
	                    tipoPlantaSeleccionada = "rosa";
	                    moviendoPlanta = true;
	                    return;
	                }
	            }
	            
	            // Luego verificar nueces
	            for (int i = 0; i < nuez.length; i++) {
	                if (nuez[i] != null && nuez[i].vivo && nuez[i].posX == posibleX && nuez[i].posY == posibleY) {
	                    plantaSeleccionada = i;
	                    tipoPlantaSeleccionada = "nuez";
	                    moviendoPlanta = true;
	                    return;
	                }
	            }
	            
	            for(int i = 0; i < chile.length; i++) {
	            	if (chile[i] != null && chile[i].posX == posibleX && chile[i].posY == posibleY) {
	            		plantaSeleccionada = i;
	                    tipoPlantaSeleccionada = "chile";
	                    moviendoPlanta = true;
	                    return;
	            	}
	            }
	            
	        }
	    } else {
	        int curX = getPosX();
	        int curY = getPosY();
	        int nuevoX = curX;
	        int nuevoY = curY;
	        char w = 119;
	        char W = 87;
	        char a = 97;
	        char A = 65;
	        char s = 115;
	        char S = 83;
	        char d = 100;
	        char D = 68;

	        if ((entorno.sePresiono(entorno.TECLA_IZQUIERDA) || entorno.sePresiono(a) || entorno.sePresiono(A)) && curX > xs[0] && !izquierdaPres) {
	            nuevoX = obtenerPosicionXMenor(curX);
	            izquierdaPres = true;
	        } else if (!(entorno.sePresiono(entorno.TECLA_IZQUIERDA) || entorno.sePresiono(a) || entorno.sePresiono(A))) {
	            izquierdaPres = false;
	        }

	        if ((entorno.sePresiono(entorno.TECLA_DERECHA) || entorno.sePresiono(d) || entorno.sePresiono(D)) && curX < xs[xs.length - 1] && !derechaPres) {
	            nuevoX = obtenerPosicionXMayor(curX);
	            derechaPres = true;
	        } else if (!(entorno.sePresiono(entorno.TECLA_DERECHA) || entorno.sePresiono(d) || entorno.sePresiono(D))) {
	            derechaPres = false;
	        }

	        if ((entorno.sePresiono(entorno.TECLA_ARRIBA) || entorno.sePresiono(w) || entorno.sePresiono(W)) && curY > ys[0] && !arribaPres) {
	            nuevoY = obtenerPosicionYMenor(curY);
	            arribaPres = true;
	        } else if (!(entorno.sePresiono(entorno.TECLA_ARRIBA) || entorno.sePresiono(w) || entorno.sePresiono(W))) {
	            arribaPres = false;
	        }

	        if ((entorno.sePresiono(entorno.TECLA_ABAJO) || entorno.sePresiono(s) || entorno.sePresiono(S)) && curY < ys[ys.length - 1] && !abajoPres) {
	            nuevoY = obtenerPosicionYMayor(curY);
	            abajoPres = true;
	        } else if (!(entorno.sePresiono(entorno.TECLA_ABAJO) || entorno.sePresiono(s) || entorno.sePresiono(S))) {
	            abajoPres = false;
	        }

	        if ((nuevoX != curX || nuevoY != curY) && !hayPlantaEnPosicion(nuevoX, nuevoY)) {
	            setPos(nuevoX, nuevoY);
	        }

	        // se confirma la nueva posición con click o q
	        if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) || entorno.seLevanto('q') || entorno.sePresiono('Q')) {
	            moviendoPlanta = false;
	            plantaSeleccionada = -1;
	            tipoPlantaSeleccionada = "";
	        }
	    }
	}

	
	
	public void crearAbono() {
		entorno.cambiarFont("Arial", 18, Color.CYAN);
		entorno.escribirTexto("Abono total: " + abono, 1200, 100);
		contarTicks(false);
		if(abono < 300 && cuantosTicks > 100) {
			abono += 15;
			contarTicks(true);
			
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
	

	public boolean hayPlantaEnPosicion(int x, int y) {
	    for (int i = 0; i < rosa.length; i++) {
	        if (rosa[i] != null && rosa[i].vivo && rosa[i].posX == x && rosa[i].posY == y) 
	            return true;
	    }
	    for (int i = 0; i < nuez.length; i++) {
	        if (nuez[i] != null && nuez[i].vivo && nuez[i].posX == x && nuez[i].posY == y) 
	            return true;
	    }
	    for (int i = 0; i < chile.length; i++) {
	        if (chile[i] != null && chile[i].posX == x && chile[i].posY == y) 
	            return true;
	    }
	    return false;
	}

	
	private int obtenerPosicionXMenor(int x) {
		for(int i = 0; i < xs.length; i++) {
			if(i == 0 && xs[i] == x) return x;
			if(xs[i] == x) return xs[i - 1];
		}
		return x;
	}
	private int obtenerPosicionYMenor(int y) {
		for(int i = 0; i < ys.length; i++) {
			if(i == 0 && ys[i] == y) return y;
			if(ys[i] == y) return ys[i - 1];
		}
		return y;
	}
	private int obtenerPosicionXMayor(int x) {
		for(int i = 0; i < xs.length; i++) {
			if(i == xs.length - 1 && xs[i] == x) return x;
			if(xs[i] == x) return xs[i + 1];
		}
		return x;
	}	
	private int obtenerPosicionYMayor(int y) {
		for(int i = 0; i < ys.length; i++) {
			if(i == ys.length - 1 && ys[i] == y) return y;
			if(ys[i] == y) return ys[i + 1];
		}
		return y;
	}
	private int obtenerPosicionXDesdeMouse(int mouseX) {
	    for (int i = 0; i < xs.length; i++) {
	        if (Math.abs(mouseX - xs[i]) <= 60) return xs[i];
	    }
	    return -1;
	}

	private int obtenerPosicionYDesdeMouse(int mouseY) {
	    for (int i = 0; i < ys.length; i++) {
	        if (Math.abs(mouseY - ys[i]) <= 60) return ys[i];
	    }
	    return -1;
	}

	private int getPosX() {
	    if ("rosa".equals(tipoPlantaSeleccionada)) 
	        return rosa[plantaSeleccionada].posX;
	    if ("nuez".equals(tipoPlantaSeleccionada)) 
	        return nuez[plantaSeleccionada].posX;
	    if ("chile".equals(tipoPlantaSeleccionada))
	    	return chile[plantaSeleccionada].posX;
	    return 0;
	}

	private int getPosY() {
	    if ("rosa".equals(tipoPlantaSeleccionada)) 
	        return rosa[plantaSeleccionada].posY;
	    if ("nuez".equals(tipoPlantaSeleccionada)) 
	        return nuez[plantaSeleccionada].posY;
	    if ("chile".equals(tipoPlantaSeleccionada)) 
	        return chile[plantaSeleccionada].posY;
	    return 0;
	}

	private void setPos(int x, int y) {
	    if ("rosa".equals(tipoPlantaSeleccionada)) {
	        rosa[plantaSeleccionada].posX = x;
	        rosa[plantaSeleccionada].posY = y;
	    }
	    if ("nuez".equals(tipoPlantaSeleccionada)) {
	        nuez[plantaSeleccionada].posX = x;
	        nuez[plantaSeleccionada].posY = y;
	    }
	    if ("chile".equals(tipoPlantaSeleccionada)) {
	        chile[plantaSeleccionada].posX = x;
	        chile[plantaSeleccionada].posY = y;
	    }
	}

}
