package IKnowThatWord;

import javax.swing.*;
//import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

public class PanelWord extends JPanel {
    public static final int WIDTH=230;
    public static final int HEIGTH=300;
    private Border border;
    private JTextField words;
    private ControlGame controlGame;
    private  JButton yes, no;
    GridBagConstraints constraints;
    private Escucha escucha;
    private int randomNumber;
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
        printWords();
    }

    private void printWords(){
        escucha = new Escucha();


        if(controlGame.getLevels() == 1){

            yes = new JButton();
            yes.setIcon(new ImageIcon(getClass().getResource("/resources/yes.png")));
            yes.setPreferredSize(new Dimension(30, 30));
            yes.setOpaque(true);
            yes.setBorder(null);
            yes.setFocusPainted(false);
            yes.setContentAreaFilled(false);
            yes.setFocusable(true);

            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.weightx = 0.1;
            constraints.fill = GridBagConstraints.EAST;
            //constraints.anchor = GridBagConstraints.CENTER;
            add(yes, constraints);
         //   constraints.gridy = 0;

            no = new JButton();
            no.setPreferredSize(new Dimension(30, 30));
            no.setOpaque(true);
            no.setFocusPainted(false);
            no.setIcon(new ImageIcon(getClass().getResource("/resources/no.png")));
            no.setBorder(null);
            no.setContentAreaFilled(false);
            no.setFocusable(true);
            constraints.anchor = GridBagConstraints.WEST;

            constraints.gridx = 2;
            constraints.gridy = 1;
           // constraints.gridy = 3;
            //constraints.gridwidth = 1;
            //constraints.fill = GridBagConstraints.WEST;

            add(no, constraints);

            words = new JTextField(controlGame.getWords().get(controlGame.getRandom()));
            words.setEditable(false);
            words.setBorder(null);
            //words.setBackground(Color.WHITE);

            words.setOpaque(true);
            words.setSize(100, 100);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(100, 100));

            constraints.gridx = 1;
            constraints.gridy = 0;
            //constraints.gridwidth = 2;
            constraints.fill = GridBagConstraints.CENTER;
            add(words, constraints);

            timer = new Timer(1000, escucha);
            timer.start();


        }else if(controlGame.getLevels() == 2){
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

    }

    public class Escucha implements ActionListener{

        private Random random;
       // private int randomNumber;
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
                System.out.print(counter);
               if(counter == 6){

                    //randomNumber = random.nextInt(19)+1;
                    randomNumber = controlGame.getRandom();
                    words.setText(controlGame.getWords().get(randomNumber));
                    counter = 0;
                    timer.restart();


                }else {
                   // timer.restart();
                    yes.addActionListener(escucha);
                }

            }else {
                timer.start();
                counter = 0;
                yes.removeActionListener(escucha);
            }

        }
    }
}
