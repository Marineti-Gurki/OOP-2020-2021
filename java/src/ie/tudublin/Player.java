package ie.tudublin;

import processing.core.PApplet;

public class Player {
    float x, y;
    float w = 50;
    float halfW = w / 2;
    float rotation;
    YASC yasc;

    

    void render()
    {
        yasc.rotate(rotation);
        yasc.line(- halfW, halfW, 0, - halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, - halfW, halfW);
    }

    void update()
    {
        if (yasc.checkKey(PApplet.UP))
        {
            y -= 1;
        }
        if (yasc.checkKey(PApplet.DOWN))
        {
            y += 1;
        }
        if (yasc.checkKey(PApplet.LEFT))
        {
            rotation -= 0.1f;
        }
        if (yasc.checkKey(PApplet.RIGHT))
        {
            rotation += 0.1f;
        }
    }

    public Player(YASC yasc, float y, float x) {
        this.x = x;
        this.y = y;
        this.yasc = yasc;
        rotation = 0;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getHalfW() {
        return halfW;
    }

    public void setHalfW(float halfW) {
        this.halfW = halfW;
    }

    public YASC getYasc() {
        return yasc;
    }

    public void setYasc(YASC yasc) {
        this.yasc = yasc;
    }
}
