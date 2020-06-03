import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {

	private int width;
	private int height;

	private JImageDisplay display;
	private Rectangle2D.Double range;
	private JFrame frame;
	private JButton button;
	private Mandelbrot mandelbrot;

	private class resetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mandelbrot.getInitialRange(range);
			FractalExplorer.this.drawFractal();
		}
	}

	private class mouseClickListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();

			double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, display.getWidth(), x);
			double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, display.getHeight(), y);

			if (e.getButton() == MouseEvent.BUTTON1) {
				mandelbrot.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
			}

			if (e.getButton() == MouseEvent.BUTTON3) {
				mandelbrot.recenterAndZoomRange(range, xCoord, yCoord, 1.5);
			}

			FractalExplorer.this.drawFractal();
		}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
	}

	public FractalExplorer() {
		this(600);
	}

	public FractalExplorer(int size) {
		this(size, size);
	}

	public FractalExplorer(int width, int height) {
		this.width = width;
		this.height = height;

		this.range = new Rectangle2D.Double();

		this.mandelbrot = new Mandelbrot();

		mandelbrot.getInitialRange(range);
	}

	public void createAndShowGUI() {
		this.frame = new JFrame("Fraktalz");
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame.setSize(this.width, this.height);
		this.frame.setResizable(false);

		this.button = new JButton("Reset display");
		frame.getContentPane().add(BorderLayout.SOUTH, this.button);

		button.addActionListener(new resetButtonListener());

		this.display = new JImageDisplay(this.frame.getWidth(), this.frame.getHeight());
		frame.getContentPane().add(BorderLayout.CENTER, this.display);

		display.addMouseListener(new mouseClickListener());

		frame.setVisible(true);
	}

	public void drawFractal() {

		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {

				double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, display.getWidth(), x);
				double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, display.getHeight(), y);

				int numOfIter = mandelbrot.numIterations(xCoord, yCoord);

				int rgbColor;
				if (numOfIter != -1) {
					float hue = 0.7f + (float) numOfIter / 200f;
					rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
				}
				else {
					rgbColor = Color.HSBtoRGB(0, 0, 0);
				}


				display.drawPixel(x, y, new Color(rgbColor));

			}
		}
	}

	public static void main(String[] args) {
		FractalExplorer explorer = new FractalExplorer(700);
		explorer.createAndShowGUI();
		explorer.drawFractal();
	}
}