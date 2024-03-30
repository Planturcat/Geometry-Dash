package Jade;

import util.Constants;

import java.awt.*;

public class LevelEditorScene extends  Scene {
    public  LevelEditorScene(String name){
        super.Scene(name);
    }
    @Override
    public void init() {

    }

    @Override
    public void update(double dt) {
        System.out.println("srrrrrrrdtwffqdwf");
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.fillRect(0,0, Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
    }
}
