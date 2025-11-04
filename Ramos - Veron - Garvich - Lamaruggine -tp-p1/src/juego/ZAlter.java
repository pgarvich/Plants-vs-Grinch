package juego;


public class ZAlter {
    private Estado estado;
    
    boolean vivo = false;
    int posX;
    int posY;
    int vida = 40;
    int ultimoDisparo = 0;
    boolean detener = false;
    boolean zombieVictorioso = false;
    
    public ZAlter(Estado estado) {
        this.estado = estado;
    }
    
    public void desplazar() {
        if(detener) {
            return;
        }
        else if(estado.esJuego()) {
            // Moverse hacia la izquierda durante el juego
            posX -= 1.5;
        }
        else if(estado.esDerrota()) {
            // Moverse hacia la derecha durante la derrota
            posX += 1.5;
        }
    }
    
    public void victoriaZombie() {
        if(posX <= 100 && estado.esJuego()) {
            estado.setEstado(4);
            zombieVictorioso = true;
        }
    }
    
    public boolean puedeDisparar(Reloj reloj) {
		int actual = reloj.getTiempo();
		if (actual - ultimoDisparo >= 2000 && !detener) {
			ultimoDisparo = actual;
			return true;
		}
		return false;
	}
}