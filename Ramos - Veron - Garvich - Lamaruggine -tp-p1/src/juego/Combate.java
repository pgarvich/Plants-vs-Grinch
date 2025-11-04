package juego;
import entorno.Entorno;
import entorno.Herramientas;

public class Combate {
    private Jardin jardin;
    private Cripta cripta;
    private Estado estado;
    private Reloj reloj;
    private Entorno entorno;
    
    public Combate(Entorno entorno, Jardin jardin, Cripta cripta, Estado estado, Reloj reloj) {
        this.jardin = jardin;
        this.cripta = cripta;
        this.estado = estado;
        this.reloj = reloj;
        this.entorno = entorno; // Necesitamos el entorno para dibujar
    }
    
    public void debilitamiento() {
        if(!estado.esJuego()) return;
        
        // Reiniciar todos los estados de detención primero
        for(int j = 0; j < cripta.zBase.length; j++) {
            if(cripta.zBase[j] != null && cripta.zBase[j].vivo) {
                cripta.zBase[j].detener = false;
            }
        }
        for(int j = 0; j < cripta.zAlter.length; j++) {
            if(cripta.zAlter[j] != null && cripta.zAlter[j].vivo) {
                cripta.zAlter[j].detener = false;
            }
        }
        
        // Ahora verificar colisiones
        for(int i = 0; i < jardin.nuez.length; i++) {        
            if (jardin.nuez[i] == null || !jardin.nuez[i].vivo) continue;
            
            for(int j = 0; j < cripta.zBase.length; j++) {
                if(cripta.zBase[j] != null && cripta.zBase[j].vivo) {
                    if(Math.abs(cripta.zBase[j].posY - jardin.nuez[i].posY) < 30 && 
                       cripta.zBase[j].posX - jardin.nuez[i].posX <= 80 && 
                       cripta.zBase[j].posX - jardin.nuez[i].posX > 0) {
                        cripta.zBase[j].detener = true;
                        jardin.nuez[i].vida -= 1;
                        if(jardin.nuez[i].vida <= 0) {
                            jardin.nuez[i].vivo = false;
                        }
                    }
                }
            }

            for(int j = 0; j < cripta.zAlter.length; j++) {
                if(cripta.zAlter[j] != null && cripta.zAlter[j].vivo) {
                    if(Math.abs(cripta.zAlter[j].posY - jardin.nuez[i].posY) < 30 && 
                       cripta.zAlter[j].posX - jardin.nuez[i].posX <= 80 && 
                       cripta.zAlter[j].posX - jardin.nuez[i].posX > 0) {
                        cripta.zAlter[j].detener = true;
                        jardin.nuez[i].vida -= 1;
                        
                        if(jardin.nuez[i].vida <= 0) {
                            jardin.nuez[i].vivo = false;
                        }
                    }
                }
            }
        }
        
        // Misma lógica para rosas
        for(int i = 0; i < jardin.rosa.length; i++) {        
            if (jardin.rosa[i] == null || !jardin.rosa[i].vivo) continue;
            
            for(int j = 0; j < cripta.zBase.length; j++) {
                if(cripta.zBase[j] != null && cripta.zBase[j].vivo) {
                    if(Math.abs(cripta.zBase[j].posY - jardin.rosa[i].posY) < 30 && 
                       cripta.zBase[j].posX - jardin.rosa[i].posX <= 80 && 
                       cripta.zBase[j].posX - jardin.rosa[i].posX > 0) {
                        cripta.zBase[j].detener = true;
                        jardin.rosa[i].vida -= 1;
                        
                        if(jardin.rosa[i].vida <= 0) {
                            jardin.rosa[i].vivo = false;
                        }
                    }
                }
            }

            for(int j = 0; j < cripta.zAlter.length; j++) {
                if(cripta.zAlter[j] != null && cripta.zAlter[j].vivo) {
                    if(Math.abs(cripta.zAlter[j].posY - jardin.rosa[i].posY) < 30 && 
                       cripta.zAlter[j].posX - jardin.rosa[i].posX <= 80 && 
                       cripta.zAlter[j].posX - jardin.rosa[i].posX > 0) {
                        cripta.zAlter[j].detener = true;
                        jardin.rosa[i].vida -= 1;
                        
                        if(jardin.rosa[i].vida <= 0) {
                            jardin.rosa[i].vivo = false;
                        }
                    }
                }
            }
        }
        
        // colisiones de chiles
        for(int i = 0; i < jardin.chile.length; i++) {
        	if(jardin.chile[i] == null) continue;
        	
        	for(int j = 0; j < cripta.zBase.length; j++) {
                if(cripta.zBase[j] != null && cripta.zBase[j].vivo) {
                    if(Math.abs(cripta.zBase[j].posY - jardin.chile[i].posY) < 30 && 
                       cripta.zBase[j].posX - jardin.chile[i].posX <= 80 && 
                       cripta.zBase[j].posX - jardin.chile[i].posX > 0) {
                        cripta.herirZombiesEnRango(jardin.chile[i], jardin);
                        jardin.chile[i].explotando = true;
                        break;
                    }
                }
            }
        	
        	if(jardin.chile[i] == null) continue;
        	
        	for(int j = 0; j < cripta.zAlter.length; j++) {
                if(cripta.zAlter[j] != null && cripta.zAlter[j].vivo) {
                    if(Math.abs(cripta.zAlter[j].posY - jardin.chile[i].posY) < 30 && 
                       cripta.zAlter[j].posX - jardin.chile[i].posX <= 80 && 
                       cripta.zAlter[j].posX - jardin.chile[i].posX > 0) {
                        cripta.herirZombiesEnRango(jardin.chile[i], jardin);
                        jardin.chile[i].explotando = true;
                        break;
                    }
                }
            }
        	
        }
    }
    
    public void gestionarDisparos() {
        if(!estado.esJuego()) return;
        
        // Gestiona los disparos de las rosas
        for(int i = 0; i < jardin.rosa.length; i++) {
            Rosa r = jardin.rosa[i];
            if (r == null || !r.vivo) continue;
            
            if (r.puedeDisparar() && cripta.hayZombieEnFila(r.posX, r.posY)) {
                BolaDeFuego bola = r.disparar();
                if (jardin.conteoBFuego >= jardin.bFuego.length * 0.9) {
                    aumentarLengthBFuego();
                }
                for(int a = 0; a < jardin.bFuego.length; a++) {
                    if (jardin.bFuego[a] == null) {
                        jardin.bFuego[a] = bola;
                        jardin.conteoBFuego++;
                        break;
                    }
                }
            }
        }
        
        // Gestiona los disparos de los zombies base
        for(int i = 0; i < cripta.zBase.length; i++) {
        	ZBase z = cripta.zBase[i];
        	if(z == null || !z.vivo) continue;
        	
        	if (z.puedeDisparar(reloj) && jardin.hayPlantaEnFila(z.posX, z.posY)) {
                BolaDeNieve bola = new BolaDeNieve(entorno, estado, reloj, z.posX, z.posY);
                if (jardin.conteoBNieve >= jardin.bNieve.length * 0.9) {
                    aumentarLengthBNieve();
                }
                for(int j = 0; j < jardin.bNieve.length; j++) {
                    if (jardin.bNieve[j] == null) {
                        jardin.bNieve[j] = bola;
                        jardin.conteoBNieve++;
                        break;
                    }
                }
            }
        }
        
        // Disparos de zombies alter
        for(int i = 0; i < cripta.zAlter.length; i++) {
        	ZAlter z = cripta.zAlter[i];
        	if(z == null || !z.vivo) continue;
        	
        	if (z.puedeDisparar(reloj) && jardin.hayPlantaEnFila(z.posX, z.posY)) {
                BolaDeNieve bola = new BolaDeNieve(entorno, estado, reloj, z.posX, z.posY);
                if (jardin.conteoBNieve >= jardin.bNieve.length * 0.9) {
                    aumentarLengthBNieve();
                }
                for(int j = 0; j < jardin.bNieve.length; j++) {
                    if (jardin.bNieve[j] == null) {
                        jardin.bNieve[j] = bola;
                        jardin.conteoBNieve++;
                        break;
                    }
                }
            }
        }
    }
    
    public void dibujarProyectiles() {
        // Dibuja las bolas de fuego
        for(int i = 0; i < jardin.bFuego.length; i++) {
            BolaDeFuego b = jardin.bFuego[i];
            if (b == null) continue;
            b.desplazar();
            entorno.dibujarImagen(Herramientas.cargarImagen("personajes/bolaDeFuego.png"), b.posX, b.posY-35, 0);
            
            if (cripta.hayZombieEnPosicion(b.posX, b.posY)) {
                cripta.herirZombieEnPosicion(b.posX, b.posY, b.damage, jardin);
                jardin.bFuego[i] = null;
                jardin.conteoBFuego--;
            } else if(cripta.hayLapidaEnPosicion(b.posX, b.posY)) {
                cripta.herirLapida(b.damage);
                jardin.bFuego[i] = null;
                jardin.conteoBFuego--;
            }
            if (b.posX > 1400) {
                jardin.bFuego[i] = null;
                jardin.conteoBFuego--;
            }
        }
        // dibuja las bolas de nieve
        for(int i = 0; i < jardin.bNieve.length; i++) {
        	BolaDeNieve b = jardin.bNieve[i];
        	if(b == null) continue;
        	b.desplazar();
            entorno.dibujarImagen(Herramientas.cargarImagen("personajes/bolaDeNieve.png"), b.posX, b.posY, 0);
            
            if(jardin.hayPlantaEnPosicion(b.posX, b.posY)) {
            	herirPlantaADisparar(b.damage);
            	jardin.bNieve[i] = null;
            	jardin.conteoBNieve--;
            }
            if(b.posX < 0) {
            	jardin.bNieve[i] = null;
            	jardin.conteoBNieve--;
            }
        }
    }
    
    // Método auxiliar para aumentar el array de bolas de fuego
    public void aumentarLengthBFuego() {
        int length = (int) (jardin.bFuego.length * 1.5);
        BolaDeFuego[] nuevo = new BolaDeFuego[length];
        for (int i = 0; i < jardin.bFuego.length; i++) {
            nuevo[i] = jardin.bFuego[i];
        }
        jardin.bFuego = nuevo;
    }
    
    // misma lógica para las bolas de nieve
    public void aumentarLengthBNieve() {
    	int length = (int) (jardin.bNieve.length * 1.5);
    	BolaDeNieve[] nuevo = new BolaDeNieve[length];
    	for (int i = 0; i < jardin.bNieve.length; i++) {
    		nuevo[i] = jardin.bNieve[i];
    	}
    	jardin.bNieve = nuevo;
    }
    
	public void herirPlantaADisparar(int damage) {
		int i = jardin.indexPlantaADisparar;
		String tipo = jardin.tipoPlantaADisparar;
		if(i == -1) return;
		else if(tipo == "rosa") {
			jardin.rosa[i].vida -= damage;
			if (jardin.rosa[i].vida <= 0) jardin.rosa[i].vivo = false;
		}
		else if(tipo == "nuez") {
			jardin.nuez[i].vida -= damage;
			if (jardin.nuez[i].vida <= 0) jardin.nuez[i].vivo = false;
		}
		else if(tipo == "chile") {
			jardin.chile[i].vida -= damage;
			if (jardin.chile[i].vida <= 0) jardin.chile[i] = null;
		}
	}
}