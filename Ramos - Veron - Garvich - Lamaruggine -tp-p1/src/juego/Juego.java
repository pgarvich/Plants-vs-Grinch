package juego;

import entorno.Entorno;
import entorno.Herramientas;
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
	    this.reloj = new Reloj(0);
	    this.menu = new Menu(this.estado);
	    this.cripta = new Cripta(this.entorno, this.estado, this.reloj);
	    this.jardin = new Jardin(this.entorno, this.estado, this.reloj, this.menu, this.cripta);
 	    this.combate = new Combate(this.entorno, this.jardin, this.cripta, this.estado, this.reloj);
	    
	    this.entorno.iniciar();
	}
	
	public void dibujarRegalos() {
		if(estado.esDerrota()) {
			if(cripta.regalo1)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 226, 0);
			if(cripta.regalo2)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 353, 0);
			if(cripta.regalo3)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 482, 0);
			if(cripta.regalo4)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 612, 0);
			if(cripta.regalo5)
				entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 736, 0);
		}
		
		if(estado.esJuego() || estado.esVictoria()) {
		if (reloj.ciclos(200, 1200)) {			//1er regalo
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 226, 0);
		}
		else if (reloj.ciclos(400,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 220, 0);
		}
		else if (reloj.ciclos(600,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 216, 0);
		}
		else if (reloj.ciclos(800,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 210, 0);
		}
		else if (reloj.ciclos(1000,  1200)) {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 204, 0);
		}
		else {
    		entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 198, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//segundo
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 353, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 347, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 341, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 335, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 329, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 323, 0);
		}
		
		if (reloj.ciclos(200, 1200)) { //tercero
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 482, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 476, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 470, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 464, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 458, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 452, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//cuarto
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 612, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 606, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 600, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 594, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 588, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 582, 0);
		}
		
		if (reloj.ciclos(200, 1200)) {		//quinto
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 736, 0);
		}
		else if (reloj.ciclos(400, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 730, 0);
		}
		else if (reloj.ciclos(600, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 724, 0);
		}
		else if (reloj.ciclos(800, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 718, 0);
		}
		else if (reloj.ciclos(1000, 1200)) {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 712, 0);
		}
		else {
		    entorno.dibujarImagen(Herramientas.cargarImagen("personajes/regalo1.png"), 55, 706, 0);
		}
		}
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick(){
		// Procesamiento de un instante de tiempo
		menu.dibujarMenu(this.entorno);
		
		////////////////////////////GESTION DEL RELOJ///////////////////////////////////////
		if(estado.esJuego() && estado.estadoAnterior == 1)
			reloj.tiempoObjeto(this.entorno, true, false, false, false);
		if(estado.esPausa() && estado.estadoAnterior == 2)
			reloj.tiempoObjeto(this.entorno,false, true, false, false);
		if(estado.esJuego() && estado.estadoAnterior == 3)
			reloj.tiempoObjeto(this.entorno, false, false, true, false);
		if(estado.esJuego() || estado.esDerrota() || estado.esVictoria())
			reloj.tiempoObjeto(this.entorno, false, false, false, true);
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
			jardin.dibujarPociones();
			jardin.verificarPociones();
			cripta.mostrarZombiesVivos(18, 755, 135); 
			cripta.mostrarZombiesEliminados(18, 762, 160);
			reloj.mostrarTiempo(this.entorno, 18, 730, 94);
			jardin.mostrarAbono(18, 860, 94);
		}
		cripta.verZColosal();
		combate.debilitamiento();
		dibujarRegalos();
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
