package KolejkaFifo;

//Mój własny wyjątek
public class NiepoprawneImie extends RuntimeException {
    public NiepoprawneImie(String message) {
        super(message);
    }
}
