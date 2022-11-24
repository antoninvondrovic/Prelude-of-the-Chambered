package com.mojang.escape.menu;

import com.mojang.escape.*;
import com.mojang.escape.gui.Bitmap;

public class TitleMenu extends Menu {
    private String[] options = {
            "New game",
            "Instructions",
            "About",
            "Sound:",
            "Exit"
    };
    private int selected = 0;
    private boolean firstTick = true;

    public void render(Bitmap target) {
        target.fill(0, 0, 160, 120, 0);
        target.draw(Art.logo, 0, 4, 0, 0, 160, 36, Art.getCol(0xffffff));

        for (int i = 0; i < options.length; i++) {
            String msg = options[i];
            int col = 0x909090;
            if (selected == i) {
                msg = "-> " + msg;
                col = 0xffff80;
            }
            target.draw(msg, 40, 45 + i * 10, Art.getCol(col));
        }
        target.draw("Modded by Flowyan", 1 + 2, 120 - 20, Art.getCol(0x303030));
        target.draw("Copyright (C) 2011 Mojang", 1 + 2, 120 - 10, Art.getCol(0x303030));
    }

    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean use) {
        if (firstTick) {
            firstTick = false;
            Sound.altar.play();

            options[3] = "Sound:" + (int) (Sound.volume * 100) + "%";
        }
        if (up || down) Sound.click2.play();
        if (up) selected--;
        if (down) selected++;
        if (selected < 0) selected = 0;
        if (selected >= options.length) selected = options.length - 1;
        if (use) {
            Sound.click1.play();
            if (selected == 0) {
                game.setMenu(null);
                game.newGame();
            }
            if (selected == 1) {
                game.setMenu(new InstructionsMenu());
            }
            if (selected == 2) {
                game.setMenu(new AboutMenu());
            }
            if (selected == 4) {
                System.exit(0);
            }
        }
        // Volume control
        if (selected == 3) {
            if (left) {
                Sound.volume -= 0.1;
                if (Sound.volume < 0) Sound.volume = 0;
                Sound.click1.play();
            }
            if (right) {
                Sound.volume += 0.1;
                if (Sound.volume > 1) Sound.volume = 1;
                Sound.click1.play();
            }
            options[3] = "Sound:" + (int) (Sound.volume * 100) + "%";
        }
    }


}