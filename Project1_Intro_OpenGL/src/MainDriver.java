/***************************************************************
* file: MainDriver.java
* author: Raymond Arias
* class: CS 445 – Computer Graphics
*
* assignment: program 1
* date last modified: 10/03/2016
*
* purpose: Program which reads shapes from a coordinate.txt file
* and draw shapes onto screen
*
****************************************************************/ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;


public class MainDriver {
    
    //Method: start
    //Purpose: Intitiliazes the gui window and calls 
    //render to draw shapes 
    public void start() {
        try {
            createWindow();
            initGL();
            render();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Method: createWindow
    Purpose: Creates the gui window with initial size and title
    */
    private void createWindow() throws Exception {
        Display.setFullscreen(false);
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.setTitle("CS445 Program1");
        Display.create();
    }
    /*
    Method: initGL
    Purpose: set openGL with intitial values
    */
    private void initGL() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 0, 480, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    /*
    Method: render
    Purpose: reads shape data from file and draws them to screen
    */
    private void render() {
        ArrayList<Object> shapes = readCoordinateFile();
        while (!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            try {
                for(int i = 0; i < shapes.size(); i++)
                {
                    Object aShape = shapes.get(i);
                    if(aShape instanceof Line)
                    {
                        drawLine((Line)aShape);
                    }
                    else if(aShape instanceof Circle)
                    {
                        drawCircle((Circle)aShape);
                    }
                    else if(aShape instanceof Ellipse)
                    {
                        drawEllipse((Ellipse)aShape);
                    }
                }
                Display.update();
                Display.sync(60);
            } catch (Exception e) {
            }
        }
        Display.destroy();
    }
    /*
    Method: readCoordinateFile
    Purpose: reads shapes from coordinate.txt and stores shape
    objects to array list
    */
    public ArrayList<Object> readCoordinateFile()
    {
        ArrayList<Object> shapes = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("coordinates.txt"));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String []parsedData = line.split(" ");
                if (parsedData[0].equals("l"))
                {
                    System.out.println("Line");
                    String []p0 = parsedData[1].split(",");
                    String []p1 = parsedData[2].split(",");
                    float x0 = Float.parseFloat(p0[0]);
                    float y0 = Float.parseFloat(p0[1]);
                    float x1 = Float.parseFloat(p1[0]);
                    float y1 = Float.parseFloat(p1[1]);
                    Line aLine = new Line(x0, y0, x1, y1);
                    shapes.add(aLine);
                    
                }
                else if (parsedData[0].equals("c"))
                {
                    System.out.println("Circle");
                    String []centerPoints = parsedData[1].split(",");
                    float xCenter = Float.parseFloat(centerPoints[0]);
                    float yCenter = Float.parseFloat(centerPoints[1]);
                    float radius = Float.parseFloat(parsedData[2]);
                    Circle circle = new Circle(xCenter, yCenter, radius);
                    shapes.add(circle);
                }
                else if (parsedData[0].equals("e"))
                {
                    System.out.println("Ellipse");
                    String []centerPoints = parsedData[1].split(",");
                    String []radi = parsedData[2].split(",");
                    float xCenter = Float.parseFloat(centerPoints[0]);
                    float yCenter = Float.parseFloat(centerPoints[1]);
                    float xRadius = Float.parseFloat(radi[0]);
                    float yRadius = Float.parseFloat(radi[1]);
                    Ellipse ellipse = new Ellipse(xCenter, yCenter, xRadius, yRadius);
                    shapes.add(ellipse);
                    
                }
                
            }
          
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        return shapes;
    }
    /*
    Method: drawLine
    Purpose: Algorithm to draw line on screen
    given data about a line
    */
    public void drawLine(Line line)
    {
        boolean decreasingLine = false;
        float m = (line.getY1() - line.getY0()) / (line.getX1() - line.getX0());
        if((m <= -1.0) || (m >= 1.0))
        {
            //iterate through row
            drawLineRow(line);
            return;
        }
        float x = line.getX0();
        float y = line.getY0();
        float dx = line.getX1() - x;
        float dy = line.getY1() - y;
        float incrementRight = 2*dy;
        float incrementUpRight = 2 * (dy - dx);
        float d =  2*dy - dx;
        float lastX = line.getX1();
        if(y > line.getY1())
        {
            decreasingLine = true;
        }
        drawPoint(x,y,0);
        while (x < lastX)
        {
            if(!decreasingLine)
            {
                if (d > 0) {
                    d += incrementUpRight;
                    x++;
                    y++;
                } else {
                    d += incrementRight;
                    x++;
                }
            }
            else{
                if (d > 0) {
                    d += incrementRight;
                    x++;
                } else {
                    d += incrementUpRight;
                    x++;
                    y--;
                }
            }
            drawPoint(x,y,0);
        }
        
    }
    /**
     * Line algorithm using rows instead of columns
     * @param line 
     */
    public void drawLineRow(Line line)
    {
        float x0 = line.getX0();
        float y0 = line.getY0();
        float x1 = line.getX1();
        float y1 = line.getY1();
        if(line.getY0() > line.getY1())
        {
            x0 = line.getX1();
            y0 = line.getY1();
            x1 = line.getX0();
            y1 = line.getY0();
        }
        float dx = x1 - x0;
        float dy = y1 - y0;
        boolean goRight = true;
        if(x1 < x0)
        {
            goRight = false;
        }
        float incrementUp = 2*dx;
        float incrementUpRight = 2 * (dx - dy);
        float lastY = y1;
        float d =  2*dy - dx;
        drawPoint(x0,y0,0);
        while(y0 < lastY)
        {
            if(goRight)
            {
                if (d > 0) 
                {
                    d += incrementUpRight;
                    x0++;
                    y0++;
                
                } 
                else 
                {
                    d += incrementUp;
                    y0++;
                }
            }
            else
            {
                if (d > 0) 
                {
                    d += incrementUp;
                    y0++;
                } 
                else 
                {
                    d += incrementUpRight;
                    x0--;
                    y0++;
                }
                
            }
            drawPoint(x0,y0,0);
        }
            
    }
    /*
    Method: drawCircle
    Purpose: Draws a circle to the screen given data about a circle
    */
    public void drawCircle(Circle circle)
    {
        float centerX = circle.getXCenter();
        float centerY = circle.getYCenter();
        float radius = circle.getRadius();
        float theta = 0;
        float x = 0;
        float y = 0;
        
        while(theta < 2*Math.PI)
        {
            x = (float) (radius * Math.cos(theta));
            y = (float) (radius * Math.sin(theta));
            drawPoint(x + centerX, y + centerY, 1);
            theta += Math.PI / 1000.0f;
        }
    }
    /*
    Method: drawEllipse
    Purpose: Algorithm to draw ellipse to screen given data about an ellipse
    */
    public void drawEllipse(Ellipse ellipse)
    {
        float xRadius = ellipse.getXRadius();
        float yRadius = ellipse.getYRadius();
        float xCenter = ellipse.getXCenter();
        float yCenter = ellipse.getYCenter();
        float theta = 0;
        float x = 0;
        float y = 0;
        while(theta < 2*Math.PI)
        {
            x = (float) (xRadius * Math.cos(theta));
            y = (float) (yRadius * Math.sin(theta));
            drawPoint(x + xCenter, y + yCenter, 2);
            theta += Math.PI / 10000.0f;
        }
    }
    /*
    Method: drawPoint
    Purpose: Draws a single point to screen
    */
    public void drawPoint(float x, float y, int shapeType)
    {
        if(shapeType == 0)
        {
            //Make pixel red for line
            glColor3f(255.0f, 0.0f, 0.0f);
        }
        else if (shapeType == 1)
        {
            //Make pixel blue for circle
            glColor3f(0.0f, 0.0f, 255.0f);
        }
        else if(shapeType == 2)
        {
            //Make pixel green for ellipse
            glColor3f(0.0f, 255.0f, 0.0f);
        }
        
        glBegin(GL_POINTS);
        glVertex2f(x, y);
        glEnd();
           
    }
    /*
    Method: main
    Purpose: drives the program
    */
    public static void main(String []args){
        MainDriver driver = new MainDriver();
        driver.start();
    }

}
