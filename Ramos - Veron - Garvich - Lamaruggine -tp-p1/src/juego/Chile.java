package juego;

import entorno.Entorno;

public class Chile {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	int posX;
	int posY;
	int vida = 100;
	int damage = 300;
	int abonoN = 120;
	int minXExplosion;
	int maxXExplosion;
	int minYExplosion;
	int maxYExplosion;
	
	public Chile(Entorno entorno, Estado estado, Reloj reloj, int posX, int posY) {
		super();
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		this.posX = posX;
		this.posY = posY;
		calcularRangoExplosion();
	}
	
	private void calcularRangoExplosion() {
		switch (posX) {
	    	case 180:
	        	minXExplosion = 120;
	        	maxXExplosion = 240;
	        	break;
	    	case 305:
	        	minXExplosion = 240;
	        	maxXExplosion = 370;
	        	break;
	    	case 435:
	        	minXExplosion = 370;
	        	maxXExplosion = 500;
	        	break;
	    	case 565:
	        	minXExplosion = 500;
	        	maxXExplosion = 630;
	        	break;
	    	case 693:
	        	minXExplosion = 630;
	        	maxXExplosion = 755;
	        	break;
	    	case 820:
	        	minXExplosion = 755;
	        	maxXExplosion = 885;
	        	break;
	    	case 948:
	        	minXExplosion = 885;
	        	maxXExplosion = 1010;
	        	break;
	    	case 1073:
	        	minXExplosion = 1010;
	        	maxXExplosion = 1135;
	        	break;
	    	case 1198:
	        	minXExplosion = 1135;
	        	maxXExplosion = 1260;
	        	break;
	    	case 1325:
	        	minXExplosion = 1260;
	        	maxXExplosion = 1390;
	        	break;
		}

		switch (posY) {
	    	case 229:
	        	minYExplosion = 170;
	        	maxYExplosion = 288;
	        	break;
	    	case 352:
	        	minYExplosion = 288;
	        	maxYExplosion = 415;
	        	break;
	    	case 480:
	        	minYExplosion = 415;
	        	maxYExplosion = 545;
	        	break;
	    	case 608:
	        	minYExplosion = 545;
	        	maxYExplosion = 670;
	        	break;
	    	case 735:
	        	minYExplosion = 670;
	        	maxYExplosion = 800;
	        	break;
		}

	}
	
}
