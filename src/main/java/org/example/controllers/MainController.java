package org.example.controllers;

import org.example.configurations.Configuration;
import org.example.models.GameModel;
import org.example.repositories.MainMenuRepository;
import org.example.services.GameService;

import java.util.Random;
import java.util.Scanner;

public class MainController {
    MainMenuRepository  mainMenuRepository = new MainMenuRepository();
    Configuration       configuration      = new Configuration();
    GameService         gameService        = new GameService();
    GameModel           gameModel          = new GameModel();
    Scanner             scanner            = new Scanner(System.in);

    public void mainMenu () {

        boolean retryGame = false;

        while(!retryGame){

            int randomNumber = new Random().nextInt(configuration.RANDOM_MAX_NUMBER);

            System.out.println(mainMenuRepository.startGameMenu());

            System.out.println(gameService.difficultyMenu(gameModel, scanner));

            boolean userWin = gameService.introNumbers(randomNumber, gameModel.getIntents(), scanner);

            if (!userWin) { System.out.println(mainMenuRepository.youLoseString()); }

            retryGame = gameService.endGameManager(scanner);
        }
    }



}



