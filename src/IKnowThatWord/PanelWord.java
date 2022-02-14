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
    private GridBagConstraints constraints;
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


            timer = new Timer(1000, escucha);
            timer.start();


        }

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
            }


        }
    }
}
