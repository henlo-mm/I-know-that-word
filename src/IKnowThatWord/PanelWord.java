package IKnowThatWord;

import javax.swing.*;
//import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

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
    MyTimerTask myTimerTask;



    public ControlGame getControlGame(){return  controlGame;}

    public void setControlGame(ControlGame controlGame) {this.controlGame = controlGame;}

    public PanelWord(ControlGame control) {
        this.controlGame = control;
       // this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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


            words = new JTextField(controlGame.getWords(1).get(0).toUpperCase());
            words.setEditable(false);
            words.setBorder(null);
            words.setFont(font);
            words.setOpaque(false);
            words.setSize(200, 150);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(200, 150));
            words.setVisible(true);
            add(words, BorderLayout.CENTER);

            timer = new Timer();

            myTimerTask = new MyTimerTask();
            timer.schedule(myTimerTask, 1000, 2000);

        }

    }
    private int counter = 0;

    class MyTimerTask extends TimerTask {


        @Override
        public void run() {

            /**for(int i=0; i<controlGame.getWords(1).size(); i++) {
                //randomNumber = controlGame.getRandom(1);
                words.setText(controlGame.getWords(1).get(counter%controlGame.getWords(1).size()).toUpperCase().toString());
                counter++;


            }
             */
            if(counter >= controlGame.getWords(1).size()){
                counter = 0;
            }
            words.setText(controlGame.getWords(1).get(counter).toUpperCase().toString());
            counter++;

        }}

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
                //counter++;
                System.out.print(counter);

             /**  if(counter == 7){
                    //randomNumber = controlGame.getRandom(1);
                   words.setText(controlGame.getWords().get(counter%controlGame.getWords().size()).toUpperCase().toString());



                 //    timer.restart();
                }else {



                    System.out.print(" OK ");
                }

              */

            }else {
                counter = 0;
            }


        }
    }
}
