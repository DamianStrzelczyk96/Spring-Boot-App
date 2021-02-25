# Spring-Boot-App
#Aby uruchomić ten projekt pobierz go , a następnie wypakuj.
# Sposób 1: otwórz wypakowane pliki za pomocą  IDE (np. IntelliJ) ,a następnie odśwież maven i naciśnij Run.
# Sposób 2: otwórz lokalizacje wypakowanych plików za pomocą wiersza poleceń , a następnie wpisz : mvnw spring-boot:run
# Jeżeli korzystasz z PowerShell lub GitBush wpisz : ./mvnw spring-boot:run
# Aplikacja uruchomi sie na http://localhost:7070/

#Stack technologiczny:
Java 8
Spring-boot
h2 Database
JUnit

#API:
 metoda POST na http://localhost:7070/item    dodaje przedmiot do listy np.
 {
   "name":"PlayStation5",
   "price":"3000"
}
metoda PUT na http://localhost:7070/item    aktualizuje  przedmiot np.
 {
   "id": "1",
   "name":"PlayStation5",
   "price":"3000"
}
metoda GET http://localhost:7070/item/all zwraca wszytskie przedmioty na liscie
metoda GET http://localhost:7070/item/addToOrder/   wymaga RequsetParma w celu dodania przedmiotu do zamówienia, np
http://localhost:7070/item/addToOrder/?index=1 , gdzie "1" to id przedmiotu

metoda GET http://localhost:7070/item/saveOrder  , zapisuje aktualne zamówienie do bazy danych
metoda GET http://localhost:7070/item/checkActualOrder   , wyświetla aktualne zamówienie
metoda GET http://localhost:7070/item/actualOrderCost  , wyświetla koszt aktualnego zamówienia
metoda GET http://localhost:7070/order/all  , wyświetla wszystkie złożone zamówienia
metoda GET http://localhost:7070/order/cost   , wymaga RequsetParma w celu wyświetlenia kosztu złożonego zamówienia, np
http://localhost:7070/order/cost/?index=1 , gdzie "1" to index zamówienia

metoda GET http://localhost:7070/order/getOrderById  , wymaga RequsetParma w celu wyświetlenia złożonego zamówienia, np
http://localhost:7070/order/getOrderById/?index=1 , gdzie "1" to index zamówienia
