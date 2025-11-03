package juego;

import entorno.Entorno;

public class Nuez {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	
	boolean vivo = false;
	int posX;
	int posY;
	int vida = 1200;
	int abonoN = 40;
	
	public Nuez(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
	}
	

}
