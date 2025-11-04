package juego;


public class Chile {
	int posX;
	int posY;
	int vida = 100;
	int damage = 300;
	int abonoN = 100;
	int minXExplosion;
	int maxXExplosion;
	int minYExplosion;
	int maxYExplosion;
	boolean explotando = false;
	int contadorExplosion = 60;
	
	public Chile(int posX, int posY) {
		super();

		this.posX = posX;
		this.posY = posY;
		calcularRangoExplosion();
	}
	
	private void calcularRangoExplosion() {
		switch (posX) {
	    	case 180:
	        	minXExplosion = 0;
	        	maxXExplosion = 370;
	        	break;
	    	case 305:
	        	minXExplosion = 120;
	        	maxXExplosion = 500;
	        	break;
	    	case 435:
	        	minXExplosion = 240;
	        	maxXExplosion = 630;
	        	break;
	    	case 565:
	        	minXExplosion = 370;
	        	maxXExplosion = 755;
	        	break;
	    	case 693:
	        	minXExplosion = 500;
	        	maxXExplosion = 885;
	        	break;
	    	case 820:
	        	minXExplosion = 630;
	        	maxXExplosion = 1010;
	        	break;
	    	case 948:
	        	minXExplosion = 755;
	        	maxXExplosion = 1135;
	        	break;
	    	case 1073:
	        	minXExplosion = 885;
	        	maxXExplosion = 1260;
	        	break;
	    	case 1198:
	        	minXExplosion = 1010;
	        	maxXExplosion = 1390;
	        	break;
	    	case 1325:
	        	minXExplosion = 1135;
	        	maxXExplosion = 1515;
	        	break;
		}

		switch (posY) {
	    	case 220:
	        	minYExplosion = 170;
	        	maxYExplosion = 415;
	        	break;
	    	case 350:
	        	minYExplosion = 170;
	        	maxYExplosion = 545;
	        	break;
	    	case 480:
	        	minYExplosion = 288;
	        	maxYExplosion = 670;
	        	break;
	    	case 610:
	        	minYExplosion = 415;
	        	maxYExplosion = 800;
	        	break;
	    	case 740:
	        	minYExplosion = 545;
	        	maxYExplosion = 800;
	        	break;
		}
	}
	
}
