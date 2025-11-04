package juego;
import entorno.Entorno;
import entorno.Herramientas;

	public class ZColosal {
		private Estado estado;
		
		boolean vivo = false;
		double posX;
		int posY;
		int vida = 10;
		boolean derecha = false;
		boolean zombieVictorioso = false;
		
		public ZColosal(Estado estado) {
			this.estado = estado;

	}
		public void desplazar() {
			if(!derecha)
				posX -= 0.2; // mover 1 pixel por tick hacia la izquierda
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
