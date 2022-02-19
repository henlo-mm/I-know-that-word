package IKnowThatWord;

import java.io.Serializable;
import  java.util.ArrayList;

public class Score implements Serializable {

    private ArrayList<ControlGame> score;

    public Score(){
        this.score = new ArrayList<ControlGame>();
    }

    public Score(ArrayList<ControlGame> scr){
        this.score = scr;
    }

    public void addScore(ControlGame control) {this.score.add(control);}
    public String printScore(){
        String info = "";
        for(int i=0; i<score.size(); i++){
            info = score.get(i).getNick() + "\n" + score.get(i).getTotalPoint() + "\n" + score.get(i).getLevels() + info;
          //  info = "assd" + score.get(0).getNick();


        }
        return  info;
    }

    public ArrayList<ControlGame> getScore() {
        return score;
    }

    public void setScore(ArrayList<ControlGame> score) {
        this.score = score;
    }

    public  boolean checkExistence(String name){


        boolean answer = false;
        Score sc;
        FileManager fileManager = new FileManager();
        String scr2;
        if(fileManager.getGameFile().length() !=0){
            sc = fileManager.getGameObject();
        }else{
            sc = new Score();
        }
        for(int i=0; i<sc.getScore().size(); i++) {
            scr2 = sc.getScore().get(i).getNick();
            if(name.equalsIgnoreCase(scr2)){
                answer = true;
            }
        }
        return answer;
    }
    public ControlGame getPlayer(String name){
        ControlGame control = null;
        Score sr;
        FileManager fileManager = new FileManager();
        int index;

        if(fileManager.getGameFile().length() !=0){
            sr = fileManager.getGameObject();
        }else{
            sr = new Score();
        }
        for(int i=0; i<sr.getScore().size(); i++){
            if(name.equalsIgnoreCase(sr.getScore().get(i).getNick())){
                control = sr.getScore().get(i);
                index = i;
                sr.getScore().remove(index);
                fileManager.writeGame(sr);
                i = sr.getScore().size();
            }

        }
        return  control;
    }
}
