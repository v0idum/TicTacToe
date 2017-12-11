package com.aven.xo.controller;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int figureCount = 0;
        for (int x = 0; x < field.getSize(); x++) {
            figureCount += figureCountInTheRow(field, x);
        }

        if (figureCount == field.getSize() * field.getSize()) {
            return null;
        }

        if (figureCount % 2 == 0) {
            return Figure.X;
        }


        return Figure.O;
    }

    private int figureCountInTheRow(final Field field, final int row) {
        int figureCount = 0;
        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) {
                    figureCount++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return figureCount;
    }

}
