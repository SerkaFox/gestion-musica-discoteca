import javax.swing.*;

public class DiscoForm {
    private JList<String> listPrimaria;
    private JComboBox<String> comboTipoMostrar, comboAlbumAnadir, comboOrdenarTipo;
    private JButton mostrarButton, anadirButton, quitarButton, ordenarButton, buscarButton;
    private JPanel Panel;
    private JTextField textFieldCancionAnadir, fieldInterAnadir, textFieldBuscar;
    private JTextArea textResultBuscar;
    private JLabel labelSort,labelDuracion,labelMostrar, labelAnadir, labelCancionAna, labelInterp, labelAlbum, labelBuscador;
    private JSpinner spinnerSecond, spinnerMinut, spinnerHoras;


    public static void main(String[] args) {
            JFrame frame = new JFrame("DiscoForm");
            frame.setContentPane(new DiscoForm().Panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(700,500);
            frame.setVisible(true);
        }
    }
