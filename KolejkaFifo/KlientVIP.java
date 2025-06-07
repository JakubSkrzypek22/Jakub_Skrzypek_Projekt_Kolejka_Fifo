package KolejkaFifo;

// Klasa dziedzicząca po Klient, np. KlientVIP
public class KlientVIP extends Klient {

    private double rabat; // np. dodatkowe pole

    // Konstruktor wywołujący konstruktor klasy bazowej + swoje pola
    public KlientVIP(String imie, String nazwisko, int wiek, int id, double rabat) {
        super(imie, nazwisko, wiek, id);  // wywołanie konstruktora klasy Klient
        this.rabat = rabat;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        if (rabat < 0 || rabat > 100) {
            throw new IllegalArgumentException("Rabat musi być między 0 a 100%");
        }
        this.rabat = rabat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rabat VIP: " + rabat + "%";
    }
}
