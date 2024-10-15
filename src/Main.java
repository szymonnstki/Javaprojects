import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // Utworzenie obiektu Scanner do wczytywania danych od użytkownika
        Scanner scanner = new Scanner(System.in);

        // Wyświetlenie prośby o podanie imienia
        System.out.print("Podaj swoje imię: ");

        // Odczytanie imienia użytkownika
        String imie = scanner.nextLine();

        // Wyświetlenie powitania
        System.out.println("Witaj, " + imie + "!");

        // Zamknięcie obiektu Scanner
        scanner.close();
    }
}
