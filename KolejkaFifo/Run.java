package KolejkaFifo;

import java.util.Scanner;

public class Run {
    public void start() {
        // Tworzymy menadżera zamówień
        MenadzerZamowien menadzer = new MenadzerZamowien();

        Scanner sc = new Scanner(System.in);
        boolean dziala = true;

        while (dziala) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj zamówienie");
            System.out.println("2. Usuń zamówienie");
            System.out.println("3. Aktualizuj zamówienie");
            System.out.println("4. Wyświetl wszystkie zamówienia");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");

            int wybor = sc.nextInt();
            sc.nextLine(); // zjedz enter

            switch (wybor) {
                case 1:
                    try {
                        System.out.println("Wybierz typ klienta:");
                        System.out.println("1. Zwykły klient");
                        System.out.println("2. Klient VIP");
                        System.out.print("Twój wybór: ");
                        int typKlienta = sc.nextInt();
                        sc.nextLine(); // zjedz enter

                        // Dane klienta - podstawowe pola (wspólne dla obu typów)
                        System.out.print("Imię klienta: ");
                        String imie = sc.nextLine();
                        System.out.print("Nazwisko klienta: ");
                        String nazwisko = sc.nextLine();
                        System.out.print("Wiek klienta: ");
                        int wiek = sc.nextInt();
                        System.out.print("ID klienta: ");
                        int idKlienta = sc.nextInt();
                        sc.nextLine(); // zjedz enter

                        Klient klient;  // zmienna ogólna, potem przypiszemy odpowiedni obiekt

                        if (typKlienta == 2) {
                            // Jeśli klient VIP, zapytaj o rabat
                            System.out.print("Podaj rabat VIP (0-100%): ");
                            double rabat = sc.nextDouble();
                            sc.nextLine(); // zjedz enter

                            // Utwórz klienta VIP z rabatem
                            klient = new KlientVIP(imie, nazwisko, wiek, idKlienta, rabat);
                        } else {
                            // Zwykły klient
                            klient = new Klient(imie, nazwisko, wiek, idKlienta);
                        }

                        // Dane produktu
                        System.out.print("Nazwa produktu: ");
                        String nazwa = sc.nextLine();
                        System.out.print("Cena produktu: ");
                        double cena = sc.nextDouble();
                        System.out.print("Ilość produktu: ");
                        int ilosc = sc.nextInt();
                        System.out.print("ID produktu: ");
                        int idProduktu = sc.nextInt();

                        Produkt produkt = new Produkt(nazwa, cena, ilosc, idProduktu);

                        // ID zamówienia
                        System.out.print("ID zamówienia: ");
                        int idZamowienia = sc.nextInt();

                        Zamowienie zamowienie = new Zamowienie(idZamowienia, klient, produkt);
                        menadzer.dodajZamowienie(zamowienie);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Błąd: " + e.getMessage());
                        sc.nextLine(); // wyczyść bufor
                    }
                    break;
                case 2:
                    System.out.print("Podaj ID zamówienia do usunięcia: ");
                    int idUsun = sc.nextInt();
                    menadzer.usunZamowienie(idUsun);
                    break;

                case 3:
                    System.out.print("Podaj ID zamówienia do aktualizacji: ");
                    int idAkt = sc.nextInt();
                    sc.nextLine(); // zjedz enter

                    try {
                        System.out.print("Nowe imię klienta: ");
                        String noweImie = sc.nextLine();
                        System.out.print("Nowe nazwisko klienta: ");
                        String noweNazwisko = sc.nextLine();
                        System.out.print("Nowy wiek klienta: ");
                        int nowyWiek = sc.nextInt();
                        System.out.print("Nowe ID klienta: ");
                        int nowyIdKlienta = sc.nextInt();

                        Klient nowyKlient = new Klient(noweImie, noweNazwisko, nowyWiek, nowyIdKlienta);

                        System.out.print("Nowa nazwa produktu: ");
                        sc.nextLine(); // zjedz enter
                        String nowaNazwa = sc.nextLine();
                        System.out.print("Nowa cena produktu: ");
                        double nowaCena = sc.nextDouble();
                        System.out.print("Nowa ilość produktu: ");
                        int nowaIlosc = sc.nextInt();
                        System.out.print("Nowe ID produktu: ");
                        int nowyIdProduktu = sc.nextInt();

                        Produkt nowyProdukt = new Produkt(nowaNazwa, nowaCena, nowaIlosc, nowyIdProduktu);

                        menadzer.aktualizujZamowienie(idAkt, nowyKlient, nowyProdukt);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Błąd: " + e.getMessage());

                    }
                    break;

                case 4:
                    menadzer.wyswietlZamowienia();
                    break;

                case 5:
                    dziala = false;
                    System.out.println("Zakończono działanie programu.");
                    break;

                default:
                    System.out.println("Niepoprawna opcja.");
            }
        }

        sc.close();
    }
}
