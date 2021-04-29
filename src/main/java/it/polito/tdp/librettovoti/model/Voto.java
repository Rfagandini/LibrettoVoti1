package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

/**
 * Creazione di un corso superato, include voto, nome del corso e anche la data di superamento
 */

public class Voto implements Comparable<Voto>{

	
	private int voto;
	private String nomeCorso;
	private LocalDate data;
	public Voto(int voto, String nomeCorso, LocalDate data) {
		
		
		this.voto = voto;
		this.nomeCorso = nomeCorso;
		this.data = data;
		
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public int compareTo(Voto o) {
		
		if(this.getNomeCorso().equals(o.getNomeCorso())) {
			return this.getVoto()-o.getVoto();
		}
		
		return this.getNomeCorso().compareTo(o.getNomeCorso());
	}
	@Override
	public String toString() {
		return "Exam of " + nomeCorso + " passed with " + voto + " on the: " + data ;
	}
	
	
	
}
