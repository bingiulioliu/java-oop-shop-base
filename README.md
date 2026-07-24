# 🛒 Java Shop Base (`java-oop-shop-base`)

Una soluzione basata sulla **Programmazione Orientata agli Oggetti (OOP)** in Java per modellare e gestire un catalogo prodotti di uno store online.

---

## 📋 Consegna e Requisiti del Progetto

- [x] **Repository**: `java-oop-shop-base`
- [x] **Package**: `org.lessons.java.shop`
- [x] **Classe `Prodotto`**:
    - `codice` (intero, generato in modo casuale ad ogni istanziazione)
    - `nome` (stringa)
    - `descrizione` (stringa)
    - `prezzo` (double/float)
    - `iva` (intero)
- [x] **Metodi della Classe**:
    - Costruttore con parametri per la creazione immediata
    - `getFullPrice()`: restituisce il prezzo base comprensivo di IVA (arrotondato)
    - `concatCodeName()`: restituisce la stringa formattata `codice-nome`
- [x] **Classe `Main`**: Istanziazione di più oggetti e verifica dei metodi a console.

---

## 💻 Codice Sorgente

### 1. Classe `Prodotto.java`

```java
package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
    // Inizializzazione oggetto Random per la generazione del codice
    Random rand = new Random();

    // Attributi di istanza
    public int codice = rand.nextInt(100); // Genera un codice casuale tra 0 e 99
    public String nome;
    public String descrizione;
    public double prezzo;
    public int iva;

    // Costruttore con parametri
    public Prodotto(String nome, String descrizione, float prezzo, int iva) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    // Calcolo del prezzo ivato con arrotondamento a 2 decimali
    public double getFullPrice() {
        double fullPrice = this.prezzo * (1 + (this.iva / 100.0));
        return Math.round(fullPrice * 100.0) / 100.0;
    }

    // Concatenazione del codice e del nome prodotto
    public String concatCodeName() {
        return this.codice + "-" + this.nome;
    }
}

```

### 2. Classe `Main.java`

```java
package org.lessons.java.shop;

public class Main {
    public static void main(String[] args) {
        
        // Istanziazione del primo prodotto (Maglietta)
        Prodotto maglietta = new Prodotto("T-Shirt", "Maglietta a maniche corte", 9.99f, 22);
        
        System.out.println("Prodotto creato: " + maglietta.nome);
        System.out.println("Costo: " + maglietta.getFullPrice() + " euro");
        System.out.println("Codice Univoco: " + maglietta.concatCodeName());

        System.out.println("------------------------------------");

        // Istanziazione del secondo prodotto (Coltello)
        Prodotto coltello = new Prodotto("Lama divina", "Taglia tutto", 1299.99f, 10);
        
        System.out.println("Prodotto creato: " + coltello.nome);
        System.out.println("Costo: " + coltello.getFullPrice() + " euro");
        System.out.println("Codice Univoco: " + coltello.concatCodeName());
    }
}

```

---

## 📺 Esempio di Output in Console

```text
Prodotto creato: T-Shirt
Costo: 12.19 euro
42-T-Shirt
------------------------------------
Prodotto creato: Lama divina
Costo: 1429.99 euro
87-Lama divina

```

---

## 💡 Concetti Imparati e Note di Ripasso

### 🧮 1. Gestione dei Decimali e Divisioni con virgola (`100.0`)

* **Divisione Intera**: In Java, la scrittura `22 / 100` tra numeri interi restituisce `0` (vengono troncati i decimali).
* **Forzare il cast a floating-point**: Scrivendo `100.0` la divisione diventa decimale (`22 / 100.0 = 0.22`), permettendo un calcolo matematico corretto.

### 📐 2. Arrotondamento del Prezzo (`Math.round`)

A causa dell'approssimazione binaria dei numeri con virgola (`double`/`float`), i calcoli matematici possono generare code decimali indesiderate (es. `12.187799999999999`).

Si risolve moltiplicando per `100.0`, applicando `Math.round()` e ridividendo per `100.0`.

### 🔄 3. Concatenazione di Tipi Diversi

In Java, sommando un intero (`int codice`) con una stringa (`String nome`), l'intero viene convertito automaticamente in `String`, facilitando la creazione del codice prodotto formattato (`codice + "-" + nome`).

```