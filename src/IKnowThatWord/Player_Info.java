package IKnowThatWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Player_Info {

    //Atributos
    private static final String rutaHistorial = "src/datos/historial_jugadores.txt";
    private static final String rutaHistorialTemp = "src/datos/historial_jugadores_Temp.txt";
    private static final String rutaClasificacion = "src/datos/clasificacion.txt";
    private static final String rutaClasificacionTemp = "src/datos/clasificacion_temp.txt";
    private BufferedReader br = null;
    private BufferedWriter bw = null;
    private int puntRonda, puntTotal, ronda, nivel = 2;
    private int[] puntClas;
    private String[] nickClas;
    private String nick;


    //Metodos
    public void guardarHistorial(String nick, int nivel, int ronda, int puntRonda, int puntTotal) {
        try {

            String nivel_		=	Integer.toString(nivel);
            String ronda_		=	Integer.toString(ronda);
            String puntRonda_	=	Integer.toString(puntRonda);
            String puntTotal_	=	Integer.toString(puntTotal);

            File antiguosHistorial 	= new File(rutaHistorial);
            File nuevosHistorial 	= new File(rutaHistorialTemp);

            nuevosHistorial.createNewFile();

            br = new BufferedReader(new FileReader(rutaHistorial));
            bw = new BufferedWriter(new FileWriter(rutaHistorialTemp));

            String linea = br.readLine();

            while(linea != null) {
                bw.write(linea);
                bw.newLine();
                linea = br.readLine();
            }

            bw.newLine();

            bw.write(nick)		; bw.newLine();
            bw.write(nivel_)	; bw.newLine();
            bw.write(ronda_)	; bw.newLine();
            bw.write(puntRonda_); bw.newLine();
            bw.write(puntTotal_); bw.newLine();

            br.close();
            bw.close();

            antiguosHistorial.delete();
            nuevosHistorial.renameTo(antiguosHistorial);

        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo historial_jugadores.txt");
        }
    }


    public void cargarHistorial(String nick) {
        try {
            br = new BufferedReader(new FileReader(rutaHistorial));

            String nickTemp = br.readLine();

            while(nickTemp != null) {
                if (nick.equalsIgnoreCase(nickTemp)) {
                    this.nick		= nickTemp;
                    nickTemp 		= br.readLine();
                    this.nivel		= Integer.valueOf(nickTemp);
                    nickTemp 		= br.readLine();
                    this.ronda		= Integer.valueOf(nickTemp);
                    nickTemp 		= br.readLine();
                    this.puntRonda	= Integer.valueOf(nickTemp);
                    nickTemp 		= br.readLine();
                    this.puntTotal	= Integer.valueOf(nickTemp);

                    break;
                } else {
                    nickTemp = br.readLine();
                }
            }

            br.close();

        } catch (IOException e2) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo historial_jugadores.txt");
        }
    }


    public void eliminarHistorial(String nick) {
        try {
            File antiguosHistorial 	= new File(rutaHistorial);
            File nuevosHistorial 	= new File(rutaHistorialTemp);

            nuevosHistorial.createNewFile();

            br = new BufferedReader(new FileReader(rutaHistorial));
            bw = new BufferedWriter(new FileWriter(rutaHistorialTemp));

            String linea = br.readLine();

            while(linea != null) {
                if (nick.equalsIgnoreCase(linea)) {
                    //salto 5 posiciones para evitar copiar al jugador a eliminar.
                    linea = br.readLine();
                    linea = br.readLine();
                    linea = br.readLine();
                    linea = br.readLine();
                    linea = br.readLine();
                } else {
                    bw.write(linea);
                    bw.newLine();
                    linea = br.readLine();
                }
            }

            br.close();
            bw.close();

            antiguosHistorial.delete();
            nuevosHistorial.renameTo(antiguosHistorial);

        } catch (IOException e3) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo historial_jugadores.txt");
        }
    }


    public void guardarClasificacion(String nick, int puntTotal) {

        try {
            String puntTotal_		= Integer.toString(puntTotal);

            File antiguosHistorial 	= new File(rutaClasificacion);
            File nuevosHistorial 	= new File(rutaClasificacionTemp);

            nuevosHistorial.createNewFile();

            br = new BufferedReader(new FileReader(rutaClasificacion));
            bw = new BufferedWriter(new FileWriter(rutaClasificacionTemp));

            String linea = br.readLine();

            while(linea != null) {
                bw.write(linea);
                bw.newLine();
                linea = br.readLine();
            }

            bw.write(nick)			; bw.newLine();
            bw.write(puntTotal_)	; bw.newLine();

            br.close();
            bw.close();

            antiguosHistorial.delete();
            nuevosHistorial.renameTo(antiguosHistorial);

        } catch (IOException e4) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo clasificacion.txt");
        }
    }


    public void cargarClasificacion() {
        try {
            br = new BufferedReader(new FileReader(rutaClasificacion));

            int numLin = 0;
            String linea = br.readLine();

            while(linea != null) {
                numLin++;
            }

            br.close();



            this.nickClas = new String[numLin/2];
            this.puntClas = new int[numLin/2];

            br = new BufferedReader(new FileReader(rutaClasificacion));

            String infoClas = br.readLine();
            int i = 0;

            while(infoClas != null) {
                this.nickClas[i]	= infoClas;
                infoClas 			= br.readLine();
                this.puntClas[i]	= Integer.valueOf(infoClas);
                infoClas 			= br.readLine();
            }

            br.close();

        } catch (IOException e5) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo historial_jugadores.txt");
        }
    }


    //Getters

    public String getNick() {
        return this.nick;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getRonda() {
        return this.ronda;
    }

    public int getPuntRonda() {
        return this.puntRonda;
    }

    public int getPuntTotal() {
        return this.puntTotal;
    }

    public String[] getNickClas() {
        return this.nickClas;
    }

    public int[] getPuntClas() {
        return this.puntClas;
    }
}
