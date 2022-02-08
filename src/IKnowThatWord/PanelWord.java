package IKnowThatWord;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelWord extends JPanel {
    public static final int WIDTH=230;
    public static final int HEIGTH=300;
    private Border border;
    private JTextField words;
    private ControlGame controlGame;

    ///ControlGame por acá

    public PanelWord() {

    }

    public PanelWord(PanelWord newControl) {
        this.controlGame = newControl.controlGame;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setPreferredSize(size);
        setSize(size);
        border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        setBorder(border);
        printWords();
    }

    private void printWords(){

        for(int i = 0; i < controlGame.getWords().size(); i++){
            System.out.print("Words");
        }

    }
}
