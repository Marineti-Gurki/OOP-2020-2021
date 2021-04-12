package ie.tudublin;

public abstract class GameObject {
    float x, y;
    float dx, dy;
    float rotation = 0;
    float speed = 5;
    YASC yasc;
    float w = 50;
    float halfW = w / 2;

    public GameObject(YASC yasc, float x, float y, float rotation)
    {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
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

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public YASC getYasc() {
        return yasc;
    }

    public void setYasc(YASC yasc) {
        this.yasc = yasc;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public abstract void update();
    public abstract void render();

    
}
