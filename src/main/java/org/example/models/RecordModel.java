package org.example.models;

public class RecordModel {

    private String  game;
    private int     intents;
    private float   timeAttempt;

    public RecordModel(String game, int intents, float timeAttempt) {
        this.game = game;
        this.intents = intents;
        this.timeAttempt = timeAttempt;
    }

    public RecordModel() {  }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public float getTimeAttempt() {
        return timeAttempt;
    }

    public void setTimeAttempt(float timeAttempt) {
        this.timeAttempt = timeAttempt;
    }

}
