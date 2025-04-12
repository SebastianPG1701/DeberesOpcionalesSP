import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;

    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pila p = new Pila();
                    String codigo = txtCodigo.getText();

                    for (int i = 0; i < codigo.length(); i++) {
                        char c = codigo.charAt(i);

                        // Si es un carácter de apertura, lo insertamos
                        if (c == '(' || c == '[' || c == '{') {
                            p.insertar(String.valueOf(c));
                        } else if (c == ')' || c == ']' || c == '}') {
                            if (p.esVacia()) {
                                JOptionPane.showMessageDialog(null, "Falta símbolo de apertura para: " + c);
                                return;
                            }

                            char apertura = p.extraer().charAt(0);

                            // Verificamos que coincidan
                            if ((c == ')' && apertura != '(') ||
                                    (c == ']' && apertura != '[') ||
                                    (c == '}' && apertura != '{')) {
                                JOptionPane.showMessageDialog(null, "Símbolos desordenados o incorrectos");
                                return;
                            }
                        }
                    }

                    if (p.esVacia()) {
                        JOptionPane.showMessageDialog(null, "Código correcto");
                    } else {
                        JOptionPane.showMessageDialog(null, "Faltan símbolos de cierre");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
