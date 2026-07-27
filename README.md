---

# 🛒 Java Shop Base (`java-oop-shop-base`)

Una soluzione basata sui principi della **Programmazione Orientata agli Oggetti (OOP)** in Java per la gestione di un catalogo prodotti, aggiornata con le migliori pratiche di **Incapsulamento** e **Overload dei costruttori**.

---

## 📋 Consegna e Requisiti del Progetto

- [x] **Repository**: `java-oop-shop-base`
- [x] **Package**: `org.lessons.java.shop`
- [x] **Incapsulamento & Visibilità**:
  - Attributi della classe `Prodotto` definiti come `private`.
  - `codice`: Accessibile **solo in lettura** (metodo `getCode()`, nessun setter).
  - Altri attributi (`nome`, `descrizione`, `prezzo`, `iva`): Accessibili sia in lettura che in scrittura tramite **Getter e Setter** con validazione dei dati.
- [x] **Overload dei Costruttori**:
  - **Costruttore Completo**: Riceve tutti i parametri (`nome`, `descrizione`, `prezzo`, `iva`).
  - **Costruttore Semplificato**: Riceve `nome`, `descrizione` e `prezzo`, assegnando un'aliquota IVA di default al **22%** tramite l'uso di `this(...)`.
- [x] **Metodi di Utilità**:
  - `getFullPrice()`: Calcola il prezzo totale comprensivo di IVA (arrotondato a 2 cifre decimali con `Math.round()`).

---

## 💻 Codice Sorgente

### 1. Classe `Prodotto.java`

```java
package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
    Random rand = new Random();

    // Attributi incapsulati (privati)
    private int codice = rand.nextInt(100);
    private String nome;
    private String descrizione;
    private double prezzo;
    private int iva;

    // 1️⃣ PRIMO COSTRUTTORE (Completo)
    public Prodotto(String nome, String descrizione, double prezzo, int iva) {
        setName(nome);
        setDescription(descrizione);
        setPrice(prezzo);
        setIva(iva);
    }

    // 2️⃣ SECONDO COSTRUTTORE (Overload: imposta l'IVA al 22% di default)
    public Prodotto(String nome, String descrizione, double prezzo) {
        this(nome, descrizione, prezzo, 22);
    }

    // --- GETTER (Solo lettura per il codice) ---
    public int getCode() {
        return this.codice;
    }

    // --- GETTER & SETTER (Con validazione) ---
    public String getName() {
        return this.nome;
    }

    public void setName(String name) {
        if (name != null && name.trim().length() > 0) {
            this.nome = name;
        } else {
            System.out.println("Inserire un nome");
        }
    }

    public String getDescription() {
        return this.descrizione;
    }

    public void setDescription(String description) {
        if (description != null && description.trim().length() > 0) {
            this.descrizione = description;
        } else {
            System.out.println("Inserire una descrizione");
        }
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.prezzo = price;
        } else {
            System.out.println("Inserire un prezzo valido");
        }
    }

    public int getIva() {
        return this.iva;
    }

    public void setIva(int vat) {
        if (vat > 0) {
            this.iva = vat;
        } else {
            System.out.println("Inserire un'aliquota corretta");
        }
    }

    // --- METODI DI UTILITÀ ---
    public double getFullPrice() {
        double fullPrice = this.prezzo * (1 + (this.iva / 100.0));
        return Math.round(fullPrice * 100.0) / 100.0;
    }
}

```

### 2. Classe `Main.java`

```java
package org.lessons.java.shop;

public class Main {
    public static void main(String[] args) {
        
        // Test Costruttore Completo (IVA specificata al 22%)
        Prodotto maglietta = new Prodotto("T-Shirt", "Maglietta a maniche corte", 9.99, 22);
        System.out.println("Prodotto creato: " + maglietta.getName() + " codice: " + maglietta.getCode());
        System.out.println("Costo: " + maglietta.getFullPrice() + " euro");

        System.out.println("------------------------------------");

        // Test Secondo Costruttore (Overload: prende l'IVA di default al 22%)
        Prodotto coltello = new Prodotto("Lama divina", "Taglia tutto", 1299.99);
        System.out.println("Prodotto creato: " + coltello.getName() + " codice: " + coltello.getCode());
        System.out.println("Costo: " + coltello.getFullPrice() + " euro");
    }
}

```

---

## 📺 Esempio di Output in Console

```text
Prodotto creato: T-Shirt codice: 42
Costo: 12.19 euro
------------------------------------
Prodotto creato: Lama divina codice: 87
Costo: 1585.99 euro

```

---

## 💡 Concetti Appresi in questa Fase

1. **🛡️ Incapsulamento (`private`)**: Gli attributi sono protetti da accessi o modifiche indesiderate dall'esterno.
2. **🔒 Proprietà Read-Only**: L'assenza di un metodo `setCode()` rende il codice generato univoco e non modificabile dopo la creazione.
3. **🔀 Overload dei Costruttori (`this(...)`)**: Consente di definire costruttori secondari richiamando quello principale ed eliminando la duplicazione del codice (*Principio DRY*).
4. **⚙️ Controllo di Validità nei Setter**: L'uso dei blocchi `if` nei metodi di modifica garantisce che lo stato interno dell'oggetto rimanga coerente e privo di valori non validi (es. prezzi negativi o nomi `null`).

```