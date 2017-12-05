package com.aven.xo.controller;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
                return field.getFigure(new Point(1, 1));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointChanger changer) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = changer.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null) {
                return false;
            }

            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure) {
            return false;
        }

        return check(field, nextPoint, changer);
    }

    private interface IPointChanger {

        Point next(final Point point);

    }

}
