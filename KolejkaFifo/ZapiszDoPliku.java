package KolejkaFifo;

import java.io.*;
import java.util.List;

public class ZapiszDoPliku {

    // Metoda zapisująca listę zamówień do pliku tekstowego
    public void zapiszZamowienia(List<Zamowienie> zamowienia, String Zamowienia) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Zamowienia))) {
            for (Zamowienie z : zamowienia) {
                writer.write(z.toString());
                writer.newLine();
            }
            System.out.println("Zamówienia zapisane do pliku: " + Zamowienia);
        } catch (IOException e) {
            System.err.println("Błąd zapisu: " + e.getMessage());
        }
    }

    // Metoda odczytująca zawartość pliku i wypisująca na ekran
    public void wczytajZamowienia(String nazwaPliku) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            while ((linia = reader.readLine()) != null) {
                System.out.println(linia);
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu: " + e.getMessage());
        }
    }
}
