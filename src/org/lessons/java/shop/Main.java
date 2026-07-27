package org.lessons.java.shop;

public class Main {
    public static void main(String[] args) {
    // Popolamento tramite costruttore
    Prodotto maglietta = new Prodotto("T-Shirt", "Maglietta a maniche corte", 9.99f, 22);
        
    System.out.println("Prodotto creato: " + maglietta.getName() + " codice: " + maglietta.getCode());
    System.out.println("Costo: " + maglietta.getFullPrice() + " euro");

    Prodotto coltello = new Prodotto("Lama divina", "Taglia tutto", 1299.99f);
    
    System.out.println("Prodotto creato: " + coltello.getName() + " codice: " + coltello.getCode());
    System.out.println("Costo: " + coltello.getFullPrice() + " euro");
    }


}
