package org.example.models;

import org.example.repositories.MainMenuRepository;

public class AttemptModel {

    private boolean isWin;

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

    public boolean getIsWin(){
        return this.isWin;
    }
}