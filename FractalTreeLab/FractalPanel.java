import java.awt.*;
import javax.swing.JPanel;

/**
 * Class that generates fractal trees of different sizes and shapes.
 * 
 * @author Annika Dugad 
 * @version 3/23/2015
 */
public class FractalPanel extends JPanel
{
    private final int PANEL_WIDTH = 600;
    private final int PANEL_HEIGHT = 400;
    
    private double redux;
    
    private final int TOPX = 300, BOTTOMX=300;
    private final int TOPY = 300, BOTTOMY = 400;
    
    private double cAngle;
    private double sAngle;
    
    private int current;

    /**
     * Constructor for objects of class FractalPanel
     */
    public FractalPanel(int currentOrder, double redux, double cAngle, double sAngle)
    {
        current = currentOrder;
        this.redux = redux;
        this.cAngle = 90 - cAngle;
        this.sAngle = sAngle;
        setBackground (Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
    }

    /**
     * Draws a fractal tree
     * 
     * @param  order   The order of the fractal tree
     *         reduc   The amount each length will be reduced by
     *         x1      The top x value
     *         x2      The bottom x value
     *         y1      The top y value
     *         y2      The bottom y value
     *         cAngle  The constant angle
     *         sAngle  The starting angle
     *         page    The page upon which graphics will be placed
     * 
     */
    public void drawFractal(int order, double reduc, int x1, int x2, int y1, int y2, double cAngle, double sAngle, Graphics page)
    {
        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        page.drawLine(x1,y1,x2,y2);
        if(order==1)
        {
            page.drawLine(x1,y1,x2,y2);
        }
        else
        {
            distance = distance * reduc;
            double angle1 = sAngle + cAngle;
            double angle2 = sAngle - cAngle;
            double angle3 = Math.toRadians(angle1);
            double angle4 = Math.toRadians(angle2);
            double dy1 = distance * Math.sin(angle3);
            int dy13 = (int) dy1;
            double dy2 = distance * Math.sin(angle4);
            int dy24 = (int) dy2;
            double dx1 = distance * Math.cos(angle3);
            int dx13 = (int) dx1;
            double dx2 = distance * Math.cos(angle4);
            int dx24 = (int) dx2;
            int y13 = y1 - dy13;
            int y24 = y1 + dy24;
            int x13 = x1 - dx13;
            int x24 = x1 + dx24;
            drawFractal(order-1,reduc,x13,x1,y13,y1,cAngle,angle2,page);
            drawFractal(order-1,reduc,x24,x1,y24,y1,cAngle,angle1,page);
        }
    }
    

    /**
     * The paint component of the fractal tree
     *
     * @param  page   A page for placing graphics on
     * 
     */
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(Color.green);
        drawFractal(current,redux,TOPX,BOTTOMX,TOPY,BOTTOMY,cAngle,sAngle,page);
    }
    
    /**
     * Sets the order of the fractal tree
     * 
     * @param order The order of the fractal tree
     */
    public void setOrder(int order)
    {
        current = order;
    }
    
    /**
     * Gets the order of the fractal tree
     * 
     * @return The order of the fractal tree
     */
    public int getOrder()
    {
        return current;
    }
    
}