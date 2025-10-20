package juego;
import entorno.Entorno;

public class Cripta {
	private Entorno entorno;
	private ZBase zbase;
	private Estado estado;
	int ticksFuera;
	int cuantosTicks;
	int conteoZombies;
	int zombiesMuertos = 0;

	public Cripta(Entorno entorno, Estado estado) {
		this.entorno = entorno;
		this.estado = estado;
	}
	
	public void rendirZombies() {
		if(zombiesMuertos == 70) {
			estado.setEstado(5);
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
	
}
