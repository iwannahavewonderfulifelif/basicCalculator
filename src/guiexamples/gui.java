
package guiexamples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class gui {
        private JPanel mainPanel;
        private JTextField sayi1;
        private JTextField sayi2;
        private JButton toplaTusu;
        private JButton cikarTusu;
        private JButton carpTusu;
        private JButton bolTusu;
        private JLabel sonucLabel; // Değiştirilmiş

        public gui() {
            toplaTusu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation('+');
                }
            });
            cikarTusu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation('-');
                }
            });
            carpTusu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation('*');
                }
            });
            bolTusu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performOperation('/');
                }
            });
        }

        private void performOperation(char operation) {
            try {
                double num1 = Double.parseDouble(sayi1.getText());
                double num2 = Double.parseDouble(sayi2.getText());
                double result = 0;

                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            sonucLabel.setText("Hiçbir sayı 0'a bölünemez.Tanımsızdır!");
                            return;
                        }
                        break;
                }

                sonucLabel.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                sonucLabel.setText("Geçersiz giriş");
            }
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Basic Calculator-Basit Hesap Makinesi");
            frame.setContentPane(new gui().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }