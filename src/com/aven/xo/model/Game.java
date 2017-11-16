package com.aven.xo.model;

public class Game {

    private static final String GAME_NAME = "TicTacToe";

    private final Player[] players;

    private final Field field;

    public Game(final Player[] players,
                final Field field) {
        this.players = players;
        this.field = field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public static String getGameName() {
        return GAME_NAME;
    }

}
