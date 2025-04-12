import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboMarca;
    private JTextField txtAnio;
    private JButton btnEncolar;
    private JButton btnDesencolar;
    private JTextArea txtListado;
    private JLabel lblPago;
    private ColaAutos autos=new ColaAutos();

    public Ventana() {
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca=cboMarca.getSelectedItem().toString();
                int anio=Integer.parseInt(txtAnio.getText());
                autos.encolar(new Auto(marca,anio));
                txtListado.setText(autos.listarTodos());
            }
        });
        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Auto atendido = autos.desencolar();
                    double pago = atendido.calcularPago();
                    lblPago.setText("<html>Último auto atendido:<br>" + atendido.toString().replace("\n", "<br>") +
                            "<br><b>Pago: $" + pago + "</b></html>");
                    txtListado.setText(autos.listarTodos());

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
        frame.setSize(600, 800);
       // frame.pack();
        frame.setVisible(true);
    }
}
