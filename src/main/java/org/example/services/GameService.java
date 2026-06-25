package org.example.services;

import org.example.configurations.Configuration;
import org.example.enums.Difficult;
import org.example.models.AttemptModel;
import org.example.models.GameModel;
import org.example.repositories.MainMenuRepository;
import org.example.utils.Utils;

import java.util.Scanner;

public class GameService {

    MainMenuRepository mainMenuRepository = new MainMenuRepository();
    AttemptModel attemptModel       = new AttemptModel();
    Configuration configuration      = new Configuration();
    Utils utils              = new Utils();

    public String difficultyMenu(GameModel gameModel, Scanner scanner){

        boolean isInputedDifficultiLevel = false;
        while(!isInputedDifficultiLevel){

            String difficultyLevelUserHasSelected = scanner.nextLine();

            switch (difficultyLevelUserHasSelected){
                case "1":
                    gameModel.setIntents(configuration.EASY_INTENTS);
                    gameModel.setDifficultLevel(Difficult.Easy.toString());
                    isInputedDifficultiLevel = true;
                    break;
                case "2":
                    gameModel.setIntents(configuration.MEDIUM_INTENTS);
                    gameModel.setDifficultLevel(Difficult.Medium.toString());
                    isInputedDifficultiLevel = true;
                    break;
                case "3":
                    gameModel.setIntents(configuration.HARD_INTENTS);
                    gameModel.setDifficultLevel(Difficult.Hard.toString());
                    isInputedDifficultiLevel = true;
                    break;
                default:
                    System.out.println(mainMenuRepository.incorrectString());
            }
        }
        return mainMenuRepository.greatString(gameModel.getDifficultLevel());
    }

    public boolean introNumbers(int randomNumber ,int intents, Scanner scanner){
        for(int i=0;i<intents;i++){
            while(true){
                System.out.println(mainMenuRepository.enterYourGuess());
                String guess = scanner.nextLine();
                if(utils.isInteger(guess)){
                    int guessNumber = Integer.parseInt(guess);
                    if(utils.isValidNumber(guessNumber)){
                        System.out.println(attemptModel.guestResponse(guessNumber,randomNumber,i));
                        break;
                    }else{
                        System.out.println(mainMenuRepository.numberBetween());
                    }
                }else{
                    System.out.println(mainMenuRepository.enterNumber());
                }
            }

            if (attemptModel.getIsWin()){
                break;
            }
        }

        return attemptModel.getIsWin();

    }

    public boolean endGameManager(Scanner scanner){

        while(true){
            System.out.println(mainMenuRepository.retryString() );

            String retry = scanner.nextLine();

            if(retry.equals(mainMenuRepository.yesValue() )){
                return false;
            }else if(retry.equals(mainMenuRepository.noValue())){
                return true;
            }else{
                System.out.println(mainMenuRepository.onlyValidCharacters());
            }
        }
    }
}
