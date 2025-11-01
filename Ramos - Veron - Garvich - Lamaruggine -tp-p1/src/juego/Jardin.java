package juego;
import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Jardin {

	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	private Rosa[] rosa;
	private BolaDeFuego[] bFuego;
	private Menu menu;
	private Cripta cripta;
	
	int abono = 100;
	boolean aRosa = false;
	int conteoRosa = 0;
	int conteoBFuego = 0;
	int ticksFuera;
	int cuantosTicks;
	int regaloPerdido;
	
	
	public Jardin(Entorno entorno, Estado estado, Reloj reloj, Menu menu, Cripta cripta) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		this.menu = menu;
		this.cripta = cripta;
		
		this.rosa = new Rosa[50];
		this.bFuego = new BolaDeFuego[100];
		
		for(int i = 0; i < rosa.length; i++) {
			rosa[i] = new Rosa(this.entorno, this.estado, this.reloj);
		}
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
		
		if(estado.esJuego()) {
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
	
	public void dibujarPlantas() {
		if(estado.esDerrota()) {
			for(int i = 0; i < rosa.length; i++) {		//dibujar zombies base
				Rosa r = rosa[i];
				if (r == null) continue;
		    	if(r.vivo) {
		    		if (reloj.ciclos(300, 600)) {
		    			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBladeD1.png"), rosa[i].posX, rosa[i].posY, 0);
		    		}
		    		else {
		    			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBladeD2.png"), rosa[i].posX, rosa[i].posY, 0);
		    			}			 
		    		}
				}
		}
		if(estado.esJuego()) {
		for(int i = 0; i < rosa.length; i++) {		//dibujar zombies base
			Rosa r = rosa[i];
			if (r == null) continue;
	    	if(r.vivo) {
	    		if (r.puedeDisparar() && cripta.hayZombieEnFila(r.posX, r.posY)) {
	    			BolaDeFuego bola = rosa[i].disparar();
	    			if (conteoBFuego >= bFuego.length * 0.9) aumentarLengthBFuego();
	    			for(int a = 0; a < bFuego.length; a++) {
	    				if (bFuego[a] == null) {
	    					bFuego[a] = bola;
	    					conteoBFuego ++;
	    					break;
	    				}
	    			}
	    		}
	    		if (reloj.ciclos(200, 400)) {
	    			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade1.png"), rosa[i].posX, rosa[i].posY, 0);
	    		}
	    		else {
	    			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/roseBlade2.png"), rosa[i].posX, rosa[i].posY, 0);
	    			}			 
	    		}
			}
		}
	}
	public void dibujarProyectiles() {
		// Dibuja las bolas de fuego
		for(int i = 0; i < bFuego.length; i++) {
			BolaDeFuego b = bFuego[i];
			if (b == null) continue;
			b.desplazar();
			entorno.dibujarImagen(Herramientas.cargarImagen("personajes/bolaDeFuego.png"), b.posX, b.posY, 0);
			if (cripta.hayZombieEnPosicion(b.posX, b.posY)) {
				cripta.herirZombieEnPosicion(b.posX, b.posY, b.damage);
				bFuego[i] = null;
				conteoBFuego --;
			}
			if (b.posX > 1400) {
				bFuego[i] = null;
				conteoBFuego --;
			}
		}
		
		// También se deberían dibujar las bolas de nieve en este método
	}
	
	public void spawnPlanta() {
		int mX = entorno.mouseX();
		int mY = entorno.mouseY();
		int posibleX;
		int posibleY;
		
		if(40 < mX && mX < 165 && 20 < mY && mY < 145 && abono >= 60 && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO)) {
			aRosa = true;
			
		}
		
		if(aRosa == true) {
			menu.aRose = true;
		}
		
		if(aRosa == true && entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && mY >= 170) {
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
				posibleY = 229;
			}
			else if(288 < mY && mY < 415) {
				posibleY = 352;
			}
			else if(415 < mY && mY < 545) {
				posibleY = 480;
			}
			else if(545 < mY && mY < 670) {
				posibleY = 608;
			}
			else if(670 < mY && mY < 800) {
				posibleY = 735;
			}
			else {
				return;
			}
			
			for(int i = 0; i < rosa.length; i++){
				if(rosa[i].posX == posibleX && rosa[i].posY == posibleY) {
					return;
				}
			}
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
		
	}
	
	
	public void crearAbono() {
		entorno.cambiarFont("Arial", 18, Color.CYAN);
		entorno.escribirTexto("Abono total: " + abono, 700, 100);
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
	
	private void aumentarLengthBFuego() {
		int length = (int) (bFuego.length * 1.5);
		BolaDeFuego[] nuevo = new BolaDeFuego[length];
		for (int i = 0; i < bFuego.length; i++) {
			nuevo[i] = bFuego[i];
		}
		bFuego = nuevo;
	}
}
