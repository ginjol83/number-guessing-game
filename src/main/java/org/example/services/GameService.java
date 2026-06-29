package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.configurations.Configuration;
import org.example.enums.Difficult;
import org.example.models.AttemptModel;
import org.example.models.GameModel;
import org.example.models.RecordModel;
import org.example.repositories.MainMenuRepository;
import org.example.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GameService {

    MainMenuRepository mainMenuRepository = new MainMenuRepository();
    AttemptModel       attemptModel       = new AttemptModel();
    Configuration      configuration      = new Configuration();
    Utils              utils              = new Utils();

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);



    public boolean mainMenu(GameModel gameModel, Scanner scanner){

        boolean isInputedMainMenu = false;
        while(!isInputedMainMenu){

            String difficultyLevelUserHasSelected = scanner.nextLine();

            switch (difficultyLevelUserHasSelected){
                case "1":
                    return false;
                case "2":
                    System.out.println(listRanking());
                    isInputedMainMenu = true;
                    break;
                case "3":
                    isInputedMainMenu = true;
                    break;
                default:
                    System.out.println(mainMenuRepository.incorrectString());
            }
        }
        return true;
    }


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
                case "4":
                    return listRanking();
                default:
                    System.out.println(mainMenuRepository.incorrectString());
            }
        }
        return mainMenuRepository.greatString(gameModel.getDifficultLevel());
    }

    private String listRanking() {
        ArrayList<RecordModel> recordsList = new ArrayList<>(loadRecords("RECORDS.json"));

        StringBuilder ranking = new StringBuilder();
        recordsList.sort(Comparator.comparingInt(RecordModel::getIntents));
        ranking.append("\n").append("\n").append("\n");
        for(int i=0; i < recordsList.size() && i < 10 ; i++){
            ranking.append(minorTen(i+1))
                    .append(" | Num Intents: ")
                    .append(minorTen(recordsList.get(i).getIntents()))
                    .append("| Time ")
                    .append(recordsList.get(i).getTimeAttempt())
                    .append("\n");
        }
        return ranking.toString();
    }

    private String minorTen(int num){
        if(num < 10) return "0" + num;
        else return String.valueOf(num);
    }

    public boolean introNumbers(int randomNumber ,int intents, Scanner scanner){
        for(int intentsCount=0;intentsCount<intents;intentsCount++){
            while(true){
                System.out.println(mainMenuRepository.enterYourGuess());
                String guess = scanner.nextLine();
                if(utils.isInteger(guess)){
                    int guessNumber = Integer.parseInt(guess);
                    if(utils.isValidNumber(guessNumber)){
                        System.out.println(attemptModel.guestResponse(guessNumber,randomNumber,intentsCount));
                        attemptModel.setTotalIntents(intentsCount);
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

    public void initTimeIntent(){
        attemptModel.setInitTime(System.currentTimeMillis());
    }

    public String  getTimeIntent(){
        attemptModel.setFinishTime(System.currentTimeMillis());
        return "Time Attempt: "+calculateAttemptTime()+" seconds";
    }

    private float calculateAttemptTime(){
        return (attemptModel.getFinishTime() - attemptModel.getInitTime())/1000f;
    }

    public void saveAttempt(int intents){
        RecordModel record = new RecordModel("GuestNumber",attemptModel.getTotalIntents(),calculateAttemptTime());
        ArrayList<RecordModel> recordsList = new ArrayList<>(loadRecords("RECORDS.json"));

        recordsList.add(record);

        saveRecords("RECORDS.json",recordsList);
    }

    public List<RecordModel> loadRecords(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    file,
                    new TypeReference<List<RecordModel>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + path, e);
        }
    }



    public static void saveRecords(String path, List<RecordModel> records) {
        File file = new File(path);

        try {
            objectMapper.writeValue(file, records);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo JSON: " + path, e);
        }
    }

}