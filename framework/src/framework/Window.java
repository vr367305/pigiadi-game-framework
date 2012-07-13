/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


/**
 *
 * @author Marco
 */
public class Window {

    public static int w, h;
    public static Tester game;
    public static Game game2;
    public static Vec2 mSpace;


    public static boolean initialise(int width, int heigth) {
        try {
            Display.setDisplayMode(new DisplayMode(width, heigth));
            w=width;
            h=heigth;
            return true;
        } catch (LWJGLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static World getWorld(){
        return Window.game2.world;
    }

    public static void setMeterSpace(Vec2 value){
        Window.mSpace=value;
    }

    public static void setMeterSpace(float x,float y){
        Window.mSpace=new Vec2(x,y);
    }

    public static Float[] getBoundaries(){
        Float[] bounds=new Float[4];
        bounds[0]=-Window.mSpace.x/2.0f;
        bounds[1]=Window.mSpace.x/2.0f;
        bounds[2]=-Window.mSpace.y/2.0f;
        bounds[3]=Window.mSpace.y/2.0f;
        return bounds;
    }
}
