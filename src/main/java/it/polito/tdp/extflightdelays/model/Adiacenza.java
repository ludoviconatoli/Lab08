package it.polito.tdp.extflightdelays.model;

public class Adiacenza {

	private int origin_id;
	private int destination_id;
	private int distanza;
	private int peso;
	
	public Adiacenza(int origin_id, int destination_id, int distanza, int peso) {
		super();
		this.origin_id = origin_id;
		this.destination_id = destination_id;
		this.distanza = distanza;
		this.peso = peso;
	}

	public int getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(int origin_id) {
		this.origin_id = origin_id;
	}

	public int getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(int destination_id) {
		this.destination_id = destination_id;
	}

	public int getDistanza() {
		return distanza;
	}

	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
