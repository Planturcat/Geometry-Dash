package com.jade;

import com.util.Constants;
import com.util.Time;

import javax.swing.JFrame;
import java.awt.*;


public class Window extends JFrame implements Runnable {
    private static Window window = null;
    public ML mouseListener;
    public KL keylistener;
    private static boolean isRunning = true;
    private Scene currentScene = null;
    private Image doubleBufferImage= null;
    private Graphics doubleBufferGraphics = null;
    public Window() {
        this.mouseListener = new ML();
        this.keylistener =new KL();
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keylistener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.setLocationRelativeTo(null);

    }


    public void init() {
 changeScene(0);

    }
    public void  changeScene(int scene){
        switch (scene){
            case 0:
currentScene=new LevelEditorScene("Level Editor");
                break;
            case 1:
                break;
            default:
                System.out.println("do not knoe whwere we are");
                currentScene=null;
                break;
        }
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();

        }
        return Window.window;

    }

    public void update(double dt) {
      currentScene.update(dt);
      draw(getGraphics());
    }
public void draw(Graphics g){
  if(doubleBufferImage == null){
      doubleBufferImage=createImage(getWidth(),getHeight());
      doubleBufferGraphics =doubleBufferImage.getGraphics();
  }
  renderOffscreen(doubleBufferGraphics);
  g.drawImage(doubleBufferImage,0,0,getWidth(),getHeight(),null);
}
public void renderOffscreen(Graphics g){
Graphics2D g2=(Graphics2D)g;
currentScene.draw(g2);
}
    @Override
    public void run() {
        double lastFrameTime = 0.0;
        try {
            while (isRunning) {
                //do whatever
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                update(deltaTime);
            }
        }
          catch(Exception e){
                e.printStackTrace();
            }


        }
    }

