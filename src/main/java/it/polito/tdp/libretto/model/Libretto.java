package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {
  private List<Voto> voti;

public Libretto() {
	VotoDAO dao= new VotoDAO();
	this.voti = dao.listVoti();
}
  public boolean add(Voto v) {
	  if(this.esisteDuplicato(v)||this.esisteConflitto(v)) {
		  System.out.println("Voto errato");
		  throw new IllegalArgumentException("Voto errato: "+v);
	  }
    VotoDAO dao=new VotoDAO();
    dao.createVoto(v);
	return  this.voti.add(v);
  }
  public void stampa() {
	  for(Voto v: this.voti) {
		  System.out.println(v);
	  }
  }
  public void stampaPuntiUguali(int valore) {
	  for(Voto v: this.voti) {
		  if(v.getPunti()==valore) {
		  System.out.println(v);
	  }
  }
  }
  public Voto ricercaVotoPerNome(String corso) {
	  for(Voto v: this.voti) {
		  if(v.getCorso().compareTo(corso)==0) {
		return v;
	  }
  }
	  return null;
  }
  public boolean esisteDuplicato(Voto nuovo) {
	  for(Voto v: this.voti) {
		  if(v.getCorso().compareTo(nuovo.getCorso())==0 && v.getPunti()==nuovo.getPunti())
			  return true;
	  }
	  return false;
  }
 
  public boolean esisteConflitto(Voto nuovo) {
	  for(Voto v: this.voti) {
		  if(v.getCorso().compareTo(nuovo.getCorso())==0 && v.getPunti()!=nuovo.getPunti())
			  return true;
	  }
	  return false;
  }
  
  public Libretto librettoMigliorato() {
	Libretto migliore= new Libretto();
	migliore.voti= new ArrayList<>();
	for(Voto v: this.voti) {
		migliore.voti.add(new Voto(v));
		
	}
	for(Voto v:migliore.voti) {
		v.setPunti(v.getPunti()+2);
	}
	return migliore;
  }
  public void cancellaVotiInferiori(int punti) {
	  List<Voto> daCancellare= new ArrayList<Voto>();
	  for(Voto v: this.voti) {
		if(v.getPunti()<punti) {
			daCancellare.add(v);
		}
	  }
	  for(Voto v1:daCancellare) {
		  this.voti.remove(v1);
	  }
  }
//for(int i=0; i<this.voti.size();i++) {
		//  if(this.voti.get(i).getPunti()<punti) {
			//  this.voti.remove(i);
		  //}

	  public Libretto librettoOrdinatoAlfabeticamente() {
		  Libretto ordinato= new Libretto();
			ordinato.voti= new ArrayList<>(this.voti);
		    ordinato.voti.sort(new ComparatorByName());
		    Collections.sort(ordinato.voti, new ComparatorByName());
			return ordinato;
}
	  public String toString() {
		  String txt="";
		  for(Voto v: this.voti) {
			  txt= txt+v.toString()+" \n";
		  }
		  return txt;
	  }
	  }


