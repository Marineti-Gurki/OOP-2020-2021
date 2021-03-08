package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim; //minim library connection
    AudioInput ai; // how its' Connected to mic
    AudioPlayer ap;
    AudioBuffer ab; //samples

    public void settings()
    {
        fullScreen(P3D);
        frameRate = 170;
    }

    float y = 300;
    float lerpedY = y;
    float lerpedAverage = 0;
    float[] lerpedBuffer;

    public void setup()
    {
        background(0);
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("heroplanet.mp3", width);
        ap.play();
        ab = ai.mix;
        ab = ap.mix;
        colorMode(HSB);
        lerpedBuffer = new float[width];
    }

    public void draw()
    {
        // for(int i = 0; i < width && i < height; i++)
        // {

        // }
        background(0);
        //stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;
        for(int i = 0; i < ab.size(); i++)
        {
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);

            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);


            line(i, halfHeight - lerpedBuffer[i]* halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);

            sum += abs(ab.get(i));
        }
        average = sum / (float) ab.size();
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);
        
        for(int i = 0; i < ab.size(); i++)
        {
            noStroke();
            fill(i + 100, i + 100, i + 100, 30);
        }
        ellipse(width / 2, height / 2, lerpedAverage* width*2, lerpedAverage * width*2);
        
        
        //C = LERP(A, B, T);
        // C = a+(b-a) *c;
        // float c = lerp(10, 20, (float) 0.1);
        // println(c);

        // ellipse(200, y, 30, 30);
        // ellipse(300, lerpedY, 30, 30);
        // y += random(-10, 10);
        // lerpedY = lerp(lerpedY, y, 0.1f);
    }       
}