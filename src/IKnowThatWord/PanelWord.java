package IKnowThatWord;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class PanelWord extends JPanel{
    public static final int WIDTH=200;
    public static final int HEIGTH=200;
    private Border border;
    private JTextField words;
    private ControlGame controlGame;
    private GridBagConstraints constraints;
    private int randomNumber;
    private Font font;
    private Timer timer;
    MyTimerTask myTimerTask;
    private int counter;
    private  int reply;

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

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            words.setText(controlGame.getWords(1).get(counter).toUpperCase().toString());
            counter++;

            if(counter >= controlGame.getWords(1).size()){
                if(timer !=null){
                    timer.cancel();
                    timer = null;
                    reply = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if(reply == JOptionPane.YES_OPTION){
                        System.out.print("Holi");

                    }else{
                        System.out.print(":(");

                    }
                }
            }

        }
    }
}
