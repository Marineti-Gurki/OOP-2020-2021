package ie.tudublin;
import processing.core.PApplet;

public class Health {
    float x;
    float y;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;

    public Health(YASC yasc, float y, float w) {
        this.yasc = yasc;
        this.y = y;
        this.w = w;
    }
    void render()
    {
        //yasc.pushMatrix();
        yasc.rect(30, 20, 50, 50);
        //yasc.popMatrix();
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

    
}
