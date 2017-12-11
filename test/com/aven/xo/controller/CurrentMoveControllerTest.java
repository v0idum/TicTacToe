package com.aven.xo.controller;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void testCurrentMoveWhenTheNextMoveIsO() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    void testCurrentMoveWhenTheNextMoveIsX() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    void testCurrentMoveWhenNoNextMove() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field.setFigure(new Point(i, j), Figure.X);
            }
        }

        assertNull(currentMoveController.currentMove(field));
    }

}