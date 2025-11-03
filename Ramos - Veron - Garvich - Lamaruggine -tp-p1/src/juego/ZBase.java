package juego;
import entorno.Entorno;
import entorno.Herramientas;

public class ZBase {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	
	boolean vivo = false;
	boolean derecha = false;
	boolean detener = false;
	int posX;
	int posY;
	int vida = 80;
	boolean zombieVictorioso = false;
			
	public ZBase(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;

	}
	public void desplazar() {
		 if(detener)
			return;
		 
		else if(!derecha)
			posX -= 0.8;
		
		else
			posX += 1;
	}
	public void victoriaZombie() {
		if(posX <= 100) {
			estado.setEstado(4);
			zombieVictorioso = true;
		}
	}
}

