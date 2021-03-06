package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    Health h;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        h = new Health(this, width / 2, height / 2);
        p = new Player(this, width / 2, height / 2);
    }

    public void draw() {
        background(0);
        stroke(255);
        p.update();
        p.render();
        h.update();
        h.render();
        // Check collisions        
        checkCollisions();
    }

    void checkCollisions() 
    {
        if(dist(h.x, h.y, p.x, p.y) <= 20)
        {
            if(h.healthctr < 100)
            {
                h.healthctr+=10;
                h.respawn();
            }
            else{
                h.respawn();
            }
        }
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}