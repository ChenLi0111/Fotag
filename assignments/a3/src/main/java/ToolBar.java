import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ToolBar extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    private JButton grid_layout = new JButton("");
    private JButton list_layout = new JButton();
    private JLabel fotlag = new JLabel("Fotlag!");
    private JButton load = new JButton("");
    private JLabel filter_by = new JLabel("Filter by: ");
    //private JPanel star_filter;
    private JButton clear_filter = new JButton("");


    //private void set_button_listener() {}

    private void config_button() {
        grid_layout.setIcon(new ImageIcon("images/grid.png"));
        grid_layout.setSize(new Dimension(55, 55));

        list_layout.setIcon(new ImageIcon("images/list.png"));
        list_layout.setSize(new Dimension(55, 55));

        fotlag.setFont(new Font("Dialog", 1, 25));

        load.setIcon(new ImageIcon("images/load.png"));
        load.setSize(new Dimension(55, 55));

        filter_by.setFont(new Font("Dialog", 1, 15));

        clear_filter.setIcon(new ImageIcon("images/empty.png"));
        clear_filter.setSize(new Dimension(55, 55));
    }

    ToolBar(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        config_button();

        this.add(grid_layout);
        this.add(Box.createRigidArea(new Dimension(10,0)));
        this.add(list_layout);
        this.add(fotlag);
        this.add(Box.createHorizontalGlue());
        this.add(load);
        this.add(Box.createHorizontalStrut(10));
        this.add(filter_by);
        this.add(clear_filter);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ToolBar: update");
    }
}
