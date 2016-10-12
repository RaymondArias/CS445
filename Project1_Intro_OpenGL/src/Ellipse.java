/***************************************************************
* file: Ellipse.java
* author: Raymond Arias
* class: CS 445 – Computer Graphics
*
* assignment: program 1
* date last modified: 10/03/2016
*
* purpose: Class which holds data about a Ellipse
*
****************************************************************/

public class Ellipse {
    private float xCenter;
    private float yCenter;
    private float xRadius;
    private float yRadius;
    
    /**
     * Constructor which sets data for this object
     * @param xCenter
     * @param yCenter
     * @param xRadius
     * @param yRadius 
     */
    public Ellipse(float xCenter, float yCenter, float xRadius, float yRadius) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }
    public Ellipse(){
        this.xCenter = 0.0f;
        this.yCenter = 0.0f;
        this.xRadius = 0.0f;
        this.yRadius = 0.0f;
    }
    /**
     * Method: getXCenter
     * Purpose: returns this instance xCenter
     * @return xCenter
     */
    public float getXCenter() {
        return xCenter;
    }
    /**
     * Method: setXCenter
     * Purpose: sets this instance xCenter
     * @param xCenter 
     */
    public void setXCenter(float xCenter) {
        this.xCenter = xCenter;
    }
    /**
     * Method: getYCenter
     * Purpose: returns this instance's yCenter
     * @return yCenter
     */
    public float getYCenter() {
        return yCenter;
    }
    /**
     * Method: setYCenter
     * Purpose: sets this instance yCenter
     * @param yCenter 
     */
    public void setyCenter(float yCenter) {
        this.yCenter = yCenter;
    }
    /**
     * Method: getXRadius
     * Purpose: returns this instance xRadius
     * @return xRadius
     */
    public float getXRadius() {
        return xRadius;
    }
    /**
     * Method: setXRadius
     * Purpose: sets this instance xRadius
     * @param xRadius 
     */
    public void setXRadius(float xRadius) {
        this.xRadius = xRadius;
    }
    /**
     * Method: getYRadius
     * Purpose: returns this instance yRandius
     * @return yRadius
     */
    public float getYRadius() {
        return yRadius;
    }
    /**
     * Method: setYRadius
     * Purpose: sets this instance yRadius
     * @param yRadius 
     */
    public void setYRadius(float yRadius) {
        this.yRadius = yRadius;
    }
}
