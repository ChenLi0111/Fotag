import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MenuBarView extends JPanel implements Observer {
    private Model model;

    //Create a new View.
    MenuBarView(Model model) {
        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("MenuBarView: updateView");
        }
    }
}
