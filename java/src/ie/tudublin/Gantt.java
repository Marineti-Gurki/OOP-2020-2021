package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;


public class Gantt extends PApplet
{	
	ArrayList<Stage> stages = new ArrayList<Stage>();

    int startStage = -1;
    int endStage = -1;
    private float leftBorder;
    private float border;
    


    void drawGrid()
    {
        float border = 0.1f * width;
        textAlign(CENTER, CENTER);
        //float drawable = width - (border * 2.0f);
        // /float gap = drawable / 10.0f;
        for(int i = 1 ; i <=30 ; i ++)
        {
            float x = map(i, 1, 30, border, width - border);
            stroke(0, 0, 255);
            line(x, border,x, height - border);
            fill(255);
            text(i, x, border / 2);
        }
		for(int row = 0; row < stages.size(); row++)
		{
            Stage t = stages.get(row);
			float k = map(row, 0, stages.size(), border + 50, height - border - 50);
            fill(255);
			text(t.getTask(), border / 2, k);
            float x1 = map(t.getStart(), 1, 30, border, width-border);
            float x2 = map(t.getEnd(), 1, 30, border, width-border);
            int c = (int) map(row, 0, stages.size(), 0, 255);
            noStroke();
            fill(c, 255, 255);
            rect(x1, k-20, x2 - x1, 40);
			//break;
		}
    }

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
        for(TableRow row:table.rows())
        {
            Stage s = new Stage(row);
            stages.add(s);
        }
	}

	public void printTasks()
    {
        for(Stage s: stages)
        {
            println(s);
        }
    }

	public void displayTasks()
    {
        noStroke();
        fill(random(40, 255), random(40, 255), random(40, 255));
        for (int i = 0; i <= 30; i++)

    }
	// public void mousePressed()
	// {
	// 	println("Mouse pressed");	
	// }

	// public void mouseDragged()
	// {
	// 	println("Mouse dragged");
	// }

	public void drawStages()
    {
        for(Stage s: stages)
        {
            s.render(this);
        }
    }
	
	
	public void setup() 
	{
		loadTasks();
        printTasks();
		colorMode(HSB);
        leftBorder = width * 0.2f;
        // border = 100;
	}
	
	public void draw()
	{			
		background(0);
		drawGrid();
		drawStages();
	}
}