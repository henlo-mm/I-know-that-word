package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIStart extends JFrame {
    public static final int WIDTH = 300;
    public static final int HEIGTH = 200;

    private Escucha escucha;
    private JTextField user;
    private JButton start, exitButton, register;
    private JTextField txtUsuario;
    private JLabel title, text;
    private JPanel panelBotones, panelTexto;
    private ImageIcon imageExit;
    private String nick;
    private Font font;
    private Point initialClick;
    private Header header;


    public GUIStart() {
        initGUI();
        //font = new Font("Agency FB", Font.BOLD, 14);
        this.setTitle("I Know That Word");
        //setFont(font);

        Dimension size = new Dimension(WIDTH, HEIGTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(size);
        setPreferredSize(size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // get location of Window
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });

    }

    private void initGUI() {

        escucha = new Escucha();
        header = new Header("I Know That Word");
        header.setBounds(35, 5, 200, 20);
        this.add(header);

        user = new JTextField();
        // user.setLocation(10, 10);
        user.setBounds(50, 75, 200, 35);
        //user.setPreferredSize( new Dimension( 100, 30 ) );

        user.setEditable(true);
        // usuario.setHorizontalAlignment(JTextField.LEFT);
        start = new JButton("Empezar");
        start.addActionListener(escucha);
        //start.setLocation(200, 30);
        start.setBounds(50, 120, 200, 30);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);

        register = new JButton("Registrarse");
        register.addActionListener(escucha);
        //start.setLocation(200, 30);
        register.setBounds(50, 155, 200, 30);
        register.setBackground(new Color(2, 75, 174));
        register.setForeground(Color.WHITE);


        imageExit = new ImageIcon(getClass().getResource("/resources/exit.png"));

        exitButton = new JButton("X");
        exitButton.addActionListener(escucha);
        // exit.setIcon(new ImageIcon(getClass().getResource("/resources/exit.png")));
        exitButton.setOpaque(true);
        exitButton.setFocusPainted(false);
        //exit.setBorder(null);
        exitButton.setBounds(240, 0, 60, 25);
        //  exit.setPreferredSize(new Dimension(30, 30));
        exitButton.setBackground(new Color(246, 51, 71));
        exitButton.setForeground(Color.BLACK);
        //
        // exit.setContentAreaFilled(false);
        // exit.setFocusable(true);
        txtUsuario = new JTextField(50);
        font = new Font("Agency FB", Font.BOLD, 16);

        text = new JLabel("Ingresa tu nick:");
        text.setFont(font);
        text.setForeground(Color.WHITE);
        text.setBounds(50, 50, 100, 25);
        // text.setLocation(50, 50);

        panelTexto = new JPanel();
        panelTexto.add(user);
        panelTexto.add(start);
        panelTexto.add(exitButton);
        panelTexto.add(text);
        panelTexto.add(register);
        panelTexto.setBackground(new Color(95, 24, 191));
        panelTexto.add(txtUsuario);
        panelTexto.setLayout(null);
        add(panelTexto);


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIStart miProjectGUI = new GUIStart();
            }
            });
            }





    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Player player = new Player();
            ControlGame words = new ControlGame();

            Player_Info info = new Player_Info();
            nick = txtUsuario.getText();

            words.setNick(nick);


            if (e.getSource() == exitButton) {
                System.exit(0);
            }

            if (e.getSource() == start) {
                if (player.validateNick(nick)) {

                    Archive archivo = new Archive();
                    Score comprobador;
                    if (archivo.getArchivoPartidas().length() != 0) {
                        comprobador = archivo.obtenerPartidaObjeto();
                        System.out.println("Camino 11111111111");
                    } else {
                        comprobador = new Score();
                        System.out.println("Camino 22222222222");
                    }

                    if (comprobador.buscarExistencia(nick)) {
                        System.out.println("Camino 33333333333333333");
                        ControlGame usuarioCargado = comprobador.obtenerJugador(nick); /// Tiene un diccionario nulo.
                        usuarioCargado.setDictionary(new Dictionary());
                        System.out.println(usuarioCargado.getNick() + ", as� me llamo xddd, y tengo " + usuarioCargado.getLevels());
                        GUIGame juego = new GUIGame(usuarioCargado);
                    } else {
                        System.out.println("Camino 44444444444444444444");
                        ControlGame usuarioNuevo = new ControlGame();
                        usuarioNuevo.setNick(nick);
                        GUIGame juego = new GUIGame(usuarioNuevo);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "EL USUARIO NO SE ENCUENTRA REGISTRADO.");
                }
            }
            else if(e.getActionCommand()=="Tabla Puntajes") {
                Archive puntuacion = new Archive();

                if(puntuacion.getArchivoPuntajes().length()!=0) {
                    GUI_Clasification tabla = new GUI_Clasification(puntuacion.obtenerPuntajeString());
                }else {
                    GUI_Clasification tabla = new GUI_Clasification("");
                }


            }else if(e.getActionCommand()=="Registrarse") {
                if(player.saveNick(txtUsuario.getText())) {
                    GUIGame juego = new GUIGame(words);
                } else {
                    JOptionPane.showMessageDialog(null, "EL USUARIO YA EXISTE.");
                }
            }

            dispose();
        }
    }

}
