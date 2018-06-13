import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observer;
import java.util.Observable;

public class DrawView extends JPanel implements Observer {

    private Model model;
    private Shape shape;

    //Create a new View.
    DrawView(Model model) {
        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;

        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {

                shape = new Shape();
                // change shape type
//                shape.setIsClosed(true);
//                shape.setIsFilled(true);
                shape.setColour(Color.RED);

                // try setting scale to something other than 1
                shape.setScale(1.0f);

                repaint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                shape.addPoint(e.getX(), e.getY());
                repaint();
            }
        });
    }

    // custom graphics drawing
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // cast to get 2D drawing methods
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  // antialiasing look nicer
                RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println("here");
        if (shape != null)
            shape.draw(g2);
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("DrawView: Model changed!");
        }
    }
}
