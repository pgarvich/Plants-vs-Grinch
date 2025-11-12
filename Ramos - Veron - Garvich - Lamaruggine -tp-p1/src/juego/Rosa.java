package juego;

import entorno.Entorno;

public class Rosa {
	private Estado estado;
	private Reloj reloj;
	
	boolean vivo = false;
	int posX;
	int posY;
	int vida = 100;
	int abonoN = 60;
	int ultimoDisparo = 0;
	
	public Rosa(Estado estado, Reloj reloj) {

		this.estado = estado;
		this.reloj = reloj;
	}
	
	public BolaDeFuego disparar() {
		return new BolaDeFuego(estado, reloj, this);
	}
	
	public boolean puedeDisparar() {
		int actual = reloj.getTiempo();
		if (actual - ultimoDisparo >= 2000) {
			ultimoDisparo = actual;
			return true;
		}
		return false;
	}
	
	
}
