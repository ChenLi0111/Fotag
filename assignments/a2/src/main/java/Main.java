import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Main {

	public static void main(String[] args){	
		JFrame frame = new JFrame("2D Draw");
		
		// create Model and initialize it
		Model model = new Model();

		// create DrawView, tell it about model (and controller)
		DrawView drawview = new DrawView(model);
		// tell Model about DrawView.
		model.addObserver(drawview);
		
		// create ColorView, tell it about model (and controller)
		ColorLineView colorlineview = new ColorLineView(model);
		colorlineview.setPreferredSize(new Dimension(150, 300));
		// tell Model about ColorLineView.
		model.addObserver(colorlineview);

		// create PlayBackView, tell it about model (and controller)
		PlayBackView playbackview = new PlayBackView(model);
		// tell Model about PlayBackView. 
		model.addObserver(playbackview);

		// create TopBarView, tell it about model (and controller)
		MenuBarView menubarview = new MenuBarView(model);
		// tell Model about MenuBarView.
		model.addObserver(menubarview);
		
		// let all the views know that they're connected to the model
		model.notifyObservers();
		
		frame.getContentPane().setLayout(new BorderLayout());

		frame.getContentPane().add(colorlineview, BorderLayout.WEST);
		frame.getContentPane().add(playbackview, BorderLayout.SOUTH);
		frame.getContentPane().add(menubarview, BorderLayout.NORTH);

		// setup window
		frame.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} 
}
