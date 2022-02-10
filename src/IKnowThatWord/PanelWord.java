package IKnowThatWord;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class PanelWord extends JPanel {
    public static final int WIDTH=230;
    public static final int HEIGTH=300;
    private Border border;
    private JTextField words;
    private ControlGame controlGame;
    private  JButton yes, no;
    GridBagConstraints constraints;



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


            if(controlGame.getLevels() == 1){
                Random aleatorio = new Random();
                System.out.print("Words");
                words = new JTextField(controlGame.getWords().get(aleatorio.nextInt(20)+1));
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

             //   constraints.gridy = 0;


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
}
