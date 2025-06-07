package KolejkaFifo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Klasa MenadzerZamowien zarządza zamówieniami
// Przechowuje zamówienia w dwóch miejscach:
// - listaZamowien: ArrayList, żeby zachować kolejność zamówień (FIFO)
// - mapaZamowien: HashMap, żeby szybko znaleźć zamówienie po ID
// Implementuje interfejs PriorytetZamowienia
public class MenadzerZamowien implements PriorytetZamowienia {

    private List<Zamowienie> listaZamowien;  // lista zamówień w kolejności
    private Map<Integer, Zamowienie> mapaZamowien; // mapa zamówień po ID

    // Konstruktor tworzy puste struktury
    public MenadzerZamowien() {
        this.listaZamowien = new ArrayList<>();
        this.mapaZamowien = new HashMap<>();
    }

    // Dodaj zamówienie jeśli ID nie istnieje
    public void dodajZamowienie(Zamowienie z) {
        int id = z.getIdZamowienia();
        if (mapaZamowien.containsKey(id)) {
            System.out.println("Zamówienie o ID " + id + " już jest. Nie dodaję.");
            return;
        }
        listaZamowien.add(z);
        mapaZamowien.put(id, z);
        System.out.println("Zamówienie dodane.");
    }

    // Usuń zamówienie po ID
    public void usunZamowienie(int id) {
        Zamowienie z = mapaZamowien.remove(id);
        if (z != null) {
            listaZamowien.remove(z);
            System.out.println("Zamówienie usunięte.");
        } else {
            System.out.println("Nie znaleziono zamówienia o ID: " + id);
        }
    }

    // Aktualizuj klienta i produkt w zamówieniu o podanym ID
    public void aktualizujZamowienie(int id, Klient nowyKlient, Produkt nowyProdukt) {
        Zamowienie z = mapaZamowien.get(id);
        if (z != null) {
            z.setKlient(nowyKlient);
            z.setProdukt(nowyProdukt);
            System.out.println("Zamówienie zaktualizowane.");
        } else {
            System.out.println("Nie znaleziono zamówienia o ID: " + id);
        }
    }

    // Wyświetl wszystkie zamówienia z priorytetem
    public void wyswietlZamowienia() {
        if (listaZamowien.isEmpty()) {
            System.out.println("Brak zamówień.");
            return;
        }
        for (Zamowienie z : listaZamowien) {
            String priorytet = czyWysokiPriorytet(z) ? "Wysoki" : "Niski";
            System.out.println(z);
            System.out.println("Priorytet: " + priorytet);
            System.out.println("------------------------");
        }
    }

    // Metoda z interfejsu - wysokie priorytety to te z ID < 5
    @Override
    public boolean czyWysokiPriorytet(Zamowienie zamowienie) {
        return zamowienie.getIdZamowienia() < 5;
    }

    // Getter do listy zamówień (FIFO)
    public List<Zamowienie> getZamowienia() {
        return listaZamowien;
    }
}
