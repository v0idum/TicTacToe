package com.aven.xo.controller;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void testGetWinnerWhenRightDiagonalFilled() throws InvalidPointException {
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
    void testGetWinnerWhenLeftDiagonalFilled() throws InvalidPointException {
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
    void testGetWinnerWhenFirstHorizontalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), figureX);
        field.setFigure(new Point(0, 1), figureX);
        field.setFigure(new Point(0, 2), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenSecondHorizontalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(1, 0), figureX);
        field.setFigure(new Point(1, 1), figureX);
        field.setFigure(new Point(1, 2), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenThirdHorizontalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(2, 0), figureX);
        field.setFigure(new Point(2, 1), figureX);
        field.setFigure(new Point(2, 2), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenFirstVerticalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 0), figureX);
        field.setFigure(new Point(1, 0), figureX);
        field.setFigure(new Point(2, 0), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenSecondVerticalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 1), figureX);
        field.setFigure(new Point(1, 1), figureX);
        field.setFigure(new Point(2, 1), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetWinnerWhenThirdVerticalLineFilled() throws InvalidPointException {
        final Field field = new Field(3);
        final Figure figureX = Figure.X;
        final WinnerController winnerController = new WinnerController();
        field.setFigure(new Point(0, 2), figureX);
        field.setFigure(new Point(1, 2), figureX);
        field.setFigure(new Point(2, 2), figureX);

        final Figure expectedValue = figureX;
        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);
    }

}