package juego;
import entorno.Entorno;

public class BolaDeFuego {

	private Estado estado;
	private Reloj reloj;
	private Rosa rosa;
	
	int posX;
	int posY;
	int damage = 20;
	
	public BolaDeFuego(Estado estado, Reloj reloj, Rosa rosa) {
		super();
		this.estado = estado;
		this.reloj = reloj;
		this.rosa = rosa;
		posX = rosa.posX;
		posY = rosa.posY;
	}
	
	public void desplazar() {
			posX += 7;
	}
	
}
