package IKnowThatWord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Player {

    private static final String routePlayers		= "src/IKnowThatWord/files/players.txt";

    private static final String routePlayersTemp	= "src/IKnowThatWord/files/players_Temp.txt";

    /** The br. */
    private BufferedReader br;

    /** The bw. */
    private BufferedWriter bw;

    /** The nickname. */
    private String nickname;



    public boolean saveNick(String nick) {
        if(validateNick(nick)) {
            System.out.print("Ya existe el jugador \n");

            return false;
        } else {
            //No existe el jugador
            setNickname(nick);
            try {
                File oldPlayers = new File(routePlayers);
                File newPlayers = new File(routePlayersTemp);

                newPlayers.createNewFile();

                br = new BufferedReader(new FileReader(routePlayers));
                bw = new BufferedWriter(new FileWriter(routePlayersTemp));

                String line = br.readLine();

                while(line != null) {
                    bw.write(line);
                    bw.newLine();
                    line = br.readLine();
                }
                bw.write(nick);
                bw.newLine();
                br.close();
                bw.close();
                oldPlayers.delete();
                newPlayers.renameTo(oldPlayers);

            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo players.txt");
            }
            return true;
        }
    }

    public boolean validateNick(String nick) {
        try {
            setNickname(nick);
            br = new BufferedReader(new FileReader(routePlayers));
            String nickTemp = br.readLine();

            while(nickTemp != null) {
                if (nick.equalsIgnoreCase(nickTemp)) {
                    br.close();
                    return true;
                } else {
                    nickTemp = br.readLine();
                }
            }
            br.close();

        } catch (IOException e2) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo players.txt");
        }
        return false;
    }


    public void deleteNick(String nick) {
        try {
            File oldPlayers 	= new File(routePlayers);
            File newPlayers 	= new File(routePlayersTemp);

            newPlayers.createNewFile();

            br = new BufferedReader(new FileReader(routePlayers));
            bw = new BufferedWriter(new FileWriter(routePlayersTemp));


            String line = br.readLine();

            while(line != null) {
                if (nick.equalsIgnoreCase(line)) {
                    line = br.readLine();
                } else {
                    bw.write(line);
                    bw.newLine();
                    line = br.readLine();
                }
            }

            br.close();
            bw.close();

            oldPlayers.delete();
            newPlayers.renameTo(oldPlayers);

        } catch (IOException e3) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo players.txt");
        }
    }


    /**
     * Gets the nickname.
     *
     * @return the nickname
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Sets the nickname.
     *
     * @param nick the new nickname
     */
    public void setNickname(String nick) {
        this.nickname = nick;
    }
}
