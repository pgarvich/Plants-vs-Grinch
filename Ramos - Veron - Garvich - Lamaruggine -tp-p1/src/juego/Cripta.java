package juego;
import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Cripta {
	private Entorno entorno;
	ZBase[] zBase;
	ZAlter[] zAlter;
	ZColosal zColosal;
	private Lapida[] lapidas;
	private Estado estado;
	private Reloj reloj;
	int ticksFuera;
	int cuantosTicks;
	int conteoBase;
	int conteoAlter;
	int zombiesMuertos = 0;
	int lapidaADisparar = -1;

	int zombiesVivos = 0;
	boolean regalo1 = true;
	boolean regalo2 = true;
	boolean regalo3 = true;
	boolean regalo4 = true;
	boolean regalo5 = true;

	public Cripta(Entorno entorno, Estado estado, Reloj reloj) {
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		
		this.zBase = new ZBase[40];
		
			for(int i = 0; i < zBase.length; i++) {
				zBase[i] = new ZBase(this.estado);
			}
		
		this.zAlter = new ZAlter[10];
		
			for(int i = 0; i < zAlter.length; i++) {
				zAlter[i] = new ZAlter(this.estado);				
			}
		
		this.zColosal = new ZColosal(this.estado);	
			
		this.lapidas = new Lapida[50];
	}
		
	public void rendirZombies() {
		if(zombiesMuertos == 50) {
			estado.setEstado(5);
		}
	}
	
	public void zombiesVictoriosos() {
	 
		if(zColosal != null && zColosal.vivo) {					//dibujar zombie Colosal                      
    	zColosal.derecha = true;
    	zColosal.desplazar();
    	if(!zColosal.zombieVictorioso) {
			if(reloj.ciclos(500, 1000)) {
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZC3.png"), zColosal.posX, 500, 0);
			}
			else {
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZC4.png"), zColosal.posX, 500, 0);
			}
		}
		else {
			if(reloj.ciclos(500, 1000)) {
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZCV1.png"), zColosal.posX, 500, 0);
			}
			else {
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZCV2.png"), zColosal.posX, 480, 0);
			}
			regalo1 = false;
			regalo2 = false;
			regalo3 = false;
			regalo4 = false;
			regalo5 = false;
		}
    }
	    
		for(int i = 0; i < zBase.length; i++) {        //dibujar zombies base
	        if (zBase[i] == null) 
	            continue;
	        if(zBase[i].vivo) {
	        	zBase[i].detener = false;
	            zBase[i].desplazar();
	            if(!zBase[i].zombieVictorioso) {
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase3.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase4.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	            }
	            else {
	                if (reloj.ciclos(200, 400))
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBaseV1.png"), zBase[i].posX, zBase[i].posY, 0);
	                else
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBaseV2.png"), zBase[i].posX, zBase[i].posY, 0);
	                if(zBase[i].posY == 220)
	                    regalo1 = false;
	                else if(zBase[i].posY == 350)
	                    regalo2 = false;
	                else if(zBase[i].posY == 480)
	                    regalo3 = false;
	                else if(zBase[i].posY == 610)
	                    regalo4 = false;
	                else
	                    regalo5 = false;
	            }
	        }
	    } 
	    for(int i = 0; i < zAlter.length; i++) {        //dibujar zombies base
	        if (zAlter[i] == null) 
	            continue;
	        if(zAlter[i].vivo) {
            	zAlter[i].detener = false;
	            zAlter[i].desplazar();
	            if(!zAlter[i].zombieVictorioso) {
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlter3.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlter4.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	            }
	            else {
	                if (reloj.ciclos(200, 400))
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlterV1.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                else
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlterV2.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                if(zAlter[i].posY == 220)
	                    regalo1 = false;
	                else if(zAlter[i].posY == 350)
	                    regalo2 = false;
	                else if(zAlter[i].posY == 480)
	                    regalo3 = false;
	                else if(zAlter[i].posY == 610)
	                    regalo4 = false;
	                else
	                    regalo5 = false;
	            }
	        }
	    } 
	} 
	public void dibujarZombies() {
		
		 if(zColosal != null && zColosal.vivo) {								//dibujar zombie Colosal 
			 zColosal.desplazar();
			 zColosal.victoriaZombie();
			 if(reloj.ciclos(500, 900)) {
				 entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZC1.png"), zColosal.posX, 500, 0);
			 }
			 else {
				 entorno.dibujarImagen(Herramientas.cargarImagen("personajes/ZC2.png"), zColosal.posX, 480, 0);
			 }
		 }
		 
	    for(int i = 0; i < zBase.length; i++) {        //dibujar zombies base
	        if (zBase[i] == null) 
	            continue;
	        if(zBase[i].vivo) {
	            zBase[i].desplazar();
	            zBase[i].victoriaZombie();
	            
	            if(zBase[i].detener) {
	                // Animación de ataque para zBase cuando está detenido
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBaseAtk1.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBaseAtk2.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	            }
	            else {
	                // Animación normal de caminata para zBase
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase1.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zBase2.png"), zBase[i].posX, zBase[i].posY, 0);
	                }
	            }
	        }
	    }
	    
	    for(int i = 0; i < zAlter.length; i++) {        //dibujar zombies alter
	        if (zAlter[i] == null) 
	            continue;
	        if(zAlter[i].vivo) {
	            zAlter[i].desplazar();
	            zAlter[i].victoriaZombie();
	            
	            if(zAlter[i].detener) {
	                // Animación de ataque para zAlter cuando está detenido
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlterAtk1.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlterAtk2.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	            }
	            else {
	                // Animación normal de caminata para zAlter
	                if (reloj.ciclos(200, 400)) {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlter1.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	                else {
	                    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/zAlter2.png"), zAlter[i].posX, zAlter[i].posY, 0);
	                }
	            }
	        }
	    }
	}
	
	public void dibujarLapidas() {
		for (int i = 0; i < lapidas.length; i++) {
			if (lapidas[i] != null) entorno.dibujarImagen(Herramientas.cargarImagen("personajes/lapida.png"), lapidas[i].ejeX, lapidas[i].ejeY, 0);
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
	        contarTicks(true);
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
	    if(zombiesMuertos == 1 && !zColosal.vivo) {						//dentro de spawnZombies (liena 269)
	    	zColosal.vivo = true;
	    	zColosal.posX = 1600;
	    	zColosal.posY = 400;
	    	zombiesVivos += 0;
	    	zColosal.derecha = false;	
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

	public void herirZombieEnPosicion(int x, int y, int damage, Jardin jardin) {
	    for (int i = 0; i < zBase.length; i++) {
	        if (zBase[i] != null && zBase[i].vivo) {
	            if (Math.abs(zBase[i].posX - x) < 30 && Math.abs(zBase[i].posY - y) < 30) {
	                zBase[i].vida -= damage;
	                if (zBase[i].vida <= 0) {
                    	int ejeX = zBase[i].posX;
                    	int ejeY = zBase[i].posY;
	                	zBase[i].vivo = false;
	                    zBase[i] = null;
	                    zombiesMuertos++;
	                    zombiesVivos--;
	                    
	                    int random = (int) (Math.random() * 100) + 1;
	                    if (random <= 50) {
	                    	int posibleX = calcularPosibleX(ejeX);
	                    	int posibleY = calcularPosibleY(ejeY);
	                    	if(!hayLapidaEnPosicion(posibleX, posibleY) && !jardin.hayPlantaEnPosicion(posibleX, posibleY)) {
	                    		Lapida lapida = new Lapida(entorno, estado, reloj, posibleX, posibleY, 1);
	                    		for(int a = 0; a < lapidas.length; a++) {
	                    			if (lapidas[i] == null) lapidas[i] = lapida;
	                    		}
	                    	}
	                    }
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
	                    zAlter[i] = null;
	                    zombiesMuertos++;
	                    zombiesVivos--;
	                }
	                return;
	            }
	        }
	    }
	}
	
	public void herirZombiesEnRango(Chile chile, Jardin jardin) {
		int minX = chile.minXExplosion;
		int maxX = chile.maxXExplosion;
		int minY = chile.minYExplosion;
		int maxY = chile.maxYExplosion;
		
		for(int i = 0; i < zBase.length; i++) {
			if(zBase[i] == null || !zBase[i].vivo) continue;
			if(zBase[i].posX < maxX && zBase[i].posX > minX && zBase[i].posY < maxY && zBase[i].posY > minY) {
				herirZombieEnPosicion(zBase[i].posX, zBase[i].posY, chile.damage, jardin);
			}
		}
		for(int i = 0; i < zAlter.length; i++) {
			if(zAlter[i] == null || !zAlter[i].vivo) continue;
			if(zAlter[i].posX < maxX && zAlter[i].posX > minX && zAlter[i].posY < maxY && zAlter[i].posY > minY) {
				herirZombieEnPosicion(zAlter[i].posX, zAlter[i].posY, chile.damage, jardin);
			}
		}
	}
	
	public void herirLapida(int damage) {
		if(lapidaADisparar == -1) return;
		lapidas[lapidaADisparar].vida -= damage;
		if(lapidas[lapidaADisparar].vida <= 0) lapidas[lapidaADisparar] = null;
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
	
	public void mostrarZombiesVivos(int tamanio, int posX, int posY) {
		String vivos = String.valueOf((zBase.length + zAlter.length) - zombiesMuertos);
		entorno.cambiarFont("Comic Sans MS", tamanio, Color.yellow);
		entorno.escribirTexto(vivos, posX, posY);
	}

	public void mostrarZombiesEliminados(int tamanio, int posX, int posY) {
		String eliminados = String.valueOf(zombiesMuertos); 
		entorno.cambiarFont("Comic Sans MS", tamanio, Color.yellow);
		entorno.escribirTexto(eliminados, posX, posY);
	}
	
	public boolean hayLapidaEnPosicion(int x, int y) {
		for(int i = 0; i < lapidas.length; i++) {
			if(lapidas[i] != null && Math.abs(lapidas[i].ejeX - x) < 30 && Math.abs(lapidas[i].ejeY - y) < 30) {
				lapidaADisparar = i;
				return true;
			}
		}
		return false;
	}
	
	private int calcularPosibleX(int x) {
		if(120 < x && x < 240) return 180;
		else if(240 < x && x < 370) return 305;
		else if(370 < x && x < 500) return 435;
		else if(500 < x && x < 630) return 565;
		else if(630 < x && x < 755) return 693;
		else if(755 < x && x < 885) return 820;
		else if(885 < x && x < 1010) return 948;
		else if(1010 < x && x < 1135) return 1073;
		else if(1135 < x && x < 1260) return 1198;
		else if(1260 < x && x < 1390) return 1325;
		return 1325;
	}
	private int calcularPosibleY(int y) {
		if(170 < y && y < 288) return 229;
		else if(288 < y && y < 415) return 352;
		else if(415 < y && y < 545) return 480;
		else if(545 < y && y < 670) return 608;
		else if(670 < y && y < 800) return 735;
		return 735;
	}
}
