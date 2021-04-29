package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestLibretto {
	public static void main(String[] args) {
        //EntryPoint.main(args);
        
        System.out.println("Created a new Libretto");
        
        Libretto f = new Libretto();
        
        System.out.println("Adding courses to the recently created Libretto");
        System.out.println();
        
        f.AddVoto("Analisi1", 25, LocalDate.of(2018,1,25));
        f.AddVoto("Analisi2", 18, LocalDate.of(2019,2,8));
        f.AddVoto("Fisica1", 27, LocalDate.of(2020,6,26));
        f.AddVoto("Fisica2", 20, LocalDate.of(2020,2,7));
        f.AddVoto("PO", 28, LocalDate.of(2021,1,29));
        f.AddVoto("PGP", 23, LocalDate.of(2021,1,25));
        f.AddVoto("Statistica", 23, LocalDate.of(2020,2,14));
        f.AddVoto("BasediDati", 20, LocalDate.of(2020,2,17));
        f.AddVoto("EOA", 19, LocalDate.of(2020,7,16));
        f.AddVoto("LAG", 20, LocalDate.of(2018,9,4));
        
        System.out.println("Ordering libretto and printing in order");
        System.out.println();
       
        
        ArrayList<Voto> ArrayV = new ArrayList<Voto>(f.GetCorsiSuperatiInOrdine());
        
        for(Voto v : ArrayV) {
        	System.out.println(v.getNomeCorso()+" "+v.getVoto()+" "+v.getData());
        }
        
        System.out.println("Trying to Reupload an already submitted Exam");
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        f.AddVoto("Analisi1", 23, LocalDate.of(2018, 3, 17));
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Printing improved Version");
        
        f.MiglioratoVoto();
        
        for(Voto v : ArrayV) {
        	System.out.println(v.getNomeCorso()+" "+v.getVoto()+" "+v.getData());
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("Elminating some exams ...");
        
        
        
        f.PuliziaEsami();
        
        ArrayList<Voto> ArrayVP = new ArrayList<Voto>(f.GetCorsiSuperatiInOrdine());
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        for(Voto v : ArrayVP) {
        	System.out.println(v.getNomeCorso()+" "+v.getVoto()+" "+v.getData());
        }
        
        
        
        
    }
}

