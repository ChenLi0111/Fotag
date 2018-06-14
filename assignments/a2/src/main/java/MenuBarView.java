import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Observer;
import java.util.Observable;

public class MenuBarView extends JPanel implements Observer {
    private Model model;
    private JFileChooser file_chooser = new JFileChooser();

    // create a menu
    private JMenu menu_file = new JMenu("File");
    private JMenuBar menubar_file = new JMenuBar();

    //private JMenu menu_choice = new JMenu("Choices");
    //private JMenuBar menubar_choice = new JMenuBar();

    private void add_menu_file () {
        for (String s: new String[] {"Save", "Load", "New", "Exit" }) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // set the listener when events occur
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem mi = (JMenuItem)e.getSource();
                    if (mi.getText() == "Exit") {
                        model.exit();
                    } else if (mi.getText() == "New") {
                        model.new_file();
                    } else if (mi.getText() == "Load") {
                        model.load_file();
                        call_load();
                    } else if (mi.getText() == "Save") {
                        model.save_file();
                        call_save();
                    }
                }
            });
            // add this menu item to the menu
            menu_file.add(mi);
        }
        menubar_file.add(menu_file);
        /*
        for (String s: new String[] {"1", "2", "3", "4" }) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // set the listener when events occur
            mi.addActionListener(menuItemListener);
            // add this menu item to the menu
            menu_choice.add(mi);
        }
        menubar_choice.add(menu_choice); */
    }

    //Create a new View.
    MenuBarView(Model model) {
        // Hook up this observer so that it will be notified when the model changes.
        this.model = model;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add_menu_file ();

        this.add(menubar_file);
        //this.add(Box.createRigidArea(new Dimension(5, 0)));
        //this.add(menubar_choice);
    }

    private void call_save() {
        try{
            FileOutputStream fos = new FileOutputStream("temp.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("model " +Integer.toString(model.get_shape_collection().size()));
            oos.writeObject(model);
            System.out.println("saved!");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void call_load() {
        try {
            FileInputStream fi = new FileInputStream("temp.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Model temp = (Model) oi.readObject();
            System.out.println("temp " +Integer.toString(temp.get_shape_collection().size()));
            model.change_color(temp.get_color());
            model.change_thickness(temp.get_thickness());
            System.out.println("model 1 " +Integer.toString(model.get_shape_collection().size()));
            model.clear_collection();
            System.out.println("model 2 " +Integer.toString(model.get_shape_collection().size()));
            for (Shape s: temp.get_shape_collection()) {
                if (s != null) {
                    model.add_shape(s);
                }
            }
            System.out.println("model 3 " +Integer.toString(model.get_shape_collection().size()));
            oi.close();
            fi.close();
        } catch (IOException e_1) {
            e_1.printStackTrace();
        } catch (ClassNotFoundException e_2) {
            e_2.printStackTrace();
            return;
        }
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("MenuBarView: updateView");
    }
}
