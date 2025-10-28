package juego;
import entorno.Entorno;
import entorno.Herramientas;

public class Cripta {
	private Entorno entorno;
	private ZBase[] zBase;
	private ZAlter[] zAlter;
	private Estado estado;
	private Reloj reloj;
	int ticksFuera;
	int cuantosTicks;
	int conteoBase;
	int conteoAlter;
	int zombiesMuertos = 0;
	int zombiesVivos = 0;

	public Cripta(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		
		this.zBase = new ZBase[40];
		
			for(int i = 0; i < zBase.length; i++) {
				zBase[i] = new ZBase(this.entorno, this.estado, this.reloj);
			}
		
		this.zAlter = new ZAlter[10];
		
			for(int i = 0; i < zAlter.length; i++) {
				zAlter[i] = new ZAlter(this.entorno, this.estado, this.reloj);				
			}
	}
	
	public void rendirZombies() {
		if(zombiesMuertos == 70) {
			estado.setEstado(5);
		}
	}
	
	public void dibujarZombies() {
		
			 for(int i = 0; i < zBase.length; i++) {		//dibujar zombies base
		            if (zBase[i] == null) 
		                continue;
		            if(zBase[i].vivo) {
		            	zBase[i].desplazar();
		            	if (reloj.ciclos(200, 400)) {
		            		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase1.png"), zBase[i].posX, zBase[i].posY, 0);
                 }
		            	else {
		            		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase2.png"), zBase[i].posX, zBase[i].posY, 0);
                 }			 
			 }
		 }
		
	}
	
	public void spawnZombies() {
	    if((conteoBase >= zBase.length && conteoAlter >= zAlter.length) || zombiesVivos >= 15) {
	        return;
	    }
	    contarTicks(false);
	    if(cuantosTicks > 200) {
	    
	    int linea = (int) (Math.random() * 5) + 1;
	    int posI;
	    if(linea == 1)
	        posI = 220;
	    else if(linea == 2)  // Agregar else if
	        posI = 350;
	    else if(linea == 3)
	        posI = 480;
	    else if(linea == 4)
	        posI = 610;
	    else
	        posI = 740;
	    
	    int num = (int)(Math.random() * 50) + 1;

	    if (num >= 40 && conteoAlter < zAlter.length) {
	        // Zombie Alter
	        zAlter[conteoAlter].vivo = true;
	        zAlter[conteoAlter].posX = 1500;
	        zAlter[conteoAlter].posY = posI;
	        conteoAlter += 1;
	        zombiesVivos += 1;
	    } 
	    else if (conteoBase < zBase.length) {
	        // Zombie Base
	        zBase[conteoBase].vivo = true;
	        zBase[conteoBase].posX = 1500;
	        zBase[conteoBase].posY = posI;
	        conteoBase += 1;  
	        zombiesVivos += 1;
	        contarTicks(true);
	    }
	    

	}
	}	
	
	public void contarTicks(boolean iniciar) {
		if(entorno == null) {
			return;
		}
		if(iniciar) {
			ticksFuera = entorno.numeroDeTick();
		}
		else{
			cuantosTicks = entorno.numeroDeTick() - ticksFuera;
		}
	}
	
	public boolean hayZombieEnPosicion(int x, int y) {
	    for (int i = 0; i < zBase.length; i++) {
	        if (zBase[i] != null && zBase[i].vivo) {
	            if (Math.abs(zBase[i].posX - x) < 30 && Math.abs(zBase[i].posY - y) < 30) {
	                return true;
	            }
	        }
	    }
	    for (int i = 0; i < zAlter.length; i++) {
	        if (zAlter[i] != null && zAlter[i].vivo) {
	            if (Math.abs(zAlter[i].posX - x) < 30 && Math.abs(zAlter[i].posY - y) < 30) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public void herirZombieEnPosicion(int x, int y, int damage) {
	    for (int i = 0; i < zBase.length; i++) {
	        if (zBase[i] != null && zBase[i].vivo) {
	            if (Math.abs(zBase[i].posX - x) < 30 && Math.abs(zBase[i].posY - y) < 30) {
	                zBase[i].vida -= damage;
	                if (zBase[i].vida <= 0) {
	                    zBase[i].vivo = false;
	                    zombiesMuertos++;
	                    zombiesVivos--;
	                }
	                return;
	            }
	        }
	    }
	    for (int i = 0; i < zAlter.length; i++) {
	        if (zAlter[i] != null && zAlter[i].vivo) {
	            if (Math.abs(zAlter[i].posX - x) < 30 && Math.abs(zAlter[i].posY - y) < 30) {
	                zAlter[i].vida -= damage;
	                if (zAlter[i].vida <= 0) {
	                    zAlter[i].vivo = false;
	                    zombiesMuertos++;
	                    zombiesVivos--;
	                }
	                return;
	            }
	        }
	    }
	}

	public boolean hayZombieEnFila(int posX, int posY) {
	    for (int i = 0; i < zBase.length; i++) {
	        if (zBase[i] != null && zBase[i].vivo 
	            && Math.abs(zBase[i].posY - posY) < 30
	            && zBase[i].posX > posX) {
	            return true;
	        }
	    }
	    for (int i = 0; i < zAlter.length; i++) {
	        if (zAlter[i] != null && zAlter[i].vivo
	            && Math.abs(zAlter[i].posY - posY) < 30
	            && zAlter[i].posX > posX) {
	            return true;
	        }
	    }
	    return false;
	}

	
}
