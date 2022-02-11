package IKnowThatWord;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Interfaz.ManejadorDeEventos;


public class GUIGame extends JFrame {
    private PanelWord panelPalabras;
    private PanelInfo panelinfo;
    private JLabel titulo;
    private ControlGame controlPalabras;
    private Escucha escucha;
    private JButton salirguardar;
    private  JTextField txtPalabras;
    private Archive archivo;

    public PanelInfo getPanelInfo() {
        return this.panelinfo;
    }

    public GUIGame(ControlGame e) {

        this.controlPalabras = e;

        this.archivo = new Archive();

        this.controlPalabras.changeWords(this.controlPalabras.getLevels());
        initGUI(controlPalabras);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setTitle("Juego de Palabras");
        setSize(490,500);
        setPreferredSize(new Dimension(490,500));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.txtPalabras.addKeyListener(new Escucha());
    }

    public void initGUI(ControlGame controlPalabras) {
        escucha = new Escucha();
        Font font = new Font(Font.DIALOG,Font.BOLD,20);

        titulo = new JLabel ("Juego de Palabras");
        titulo.setFont(font);
        titulo.setSize(470,50);
        titulo.setForeground(Color.RED);
        titulo.setPreferredSize(new Dimension(470,50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);

        salirguardar = new JButton("Salir (Guardar)");
        salirguardar.addActionListener(escucha);

        setLayout(new BorderLayout());


        add(titulo, BorderLayout.NORTH);

        panelinfo = new PanelInfo(this.controlPalabras);
        add(panelinfo,BorderLayout.WEST);



        panelPalabras = new PanelWord(controlPalabras); // NOTA: Se debe de hacer de tal forma que se conserven las mismas palabras


        add(panelPalabras,BorderLayout.EAST);

        this.txtPalabras = new JTextField(5); // RECORDAR PONER UN MEJOR LAYOUT PARA QUE NO SE REDIMENSION EL JTEXTFIELD
        txtPalabras.setBounds(new Rectangle(100, 60, 250, 21));

        // Crear nuevo panel
        JPanel abajo = new JPanel();
        abajo.setLayout(new GridLayout(1,2));
        abajo.add(salirguardar);
        abajo.add(txtPalabras);

        add(abajo,BorderLayout.SOUTH);

    }

    private class Escucha implements ActionListener, KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getActionCommand()=="Salir (Guardar)") {
                if(controlPalabras.getLives() == 0) {

                    JOptionPane.showMessageDialog(null, "Has perdido todas las vidas, gracias por jugar :)");
                    GUIStart juego = new GUIStart();

                    dispose();

                }if(controlPalabras.getLives() != 0 && controlPalabras.getLevels() !=6) {
                    ////
                    if(archivo.getArchivoPartidas().length() == 0) {
                        archivo.agregarPuntaje(controlPalabras);


                        archivo.escribirPartida();
                    }else {
                        archivo.escribirPartida(controlPalabras);


                        System.out.println(archivo.getPuntaje().imprimirPuntajes());  // imprimir los componentes de Puntaje durante el tiempo de ejecuci�n STRING
                    }

                    JOptionPane.showMessageDialog(null, "Su partida se guard� correctamente");
                    GUIStart juego = new GUIStart();

                    dispose();

                }

            }

        }

        /////

        // Metodo para el KeyListener (Maneja los cuadros de texto (son 3, pero sólo se usará 1)
        @Override
        public void keyTyped(KeyEvent ke) {
            // No implementado
        }

        /*
         * keyPressed: Metodo sobrecargado que maneja los eventos del teclado (para este caso)
         * Ingreso: Los eventos arrojados por los listeners
         * Retorna: Los eventos que se realizan en el método
         */
        @Override
        public void keyPressed(KeyEvent ke) {

            if(ke.getKeyCode() == ke.VK_ENTER) {

                controlPalabras.GuessWord(txtPalabras.getText().toString()); // Para preguntar si acert�



                txtPalabras.setText("");


                panelPalabras.updateUI();

                PanelWord nuevo = new PanelWord(panelPalabras);
                panelPalabras.removeAll();
                panelPalabras.add(nuevo,BorderLayout.CENTER);


                panelinfo.updateUI();

                String nNombre = "Nombre: " + controlPalabras.getNick();
                String nAciertosN = "Aciertos (Nivel): " + Integer.toString(controlPalabras.getRoundPoint());
                String nAciertosG = "Aciertos (General) : " + Integer.toString(controlPalabras.getTotalPoint());
                String nRonda = "Ronda: " + Integer.toString(controlPalabras.getRounds());
                String nNivel = "Nivel: " + Integer.toString(controlPalabras.getLevels());
                String nVidas = "Vidas: " + Integer.toString(controlPalabras.getLives());

                PanelInfo nuevo2 = new PanelInfo(nNombre,nAciertosN,nAciertosG, nRonda,nNivel, nVidas);
                panelinfo.removeAll();
                panelinfo.add(nuevo2,BorderLayout.CENTER);



                //System.out.println(controlPalabras.getWords().get(0));


                if(controlPalabras.getLives() == 0 || controlPalabras.getLives() == 6) {

                    if(archivo.getArchivoPuntajes().length() == 0) {
                        archivo.agregarPuntaje(controlPalabras);
                        System.out.println(archivo.getPuntaje().imprimirPuntajes()); // imprimir los componentes de Puntaje durante el tiempo de ejecuci�n STRING

                        archivo.escribirPuntaje(); // Aqu� es donde se produce el error de io
                    }else {
                        archivo.escribirPuntaje(controlPalabras);
                        System.out.println(archivo.getPuntaje().imprimirPuntajes());  // imprimir los componentes de Puntaje durante el tiempo de ejecuci�n STRING
                    }

                    salirguardar.doClick();


                }



                if(controlPalabras.getLevels() == 6) {
                    JOptionPane.showMessageDialog(null, "Felicidades :)");
                    GUIStart volver = new GUIStart();
                    dispose();
                }





            }

        }

        @Override
        public void keyReleased(KeyEvent ke) {
            // No implementado
        }

        ////





    }



}