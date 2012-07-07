/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import framework.Input.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author Marco
 */
public class Tester {

    public Tester() {
        
    }

    public void start(){
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL here

        while (!Display.isCloseRequested()) {

            // render OpenGL here
            System.out.print(mouse.isClicked(0)+"\n");
            Display.update();
        }

        Display.destroy();
    }
}