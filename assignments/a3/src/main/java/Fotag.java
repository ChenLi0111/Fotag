import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Fotag {
    public ImageCollectionModel imagecollectionmodel;
    public ImageCollectionView imagecollectionview;
    public ToolBarView toolbarview;

    public void call_save() {
        try {
            FileOutputStream fos = new FileOutputStream("old_state");
            String s = "";
            for (ImageModel i: this.imagecollectionmodel.get_imagemodel_list()) {
                s += i.get_path();
                s += "\n";
                //System.out.println(i.get_path());
            }
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
                    //System.out.println(line);

                    File temp = new File(line);
                    if(temp.exists() == false) {continue;}

                    ImageModel i_m = new ImageModel(imagecollectionmodel, temp);
                    ImageView i_v = new ImageView(i_m);
                    i_m.addObserver(i_v);
                    this.imagecollectionmodel.add_view_to_collection(i_v);
                    this.imagecollectionmodel.add_to_imagemodel_list(i_m);
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
        JFrame frame = new JFrame("Fotag!");
        Fotag F = new Fotag();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                F.imagecollectionmodel.set_frame_width(frame.getWidth());
            }
        });

        JPanel p = new JPanel(new BorderLayout());
        frame.getContentPane().add(p);

        p.add(F.toolbarview, BorderLayout.NORTH);

        JScrollPane scrollpane = new JScrollPane(F.imagecollectionview, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(scrollpane, BorderLayout.CENTER);

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
