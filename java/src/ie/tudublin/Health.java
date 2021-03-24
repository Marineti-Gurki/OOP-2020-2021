package ie.tudublin;
import processing.core.PApplet;

public class Health {
    float x;
    float y;
    float halfW = y / 2;
    float rotation;
    YASC yasc;
    float speedx;
    float speedy;

    public Health(YASC yasc, float x, float y) {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
        speedx = yasc.random(2, 8);
        speedy = yasc.random(2, 8);
    }
    void render()
    {
        //yasc.pushMatrix();
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(x, y, 50, 50);
        //yasc.popMatrix();
    }

    void update()
    {
        //dx = PApplet.sin(rotation);
        //dy =  - PApplet.cos(rotation);
        
        //x+=dx;
        //x+=dy;
        x = x + speedx;
        y = y + speedy;

        if (x > yasc.width)
        {
            x = yasc.width;
            speedx *= -1;
            rotation -= 0.1f;
        }
        if (x < 0)
        {
            x = 0;
            speedx *= -1;
            rotation -= 0.1f;
        }
        if (y < 0)
        {
            y = 0;
            speedy *= -1;
            rotation -= 0.1f;
        }
        if (y > yasc.height)
        {
            y = yasc.height;
            speedy *= -1;
            rotation -= 0.1f;
        }
        // if (x < yasc.height || x < yasc.width)
        // {
        //     x = dx * - 1;
        //     x = dy * - 1;
        //     rotation -= 0.1f;
        // }
        // if (yasc.checkKey(PApplet.DOWN))
        // {
        //     x -= dx;
        //     x -= dy;
        // }
        // if (yasc.checkKey(PApplet.LEFT))
        // {
        //     rotation -= 0.1f;
        // }
        // if (yasc.checkKey(PApplet.RIGHT))
        // {
        //     rotation += 0.1f;
        // }        
    }


    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return x;
    }
    public void setY(float x) {
        this.x = x;
    }
    public float getW() {
        return y;
    }
    public void setW(float y) {
        this.y = y;
    }
    public float getHalfW() {
        return halfW;
    }
    public void setHalfW(float halfW) {
        this.halfW = halfW;
    }

    
}
