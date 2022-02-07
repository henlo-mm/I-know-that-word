package IKnowThatWord;

import javax.swing.*;
import java.awt.*;

public class Header extends  JLabel {

    public Header(String title){
        this.setText(title);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Agency FB", Font.BOLD, 20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setBackground(new Color(87,35,100));
    }
}
