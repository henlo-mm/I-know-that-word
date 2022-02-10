package IKnowThatWord;


import IKnowThatWord.ControlGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelInfo extends JPanel {
    public static final int WIDTH=230;
    public static final int HEIGTH=200;

    private JTextField nombre,aciertosN,aciertosG,ronda,nivel,vidas;
    private Border borde;
    public ControlGame control = new ControlGame();
    //public Info_Jugador jugador = new Info_Jugador();



    public JTextField getNombre() {
        return nombre;
    }



    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }



    public JTextField getAciertosN() {
        return aciertosN;
    }



    public void setAciertosN(JTextField aciertosN) {
        this.aciertosN = aciertosN;
    }



    public JTextField getAciertosG() {
        return aciertosG;
    }



    public void setAciertosG(JTextField aciertosG) {
        this.aciertosG = aciertosG;
    }



    public JTextField getRonda() {
        return ronda;
    }



    public void setRonda(JTextField ronda) {
        this.ronda = ronda;
    }



    public JTextField getNivel() {
        return nivel;
    }



    public void setNivel(JTextField nivel) {
        this.nivel = nivel;
    }



    public PanelInfo(String nNombre) {
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setSize(size);
        setPreferredSize(size);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        nombre = new JTextField();
        nombre.setText("Nombre: " + nNombre);
        nombre.setEditable(false);
        nombre.setBounds(new Rectangle(100, 60, 250, 21));

        aciertosN = new JTextField();
        aciertosN.setText("Aciertos (Nivel): " + control.getTotalPoint());
        aciertosN.setEditable(false);
        aciertosN.setBounds(new Rectangle(100, 60, 250, 21));

        aciertosG = new JTextField();
        aciertosG.setText("Aciertos (General) : " + control.getRoundPoint());
        aciertosG.setEditable(false);
        aciertosG.setBounds(new Rectangle(100, 60, 250, 21));

        ronda = new JTextField();
        ronda.setText("Ronda: " + control.getRounds());
        ronda.setEditable(false);
        ronda.setBounds(new Rectangle(100, 60, 250, 21));

        vidas = new JTextField();
        vidas.setText("Vidas: " + control.getLives());
        vidas.setEditable(false);
        vidas.setBounds(new Rectangle(100, 60, 250, 21));

        nivel = new JTextField();
        nivel.setText("Nivel: " + control.getLevels());
        nivel.setEditable(false);
        nivel.setBounds(new Rectangle(100, 60, 250, 21));

        add(nombre);
        add(aciertosN);
        add(aciertosG);
        add(ronda);
        add(nivel);
        add(vidas);

    }


    public PanelInfo(String nNombre, String nAciertosN, String nAciertosG, String nRonda, String nNivel, String nVidas) {
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setSize(size);
        setPreferredSize(size);
        //setLayout(new GridLayout(5,1));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        nombre = new JTextField();
        nombre.setText(nNombre);
        nombre.setEditable(false);
        nombre.setBounds(new Rectangle(100, 60, 250, 21));
        nombre.setSize(250,300);

        aciertosN = new JTextField();
        aciertosN.setText(nAciertosN);
        aciertosN.setEditable(false);
        aciertosN.setBounds(new Rectangle(100, 60, 250, 21));
        aciertosN.setSize(250,300);

        aciertosG = new JTextField();
        aciertosG.setText(nAciertosG);
        aciertosG.setEditable(false);
        aciertosG.setBounds(new Rectangle(100, 60, 250, 21));
        aciertosG.setSize(250,300);

        ronda = new JTextField();
        ronda.setText(nRonda);
        ronda.setEditable(false);
        ronda.setBounds(new Rectangle(100, 60, 250, 21));
        ronda.setSize(250,300);

        nivel = new JTextField();
        nivel.setText(nNivel);
        nivel.setEditable(false);
        nivel.setBounds(new Rectangle(100, 60, 250, 21));
        nivel.setSize(250,300);

        vidas = new JTextField();
        vidas.setText(nVidas);
        vidas.setEditable(false);
        vidas.setBounds(new Rectangle(100, 60, 250, 21));
        vidas.setSize(250,300);

        add(nombre);
        add(aciertosN);
        add(aciertosG);
        add(ronda);
        add(nivel);
        add(vidas);

    }


    public PanelInfo(ControlGame control) {
        this.control = control;
        Dimension size = new Dimension(WIDTH,HEIGTH);
        setSize(size);
        setPreferredSize(size);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        nombre = new JTextField();
        nombre.setText("Nombre: " + this.control.getNick());
        nombre.setEditable(false);
        nombre.setBounds(new Rectangle(100, 60, 250, 21));

        aciertosN = new JTextField();
        aciertosN.setText("Aciertos (Nivel): " + control.getTotalPoint());
        aciertosN.setEditable(false);
        aciertosN.setBounds(new Rectangle(100, 60, 250, 21));

        aciertosG = new JTextField();
        aciertosG.setText("Aciertos (General) : " + control.getRoundPoint());
        aciertosG.setEditable(false);
        aciertosG.setBounds(new Rectangle(100, 60, 250, 21));

        ronda = new JTextField();
        ronda.setText("Ronda: " + control.getRounds());
        ronda.setEditable(false);
        ronda.setBounds(new Rectangle(100, 60, 250, 21));

        vidas = new JTextField();
        vidas.setText("Vidas: " + control.getLevels());
        vidas.setEditable(false);
        vidas.setBounds(new Rectangle(100, 60, 250, 21));

        nivel = new JTextField();
        nivel.setText("Nivel: " + control.getLevels());
        nivel.setEditable(false);
        nivel.setBounds(new Rectangle(100, 60, 250, 21));

        add(nombre);
        add(aciertosN);
        add(aciertosG);
        add(ronda);
        add(nivel);
        add(vidas);

    }





}
