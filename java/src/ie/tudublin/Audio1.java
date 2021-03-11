package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] lerpedBuffer;

    public void settings() {
        size(512, 512, P3D);
        //fullScreen(P3D); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("DoomsGate.mp3", width);
        //ab = ai.mix; // Connect the buffer to the mic
        ab = ap.mix; // Connect the buffer to the mp3 file
        colorMode(HSB);
        lerpedBuffer = new float[width];
    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                //ap.rewind(); rewind disabled here because I didn't like it rewninding everytime I unpaused the track
                ap.play();
            }
        }
        //pressing enter rewinds the track
        if (keyCode == ENTER)
        {
            ap.rewind();
        }
    } 

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (which)
        {
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                // See the difference lerping makes? It smooths out the jitteryness of average, so the visual looks smoother
                // ellipse(width / 4, 100, average * 500, average * 500);
                fill(255, 0, 50);
                stroke(255, 0, 155);
                ellipse(width / 2, height / 2, 170 + (lerpedAverage * 500), 170 + (lerpedAverage * 500));
                fill(255, 0, 100);
                ellipse(width / 2, height / 2, 40 + (lerpedAverage * 500), 40 + (lerpedAverage * 500));
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);
                }

                // This is another example of how lerping works
                // ellipse(200, y, 30, 30);
                // ellipse(300, lerpedY, 30, 30);
                // y += random(-10, 10);
                // lerpedY = lerp(lerpedY, y, 0.1f);
                break;
            }   
            case 1:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }
                break;
            }
            case 2:
            {
                fill(255, 0, 50);
                stroke(255, 0, 155);
                ellipse(width / 2, height / 2, 130 + (lerpedAverage * 500), 130 + (lerpedAverage * 500));
                fill(255, 0, 100);
                ellipse(width / 2, height / 2, 40 + (lerpedAverage * 500), 40 + (lerpedAverage * 500));
                for (int i = 0; i < ab.size(); i++) 
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
    
                    line(i, height, i, height + lerpedBuffer[i] * height * 4);

                    line(i, lerpedBuffer[i] * height * 4, i, 0 - lerpedBuffer[i] * 0 * 4);
                   
                    line(0, i, lerpedBuffer[i] * height * 4, i); 

                    line(width, i, width - lerpedBuffer[i] * halfHeight * 4, i); 
                }
                break;
            }
            case 3:
            {
                fill(255, 0, 50);
                stroke(255, 0, 155);
                ellipse(width / 2, height / 2, 130 + (lerpedAverage * 500), 130 + (lerpedAverage * 500));
                break;
            }
            case 4:
            {
                fill(255, 0, 50);
                stroke(255, 0, 155);
                rectMode(CENTER);
                rect(width / 2, height / 2, 130 + (lerpedAverage * 500), 130 + (lerpedAverage * 500));
                break;
            }
            case 5:
            {
                float r = 0.1f;
                int numPoints = 10;
                float thetaInc = TWO_PI / (float) numPoints;
                float lastX = width / 2, lastY = height / 2;
                strokeWeight(3);
                stroke(255, 255, 255);
                for (int i = 0; i < 1000; i++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    float theta = i * thetaInc * lerpedAverage * 7.5f;
                    float x = width / 2 + sin(theta) * r;
                    float y = height / 2 + cos(theta) * r;
                    r += 0.1f;
                    // I love this one, it's got a fantastic color scheme
                    stroke(c, 255, r++);
                    r++;
                    line(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
                // ??
                break;
            }
        }        
    }
}