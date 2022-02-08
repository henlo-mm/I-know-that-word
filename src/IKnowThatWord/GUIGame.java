package IKnowThatWord;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends JFrame {

    private JLabel title;
    private ControlGame controlGame;
  //  private Escucha escucha;
    private JButton saveExit;
    private  JTextField wordText;
    private FileManager fileManager;

    public GUIGame(){
        initGUI();
        setTitle("I Know That Word");
        setSize(490,500);
        setPreferredSize(new Dimension(490,500));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI(){

        Font font = new Font("Agency FB",Font.BOLD,20);
        title = new JLabel ("I Know That Word");
        title.setFont(font);
        title.setSize(470,50);
        title.setForeground(Color.BLACK);
        title.setPreferredSize(new Dimension(470,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

    }
}
