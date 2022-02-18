package IKnowThatWord;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.TimerTask;
import java.util.Timer;

public class PanelWord extends JPanel{
    public static final int WIDTH=200;
    public static final int HEIGTH=200;
    private Border border;
    private JTextField words;
    private JLabel field;
    private ControlGame controlGame;
    private GUIGame game;
    private GridBagConstraints constraints;
    private int randomNumber;
    private Font font;
    private Timer timer;
    MyTimerTask myTimerTask;
    private int counter;
    private  int reply;
    private  JButton yes, no;
    private Escucha escucha;



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
        setLayout(new GridBagLayout());
        printWords();
    }

    public PanelWord(PanelWord newControl) {
        setLayout(new GridBagLayout());
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

            GridBagConstraints constraints = new GridBagConstraints();

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
            constraints.gridy = 5;
            constraints.anchor = GridBagConstraints.EAST;
            add(yes, constraints);

            no = new JButton();
            no.setIcon(new ImageIcon(getClass().getResource("/resources/no.png")));
            no.setPreferredSize(new Dimension(30, 30));
            no.setOpaque(true);
            no.setBorder(null);
            no.setFocusPainted(false);
            no.setContentAreaFilled(false);
            no.setFocusable(true);
            no.setVisible(false);
            constraints.anchor = GridBagConstraints.WEST;
            //constraints.insets = new Insets(0, 0, 10, 0);
            constraints.gridx = 0;
            constraints.gridy = 5;
            add(no, constraints);

            font = new Font("Agency FB", Font.BOLD, 25);

            words = new JTextField(controlGame.getWords(1).get(counter).toUpperCase());
            words.setEditable(false);
            words.setBorder(null);
            words.setFont(font);
            words.setOpaque(false);
            words.setSize(200, 150);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(200, 150));
            words.setVisible(true);
            constraints.gridy = 0;
            words.setAlignmentX(Component.CENTER_ALIGNMENT);
            words.setAlignmentY(Component.CENTER_ALIGNMENT);
            add(words, constraints);
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
                        yes.setVisible(true);
                        yes.addActionListener(escucha);
                        no.setVisible(true);

                        counter = 0;
                        timer = new Timer();
                        myTimerTask = new MyTimerTask();
                        timer.schedule(myTimerTask, 1000, 3000);


                    }else{
                        System.out.print(":(");

                    }
                }
            }
        }
    }

    private class Escucha implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == yes){
                controlGame.GuessWord(words.getText().toLowerCase());
                //System.out.print(words.getText().toLowerCase());
                System.out.print(controlGame.getTotalPoint());

            }else {
                System.exit(0);
                //GUIStart game = new GUIStart();

            }

        }
    }
}
