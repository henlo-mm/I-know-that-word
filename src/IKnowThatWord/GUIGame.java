package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIGame extends JFrame {

    private JLabel title;
    private ControlGame controlGame;
  //  private Escucha escucha;
    private JButton save;
    private  JTextField wordText;
    private FileManager fileManager;
    private PanelWord panelWord;
    private JLabel lblBackgroundImage = new JLabel();
    private Escucha escucha;
    private  JButton yes, no;
   // private GridBagConstraints constraints;


    public GUIGame(ControlGame w){
        this.controlGame = w;
        this.fileManager = new FileManager();
        this.controlGame.changeWords(this.controlGame.getLevels());
        initGUI(controlGame);
        //setLayout(new FlowLayout(FlowLayout.CENTER));
       // setLayout(null);
        setTitle("I Know That Word");
        setSize(300,300);
        setPreferredSize(new Dimension(300,300));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(new JLabel(new ImageIcon(getClass().getResource("/resources/back.png"))));
    }

    private void initGUI(ControlGame controlGame){


       // lblBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/resources/back.png")));
        //lblBackgroundImage.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
        //setContentPane(lblBackgroundImage);

      //  this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/resources/back.png"))));
        Font font = new Font("Agency FB",Font.BOLD,20);
        title = new JLabel ("I Know That Word");
        title.setFont(font);
        title.setSize(300,50);
        title.setForeground(Color.BLACK);
        title.setPreferredSize(new Dimension(300,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        add(title);
        panelWord = new PanelWord(this.controlGame);
        panelWord.setOpaque(false);

        add(panelWord, BorderLayout.CENTER);

        yes = new JButton();
        yes.setIcon(new ImageIcon(getClass().getResource("/resources/yes.png")));
        yes.setPreferredSize(new Dimension(30, 30));
        yes.setOpaque(true);
        yes.setBorder(null);
        yes.setFocusPainted(false);
        yes.setContentAreaFilled(false);
        yes.setFocusable(true);
        yes.setVisible(true);

        add(yes, BorderLayout.EAST);

        no = new JButton();
        no.setIcon(new ImageIcon(getClass().getResource("/resources/no.png")));
        no.setPreferredSize(new Dimension(30, 30));
        no.setOpaque(true);
        no.setBorder(null);
        no.setFocusPainted(false);
        no.setContentAreaFilled(false);
        no.setFocusable(true);
        no.setVisible(true);
        add(no, BorderLayout.WEST);
    }

    private class  Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == save) {
                if(controlGame.getLives() == 0) {

                    JOptionPane.showMessageDialog(null, "Has perdido todas las vidas, gracias por jugar :)");
                    GUIStart game = new GUIStart();

                    dispose();

                }
                if(controlGame.getLives() != 0 && controlGame.getLevels() !=10) {

                    if(fileManager.getGameFile().length() == 0) {
                       fileManager.addScore(controlGame);

                        fileManager.writeGame();
                    }else {
                        fileManager.writeGame(controlGame);

                    }

                }

            }

        }


    }
}
