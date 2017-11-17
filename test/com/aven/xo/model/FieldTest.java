package com.aven.xo.model;

import com.aven.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    public void getSize() throws Exception {
        final int expectedValue = 3;

        final Field field = new Field(3);

        assertEquals(expectedValue, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field(3);
        Point point = new Point(0, 0);
        final Figure figure = Figure.X;

        field.setFigure(point, figure);
        final Figure actualFigure = field.getFigure(point);

        assertEquals(figure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureInNotSet() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(0, 0);
        final Figure figure = field.getFigure(point);

        assertNull(figure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(-1, 0);

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(1, -1);

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYAreLessThanZero() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(-1, -1);

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThanMaxValue() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(field.getSize(), 0);

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThanMaxValue() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(1, field.getSize());

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYAreMoreThanMaxValue() throws Exception {
        final Field field = new Field(3);
        final Point point = new Point(field.getSize(), field.getSize());

        try {
            field.getFigure(point);
            fail("");
        } catch (final InvalidPointException e) {}
    }

}