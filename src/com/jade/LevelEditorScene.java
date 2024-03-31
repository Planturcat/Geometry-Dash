package com.jade;

import com.Components.BoxBounds;
import com.dataStructure.Transform;
import com.util.Constants;
import com.util.Vector2;

import java.awt.*;

public class LevelEditorScene extends  Scene {
    GameObject textObj;
    public  LevelEditorScene(String name){
        super.Scene(name);
    }
    @Override
    public void init() {
textObj=new GameObject("some thing",new Transform(new Vector2(0.0f,0.0f)));
textObj.addComponents(new BoxBounds("Box"));
    }

    @Override
    public void update(double dt){
        System.out.println(textObj.getComponents(BoxBounds.class).name);
        textObj.update(dt);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.fillRect(0,0, Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
    }
}
