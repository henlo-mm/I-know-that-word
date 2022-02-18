package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIGame extends JFrame {

    private  ControlGame controlGame;
    private JButton save, help;
    // private JLabel lblBackgroundImage = new JLabel();
    private JLabel score, level, levelGUI;
    private Escucha escucha;
   // private  JButton yes, no;
    private int levelValue, scoreValue;
   // private  JPanel guiPanel;
    private Point initialClick;
    private JPanel panelInfo;

    public static final String MESSAGE = """
            Bienvenido a I Know That Word

             I Know That Word es un juego de memoria que tiene 10 niveles.\s
             Una vez que comiences la partida mostrará una serie de palabras\s
             que aumentarán según el nivel en que se encuentre el jugador.
             Tendrás 5 segundos para memorizar cada palabra mostrada\s
             en la fase inicial y 7 segundos para decidir si la palabra está o no.\s
             Pasarás de nivel si aciertas el mayor número de palabras\s
             y ganarás si logras completar todos los niveles.""";


    public GUIGame(ControlGame w){
        this.controlGame = w;
        FileManager fileManager = new FileManager();
        this.controlGame.changeWords(this.controlGame.getLevels());
        setUndecorated(true);
        initGUI(controlGame);
        //setLayout(new FlowLayout(FlowLayout.CENTER));
       // setLayout(null);
        setTitle("I Know That Word");
        setSize(300,300);
        setPreferredSize(new Dimension(300,300));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(new JLabel(new ImageIcon(getClass().getResource("/resources/back.png"))));
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




    private void initGUI(ControlGame controlGame){
     //  this.getContentPane().setLayout(new GridBagLayout());
      // GridBagConstraints constraints = new GridBagConstraints();

       // lblBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/resources/back.png")));
        //lblBackgroundImage.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        //setContentPane(lblBackgroundImage);

      //  this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/resources/back.png"))));
        levelValue = controlGame.getLevels();
        scoreValue = controlGame.getTotalPoint();

        escucha = new Escucha();
        save = new JButton("X");
        save.addActionListener(escucha);
        save.setOpaque(true);
        save.setFocusPainted(false);
        save.setBackground(new Color(239, 25, 53));
        save.setForeground(Color.BLACK);
        save.setPreferredSize(new Dimension(30, 30));
        save.setBounds(255, 0, 45, 25);
        add(save);

        help = new JButton("?");
        help.addActionListener(escucha);
        help.setOpaque(true);
        help.setFocusPainted(false);
        help.setBounds(0, 0, 45, 25);
        help.setBackground(new Color(246, 75, 208));
        //help.setBackground(new Color(255, 0, 127));
        help.setForeground(Color.BLACK);
        add(help);


        score = new JLabel("Puntaje: " +  scoreValue);
        score.setBounds(0, 50, 80, 30);
        score.setVisible(true);
        add(score);

        level = new JLabel("Nivel: " + levelValue);
        level.setBounds(230, 50, 80, 30);
        level.setVisible(true);
        add(level);

        Font font = new Font("Agency FB",Font.BOLD,20);
        JLabel title = new JLabel("I Know That Word");
        title.setFont(font);
        title.setSize(300,50);
        title.setForeground(Color.BLACK);
        title.setPreferredSize(new Dimension(300,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        add(title, BorderLayout.PAGE_START);

        PanelWord panelWord = new PanelWord(this.controlGame);
        panelWord.setOpaque(false);
        add(panelWord, BorderLayout.CENTER);

    }

    public JLabel getScore() {
        return score;
    }

    public JLabel getLevel() {
        return level;
    }

    private class  Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == save) {
                System.exit(0);
               /** if(controlGame.getLives() == 0) {

                    JOptionPane.showMessageDialog(null, "Has perdido todas las vidas, gracias por jugar :)");
                    GUIStart game = new GUIStart();
                    dispose();

                }
                if(controlGame.getLives() != 0 && controlGame.getLevels() !=10) {

                    if(fileManager.getGameFile().length() == 0) {
                       fileManager.addScore(controlGame);

                        fileManager.writeGame();
                    }else {
                        fileManager.writeGame(controlGame);

                    }

                }

                */

            }

            if(e.getSource() == help){
                JOptionPane.showMessageDialog(null, MESSAGE);


            }

        }


    }
}
