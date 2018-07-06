import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Fotag {
    private ImageCollectionModel imagecollectionmodel;
    private ImageCollectionView imagecollectionview;
    private ToolBarView toolbarview;

    public ImageCollectionModel get_imagecollectionmodel() {
        return imagecollectionmodel;
    }

    public ImageCollectionView get_imagecollectionview() {
        return imagecollectionview;
    }

    public ToolBarView get_toolbarview() {
        return toolbarview;
    }

    public void call_save() {
        try {
            FileOutputStream fos = new FileOutputStream("old_state");

            String s = "";
            for (ImageModel i: this.get_imagecollectionmodel().get_imagemodel_list()) {
                s += i.get_user_rating();
                s += i.get_path();
                s += "\n";
                //System.out.println(i.get_path());
            }
            //System.out.println("path = " + s);
            fos.write(s.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void call_load() {
        File f = new File("old_state");
        if (f.exists() == true) {
            try {
                BufferedReader buffer = new BufferedReader(new FileReader(f));
                String line = "";
                while (true) {
                    line = buffer.readLine();
                    if(line == null) {break;}
                    int rate = 0;
                    try {
                        rate = Integer.parseInt(line.substring(0,1));
                    } catch (NumberFormatException e) {}
                    line = line.substring(1);
                    //System.out.println("rate = " + rate);
                    //System.out.println("line = " + line);

                    File temp = new File(line);
                    if(temp.exists() == false) {continue;}

                    ImageModel i_m = new ImageModel(imagecollectionmodel, temp);
                    ImageView i_v = new ImageView(i_m);
                    i_m.addObserver(i_v);
                    i_m.set_user_rating(rate);
                    this.get_imagecollectionmodel().add_view_to_collection(i_v);
                    this.get_imagecollectionmodel().add_to_imagemodel_list(i_m);
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    Fotag() {
        imagecollectionmodel = new ImageCollectionModel();
        imagecollectionview = new ImageCollectionView(imagecollectionmodel);
        imagecollectionmodel.addObserver(imagecollectionview);

        toolbarview = new ToolBarView(imagecollectionmodel);
        imagecollectionmodel.addObserver(toolbarview);

        imagecollectionmodel.notifyObservers();
        call_load();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Fotag");
        Fotag F = new Fotag();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                F.get_imagecollectionmodel().set_frame_width(frame.getWidth());
            }
        });

        JPanel p = new JPanel(new BorderLayout());
        frame.getContentPane().add(p);

        p.add(F.get_toolbarview(), BorderLayout.NORTH);

        JScrollPane scrollbar = new JScrollPane(F.get_imagecollectionview(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(scrollbar, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(800,600));
        frame.setMinimumSize(new Dimension(580,280));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                F.call_save();
            }
        });
    }
}
