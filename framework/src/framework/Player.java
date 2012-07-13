/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import framework.Window;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;

/**
 *
 * @author Marco
 */
public class Player extends Entity{

    private PolygonShape pS;
    public int c,r;

    public Player(float w, float h, float x, float y) {
        super(w, h, x, y);
        this.w= w;
        this.h=h;
        
        pS = new PolygonShape();
        pS.setAsBox(w, h);

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position = new Vec2(x, y);

        FixtureDef fd = new FixtureDef();
        fd.shape = pS;
        fd.friction = 20;

        body = Window.game2.world.createBody(bd);
        body.createFixture(fd);
    }

    public Player(Vec2[] vertex, float x, float y) {
        super(vertex, x, y);
        pS = new PolygonShape();
        pS.set(vertex, vertex.length);

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position = new Vec2(x, y);

        FixtureDef fd = new FixtureDef();
        fd.shape = pS;
        fd.friction = 0;

        body = Window.game2.world.createBody(bd);
        body.createFixture(fd);  

    }


    @Override
    public void draw() {

        Color.white.bind();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.body.getPosition().x, this.body.getPosition().y, 0);
        GL11.glBegin(GL11.GL_LINE_LOOP);
        {
            for (int j = 0; j < pS.getVertexCount(); j++) {
                GL11.glVertex2f(pS.getVertex(j).x, pS.getVertex(j).y);
            }
        }
        GL11.glEnd();
        GL11.glPopMatrix();
        float mult = 0.35f;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D((body.getPosition().x + w) - 800*mult,  800*mult + (body.getPosition().x  + w), (body.getPosition().y + h) -  600*mult, (body.getPosition().y + h) +  600*mult);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
    }
    
    public void setMatrixCoordinates(Position p){
        this.c = (int)p.x;
        this.r = (int)p.y;
    }
}
