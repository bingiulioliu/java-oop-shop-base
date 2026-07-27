package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
    Random rand = new Random();

    private int codice = rand.nextInt(100);
    private String nome;
    private String descrizione;
    private double prezzo;
    private int iva;

    // Primo costruttore
    public Prodotto(String nome, String descrizione, double prezzo, int iva){
    // Inizializzazione attributi
    setName(nome);
    setDescription(descrizione);
    setPrice(prezzo);
    setIva(iva);
    }

    // Secondo costruttore con iva a 22 di default
    public Prodotto(String nome, String descrizione, double prezzo){
        this(nome, descrizione, prezzo, 22);
    }

    public int getCode(){
        return this.codice;
    }

    public String getName(){
        return this.nome;
    }

    public void setName(String name){
        if (name.length() > 0){
            this.nome = name;
        } else {
            System.out.println("Inserire un nome");
        }
    }

    public String getDescription(){
        return this.descrizione;
    }
    public void setDescription(String description){
        if (description.length() > 0){
            this.descrizione = description;
        } else {
            System.out.println("Inserire una descrizione");
        }
    }
    
    public double getPrezzo(){
        return this.prezzo;
    }

    public void setPrice(double price){
        if (price > 0){
            this.prezzo = price;
        } else {
            System.out.println("Inserire un prezzo valido");
        }
    }

    public int getIva(){
        return this.iva;
    }

    public void setIva(int vat){
        if (vat > 0){
            this.iva = vat;
        } else {
            System.out.println("Inserire un'aliquota corretta");
        }
    }

    public double getFullPrice(){
        double fullPrice = this.prezzo * (1 +(this.iva / 100.0));
        return Math.round(fullPrice * 100.0) / 100.0;
    }
}
