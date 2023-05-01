package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto lib= new Libretto();
		lib.add(new Voto("Analisi 1", 29,LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 1", 21,LocalDate.of(2022, 6, 10)));
lib.stampa();
lib.stampaPuntiUguali(25);
Voto v= lib.ricercaVotoPerNome("Analisi 1");
System.out.println(v);
Voto a1Bis=new Voto("Analisi 1", 29,LocalDate.of(2021, 2, 15));
Voto a2Bis=new Voto("Analisi 1", 30,LocalDate.of(2021, 2, 15));
System.out.println(a1Bis+" è duplicato: "+lib.esisteDuplicato(a1Bis));
System.out.println(a2Bis+" è duplicato: "+lib.esisteConflitto(a2Bis));
Libretto migliore= lib.librettoMigliorato();
System.out.println("Libretto migliorato");
migliore.stampa();
System.out.println("Libretto ORIGINARIO");
lib.stampa();
lib.cancellaVotiInferiori(24);
System.out.println("Libretto ORIGINARIO>24");
lib.stampa();
System.out.println("Oridne Alfabetico");
lib.librettoOrdinatoAlfabeticamente().stampa();
	}

}
