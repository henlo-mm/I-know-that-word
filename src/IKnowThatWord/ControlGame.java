package IKnowThatWord;

import java.io.Serializable;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ControlGame implements Serializable {
    private int levels, rounds, roundPoint, totalPoint;
    private String nick;
    private int lives;
    ArrayList<String> words;



    public ControlGame(){

        words = new ArrayList<String>();
        lives = 5;
        levels = 1;
        rounds = 1;
        roundPoint = 0;
        totalPoint = 0;
    }

    public ControlGame(String name, int level, int round, int roundP, int totalP, int live) {

        words = new ArrayList<String>();
        this.nick = name;
        this.lives = live;
        this.levels = level;
        this.rounds = round;
        this.roundPoint = roundP;
        this.totalPoint = totalP;

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
            //
            //
            if(this.words.size() == 0){
                this.levels = levels + 1;
                this.roundPoint = roundPoint + 1;
            }
        }else {
            lives--;
            if(lives == 0){
                JOptionPane.showMessageDialog(null, "Perdiste");
                lives = 0;
                //
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
            //
            //
        }else if(roundPoint == 10  && levels == 2){
            roundPoint = 0;
            lives = 7;
            levels = 3;
            rounds = 1;

        }else if(roundPoint == 12 && levels == 3){
            roundPoint = 0;
            lives = 9;
            levels = 4;
            rounds = 1;
        }else if(roundPoint == 14 && levels == 4){
            roundPoint = 0;
            lives = 11;
            levels = 5;
            rounds = 1;

        }else if(roundPoint == 16 && levels == 5){
            roundPoint = 0;
            lives = 13;
            levels = 6;
            rounds = 1;
        }
    }

    public void changeWords(int levels){
        //
        //
        //
    }

    public void setWords(String[] words_array) {
        this.words.clear();
        for (int i = 0; i<words_array.length; i++){
            this.words.add(i, words_array[i]);
        }
    }
    public void revisarRondaPaso() {

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


