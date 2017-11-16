package com.aven.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    @Test
    void getSize() {
        final int expectedValue = 3;

        final Field field = new Field();

        assertEquals(expectedValue, field.getSize());
    }

    @Test
    void setFigure() {
        final Field field = new Field();
        Point point = new Point(0, 0);
        final Figure figure = Figure.X;

        field.setFigure(point, figure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(figure, actualFigure);
    }

}