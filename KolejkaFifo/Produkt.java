package KolejkaFifo;


// Klasa publiczna Produkt z hermetyzacją danych (wszystkie pola sa private)
public class Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;
    private int idProduktu;

    /* Pierwszy konstruktor klasy Produkt - z przypisanymi danymi startowymi
       przekazanymi jako parametry */
    public Produkt(String nazwa, double cena, int ilosc, int idProduktu) {

        if (nazwa.length() < 3) {
            throw new IllegalArgumentException("Nazwa produktu nie może być krótsza niż 3 znaki.");
        }

        if (cena <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od zera.");
        }

        if (ilosc < 0) {
            throw new IllegalArgumentException("Ilosc nie może być ujemna.");
        }

        if (idProduktu <= 0) {
            throw new IllegalArgumentException("ID produktu musi być wieksze od zera.");
        }

        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.idProduktu = idProduktu;
    }

    /* Drugi konstruktor klasy Produkt - bez przekazanych danych (przeciążenie konstruktora)
       Nadaje wartosci domyslne zerowe lub puste */
    public Produkt() {
        this.nazwa = "";
        this.cena = 0.0;
        this.ilosc = 0;
        this.idProduktu = 0;
    }

    /* Gettery pozwalają pobrać dane z obiektu Produkt */
    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public int getIdProduktu() {
        return idProduktu;
    }

    /* Settery pozwalają ustawić (zmienić) dane w obiekcie Produkt
      Dodatkowo w jest zawarta w nich walidacja potencjalnych błędów  */
    public void setNazwa(String nazwa) {
        if (nazwa.length() < 3) {
            throw new IllegalArgumentException("Nazwa produktu nie może być krótsza niż 3 znaki.");
        }
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od zera.");
        }
        this.cena = cena;
    }

    public void setIlosc(int ilosc) {
        if (ilosc < 0) {
            throw new IllegalArgumentException("Ilosc nie może być ujemna.");
        }
        this.ilosc = ilosc;
    }

    public void setIdProduktu(int idProduktu) {
        if (idProduktu <= 0) {
            throw new IllegalArgumentException("ID produktu musi być wieksze od zera.");
        }
        this.idProduktu = idProduktu;
    }

    /* Przesłonięta metoda toString pozwala na ładne wypisanie informacji o produkcie */
    @Override
    public String toString() {
        return "Nazwa Produktu : " + nazwa + ", Cena Produktu : " + cena + "zł, Ilosc : " + ilosc + ", ID Produktu: " + idProduktu;
    }
}

