package juego;

import entorno.Entorno;

public class BolaDeNieve {
	private Estado estado;
	private Reloj reloj;
	int posX;
	int posY;
	int damage = 10;
	
	public BolaDeNieve(Estado estado, Reloj reloj, int posX, int posY) {
		super();
		this.estado = estado;
		this.reloj = reloj;
		this.posX = posX;
		this.posY = posY;
	}
	
	public void desplazar() {
		posX -= 5;
	}
	
}
