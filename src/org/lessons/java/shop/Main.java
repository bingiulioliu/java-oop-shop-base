package org.lessons.java.shop;

public class Main {
    public static void main(String[] args) {
        // Popolamento tramite costruttore
        Prodotto maglietta = new Prodotto("T-Shirt", "Maglietta a maniche corte", 9.99f, 22);
        
        System.out.println("Prodotto creato: " + maglietta.nome);
        System.out.println("Costo: " + maglietta.getFullPrice() + " euro");
        System.out.println(maglietta.concatCodeName());

        Prodotto coltello = new Prodotto("Lama divina", "Taglia tutto", 1299.99f, 10);
        
        System.out.println("Prodotto creato: " + coltello.nome);
        System.out.println("Costo: " + coltello.getFullPrice() + " euro");
        System.out.println(coltello.concatCodeName());
    }
}
