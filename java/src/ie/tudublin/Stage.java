package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Stage {
    private String task;
    private int start;
    private int end;


    public Stage()
    {
        
    }

    public void render(PApplet pa)
    {
        float border = pa.width * 0.1f;
        float x = PApplet.map(start, -5, 5, border, pa.width - border);
        float y = PApplet.map(end, -5, 5, border, pa.width - border);
        pa.stroke(255, 255, 0);
        pa.line(x - 5, y, x + 5, y);
        pa.line(x, y - 5, x, y + 5);
        pa.stroke(255, 0, 0);
        pa.fill(255);
        pa.stroke(255);
        pa.rect(start, y, end, x);
        pa.fill(255);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.text(task, x + 10, y);
    }

    public Stage(TableRow row)
    {
        // Constructor chaining
        this(
            row.getString("Task"),
            row.getInt("Start"),
            row.getInt("End")
        );
    }

    public Stage(String task, int start, int end)
    {
            this.task = task;
            this.start = start;
            this.end = end;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
		this.end = end;
	}

    @Override
    public String toString() {
        return "Stages [end=" + end + ", start=" + start + ", task=" + task + "]";
    }

    
}
