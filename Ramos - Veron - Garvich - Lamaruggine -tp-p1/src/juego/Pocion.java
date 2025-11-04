package juego;

public class Pocion {
	int posX;
	int posY;
	int tiempoCreacion;
	boolean esPositiva;
	
	public Pocion(Reloj reloj, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		tiempoCreacion = reloj.getTiempo();
		esPositiva = ( (Math.random() * 10) < 5) ? true : false;
	}
	
}
