import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class PlayBackView extends JPanel implements Observer {

    private JButton play = new JButton("Play");
    private JSlider slider = new JSlider(0, 100, 50);
    private JButton start = new JButton("Start");
    private JButton end = new JButton("End");


    private Model model;

    //Create a new View.
    PlayBackView(Model model) {
        this.setLayout(new FlowLayout());

        this.model = model;
        this.add(play);
        this.add(slider);
        this.add(start);
        this.add(end);
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("PlayBackView: Model changed!");
        }
    }
}
