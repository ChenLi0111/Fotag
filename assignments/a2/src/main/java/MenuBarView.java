import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class MenuBarView extends JPanel implements Observer {
    private Model model;


    // create a menu
    private JMenu menu_file = new JMenu("File");
    private JMenuBar menubar_file = new JMenuBar();

    private JMenu menu_choice = new JMenu("Choices");
    private JMenuBar menubar_choice = new JMenuBar();

    private void add_menu_file () {
        for (String s: new String[] {"Save", "Load", "New", "Exit" }) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // set the listener when events occur
            //mi.addActionListener(menuItemListener);
            // add this menu item to the menu
            menu_file.add(mi);
        }
        menubar_file.add(menu_file);
/*
        for (String s: new String[] {"1", "2", "3", "4" }) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // set the listener when events occur
            //mi.addActionListener(menuItemListener);
            // add this menu item to the menu
            menu_choice.add(mi);
        }
        menubar_choice.add(menu_choice); */
    }

    //Create a new View.
    MenuBarView(Model model) {
        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add_menu_file ();

        this.add(menubar_file);
        //this.add(Box.createRigidArea(new Dimension(5, 0)));
        //this.add(menubar_choice);
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("MenuBarView: updateView");
        }
    }
}
