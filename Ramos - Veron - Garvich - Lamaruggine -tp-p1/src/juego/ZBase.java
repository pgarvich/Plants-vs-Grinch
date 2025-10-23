package juego;
import entorno.Entorno;
import entorno.Herramientas;

public class ZBase {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	
	boolean vivo = false;
	boolean detener = false;
	int posX;
	int posY;
	
	public ZBase(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;

}
	public void desplazar() {
		if(!detener) {
			posX -= 1;
		}
		
	}
	}

