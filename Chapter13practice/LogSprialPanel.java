import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;
public class LogSprialPanel extends JPanel
{
    private static final double GOLDEN_MEAN = (1 + Math.sqrt(5)) / 2;
    
   public void paintComponent(Graphics g)
   {
      /* Your code goes here.
         1. Compute the dimensions of the goldenRectangle (you can use getHeight() 
            to obtain the side size)
         2. Draw the golden rectangle
         3. Call the recursive helper method "recursiveDraw" which will draw 
            the spiral.
      */
      Rectangle2D golden = new Rectangle2D(0,0,100 * GOLDEN_MEAN, 100);
      g.draw(golden);
      this.recursiveDraw(g,0,0,golden.getHeight(),90);
   }
   
   /**
      Method that recursively draws a logarithmic spiral.
      @param x The x-coordinate of the golden rectangle's upper-left corner  
      @param y The y-coordinate of the golden rectangle's upper-left corner
      @param side the smallest side size of the golden rectangle
      @param angle the angle (0, 90, 180 or 270) where the top of the 
      golden rectangle is located. For the outermost golden rectangle, 
      the angle is 90.
   */
   private void recursiveDraw(Graphics g, double x, double y, double side, int angle)
   {
       // Recursion ending condition: when the side is very small
      if(side <= 0.1)
      {
          return;
        }

      // Draw the current square and arc
      Rectangle square = new Rectangle(x,y, side,side);
      int newSide = side * GOLDEN_MEAN - side;
      this.drawArc(g,x,y,side,angle);

      /* Continue drawing the spiral recursively: calculate the new side 
         size, calculate the new (x, y) coordinates and the new angle. Then, 
         call "recursiveDraw" again. */
      double x1 = calculateNewX(x, angle, side, newSide);
      double y1 = calculateNewX(y, angle, side, newSide);
      recursiveDraw(g,x1,y1, newSide,angle);
    }
    
   /**
      Draws the arc of the current iteration.
      @param x The x-coordinate of the square's upper-left corner  
      @param y The y-coordinate of the square's upper-left corner
      @param side The size of the side of the square (or the arc's radius)
      @param angle The angle (0, 90, 180 or 270) where the top of the 
      current golden rectangle is located. For the outermost golden 
      rectangle, the angle is 90.
   */
   private void drawArc(Graphics g, double x, double y, double side, int angle)
   {
      double auxX = x;
      double auxY = y;
      if (angle == 0 || angle == 270 )
      {
         auxX = x - side;
      }
      if (angle == 270 || angle == 180)
      {
         auxY = y - side;
      }
      g.drawArc((int) auxX, (int) auxY, (int) side * 2, (int) side * 2, angle, 90);
   }   
   
   private double calculateNewX(double x, double angle, double side, double newSide)
   {
      if (angle == 0)
         x = x + side - newSide;
      else if (angle == 90)
         x = x + side;
      else if (angle == 270)
         x = x - newSide;
      return x;
   }

   private double calculateNewY(double y, double angle, double side, double newSide)
   {
      if (angle == 0)
         y = y + side;
      else if (angle == 180)
         y = y - newSide;
      else if (angle == 270)
         y = y + side - newSide;
      return y;
   }
}