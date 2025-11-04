package juego;

import entorno.Entorno;

public class BolaDeNieve {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	int posX;
	int posY;
	int damage = 10;
	
	public BolaDeNieve(Entorno entorno, Estado estado, Reloj reloj, int posX, int posY) {
		super();
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void desplazar() {
		posX -= 5;
	}
	
}
