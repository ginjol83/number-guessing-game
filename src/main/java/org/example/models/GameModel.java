package org.example.models;

import org.example.configurations.Configuration;
import org.example.enums.Difficult;
import org.example.repositories.MainMenuRepository;
import org.example.utils.Utils;

import java.util.Scanner;

public class GameModel {
    private String difficultLevel;
    private int intents;

    MainMenuRepository mainMenuRepository = new MainMenuRepository();
    AttemptModel       attemptModel       = new AttemptModel();
    Configuration      configuration      = new Configuration();
    Utils              utils              = new Utils();

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public String getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(String difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

}