package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
    Random rand = new Random();

    public int codice = rand.nextInt(100);
    public String nome;
    public String descrizione;
    public double prezzo;
    public int iva;

    // Costruttori
    public Prodotto(String nome, String descrizione, float prezzo, int iva){
        // Inizializzazione attributi
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    public double getFullPrice(){
        double fullPrice = this.prezzo * (1 +(this.iva / 100.0));
        return Math.round(fullPrice * 100.0) / 100.0;
    }

    public String concatCodeName(){
        return codice + "-" + nome;
    }
}
