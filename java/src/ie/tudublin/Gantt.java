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
	    
    void drawGrid()
    {
        float border = 0.1f * width;
        textAlign(CENTER, CENTER);
        //float drawable = width - (border * 2.0f);
        // /float gap = drawable / 10.0f;
        for(int i = 0 ; i <=30 ; i ++)
        {
            float x = map(i, 0, 30, border, width - border);
            //float y = map(i, 0, 10, border, height - border);
			
            //float x = border + ((i + 5) * gap);
            //float y = border + ((i + 5) * gap);
            stroke(0, 0, 255);
            line(x, border,x, height - border);
            //line(border, y, width - border, y);
            fill(255);
            text(i, x, border / 2);
        }
		for(int row = 0; row < stages.size(); row++)
		{
			Stage t = stages.get(row);
			//float j = map(i, 0, 30, border, width - border);
			float k = map(row, 0, 9, border, height - border);
			text(t.getTask(), border / 2, k);
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
		colorMode(RGB);
	}
	
	public void draw()
	{			
		background(0);
		drawGrid();
		drawStages();
	}
}