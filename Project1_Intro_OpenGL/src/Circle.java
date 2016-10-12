/***************************************************************
* file: Circle.java
* author: Raymond Arias
* class: CS 445 – Computer Graphics
*
* assignment: program 1
* date last modified: 10/03/2016
*
* purpose: Class which holds data about a circle
*
****************************************************************/

public class Circle {
    private float xCenter;
    private float yCenter;
    private float radius;
    
    
    /**
     * Constructor to set data about circle
     * @param xCenter
     * @param yCenter
     * @param radius 
     */
    public Circle(float xCenter, float yCenter, float radius)
    {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }
    public Circle()
    {
        this.xCenter = 0.0f;
        this.yCenter = 0.0f;
        this.radius = 0.0f;
    }
    /**
     * Method: getXCenter
     * Purpose: get this instance xCenter
     * @return xCenter 
     */
    public float getXCenter() {
        return xCenter;
    }
    /**
     * Method: setXCenter
     * Purpose: Sets this instance xCenter member
     * @param xCenter 
     */
    public void setXCenter(float xCenter) {
        this.xCenter = xCenter;
    }
    /**
     * Method: getYCenter
     * Purpose: get this instance yCenter
     * @return yCenter 
     */
    public float getYCenter() {
        return yCenter;
    }
    /**
     * Method: setYCenter
     * Purpose: Sets this instance yCenter member
     * @param yCenter 
     */
    public void setyCenter(float yCenter) {
        this.yCenter = yCenter;
    }
    /**
     * Method: getRadius
     * Purpose: get this instance radius
     * @return radius 
     */
    public float getRadius() {
        return radius;
    }
    /**
     * Method: setRadius
     * Purpose: Sets this instance radius member
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
}
