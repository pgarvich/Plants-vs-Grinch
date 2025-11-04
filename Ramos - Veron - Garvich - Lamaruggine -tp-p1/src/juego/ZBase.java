package juego;


public class ZBase {
    private Estado estado;
    
    boolean vivo = false;
    boolean detener = false;
    int posX;
    int posY;
    int vida = 80;
    boolean zombieVictorioso = false;
    
    public ZBase(Estado estado) {
        this.estado = estado;
    }
    
    public void desplazar() {
        if(detener) {
            return;
        }
        else if(estado.esJuego()) {
            // Moverse hacia la izquierda durante el juego
            posX -= 1.0;
        }
        else if(estado.esDerrota()) {
            // Moverse hacia la derecha durante la derrota
            posX += 1.0;
        }
    }
    
    public void victoriaZombie() {
        if(posX <= 100 && estado.esJuego()) {
            estado.setEstado(4);
            zombieVictorioso = true;
        }
    }
}

