package org.example.models;

import org.example.repositories.MainMenuRepository;

public class AttemptModel {

    private boolean isWin;
    private long    finishTime;
    private long    initTime;
    private int     totalIntents;

    MainMenuRepository mainMenuRepository = new MainMenuRepository();

    public String guestResponse (int guessNumber, int randomNumber,int cont){
        if(guessNumber>randomNumber){
            return mainMenuRepository.theNumberisLessThanString(guessNumber);
        }else if(guessNumber<randomNumber){
            return mainMenuRepository.theNumberisGreaterThanString(guessNumber);
        }else {
            this.isWin = true;
            return mainMenuRepository.congratString(cont);
        }
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public boolean getIsWin(){
        return this.isWin;
    }

    public void setTotalIntents(int totalIntents) {
        this.totalIntents = totalIntents;
    }

    public int getTotalIntents(){
        return this.totalIntents;
    }


}