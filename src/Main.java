import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private static int proba = 0;  // Liczba prób
    private static int diament = 0; // Liczba diamentów
    private static int bomba = 0;   // Liczba bomb
    private static Random random = new Random(); // Instancja klasy Random

    public static void main(String[] args) {
        // Tworzenie okna w osobnym wątku GUI
        SwingUtilities.invokeLater(() -> {
            // Tworzenie okna JFrame
            JFrame frame = new JFrame("Siatka z przyciskami i polem tekstowym");

            // Ustawienie menedżera układu - GridLayout (2x2)
            frame.setLayout(new GridLayout(2, 2, 10, 10)); // 2 wiersze, 2 kolumny, odstępy 10px

            // Tworzenie przycisków
            JButton button1 = new JButton("Przycisk 1");
            JButton button2 = new JButton("Przycisk 2");

            // Tworzenie etykiety w miejscu trzeciego przycisku
            JLabel label3 = new JLabel("Etykieta 3", JLabel.CENTER); // Wycentrowana etykieta

            // Tworzenie pola tekstowego JTextArea w miejscu czwartego przycisku
            JTextArea textArea4 = new JTextArea("Wpisz tekst tutaj");
            textArea4.setLineWrap(true); // Automatyczne łamanie linii
            textArea4.setWrapStyleWord(true); // Łamanie w słowach
            textArea4.setRows(5); // Ustawienie liczby wierszy
            textArea4.setColumns(20); // Ustawienie liczby kolumn

            // Zmiana koloru tła JTextArea na białe
            textArea4.setBackground(Color.WHITE); // Możesz użyć dowolnego koloru

            // Dodanie ActionListener do przycisków
            ActionListener buttonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean randomValue = random.nextBoolean(); // Generowanie losowej wartości
                    // Sprawdzenie, który przycisk został wciśnięty
                    if (e.getSource() == button1) {
                        if (randomValue) {
                            diament++;
                        } else {
                            bomba++;
                        }
                        proba++;
                    } else if (e.getSource() == button2) {
                        if (randomValue) {
                            diament++;
                        } else {
                            bomba++;
                        }
                        proba++;
                    }

                    // Aktualizuj etykietę o wyniki
                    label3.setText("<html>Próba: " + proba + "<br>Diamenty: " + diament + "<br>Bomby: " + bomba + "</html>");

                    if (proba >= 20) {
                        // Wyświetlenie komunikatu w JTextArea
                        if (diament >= bomba) {
                            textArea4.setText("Koniec gry!\nWygrałeś!\nDiamenty: " + diament);
                        } else {
                            textArea4.setText("Koniec gry!\nNiestety los ci nie sprzyja:(\nBomby: " + bomba);
                        }
                        // Resetowanie wartości
                        diament = 0;
                        bomba = 0;
                        proba = 0;
                    }
                    else
                    {
                        textArea4.setText("Powodzenia!!!");
                    }
                }
            };

            // Rejestracja ActionListener dla obu przycisków
            button1.addActionListener(buttonListener);
            button2.addActionListener(buttonListener);

            // Dodawanie elementów do okna
            frame.add(button1);  // Pole 1 - Przycisk
            frame.add(button2);  // Pole 2 - Przycisk
            frame.add(label3);   // Pole 3 - Etykieta
            frame.add(textArea4);  // Pole 4 - JTextArea

            // Ustawienia okna
            frame.setSize(400, 400); // Ustawienie rozmiaru okna
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamknięcie aplikacji po kliknięciu "X"
            frame.setLocationRelativeTo(null); // Wycentrowanie okna na ekranie
            frame.setVisible(true); // Pokazanie okna
        });
    }
}
