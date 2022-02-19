package IKnowThatWord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIClasification extends JFrame {
    private JLabel title;
    private JTextField table;
    private  JPanel panelText;
    private JButton exit;
    private Escucha escucha;

    public GUIClasification(String score){
        initGUI(score);

        setTitle("I Know That Word");
        setSize(300,300);
        setPreferredSize(new Dimension(300,300));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private void initGUI(String score) {
        escucha = new Escucha();
        Font font = new Font(Font.DIALOG,Font.BOLD,20);
        title = new JLabel ("Clasificación");
        title.setFont(font);
        title.setSize(200,50);
        title.setForeground(Color.BLACK);
        title.setPreferredSize(new Dimension(300,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        //TEXTO


        table = new JTextField();
        table.setEditable(false);
        table.setText(score);

        //PANEL DONDE SE ENCUENTRA EL TEXTO, ADEMAS DE AGREGAR UN SCROLL
        panelText = new JPanel();
        JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setSize(490,400);
        table.setPreferredSize(new Dimension(490,400));

        //BOTON
        exit = new JButton("Volver");
        exit.addActionListener(escucha);


        panelText.add(scroll);
        add(title,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
        add(exit,BorderLayout.SOUTH);
    }

    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == exit){
                GUIStart start = new GUIStart();
                dispose();

            }


        }
    }
}
