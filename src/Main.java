
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Color;//biblioteka odpowiedzialna za ustawienie koloru tła pola tekstowego
import java.awt.GridLayout;//wstawianie siatki rozmieszczającej przyciski
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//"wysłuchiwanie" stanu przycisku - wciśnięty lub nie
import java.util.Random;//generowanie liczb pseudolosowych
import java.util.Scanner; //dodanie klasy Scanner

public class Main {
    // Zmienna do przechowywania liczby prób, diamentów i bomb
    private static int proba = 0;
    private static int diament = 0;
    private static int bomba = 0;
    private static Random random = new Random(); // Instancja klasy Random
    private static String imieGracza;
    private static boolean s = false; //Zmienna pomocnicza do sprawdzania ponownego startu gry

    public static void main(String[] args) {
        // Użycie Scanner do pobrania imienia gracza przed uruchomieniem GUI
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj swoje imię: ");
        imieGracza = scanner.nextLine(); // Pobranie imienia gracza


            //tworzenie okna JFrame
            JFrame frame = new JFrame("Siatka z przyciskami i polem tekstowym");

            //Ustawienie siatki  - GridLayout (2x2)
            frame.setLayout(new GridLayout(2, 2, 10, 10)); // 2 wiersze, 2 kolumny, odstępy 10px

            //tworzenie przycisków
            JButton b1 = new JButton("Kliknij tutaj");
            JButton b2 = new JButton("A może tutaj?");

            //tworzenie etykiety w miejscu trzeciego przycisku
            JLabel label3 = new JLabel("", JLabel.CENTER); // Wycentrowana etykieta

            //tworzenie pola tekstowego JTextArea w miejscu czwartego przycisku
            JTextArea pole4 = new JTextArea("Witaj w grze " + imieGracza + "!!!");
            pole4.setRows(5); // Ustawienie liczby wierszy
            pole4.setColumns(20); // Ustawienie liczby kolumn

            //zmiana koloru tła JTextArea na białe
            pole4.setBackground(Color.WHITE);

            //dodanie ActionListener do przycisków
            ActionListener buttonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean losowawartosc = random.nextBoolean(); //generowanie losowej wartości
                    //Sprawdzenie który przycisk został wciśnięty
                    if (e.getSource() == b1) {//e.getSource sprawdza ktory przycisk wywołał zdarzenie
                        if (losowawartosc) {
                            diament++;
                        } else {
                            bomba++;
                        }
                        proba++;
                    } else if (e.getSource() == b2) {
                        if (losowawartosc) {
                            diament++;
                        } else {
                            bomba++;
                        }
                        proba++;
                    }

                    // Aktualizacja etykiety o wyniki (HTML formatowanie dla nowych linii)
                    label3.setText("<html>Próba: " + proba + "<br>Diamenty: " + diament + "<br>Bomby: " + bomba + "</html>");

                    if (proba < 20) {
                        //jeżeli zmienna s przyjmuje true oznacza to ze uzytkownik gra ponownie
                        if(s == true){pole4.setText("Witaj ponownie " + imieGracza);}//wyswietlenie komunikatu
                    }
                    else
                    {
                        s = true;
                        if (diament >= bomba) {
                            pole4.setText("Koniec gry!\nWygrałeś!\nDiamenty: " + diament);
                        } else {
                            pole4.setText("Koniec gry!\nNiestety los ci nie sprzyja:(\nBomby: " + bomba);
                        }
                        //resetowanie wartości
                        diament = 0;
                        bomba = 0;
                        proba = 0;
                    }
                }
            };

            // Rejestracja ActionListener dla obu przycisków
            b1.addActionListener(buttonListener);
            b2.addActionListener(buttonListener);

            // Dodawanie elementów do okna
            frame.add(b1);  // Pole 1 - Przycisk
            frame.add(b2);  // Pole 2 - Przycisk
            frame.add(label3);   // Pole 3 - Etykieta
            frame.add(pole4);  // Pole 4 - JTextArea

            // Ustawienia okna
            frame.setSize(400, 400); // Ustawienie rozmiaru okna
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po kliknięciu "X"
            frame.setLocationRelativeTo(null); // Wycentrowanie okna na ekranie
            frame.setVisible(true); // Pokazanie okna

    }
}
