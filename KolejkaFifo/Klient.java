package KolejkaFifo;


//Klasa publiczna z hermetyzacja danych (pola klasy private)
public class Klient {
    private String imie;
    private String nazwisko;
    private int wiek;
    private int id;

    /*Pierwszy konstruktor klasy Klient z przypisanymi wartościami startowymi
    dla klasy Klient*/
    public Klient(String imie, String nazwisko, int wiek, int id) {

        if(imie.length() <=3) {
            // W tym wypadku korzystam z własnego wyjątku (NiepoprawneImie).
            throw new NiepoprawneImie("Imie klienta nie może być krótsze niż trzy litery. (Chyba że Kleint jest Chińczykiem)");
        }

        if (nazwisko.length() <= 3){
            throw new IllegalArgumentException("Nazwisko kienta nie może być krótsze niż trzy litery.");
        }

        if (wiek <= 0){
            throw new IllegalArgumentException("Wiek klienta nie może być mniejszy lub równy zero.");
        }

        if (id <= 0){
            throw  new IllegalArgumentException("Id kklienta nie może być mneijsze lub równe zero.");
        }


            this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.id = id;
    }

    /*Drugi konstruktor klasy Klient bez przypisanych wartosci startowych
    dla klasy Klient ( Przciążenie Konstruktora) */
    public Klient(){
        this.imie = "";
        this.nazwisko = "";
        this.wiek = 0;
        this.id = 0;
    }



    /* Gettery pozwalają pobrać dane z obiektu Klient */

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public int getWiek(){
        return wiek;
    }

    public int getId(){
        return id;
    }

    /* Settery pozwalają ustawić (zmienić) dane w obiekcie Klient
       Dodatkowo w jest zawarta w nich walidacja potencjalnych błędów */


    public void setImie(String imie){
        if(imie.length() <=3){
            // W tym wypadku korzystam z własnego wyjątku (NiepoprawneImie).
            throw new NiepoprawneImie("Imie klienta nie może być krótsze niż trzy litery. (Chyba że Kleint jest Chińczykiem)");
        }
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko){
        if (nazwisko.length() <= 3){
            throw new IllegalArgumentException("Nazwisko kienta nie może być krótsze niż trzy litery.");
        }
        this.nazwisko = nazwisko;
    }

    public void setWiek(int wiek){
        if (wiek <= 0){
            throw new IllegalArgumentException("Wiek klienta nie może być mniejszy lub równy zero.");
        }
        this.wiek = wiek;
    }

    public void setId(int id){
        if (id <= 0){
            throw  new IllegalArgumentException("Id kklienta nie może być mneijsze lub równe zero.");
        }
        this.id = id;
    }


    /* Przesłonięta metoda toString pozwala na ładne wypisanie informacji o produkcie */
    @Override
    public String toString() {
        return "Imie Klienta: " + imie + ", Nazwisko Klienta = " + nazwisko + ", Wiek Klienta " + wiek + ", ID Klienta = " + id;
    }


}