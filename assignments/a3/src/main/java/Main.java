import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("Fotag!");

		ImageCollectionModel imagecollectionmodel = new ImageCollectionModel();

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				imagecollectionmodel.set_frame_width(frame.getWidth());
			}
		});

		ImageCollectionView imagecollectionview = new ImageCollectionView(imagecollectionmodel);
		imagecollectionmodel.addObserver(imagecollectionview);

		ToolBarView toolbarview = new ToolBarView(imagecollectionmodel);
		imagecollectionmodel.addObserver(toolbarview);

		imagecollectionmodel.notifyObservers();

		JPanel p = new JPanel(new BorderLayout());
		frame.getContentPane().add(p);

		p.add(toolbarview, BorderLayout.NORTH);

		JScrollPane scrollpane = new JScrollPane(imagecollectionview, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p.add(scrollpane, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800,600));
		frame.setMinimumSize(new Dimension(580,280));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
