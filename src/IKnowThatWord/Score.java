package IKnowThatWord;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {

    private ArrayList<ControlGame> puntaje;

    public Score() {
        this.puntaje = new ArrayList<ControlGame>();

    }


    public Score(ArrayList<ControlGame> array) {

        this.puntaje = array;


    }

    public void agregarPuntaje(ControlGame cont) {
        this.puntaje.add(cont);
    }

    public String imprimirPuntajes() {
        String info = "";
        for(int i=0; i<puntaje.size();i++) {
            info = "Jugador : " + puntaje.get(i).getNick() +
                    "\nPuntaje : " + Integer.toString(puntaje.get(i).getTotalPoint()) + "\n" +
                    "Nivel : " + Integer.toString(puntaje.get(i).getLevels()) + "\n----------------\n" + info;
        }

        //System.out.println(info);

        return info;
    }

    public ArrayList<ControlGame> getPuntaje() {
        return puntaje;
    }


    public void setPuntajes(ArrayList<ControlGame> puntaje) {
        this.puntaje = puntaje;
    }

    public boolean buscarExistencia(String nombre) {
        boolean respuesta = false;
        Score comp;
        Archive archivo = new Archive();
        String comp2 = "";

        if(archivo.getArchivoPartidas().length() !=0) {
            comp = archivo.obtenerPartidaObjeto();
            //System.out.println("1.11");
        }else {
            comp = new Score();
            //System.out.println("2.22");
        }

        for(int i=0; i<comp.getPuntaje().size(); i++) {
            System.out.println(comp.getPuntaje().get(i).getNick() + " =? " +nombre);
            comp2 = comp.getPuntaje().get(i).getNick();
            if(nombre.equalsIgnoreCase(comp2)) {
                respuesta = true;
                System.out.println("Soy verdad!!!!");
            }
        }

        return respuesta;
    }


    // Aqu� se debe de, adem�s de sacar el jugador, quitarlo del archivo.
    public ControlGame obtenerJugador(String nombre) {
        ControlGame e = null;
        Score comp;
        Archive archivo = new Archive();
        int index = 0;

        if(archivo.getArchivoPartidas().length() !=0) {
            comp = archivo.obtenerPartidaObjeto();
        }else {
            comp = new Score();
        }

        for(int i=0; i<comp.getPuntaje().size(); i++) {
            if(nombre.equalsIgnoreCase(comp.getPuntaje().get(i).getNick())) {
                System.out.println("Funciona??????????????????????????????????????????");
                e = comp.getPuntaje().get(i);
                index = i;
                System.out.println(comp.imprimirPuntajes());
                System.out.println("������������������������������������������������������������������������");
                comp.getPuntaje().remove(index); // Aqu� se elimina el componente que se sac� del arreglo
                archivo.escribirPartida(comp); // Aqu� se reescribe el archivo que guarda las partidas en curso
                System.out.println("������������������������������������������������������������������������");
                System.out.println(archivo.obtenerPartidaObjeto().imprimirPuntajes());
                i = comp.getPuntaje().size();
            }
        }



        return e;
    }






}
