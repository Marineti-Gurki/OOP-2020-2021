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
    int healthctr;

    public Health(YASC yasc, float x, float y) {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
        speedx = yasc.random(1, 2);
        speedy = yasc.random(1, 2);
        healthctr = 100;
    }
    void render()
    {
        
        yasc.pushMatrix();
        //yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(x, y, 50, 50);
        yasc.color(255);
        yasc.text(healthctr, 20, 20);
        yasc.popMatrix();
    }

    void update()
    {
        //dx = PApplet.sin(rotation);
        //dy =  - PApplet.cos(rotation);
        
        x = x + speedx;
        y = y + speedy;
        //rotation += 0.01f;
        if (x > yasc.width)
        {
            x = yasc.width;
            respawn();
            //speedx *= -1;
            //rotation += 0.1f;
        }
        if (x < 0)
        {
            x = 0;
            respawn();
            //speedx *= -1;
            //rotation -= 0.1f;
        }
        if (y < 0)
        {
            y = 0;
            respawn();
            //speedy *= -1;
            //rotation -= 0.1f;
        }
        if (y > yasc.height)
        {
            y = yasc.height;
            respawn();
            //speedy *= -1;
            //rotation += 0.1f;
        }
    }
    void respawn()
    {
        x = 50;
        y = 50;
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
