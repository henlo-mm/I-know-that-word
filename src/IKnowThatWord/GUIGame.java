package IKnowThatWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    public GUIGame(ControlGame w){
        this.controlGame = w;
        this.fileManager = new FileManager();
        this.controlGame.changeWords(this.controlGame.getLevels());
        initGUI(controlGame);
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

        lblBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/resources/back.png")));
        lblBackgroundImage.setLayout(new FlowLayout());
        setContentPane(lblBackgroundImage);

      //  this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/resources/back.png"))));
        Font font = new Font("Agency FB",Font.BOLD,20);
        title = new JLabel ("I Know That Word");

        title.setFont(font);
        title.setSize(470,50);
        title.setForeground(Color.BLACK);
        title.setPreferredSize(new Dimension(470,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        add(title, BorderLayout.NORTH);

        panelWord = new PanelWord(this.controlGame);
        panelWord.setOpaque(false);
        add(panelWord, BorderLayout.CENTER);
    }

    public class  Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            ///Implementación

        }
    }
}
