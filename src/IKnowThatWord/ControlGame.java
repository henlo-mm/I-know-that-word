package IKnowThatWord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Serializable;
import javax.swing.*;
import java.util.*;

public class ControlGame implements Serializable {
    private int levels, totalPoint;
    private String nick;
    private int lives;
    private final ArrayList<String> words;
    private ArrayList<Integer> repeated;
    ArrayList<String> list;
    transient private Dictionary dictionary;


    public ControlGame(){
        dictionary = new Dictionary();
        words = new ArrayList<>();
        lives = 3;
        levels = 1;
        totalPoint = 0;
        repeated = new ArrayList<Integer>();
        ArrayList<String> list = new ArrayList<String>();

        this.changeWords(levels);
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public ControlGame(String name, int level,int totalP, int live) {
        dictionary = new Dictionary();
        words = new ArrayList<>();
        this.nick = name;
        this.lives = live;
        this.levels = level;
        this.totalPoint = totalP;
        this.changeWords(levels);
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevels() {
        return levels;
    }


    public int getTotalPoint() {
        return totalPoint;
    }

    public String getNick() {
        return nick;
    }

    public int getLives() {
        return lives;
    }

    public ArrayList<String> getWords(int level) {


        switch (level){
            case 1:
                 list = new ArrayList<String>(words.subList(0, 10));
                break;
            case 2:
                list = new ArrayList<String>(words.subList(0, 21));
                break;
            case 3:
                 list = new ArrayList<String>(words.subList(0, 26));
                break;
            case 4:
               list = new ArrayList<String>(words.subList(0, 31));
                break;
            case 5:
                list = new ArrayList<String>(words.subList(0, 36));
                break;
            case 6:
               list = new ArrayList<String>(words.subList(0, 41));
                break;
            case 7:
                 list = new ArrayList<String>(words.subList(0, 51));
                break;
            case 8:
                list = new ArrayList<String>(words.subList(0, 61));
                break;
            case 9:
                list = new ArrayList<String>(words.subList(0, 71));
                break;
            case 10:
                list = new ArrayList<String>(words.subList(0, 100));
                break;

        }



        return list;
    }

    public void GuessWord(String answer){
        if(words.contains(answer)){
            totalPoint++;
            resetComponent(answer);
            if(this.words.size() == 0){
                this.levels = levels + 1;
            }
        }else {
            lives--;
            if(lives == 0){
                JOptionPane.showMessageDialog(null, "Perdiste");
                lives = 0;
                this.changeWords(levels);
            }
        }
    }
    public ArrayList<String> resetComponent (String index){
        words.remove(words.indexOf(index));
        return  words;
    }

    public void changeWords(int level){
        dictionary.FillArray(level);
        String [] str = dictionary.getWords();
        this.setWords(str);
    }
 /**   public int getRandom(int level){
       int randomNumber = 0;
        Random random = new Random();
        switch (level){
            case 1:
                randomNumber = random.nextInt(9 )+1;
                break;
            case 2:
                randomNumber = random.nextInt(19 )+1;
                break;
            case 3:
                randomNumber = random.nextInt(24 )+1;
                break;
            case 4:
                randomNumber = random.nextInt(29 )+1;
                break;
            case 5:
                randomNumber = random.nextInt(34)+1;
                break;
            case 6:
                randomNumber = random.nextInt(39 )+1;
                break;
            case 7:
                randomNumber = random.nextInt(49 )+1;
                break;
            case 8:
                randomNumber = random.nextInt(59 )+1;
                break;
            case 9:
                randomNumber = random.nextInt(69 )+1;
                break;
            case 10:
                randomNumber = random.nextInt(99 )+1;
                break;

        }

        return  randomNumber;
    }

  *//


    public void setWords(String[] words_array) {
        this.words.clear();
        for (int i = 0; i<words_array.length; i++){
            this.words.add(i, words_array[i]);
        }
    }
}


