package com.jade;

import com.dataStructure.Transform;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    private List<Component>components;
    private String name;
    public Transform transform;

    public GameObject(String name, Transform transform){
        this.name=name;
        this.transform=transform;
        this.components=new ArrayList<>();

    }

    public <T extends Component> T getComponents(Class <T> ComponentClass) {
        for (Component c: components){
            if(ComponentClass.isAssignableFrom(c.getClass())){
                try {
                    return ComponentClass.cast(c);
                }catch (ClassCastException e){
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
        return null;
    }
public void addComponents(Component c){
        components.add(c);
}
    public void  update(double dt){
    for (Component c:components){
        c.update(dt);
    }
}

}
