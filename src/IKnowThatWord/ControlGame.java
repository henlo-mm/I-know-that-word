package IKnowThatWord;

import java.io.Serializable;
import javax.swing.*;
import java.util.*;

public class ControlGame implements Serializable {
    private int levels, totalPoint;
    private String nick;
    private int lives;
    private final ArrayList<String> words;
    transient private Dictionary dictionary;


    public ControlGame(){
        dictionary = new Dictionary();
        words = new ArrayList<>();
        lives = 3;
        levels = 1;
        totalPoint = 0;
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

    public ArrayList<String> getWords() {

        return words;
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
    public int getRandom(){
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(19 )+1;
        return  randomNumber;

    }

    public void setWords(String[] words_array) {
        this.words.clear();
        for (int i = 0; i<words_array.length; i++){
            this.words.add(i, words_array[i]);
        }
    }
}


