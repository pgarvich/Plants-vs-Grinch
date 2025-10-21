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
				zBase[i] = new ZBase(this.entorno, this.estado, this.reloj);				
			}
	}
	
	public void rendirZombies() {
		if(zombiesMuertos == 70) {
			estado.setEstado(5);
		}
	}
	
	public void cadaZombie() {

		if(conteoBase >= zBase.length && conteoAlter >= zAlter.length) {
			return; //no crear mas zombies, array lleno
		}
		
		int num = (int)(Math.random() * 50) + 1;		//Qué tipo de zombie
		int cara = (int) (Math.random() * 5) + 1;		//Ver en qué línea cae
		
		if (num >= 40 && conteoAlter < zAlter.length) {
			zAlter[conteoAlter].vivo = true;
			
			
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
