package com.aven.xo.controller;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void testGetWinnerWhenRightDiagonalWins() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), figureX);
        field.setFigure(new Point(1, 1), figureX);
        field.setFigure(new Point(2, 2), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenRightDiagonalDoesNotWin() throws InvalidPointException {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    void testGetWinnerWhenRightDiagonalDoesNotWin2() throws InvalidPointException {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    void testGetWinnerWhenLeftDiagonalWins() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), figureX);
        field.setFigure(new Point(1, 1), figureX);
        field.setFigure(new Point(2, 0), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenLeftDiagonalDoesNotWin() throws InvalidPointException {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    void testGetWinnerWhenLeftDiagonalDoesNotWin2() throws InvalidPointException {
        final Field field = new Field(3);
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.X);

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);
    }

    @Test
    void testGetWinnerWhenHorizontalLineWins() throws InvalidPointException {
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();

        final Figure expectedValue = figureX;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), figureX);
            field.setFigure(new Point(i, 1), figureX);
            field.setFigure(new Point(i, 2), figureX);

            final Figure actualValue = winnerController.getWinner(field);

            assertEquals(expectedValue, actualValue);
        }
    }

    @Test
    void testGetWinnerWhenNoHorizontalLineWins() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

            final Figure actualValue = winnerController.getWinner(field);

            assertNull(actualValue);
        }
    }

    @Test
    void testGetWinnerWhenNoVerticalLineWins() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);

            final Figure actualValue = winnerController.getWinner(field);

            assertNull(actualValue);
        }
    }

    @Test
    void testGetWinnerWhenVerticalLineWins() throws InvalidPointException {
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();

        final Figure expectedValue = figureX;

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(0, i), figureX);
            field.setFigure(new Point(1, i), figureX);
            field.setFigure(new Point(2, i), figureX);

            final Figure actualValue = winnerController.getWinner(field);

            assertEquals(expectedValue, actualValue);
        }
    }

}