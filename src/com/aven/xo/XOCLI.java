package com.aven.xo;

import com.aven.xo.model.Field;
import com.aven.xo.model.Figure;
import com.aven.xo.model.Game;
import com.aven.xo.model.Player;
import com.aven.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Aki";
        final String name2 = "Dior";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3));

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);
        }
    }

}
