package KolejkaFifo;



/* Klasa Zamowienie – łączy klienta z produktem i reprezentuje jedno konkretne zamówienie.
 Każde zamówienie posiada unikalne ID. */

public class Zamowienie  {

    private int idZamowienia;
    private Klient klient;
    private Produkt produkt;

    // Konstruktor główny – przypisuje klienta, produkt i ID zamówienia
    public Zamowienie(int idZamowienia, Klient klient, Produkt produkt) {
        this.idZamowienia = idZamowienia;
        this.klient = klient;
        this.produkt = produkt;
    }

    // Przeciążony konstruktor – bez danych (zerowe wartości)
    public Zamowienie() {
        this.idZamowienia = 0;
        this.klient = new Klient();
        this.produkt = new Produkt();
    }

    // Gettery
    public int getIdZamowienia() {
        return idZamowienia;
    }

    public Klient getKlient() {
        return klient;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    // Settery z walidacją
    public void setIdZamowienia(int idZamowienia) {
        if (idZamowienia <= 0) {
            throw new IllegalArgumentException("ID zamówienia musi być większe od zera.");
        }
        this.idZamowienia = idZamowienia;
    }

    public void setKlient(Klient klient) {
        if (klient == null) {
            throw new IllegalArgumentException("Klient nie może być puste.");
        }
        this.klient = klient;
    }

    public void setProdukt(Produkt produkt) {
        if (produkt == null) {
            throw new IllegalArgumentException("Produkt nie może być puste.");
        }
        this.produkt = produkt;
    }

    // Przesłonięcie metody toString – czytelny wypis zamówienia + Obsługa klasy dziedziczne Klient VIP
    @Override
    public String toString() {
        double cenaProdukt = produkt.getCena();
        if (klient instanceof KlientVIP) {
            KlientVIP vip = (KlientVIP) klient;
            cenaProdukt = cenaProdukt * (1 - vip.getRabat() / 100.0);
        }
        return "Zamówienie #" + idZamowienia + "\n"
                + "Klient: " + klient.getImie() + " " + klient.getNazwisko() + " (ID: " + klient.getId() + ")\n"
                + "Produkt: " + produkt.getNazwa() + ", Cena po rabacie: " + String.format("%.2f", cenaProdukt) + " zł, Ilość: " + produkt.getIlosc() + " (ID: " + produkt.getIdProduktu() + ")";
    }

}
