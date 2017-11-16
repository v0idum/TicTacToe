package com.aven.xo.controller;

import com.aven.xo.model.*;
import com.aven.xo.model.exceptions.AlreadyOccupiedException;
import com.aven.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                                   final Figure figure,
                                   final Point point) throws AlreadyOccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
