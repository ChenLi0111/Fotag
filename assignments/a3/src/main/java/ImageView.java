import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Observer;
import java.util.Observable;

public class ImageView extends JPanel implements Observer {
    private ImageModel imagemodel;

    private JButton image = new JButton("");
    private JLabel image_name = new JLabel("");
    private JLabel image_date = new JLabel("");
    private JButton star_1 = new JButton(new ImageIcon("images/star.png"));
    private JButton star_2 = new JButton(new ImageIcon("images/star.png"));
    private JButton star_3 = new JButton(new ImageIcon("images/star.png"));
    private JButton star_4 = new JButton(new ImageIcon("images/star.png"));
    private JButton star_5 = new JButton(new ImageIcon("images/star.png"));
    private ImageIcon star = new ImageIcon("images/star.png");
    private ImageIcon red_star = new ImageIcon("images/redstar.png");

    public ImageModel get_imagemodel() {
        return imagemodel;
    }

    private void config_button() {
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //TODO enlarge
            }
        });

        star_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagemodel.set_user_rating(1);
            }
        });

        star_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagemodel.set_user_rating(2);
            }
        });

        star_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagemodel.set_user_rating(3);
            }
        });

        star_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagemodel.set_user_rating(4);
            }
        });

        star_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                imagemodel.set_user_rating(5);
            }
        });
    }

    public void grid_view() {
        String path = imagemodel.get_path();
        File f = new File(path);
        BufferedImage buffer_image = null;
        try {
            buffer_image = ImageIO.read(f);
        } catch (IOException e) {}

        java.awt.Image i = buffer_image.getScaledInstance(270,200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon temp = new ImageIcon(i);
        image.setIcon(temp);

        image_name.setText(f.getName());

        BasicFileAttributes a = null;
        try {
            a = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        image_date.setText(a.creationTime().toString());

        this.setPreferredSize(new Dimension(300, 300));
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEtchedBorder());

        // create a constraints object
        GridBagConstraints gc = new GridBagConstraints();

        // stretch the widget horizontally and vertically
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridy = 0;
        gc.gridx = 0;
        gc.gridwidth = 5; // 1 grid cell wide
        this.add(image, gc);

        // modify gc for the next widget to be added
        gc.gridwidth = 5;
        gc.gridheight = 1;
        gc.gridy = 1;
        this.add(image_name, gc);
        gc.gridy = 2;
        this.add(image_date, gc);
        gc.gridy = 3;
        gc.gridwidth = 1;
        this.add(star_1, gc);
        gc.gridx = 1;
        this.add(star_2, gc);
        gc.gridx = 2;
        this.add(star_3, gc);
        gc.gridx = 3;
        this.add(star_4, gc);
        gc.gridx = 4;
        this.add(star_5, gc);
    }

    public void list_view() {}

    ImageView(ImageModel imagemodel) {
        this.imagemodel = imagemodel;
        //System.out.println(imagemodel.get_path());
        if (imagemodel.get_view_mode() == 0) {
            grid_view();
        } else if (imagemodel.get_view_mode() == 1) {
            list_view();
        }
        config_button();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ImageView: update");

        if (imagemodel.get_view_mode() == 0) {
            grid_view();
        } else if (imagemodel.get_view_mode() == 1) {
            list_view();
        }

        int star_number = imagemodel.get_user_rating();
        //System.out.println(star_number);
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
        repaint();
    }
}