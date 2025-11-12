package juego;


	public class ZColosal {
		private Estado estado;
		
		boolean vivo = false;
		double posX;
		int posY;
		int vida = 5000;
		boolean derecha = false;
		boolean zombieVictorioso = false;
		
		public ZColosal(Estado estado) {
			this.estado = estado;

	}
		public void desplazar() {
			if(!derecha)
				posX -= 0.4; 
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
