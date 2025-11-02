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
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		
		this.entorno = new Entorno(this, "La Invasión de los Zombies Grinch", 1400, 800);
		
		// Inicializar lo que haga falta para el juego
		this.estado = new Estado();
		this.reloj = new Reloj(this.entorno, this.estado, 0);
		this.menu = new Menu(this.entorno, this.estado, this.reloj);
		this.cripta = new Cripta(this.entorno, this.estado, this.reloj);
		this.jardin = new Jardin(this.entorno, this.estado, this.reloj, this.menu, this.cripta);
		

		

		// Inicia el juego!
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
		if(estado.esJuego() || estado.esDerrota())
			reloj.tiempoObjeto(false, false, false, true);
		estado.estadoAnterior = estado.getEstado();	
		////////////////////////////////////////////////////////////////////////////////////
		jardin.dibujarPlantas();
		if (estado.esJuego()) {
			cripta.spawnZombies();
			cripta.dibujarZombies();
			jardin.spawnPlanta();
			jardin.crearAbono();

			jardin.dibujarProyectiles();
			cripta.mostrarZombiesVivos(18, 755, 135); 
			cripta.mostrarZombiesEliminados(18, 762, 160);
			reloj.mostrarTiempo(18, 730, 94);
			
		}
		jardin.dibujarRegalos();
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
