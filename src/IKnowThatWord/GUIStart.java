package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIStart extends JFrame {
    public static final int WIDTH=300;
    public static final int HEIGTH=150;

    private Escucha escucha;
    private JTextField usuario;
    private JButton iniciar;
    private JLabel titulo,texto;
    private JPanel panelBotones,panelTexto;
    private String nick;


    public  GUIStart(){
        initGUI();
        setTitle("...");

        Dimension size = new Dimension(WIDTH, HEIGTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(size);
        setPreferredSize(size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // pack();
    }

    private  void initGUI() {

        GridBagConstraints constraints = new GridBagConstraints();

        escucha = new Escucha();

        usuario = new JTextField();
        usuario.setBounds(50, 40, 200, 40);
        //usuario.setPreferredSize( new Dimension( ,  ) );
        usuario.setEditable(true);
       // usuario.setHorizontalAlignment(JTextField.LEFT);
        iniciar = new JButton("Empezar");
        iniciar.setBounds(50, 90, 200, 40);

        panelTexto = new JPanel();
        panelTexto.add(usuario);
        panelTexto.add(iniciar);
        panelTexto.setLayout(null);

        add(panelTexto, BorderLayout.CENTER);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIStart miProjectGUI = new GUIStart();
        });
    }


    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}
