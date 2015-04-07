import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Class to view the fractal tree
 * 
 * @author Annika Dugad
 * @version 3/23/2015
 */
public class FractalViewer implements ActionListener
{
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    
    private final int MIN = 1, MAX = 15;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private FractalPanel drawing1;
    private JPanel panel, tools;
    private JFrame frame;

    /**
     * 
     */
    public static void main(String[] args)
    {
        FractalViewer viewer = new FractalViewer();
    }

    /**
     * Constructor for the FractalViewer
     */
    public FractalViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("The Fractal Tree");
        titleLabel.setForeground (Color.black);

        increase = new JButton (new ImageIcon ("increase.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decrease.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);

        orderLabel = new JLabel ("Order: 1");
        orderLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);
        
        drawing1 = new FractalPanel(1,0.75,60,0);

        panel = new JPanel();
        panel.add(tools);
        panel.add (drawing1);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    /**
     * Controls the action performed when the button is clicked
     * 
     * @param event The ActionEvent that takes place
     */
    public void actionPerformed (ActionEvent event)
    {
        int order = drawing1.getOrder();

        if (event.getSource() == increase)
            order++;
        else
            order--;

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + order);
            drawing1.setOrder (order);
            frame.repaint();
        }
    }
}