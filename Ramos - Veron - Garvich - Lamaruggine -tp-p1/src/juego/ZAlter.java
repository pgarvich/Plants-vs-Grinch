package juego;
import entorno.Entorno;
import entorno.Herramientas;

public class ZAlter {
    private Entorno entorno;
    private Estado estado;
    private Reloj reloj;
    
    boolean vivo = false;
    int posX;
    int posY;
    int vida = 40;
    boolean detener = false;
    boolean zombieVictorioso = false;
    
    public ZAlter(Entorno entorno, Estado estado, Reloj reloj) {
        this.entorno = entorno;
        this.estado = estado;
        this.reloj = reloj;
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
}