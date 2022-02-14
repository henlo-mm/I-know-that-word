package IKnowThatWord;

import javax.swing.*;
//import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

public class PanelWord extends JPanel{
    public static final int WIDTH=200;
    public static final int HEIGTH=200;
    private Border border;
    private JTextField words;
    private ControlGame controlGame;
    private  JButton yes, no;
    GridBagConstraints constraints;
    private Escucha escucha;
    private int randomNumber;
    private Font font;
    private Timer timer;




    public ControlGame getControlGame(){return  controlGame;}

    public void setControlGame(ControlGame controlGame) {this.controlGame = controlGame;}

    public PanelWord(ControlGame control) {
        this.controlGame = control;
       // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        Dimension size = new Dimension(150,150);
        setPreferredSize(size);
        setSize(size);
        setOpaque(false);

       // border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        setBorder(null);
        printWords();
    }

    public PanelWord(PanelWord newControl) {
        this.controlGame = newControl.controlGame;
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        Dimension size = new Dimension(150,150);
        setPreferredSize(size);
        setSize(size);
        border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        setBorder(null);
        setOpaque(false);

        printWords();
    }

    private void printWords(){
        escucha = new Escucha();
        Insets inset = new Insets(10, 10, 10, 10);


        if(controlGame.getLevels() == 1){

            font = new Font("Agency FB", Font.BOLD, 25);
            words = new JTextField(controlGame.getWords().get(controlGame.getRandom(1)).toUpperCase());
            words.setEditable(false);
            words.setBorder(null);
            words.setFont(font);
            words.setOpaque(false);
            words.setSize(150, 150);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(150, 150));
            words.setVisible(true);
            constraints.gridy = 0;
            words.setAlignmentX(Component.CENTER_ALIGNMENT);
            words.setAlignmentY(Component.CENTER_ALIGNMENT);
            add(words, constraints);

            yes = new JButton();
            yes.setIcon(new ImageIcon(getClass().getResource("/resources/yes.png")));
            yes.setPreferredSize(new Dimension(30, 30));
            yes.setOpaque(true);
            yes.setBorder(null);
            yes.setFocusPainted(false);
            yes.setContentAreaFilled(false);
            yes.setFocusable(true);
            yes.setVisible(false);
            constraints.gridx = 4;
            constraints.gridy = 2;
            constraints.anchor = GridBagConstraints.EAST;
            add(yes, constraints);

            no = new JButton();
            no.setPreferredSize(new Dimension(30, 30));
            no.setOpaque(true);
            no.setFocusPainted(false);
            no.setIcon(new ImageIcon(getClass().getResource("/resources/no.png")));
            no.setBorder(null);
            no.setContentAreaFilled(false);
            no.setFocusable(true);
            no.setVisible(false);
            constraints.anchor = GridBagConstraints.WEST;
            constraints.gridx = 0;
            add(no, constraints);
            timer = new Timer(1000, escucha);
            timer.start();


        }/**else if(controlGame.getLevels() == 2){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(40)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 3){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(50)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 4){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(60)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 5){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(70)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 6){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(80)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 7){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(100)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 8){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(120)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 9){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(140)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

        }else if(controlGame.getLevels() == 10){
            Random aleatorio = new Random();
            System.out.print("Words");
            words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(200)+1));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));
            add(words);

            }
         */

    }

    public class Escucha implements ActionListener{

        private Random random;
        private int randomNumber;
        private int  counter;
        TimerTask task;

        public  Escucha(){
            counter = 0;
            random = new Random();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == timer){
                counter++;
               // System.out.print(counter);
               if(counter == 2){
                    randomNumber = controlGame.getRandom(1);
                    words.setText(controlGame.getWords().get(randomNumber).toUpperCase());
                    System.out.print(" " + randomNumber + " ");
                    counter = 0;
                    timer.restart();

                }else {
                   // timer.restart();
                    System.out.print(" OK ");
                }

            }else {
                timer.start();
                counter = 0;
                yes.removeActionListener(escucha);
            }

            if(e.getSource() == yes){

            }

        }
    }
}
