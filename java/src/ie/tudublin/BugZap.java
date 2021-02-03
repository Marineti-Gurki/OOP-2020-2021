package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 250;
    float playerY = 450;
    float playerWidth = 300;
    float playerHeight = 10;
    float bugX = 250;
    float bugY = 200;
    float bugWidth = 15;
    float bugHeight = 10;
    float speedX = 5;
    float speedY = 3;
    int score = 0;


	public void settings()
	{
		size(500, 500);
	}

    public void setup() 
    {
		background(0);
	}
	
	public void draw()
	{	
		background(0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);
        bugMove(bugX, bugY);
        collision(bugX, bugY, playerX, playerY);
    }
    public void drawPlayer(float x, float y, float w)
    {
        stroke(255);
        rect(playerX, playerY, playerWidth, playerHeight);
    }
    public void drawBug(float x, float y, float w)
    {
        stroke(255);
        rect(bugX, bugY, bugWidth, bugHeight);
    }
    public void keyPressed()
    {
        if(keyCode == LEFT)
        {
            if(playerX < 0)
            {
                playerX = 0;
            }
            if(playerX > 0)
            {
                playerX -= 10;
            }
            
            System.out.println("Left Arrow Pressed");

        }   
        if(keyCode == RIGHT)
        {
                if(playerX < width)
                {
                    playerX += 10;
                }
                if(playerX + playerWidth > width)
                {
                    playerX = width - playerWidth;
                }
                System.out.println("Right Arrow Pressed");
        }        
        if(keyCode == ' ')
        {

            System.out.println("Space Key Pressed");
        }             
    }
    public void bugMove(float x, float y)
    {
        bugY = bugY + speedY;
        bugX = bugX + speedX;

        if(bugY < 0 || bugY > height)
        {
            speedY *= -1;
        }
        if(bugX < 0 || bugX > width)
        {
            speedX *= -1;
        }
    }
    
        public void collision(float x, float y, float v, float z)
        {
            fill(255);
            text(score, 30, 50);
            if(bugY == playerY+playerHeight && bugX == playerX + playerWidth)
            {
                score++;
            }
        }
}
