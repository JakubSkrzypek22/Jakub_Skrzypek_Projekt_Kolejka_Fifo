
# Kolejka FIfo - Prosty System Zarządzania Zamówieniami

## Opis
Program zarządza listą zamówień klientów.  
Zamówienia są przechowywane w kolejności FIFO (ArrayList) oraz dodatkowo w HashMap dla szybkiego dostępu po ID.

## Funkcje
- Dodawanie nowego zamówienia (sprawdzanie czy ID jest unikalne)  
- Usuwanie zamówienia po ID  
- Aktualizacja zamówienia (klient i produkt) po ID  
- Wyświetlanie wszystkich zamówień z oznaczeniem priorytetu (ID < 5 to wysoki priorytet)  
- Priorytet jest prostą metodą (na podstawie ID)

## Jak używać
1. Uruchom klasę `Run` i wybierz opcje z menu:  
    - Dodaj zamówienie  
    - Usuń zamówienie  
    - Aktualizuj zamówienie  
    - Wyświetl zamówienia  
    - Zapisz / wczytaj zamówienia do/z pliku  
2. Przy dodawaniu zamówienia podajesz dane klienta i produktu oraz ID zamówienia.  
3. Program sam pilnuje unikalności ID zamówienia.

## Struktura
- `MenadzerZamowien` – klasa zarządza zamówieniami, wykorzystuje ArrayList i HashMap  
- `Zamowienie` – reprezentuje pojedyncze zamówienie  
- `Klient`, `KlientVIP` – dane klienta  
- `Produkt` – dane produktu  
- `PriorytetZamowienia` – interfejs z metodą do sprawdzania priorytetu

## Wymagania
- Java 8 lub wyższa  
- Konsola do obsługi interaktywnego menu



