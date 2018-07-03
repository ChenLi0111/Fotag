import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ToolBarView extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    private ButtonGroup button_group = new ButtonGroup();
    private JToggleButton grid_layout = new JToggleButton(new ImageIcon("images/grid.png"));
    private JToggleButton list_layout = new JToggleButton(new ImageIcon("images/list.png"));
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

    private void call_load() {
        JFileChooser file_chooser = new JFileChooser();
        FileNameExtensionFilter file_ext_filter = new FileNameExtensionFilter("image file", "png", "jpg");
        file_chooser.setFileFilter(file_ext_filter);
        file_chooser.setMultiSelectionEnabled(true);

        int load_or_not = file_chooser.showOpenDialog(null);
        if (load_or_not == 1) { // cancel
            return;
        } else { // load
            File[] file = file_chooser.getSelectedFiles();
            BufferedImage buffer_image = null;
            for (File f: file) {
                try {
                    buffer_image = ImageIO.read(f);
                } catch (IOException e) {}

                ImageModel i_m = new ImageModel(imagecollectionmodel, f);
                ImageView i_v = new ImageView(i_m);
                i_m.addObserver(i_v);
                imagecollectionmodel.add_view_to_collection(i_v);
                imagecollectionmodel.add_to_imagemodel_list(i_m);
            }
        }
    }

    private void config_button() {
        grid_layout.setSize(new Dimension(40, 40));
        list_layout.setSize(new Dimension(40, 40));

        button_group.add(grid_layout);
        button_group.add(list_layout);

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

        clear_filter.setSize(new Dimension(40, 40));
    }

    private void set_button() {
        grid_layout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_view_mode(0);
            }
        });

        list_layout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_view_mode(1);
            }
        });

        star_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(1);
            }
        });

        star_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(2);
            }
        });

        star_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(3);
            }
        });

        star_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(4);
            }
        });

        star_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(5);
            }
        });

        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                call_load();
            }
        });

        clear_filter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagecollectionmodel.set_star_number(0);
            }
        });
    }

    ToolBarView(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        config_button();
        set_button();

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
        int star_number = imagecollectionmodel.get_star_number();

        if (star_number == 0) {
            star_1.setIcon(star);
            star_2.setIcon(star);
            star_3.setIcon(star);
            star_4.setIcon(star);
            star_5.setIcon(star);
        } else if (star_number == 1) {
            star_1.setIcon(red_star);
            star_2.setIcon(star);
            star_3.setIcon(star);
            star_4.setIcon(star);
            star_5.setIcon(star);
        } else if (star_number == 2) {
            star_1.setIcon(red_star);
            star_2.setIcon(red_star);
            star_3.setIcon(star);
            star_4.setIcon(star);
            star_5.setIcon(star);
        } else if (star_number == 3) {
            star_1.setIcon(red_star);
            star_2.setIcon(red_star);
            star_3.setIcon(red_star);
            star_4.setIcon(star);
            star_5.setIcon(star);
        } else if (star_number == 4) {
            star_1.setIcon(red_star);
            star_2.setIcon(red_star);
            star_3.setIcon(red_star);
            star_4.setIcon(red_star);
            star_5.setIcon(star);
        } else if (star_number == 5) {
            star_1.setIcon(red_star);
            star_2.setIcon(red_star);
            star_3.setIcon(red_star);
            star_4.setIcon(red_star);
            star_5.setIcon(red_star);
        }
        //System.out.println("ToolBar: update");
    }
}
