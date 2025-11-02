package juego;

import entorno.Entorno;

public class Lapida {
	private Entorno entorno;
	private Estado estado;
	private Reloj reloj;
	int ejeX;
	int ejeY;
	int vida = 100;
	int tipoDeLapida;
	
	public Lapida(Entorno entorno, Estado estado, Reloj reloj, int ejeX, int ejeY, int tipoDeLapida) {
		super();
		this.entorno = entorno;
		this.estado = estado;
		this.reloj = reloj;
		this.ejeX = ejeX;
		this.ejeY = ejeY;
		this.tipoDeLapida = tipoDeLapida;
	}
}
