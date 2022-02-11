package IKnowThatWord;

import java.io.Serializable;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ControlGame implements Serializable {
    private int levels, rounds, roundPoint, totalPoint;
    private String nick;
    private int lives;
    private ArrayList<String> words;
    transient private Dictionary dictionary = new Dictionary();
    private  int randomNumber;

    public ControlGame(){
        dictionary = new Dictionary();
        words = new ArrayList<String>();
        lives = 5;
        levels = 1;
        rounds = 1;
        roundPoint = 0;
        totalPoint = 0;
        this.changeWords(levels);
    }

    public ControlGame(String name, int level, int round, int roundP, int totalP, int live) {
        dictionary = new Dictionary();
        words = new ArrayList<String>();
        this.nick = name;
        this.lives = live;
        this.levels = level;
        this.rounds = round;
        this.roundPoint = roundP;
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

    public int getRounds() {
        return rounds;
    }

    public int getRoundPoint() {
        return roundPoint;
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
            roundPoint++;
            totalPoint++;
            resetComponent(answer);
            CheckRound();
            checkAdvancedRound();
            if(this.words.size() == 0){
                this.levels = levels + 1;
                this.roundPoint = roundPoint + 1;
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
    public void CheckRound(){
        if(roundPoint == 8 && levels == 1){
            roundPoint = 0;
            lives = 5;
            levels = 2;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 10  && levels == 2){
            roundPoint = 0;
            lives = 7;
            levels = 3;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 12 && levels == 3){
            roundPoint = 0;
            lives = 9;
            levels = 4;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 14 && levels == 4){
            roundPoint = 0;
            lives = 11;
            levels = 5;
            rounds = 1;
            this.changeWords(levels);

        }else if(roundPoint == 16 && levels == 5){
            roundPoint = 0;
            lives = 13;
            levels = 6;
            rounds = 1;
            this.changeWords(levels);
        }
        else if(roundPoint == 18 && levels == 6){
            roundPoint = 0;
            lives = 15;
            levels = 7;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 20 && levels == 7){
            roundPoint = 0;
            lives = 17;
            levels = 8;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 22 && levels == 8){
            roundPoint = 0;
            lives = 19;
            levels = 9;
            rounds = 1;
            this.changeWords(levels);
        }else if(roundPoint == 24 && levels == 9){
            roundPoint = 0;
            lives = 21;
            levels = 10;
            rounds = 1;
            this.changeWords(levels);
        } else if(roundPoint == 26 && levels == 10){
            levels = 11;
            System.out.print("Has pasado");
        }
    }

    public void changeWords(int level){
        dictionary.FillArray(level);
        String [] str = dictionary.getWords();
        this.setWords(str);
    }
    public int getRandom(){
        Random aleatorio = new Random();
        randomNumber = aleatorio.nextInt(19 )+1;
        return  randomNumber;

    }

    public void setWords(String[] words_array) {
        this.words.clear();
        for (int i = 0; i<words_array.length; i++){
            this.words.add(i, words_array[i]);
        }
    }
    public void checkAdvancedRound() {

        if(this.levels == 1) {
            if(this.roundPoint >= 8/2) {
                if(this.roundPoint == 8/2) JOptionPane.showMessageDialog(null,"Felicidades, pasaste a la segunda ronda");
                this.rounds = 2;
            }
        }else if(this.levels == 2) {
            if(this.roundPoint >= 12/2) {
                if(this.roundPoint == 12/2) JOptionPane.showMessageDialog(null,"Felicidades, pasaste a la segunda ronda");
                this.rounds = 2;
            }
        }else if(this.levels == 3) {
            if(this.roundPoint >= 16/2) {
                if(this.roundPoint == 16/2) JOptionPane.showMessageDialog(null,"Felicidades, pasaste a la segunda ronda");
                this.rounds = 2;
            }
        }else if(this.levels == 4) {
            if(this.roundPoint >= 20/2) {
                if(this.roundPoint == 20/2) JOptionPane.showMessageDialog(null,"Felicidades, pasaste a la segunda ronda");
                this.rounds = 2;
            }
        }else if(this.levels == 5) {
            if(this.roundPoint >= 24/2) {
                if(this.roundPoint == 24/2) JOptionPane.showMessageDialog(null,"Felicidades, pasaste a la segunda ronda");
                this.rounds= 2;
            }
        }

    }
}


