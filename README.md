# Amőba játék (Java, Maven, konzolos)

Ez a projekt egy egyszerű amőba játék konzolos felülettel, Java nyelven fejlesztve. A program Maven projektként lett kialakítva, tartalmaz tesztelést, JSON alapú mentést és betöltést, valamint megfelel a beadandó követelményeinek.

## Fő jellemzők:
- 5x5-ös amőba játék ember vs gép módban
- Lépés- és nyerésellenőrzés
- Játékállás mentése és visszatöltése (JSON formátumban)
- VO (Value Object) típusú osztályok (`JatekAllapot`)
- Egységtesztek JUnit 5-tel (`TablaTest`)
- Checkstyle integráció
- Futtatható JAR fájl Maven builddel

## Használat
A projekt futtatásához:
mvn clean install
java -jar target/progtech_beadando-1.0-SNAPSHOT-jar-with-dependencies.jar

## Követelmények
- Java 21+ vagy újabb
- Maven 3.9+ vagy újabb
