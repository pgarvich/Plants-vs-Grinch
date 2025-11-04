package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	private Cripta cripta;
	private Menu menu;
	private Jardin jardin;
	private Combate combate;
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego() {
	    this.entorno = new Entorno(this, "La Invasión de los Zombies Grinch", 1400, 800);
	    
	    this.estado = new Estado();
	    this.reloj = new Reloj(this.entorno, this.estado, 0);
	    this.menu = new Menu(this.entorno, this.estado);
	    this.cripta = new Cripta(this.entorno, this.estado, this.reloj);
	    this.jardin = new Jardin(this.entorno, this.estado, this.reloj, this.menu, this.cripta);
 	    this.combate = new Combate(this.entorno, this.jardin, this.cripta, this.estado);
	    
	    this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick(){
		// Procesamiento de un instante de tiempo
		menu.dibujarMenu();
		
		////////////////////////////GESTION DEL RELOJ///////////////////////////////////////
		if(estado.esJuego() && estado.estadoAnterior == 1)
			reloj.tiempoObjeto(true, false, false, false);
		if(estado.esPausa() && estado.estadoAnterior == 2)
			reloj.tiempoObjeto(false, true, false, false);
		if(estado.esJuego() && estado.estadoAnterior == 3)
			reloj.tiempoObjeto(false, false, true, false);
		if(estado.esJuego() || estado.esDerrota() || estado.esVictoria())
			reloj.tiempoObjeto(false, false, false, true);
		estado.estadoAnterior = estado.getEstado();	
		////////////////////////////////////////////////////////////////////////////////////
		jardin.dibujarPlantas();
		if (estado.esJuego()) {
			cripta.spawnZombies();
			cripta.dibujarLapidas();
			jardin.dibujarPlantas();
			cripta.dibujarZombies();
			jardin.spawnPlanta();
			jardin.moverPlanta();
			jardin.crearAbono();
			combate.gestionarDisparos();
			combate.dibujarProyectiles();
			cripta.mostrarZombiesVivos(18, 755, 135); 
			cripta.mostrarZombiesEliminados(18, 762, 160);
			reloj.mostrarTiempo(18, 730, 94);
			
		}
		combate.debilitamiento();
		jardin.dibujarRegalos();
		jardin.victoriaPlanta();
		if(estado.esDerrota()) {
			cripta.zombiesVictoriosos();
			
		}

		// ...
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
