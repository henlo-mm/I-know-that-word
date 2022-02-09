package IKnowThatWord;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
    //Attributes
    private static final String rutaPalabras= "src/datos/palabras.txt";
    private LineNumberReader br = null;
    private ArrayList<Integer> repetidas;
    private String[] palabras;
    private int cant;
    int Level = 1;

    public Dictionary() {
        repetidas = new ArrayList<Integer>();
    }

    //M�todos
    public void FillArray(int nivel) {
        this.palabras = null;

        switch (nivel) {
            case 1:
                this.cant = 20;
                break;
            case 2:
                this.cant = 40;
                break;
            case 3:
                this.cant = 50;
                break;
            case 4:
                this.cant = 60;
                break;
            case 5:
                this.cant = 70;
                break;
            case 6:
                this.cant = 80;
                break;
            case 7:
                this.cant = 100;
                break;
            case 8:
                this.cant = 120;
                break;
            case 9:
                this.cant = 140;
                break;
            case 10:
                this.cant = 200;
                break;

        }
        this.palabras = new String[cant];
        try {
            int numPalabras = 0;
            String control = null;
            Random random = new Random();

            br = new LineNumberReader(new FileReader(rutaPalabras));

            for(int i = 0; i < cant; i++) {
                numPalabras = random.nextInt(300)+1;

                if(repetidas.contains(numPalabras)) {
                    i--;
                }
                else {
                    control = br.readLine();

                    for(int j = 0; j < numPalabras; j++) {
                        control = br.readLine();
                    }

                    this.repetidas.add(br.getLineNumber());
                    this.palabras[i] = control;
                }
            }

            br.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo historial_jugadores.txt");
        }
    }
    public void borrarTodo() {
        this.palabras = null;
        repetidas.clear();
    }
    public String[] getPalabras() {
        return this.palabras;
    }


    public ArrayList<Integer> getRepetidas() {
        return repetidas;
    }

    }



