import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("Fotag!");

		ImageCollectionModel imagecollectionmodel = new ImageCollectionModel();

		ImageCollectionView imagecollectionview = new ImageCollectionView(imagecollectionmodel);
		imagecollectionmodel.addObserver(imagecollectionview);

		ToolBar toolbar = new ToolBar(imagecollectionmodel);
		imagecollectionmodel.addObserver(toolbar);

		imagecollectionmodel.notifyObservers();

		JPanel p = new JPanel(new BorderLayout());
		frame.getContentPane().add(p);

		p.add(toolbar, BorderLayout.NORTH);

		JScrollPane scrollpane = new JScrollPane(imagecollectionview, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p.add(scrollpane, BorderLayout.CENTER);

		frame.setPreferredSize(new Dimension(800,600));
		//frame.setMinimumSize(new Dimension(800,600));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
