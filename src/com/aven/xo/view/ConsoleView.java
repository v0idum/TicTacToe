package com.aven.xo.view;

import com.aven.xo.controller.CurrentMoveController;
import com.aven.xo.controller.MoveController;
import com.aven.xo.controller.WinnerController;
import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.Game;
import com.aven.xo.model.exceptions.AlreadyOccupiedException;
import com.aven.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final MoveController moveController = new MoveController();

    private final WinnerController winnerController = new WinnerController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getGameName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.println();
            System.out.format("Winner is %s", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println();
            System.out.println("There is no winner! Draw!");
            return false;
        }
        System.out.format("Please input point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Invalid point!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordName) {
        System.out.format("Please input coordinate %s: ", coordName);
        final Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }
        catch (final InputMismatchException e) {
            System.out.println("^_^ Re-enter point!");
            return askCoordinate(coordName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
