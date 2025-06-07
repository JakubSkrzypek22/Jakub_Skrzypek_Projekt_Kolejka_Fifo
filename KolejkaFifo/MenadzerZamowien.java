package KolejkaFifo;


import java.util.ArrayList;
import java.util.List;

// Klasa MenadzerZamowien zarządza listą zamówień
// Implementuje interfejs PriorytetZamowienia
public class MenadzerZamowien implements PriorytetZamowienia {

    private List<Zamowienie> zamowienia; // Lista zamówień

    // Konstruktor tworzy pustą listę zamówień
    public MenadzerZamowien() {
        this.zamowienia = new ArrayList<>();
    }

    // Dodaj nowe zamówienie
    public void dodajZamowienie(Zamowienie z) {
        zamowienia.add(z);
        System.out.println("Zamówienie dodane.");
    }

    // Usuń zamówienie na podstawie ID
    public void usunZamowienie(int id) {
        boolean znaleziono = false;
        for (Zamowienie z : zamowienia) {
            if (z.getIdZamowienia() == id) {
                zamowienia.remove(z);
                System.out.println("Zamówienie usunięte.");
                znaleziono = true;
                break;
            }
        }
        if (!znaleziono) {
            System.out.println("Nie znaleziono zamówienia o ID: " + id);
        }
    }

    // Zaktualizuj produkt lub klienta w istniejącym zamówieniu
    public void aktualizujZamowienie(int id, Klient nowyKlient, Produkt nowyProdukt) {
        for (Zamowienie z : zamowienia) {
            if (z.getIdZamowienia() == id) {
                z.setKlient(nowyKlient);
                z.setProdukt(nowyProdukt);
                System.out.println("Zamówienie zaktualizowane.");
                return;
            }
        }
        System.out.println("Nie znaleziono zamówienia o ID: " + id);
    }

    // Wyświetl wszystkie zamówienia z informacją o priorytecie
    public void wyswietlZamowienia() {
        if (zamowienia.isEmpty()) {
            System.out.println("Brak zamówień.");
        } else {
            for (Zamowienie z : zamowienia) {
                String priorytet = czyWysokiPriorytet(z) ? "Wysoki" : "Niski";
                System.out.println(z); // toString() z klasy Zamowienie
                System.out.println("Priorytet: " + priorytet);
                System.out.println("------------------------");
            }
        }
    }

    // Implementacja metody interfejsu PriorytetZamowienia
    // Priorytet wysoki jeśli ID zamówienia < 5
    @Override
    public boolean czyWysokiPriorytet(Zamowienie zamowienie) {
        return zamowienie.getIdZamowienia() < 5;
    }

    // Getter do listy zamówień (jeśli potrzebujesz gdzie indziej)
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }
}
