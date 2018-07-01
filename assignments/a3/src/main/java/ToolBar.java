import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ToolBar extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    private JButton grid_layout = new JButton(new ImageIcon("images/grid.png"));
    private JButton list_layout = new JButton(new ImageIcon("images/list.png"));
    private JLabel fotlag = new JLabel("Fotlag!");
    private JButton load = new JButton(new ImageIcon("images/load.png"));
    private JLabel filter_by = new JLabel("Filter by: ");
    private JButton star_1 = new JButton("");
    private JButton star_2 = new JButton("");
    private JButton star_3 = new JButton("");
    private JButton star_4 = new JButton("");
    private JButton star_5 = new JButton("");
    private ImageIcon star = new ImageIcon("images/star.png");
    private ImageIcon red_star = new ImageIcon("images/redstar.png");
    private JButton clear_filter = new JButton(new ImageIcon("images/empty.png"));


    //private void set_button_listener() {}

    private void config_button() {
        grid_layout.setSize(new Dimension(40, 40));

        list_layout.setSize(new Dimension(40, 40));

        fotlag.setFont(new Font("Dialog", 1, 25));

        load.setSize(new Dimension(40, 40));

        filter_by.setFont(new Font("Dialog", 1, 15));

        star_1.setIcon(star);
        star_1.setSize(new Dimension(40, 40));

        star_2.setIcon(star);
        star_2.setSize(new Dimension(40, 40));

        star_3.setIcon(star);
        star_3.setSize(new Dimension(40, 40));

        star_4.setIcon(star);
        star_4.setSize(new Dimension(40, 40));

        star_5.setIcon(star);
        star_5.setSize(new Dimension(40, 40));

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
        this.add(star_1);
        this.add(star_2);
        this.add(star_3);
        this.add(star_4);
        this.add(star_5);
        this.add(clear_filter);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ToolBar: update");
    }
}
