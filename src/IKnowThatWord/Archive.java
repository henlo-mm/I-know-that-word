package IKnowThatWord;


import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Archive {

    //private ControlPalabras jugador, jugadoresPuntaje, jugadoresPartida;
    private Score puntaje;
    private File archivoPuntajes;
    private File archivoPartidas;

    public Archive() {
        //this.jugador = new ControlPalabras();
        this.puntaje = new Score();
        this.archivoPuntajes = new File("src/data/clasificacion.txt");
        this.archivoPartidas = new File("src/data/partidas.txt");
    }

    public Archive(Score nuevo) {
        //this.jugador = new ControlPalabras();
        this.puntaje = nuevo;
        this.archivoPuntajes = new File("src/data/clasificacion.txt");
        this.archivoPartidas = new File("src/data/partidas.txt");
    }


    // OJO, ESTE METODO S�LO ES PARA AGREGAR EN EL ARRAYLIST DE CONTROL PALABRAS
    public void agregarPuntaje(ControlGame cont) {
        this.puntaje.agregarPuntaje(cont);
    }

    public Score getPuntaje() {
        return puntaje;
    }



    public void setArchivoPuntajes(File archivoPuntajes) {
        this.archivoPuntajes = archivoPuntajes;
    }

    public void setPuntaje(Score puntaje) {
        this.puntaje = puntaje;
    }



    public void escribirPuntaje () {
        try{



            ObjectOutputStream escribirGrupo = new ObjectOutputStream(new FileOutputStream(archivoPuntajes,false));
            // recuerda que con false cuando escribas el archivo se reinicia.
            System.out.println("El archivo es nuevo");
            escribirGrupo.writeObject(this.puntaje);

            escribirGrupo.close();

            //obtenerPuntaje();



        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void escribirPuntaje (ControlGame nuevo) {
        try{

            if(this.getArchivoPuntajes().length()!=0) {
                this.puntaje = this.obtenerPuntajeObjeto();
            }else {
                this.puntaje = new Score();
            }


            this.puntaje.agregarPuntaje(nuevo);

            ObjectOutputStream escribirGrupo = new ObjectOutputStream(new FileOutputStream(archivoPuntajes,false));
            // recuerda que con false cuando escribas el archivo se reinicia.
            System.out.println("El archivo se reescribi�");
            escribirGrupo.writeObject(this.puntaje);

            escribirGrupo.close();

            //obtenerPuntaje();



        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    // funci�n para obtener los puntajes de los jugadores
    public String obtenerPuntajeString(){
        String info = "";
        try{

            ObjectInputStream leerGrupo = new ObjectInputStream(new FileInputStream(archivoPuntajes));

            this.puntaje= (Score) leerGrupo.readObject();

            info = this.puntaje.imprimirPuntajes();


            //System.out.println(puntaje.getPuntaje().get(0).getNick());





            //System.out.println("Aqu� se obtiene el puntaje");
            //System.out.println("Recordar eliminar esto de .Archivo");

            //this.puntaje.imprimirPuntajes();




        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return info;
    }

    // funci�n para obtener los puntajes de los jugadores
    public Score obtenerPuntajeObjeto(){
        Score nuevo = null;
        try{

            ObjectInputStream leerGrupo = new ObjectInputStream(new FileInputStream(archivoPuntajes));

            if(this.getArchivoPuntajes().length()!=0) {
                nuevo = (Score) leerGrupo.readObject();
            }else {
                nuevo = new Score();
            }


        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return nuevo;
    }

    public File getArchivoPuntajes() {
        return archivoPuntajes;
    }

    public File getArchivoPartidas() {
        return archivoPartidas;
    }




////////////////////////////////////////////


    public void setArchivoPartidas(File archivoPartidas) {
        this.archivoPartidas = archivoPartidas;
    }

    public void escribirPartida() {
        try{



            ObjectOutputStream escribirGrupo = new ObjectOutputStream(new FileOutputStream(archivoPartidas,false));
            // recuerda que con false cuando escribas el archivo se reinicia.
            System.out.println("El archivo es nuevo");
            escribirGrupo.writeObject(this.puntaje);

            escribirGrupo.close();

            //obtenerPuntaje();



        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void escribirPartida(Score punt){
        try{



            ObjectOutputStream escribirGrupo = new ObjectOutputStream(new FileOutputStream(archivoPartidas,false));
            // recuerda que con false cuando escribas el archivo se reinicia.
            System.out.println("El archivo es nuevo");
            escribirGrupo.writeObject(punt);

            escribirGrupo.close();

            //obtenerPuntaje();



        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void escribirPartida (ControlGame nuevo) {
        try{

            this.puntaje = this.obtenerPartidaObjeto();

            this.puntaje.agregarPuntaje(nuevo);

            ObjectOutputStream escribirGrupo = new ObjectOutputStream(new FileOutputStream(archivoPartidas,false));
            // recuerda que con false cuando escribas el archivo se reinicia.
            System.out.println("El archivo se reescribi�");
            escribirGrupo.writeObject(this.puntaje);

            escribirGrupo.close();

            //obtenerPuntaje();



        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    // funci�n para obtener los puntajes de los jugadores
    public Score obtenerPartidaObjeto(){
        Score nuevo = null;
        try{

            ObjectInputStream leerGrupo = new ObjectInputStream(new FileInputStream(this.archivoPartidas));

            nuevo = (Score) leerGrupo.readObject();


        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return nuevo;
    }


}

////////////////////////////////////////////////////////////////////////////////////////////////////////////








