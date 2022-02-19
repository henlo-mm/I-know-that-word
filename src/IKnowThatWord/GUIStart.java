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
    public static final int WIDTH=300;
    public static final int HEIGTH=250;

    private Escucha escucha;
    private JTextField user;
    private JButton start, exitButton, register, help, games;
    private JLabel title,text;
    private JPanel panelTexto;
    private String nick;
    private Font font;
    private Point initialClick;
    private Header header;
    private  FileManager fileManager;
    public static final String MESSAGE = "Bienvenido a I Know That Word\n" +
            "\n I Know That Word es un juego de memoria que tiene 10 niveles. " +
            "\n Una vez que comiences la partida mostrará una serie de palabras "+
            "\n que aumentarán según el nivel en que se encuentre el jugador." +
            "\n Tendrás 5 segundos para memorizar cada palabra mostrada "+
            "\n en la fase inicial y 7 segundos para decidir si la palabra está o no. " +
            "\n Pasarás de nivel si aciertas el mayor número de palabras " +
            "\n y ganarás si logras completar todos los niveles.";


    public  GUIStart(){
        initGUI();
        //font = new Font("Agency FB", Font.BOLD, 14);
        this.setTitle("I Know That Word");
        setFont(font);
        Dimension size = new Dimension(WIDTH, HEIGTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(size);
        setPreferredSize(size);
        pack();
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

    private  void initGUI() {

        escucha = new Escucha();
        header = new Header("I Know That Word", new Color(95,24,191));
        header.setBounds(45, 5, 200, 20);
        this.add(header);

        user = new JTextField();
       // user.setLocation(10, 10);
        user.setBounds(50, 115, 200, 35);
        //user.setPreferredSize( new Dimension( 100, 30 ) );

        user.setEditable(true);
       // usuario.setHorizontalAlignment(JTextField.LEFT);
        start = new JButton("Empezar");
        start.addActionListener(escucha);
        //start.setLocation(200, 30);
        start.setBounds(50, 166, 200, 30);
        start.setBackground(new Color(255, 0, 127));
        start.setForeground(Color.WHITE);
        start.setFocusPainted(false);

        register = new JButton("Registrarse");
        register.addActionListener(escucha);
        //start.setLocation(200, 30);
        register.setBounds(50, 200, 200, 30);
       // register.setBackground(new Color(255, 0, 127));
        register.setBackground(Color.BLACK);
        // register.setBackground(new Color(2, 75, 174));
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);


        exitButton = new JButton("X");
        exitButton.addActionListener(escucha);
        //exitButton.setIcon(new ImageIcon(getClass().getResource("/resources/exit_.png")));
    //    exitButton.setOpaque(true);
        exitButton.setFocusPainted(false);
      //  exitButton.setContentAreaFilled(false);
        //exitButton.setBorder(null);
        //exit.setBorder(null);
        //exitButton.setBounds(240, 0, 60, 25);
        exitButton.setBounds(255, 0, 45, 25);
      //  exit.setPreferredSize(new Dimension(30, 30));
        exitButton.setBackground(new Color(239, 25, 53));
        exitButton.setForeground(Color.BLACK);


        help = new JButton("?");
        help.addActionListener(escucha);
       // help.setIcon(new ImageIcon(getClass().getResource("/resources/information.png")));
       // help.setOpaque(true);
       // help.setBorder(null);
        //  help.setContentAreaFilled(false);
        help.setFocusPainted(false);
        help.setBounds(0, 0, 45, 25);
        help.setBackground(new Color(246, 75, 208));
       // help.setBackground(new Color(255, 0, 127));
        help.setForeground(Color.BLACK);

        games = new JButton("");
        games.setIcon(new ImageIcon(getClass().getResource("/resources/history.png")));
        games.addActionListener(escucha);
        games.setBorder(null);
        //games.setBackground(Color.white);
        games.setOpaque(true);
        games.setFocusPainted(false);
        games.setContentAreaFilled(false);
        games.setFocusable(true);
        games.setBounds(0, 50, 45, 30);


        font = new Font("Agency FB", Font.BOLD, 18);

        text = new JLabel("Ingresa tu nick:");
        text.setFont(font);
        text.setForeground(Color.WHITE);
        text.setBounds(50, 85, 150, 25);
       // text.setLocation(50, 50);

        panelTexto = new JPanel();
        panelTexto.add(user);
        panelTexto.add(start);
        panelTexto.add(exitButton);
        panelTexto.add(text);
        panelTexto.add(register);
        panelTexto.add(help);
        panelTexto.add(games);
        panelTexto.setBackground(new Color(95,24,191));
        panelTexto.setLayout(null);
        /** constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
         */
        add(panelTexto);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIStart miProjectGUI = new GUIStart();
        });
    }

    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Player player = new Player();
            ControlGame words = new ControlGame();

            nick = user.getText();
            words.setNick(nick);

            if (e.getSource() == exitButton){
                System.exit(0);
            }
            if(e.getSource() == help){
                JOptionPane.showMessageDialog(null, MESSAGE);
            }

            if(e.getSource() == start){

                if(player.validateNick(nick)){
                    fileManager = new FileManager();
                    Score score;

                    if(fileManager.getGameFile().length() !=0){
                        score = fileManager.getGameObject();
                        dispose();
                    }else {
                        score = new Score();
                    }
                    if(score.checkExistence(nick)){
                        ControlGame user = score.getPlayer(nick);

                        user.setDictionary(new Dictionary());
                        GUIGame game = new GUIGame(user);
                        dispose();
                    }else {
                        if(nick.length() == 0){
                            JOptionPane.showMessageDialog(null, "Por favor, introduzca o registre su nombre.");
                        }else {
                            ControlGame newUser = new ControlGame();
                            newUser.setNick(nick);
                            GUIGame game = new GUIGame(newUser);
                            dispose();
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }

              }else if(e.getSource() == games){
                FileManager score = new FileManager();
                if(score.getScoreFile().length() !=0){
                    GUIClasification clasification = new GUIClasification(score.getScoreString());

                    dispose();
                }else{
                    GUIClasification clasification = new GUIClasification("");
                    dispose();


                }

            }
            else if(e.getSource() == register){
                if(player.saveNick(user.getText())){
                    GUIGame game = new GUIGame(words);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            }
        }
    }
}
