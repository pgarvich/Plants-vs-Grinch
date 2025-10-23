package juego;

import entorno.Entorno;

public class Rosa {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	
	boolean vivo = false;
	int posX;
	int posY;
	int vida = 100;
	int abonoN = 60;
	
	public Rosa(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;

}
}
