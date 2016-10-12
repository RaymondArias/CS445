/***************************************************************
* file: Line.java
* author: Raymond Arias
* class: CS 445 – Computer Graphics
*
* assignment: program 1
* date last modified: 10/03/2016
*
* purpose: Class which holds data about a line
*
****************************************************************/
public class Line {
    private float x0;
    private float x1;
    private float y0;
    private float y1;
    
    /**
     * Method: Line
     * Purpose: Constructor for line object to set data
     * @param x0
     * @param y0
     * @param x1
     * @param y1 
     */
    public Line(float x0, float y0, float x1, float y1)
    {
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }
    public Line ()
    {
        this.x0 = 0.0f;
        this.x1 = 0.0f;
        this.y0 = 0.0f;
        this.y1 = 0.0f;
    }
    /**
     * Method: getX0
     * Purpose: returns x0
     * @return x0 
     */
    public float getX0() {
        return x0;
    }
    /**
     * Method: setX0
     * Purpose: sets this instance x0
     * @param x0 
     */
    public void setX0(float x0) {
        this.x0 = x0;
    }
    /**
     * Method: getX1
     * Purpose: returns x1
     * @return x1 
     */
    public float getX1() {
        return x1;
    }
    /**
     * Method: setX1
     * Purpose: sets this instance x1
     * @param x1 
     */
    public void setX1(float x1) {
        this.x1 = x1;
    }
    /**
     * Method: getY0
     * Purpose: returns y0
     * @return y0 
     */
    public float getY0() {
        return y0;
    }
    /**
     * Method: setY0
     * Purpose: sets this instance Y0
     * @param y0 
     */
    public void setY0(float y0) {
        this.y0 = y0;
    }
    /**
     * Method: getY1
     * Purpose: returns y1
     * @return y1 
     */
    public float getY1() {
        return y1;
    }
    /**
     * Method: setY1
     * Purpose: sets this instance y1
     * @param y1 
     */
    public void setY1(float y1) {
        this.y1 = y1;
    }
}
