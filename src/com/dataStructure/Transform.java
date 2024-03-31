package com.dataStructure;

import com.util.Vector2;

public class Transform {
    public Vector2 position;


    public  Transform(Vector2 position){
        this.position=position;
    }
    @Override
    public String toString(){
    return "Position ("+position.x +","+position.y+")";
    }
}
