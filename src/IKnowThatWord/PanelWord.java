package IKnowThatWord;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelWord extends JPanel {
    public static final int WIDTH=230;
    public static final int HEIGTH=300;
    private Border borde;
    private JTextField words;
    private ControlGame controlGame;

    ///ControlGame por acá

    public ControlGame getControl() {
        return controlGame;
    }



    public void setControl(ControlGame control) {
        this.controlGame = control;
    }







    public PanelWord(ControlGame controle) {
        this.controlGame = controle;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setPreferredSize(size);
        setSize(size);
        borde = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        setBorder(borde);
        printWords();

    }

    public PanelWord(PanelWord newControl) {
        this.controlGame = newControl.controlGame;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setPreferredSize(size);
        setSize(size);
        borde = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        setBorder(borde);
        printWords();
    }


    private void printWords(){

        for(int i = 0; i < controlGame.getWords().size(); i++){
            words = new JTextField(controlGame.getWords().get(i));
            words.setEditable(false);

            words.setBorder(borde);
            words.setBackground(Color.WHITE);
            words.setOpaque(true);
            words.setSize(230,260);
            words.setHorizontalAlignment(JLabel.CENTER);
            words.setPreferredSize(new Dimension(230,260));

            add(words);
        }

    }
}
