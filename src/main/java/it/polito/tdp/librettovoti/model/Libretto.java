package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;


public class Libretto {
	
	TreeMap<String,Voto> MapVoto = new TreeMap<String,Voto>();
	ArrayList<Voto> ArrayVoto = new ArrayList<Voto>();
	String perro = "This Subject has already been submitted";
	Boolean gato = false;
	
public Collection<Voto> GetCorsiSuperatiInOrdine() {
	
	ArrayList<Voto> ArrayVotoxx = new ArrayList<Voto>(ArrayVoto);
	
	Collections.sort(ArrayVotoxx);
	
	return ArrayVotoxx;
	
	}

public String StringDiCorsiSuperati() {
	
	String s = "";
	
	for(Voto v: GetCorsiSuperatiInOrdine()) {
		s += v.toString()+"\n";
	}
	
	return s.trim();
}

public void AddVoto (String nomecorso, int voto, LocalDate datasuperamento) {
	
	if(MapVoto.get(nomecorso)==null) {
		Voto v = new Voto(voto,nomecorso,datasuperamento);
		MapVoto.put(nomecorso, v);
		ArrayVoto.add(v);
		gato = false;
	}
	
	else{
		gato = true;
	}
}

public String RepeatedCourse() {
	return perro;
}

public boolean IsRepeatedCourse() {
	return gato;
}

public Collection<Voto> GetEsami (int x) {
	
	ArrayList<Voto> ArrayVotox = new ArrayList<Voto>();
	
	for(Voto v: ArrayVoto) {
		if(v.getVoto()==x) {
			ArrayVotox.add(v);
		}
	}
	
	if(ArrayVotox.size()==0) {
		return null;
	}
	
	return ArrayVotox;
}

public String GetVoto (String nomecorso) {
	
	String s = "";
	int voto = MapVoto.get(nomecorso).getVoto();
	s = "The grade of the required exam is: "+voto;
	
	return s;
}

public void MiglioratoVoto () {
	
	for(Voto v: ArrayVoto) {
		
		if(v.getVoto() >= 24 && (v.getVoto()+2)<31){
			v.setVoto(v.getVoto()+2);;
		}
		else if(v.getVoto() >= 18) {
			v.setVoto(v.getVoto()+1);;
		}
		
	}
	
}

public void PuliziaEsami ( ) {
	
	Iterator<Voto> i = ArrayVoto.iterator();
	
	while( i.hasNext()) {
		
		Voto v = i.next();
		
		if(v.getVoto() < 24) {
			i.remove();
		}
		
		
	}
	
}

}
