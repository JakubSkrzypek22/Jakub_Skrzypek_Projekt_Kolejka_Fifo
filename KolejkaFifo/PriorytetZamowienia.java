package KolejkaFifo;

// Interfejs do sprawdzenia priorytetu zamówienia
public interface PriorytetZamowienia {
    boolean czyWysokiPriorytet(Zamowienie zamowienie); // logika zależy od ID
}
