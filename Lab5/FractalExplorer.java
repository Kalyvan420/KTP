import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class FractalExplorer {
	private int size;
	private int rowsRemaining;

	private JFrame frame;
	private JButton saveButton;
	private JButton clearButton;
	private JImageDisplay imageDisplay;
	private JComboBox<FractalGenerator> comboBox;

	private FractalGenerator fractalGenerator;
	private Rectangle2D.Double rectRange;



	public FractalExplorer(int size) {
		this.size = size;
		this.fractalGenerator = new Mandelbrot();
		this.rectRange = new Rectangle2D.Double();
		fractalGenerator.getInitialRange(rectRange);
	}

	public void createAndShowGUI() {
		frame = new JFrame("Fractals generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JLabel label = new JLabel("Fractal:");

		comboBox = new JComboBox<>();
		comboBox.addItem(new Mandelbrot());
		comboBox.addItem(new Tricorn());
		comboBox.addItem(new BurningShip());

		comboBox.addActionListener(new ComboBoxActionListener());

		panel.add(label);
		panel.add(comboBox);

		imageDisplay = new JImageDisplay(size, size);
		imageDisplay.addMouseListener(new MouseListener());

		JPanel buttonPanel = new JPanel();

		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ButtonActionListener());

		saveButton = new JButton("Save");
		saveButton.addActionListener(new ButtonActionListener());

		buttonPanel.add(saveButton);
		buttonPanel.add(clearButton);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(imageDisplay, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public void enableUI(boolean val) {
		comboBox.setEnabled(val);
		saveButton.setEnabled(val);
		clearButton.setEnabled(val);
	}

	private void drawFractal() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				double x = FractalGenerator.getCoord(rectRange.x, rectRange.x + rectRange.width, size, i);
				double y = FractalGenerator.getCoord(rectRange.y, rectRange.y + rectRange.width, size, j);

				int numIters = fractalGenerator.numIterations(x, y);
				if (numIters == -1) {
					imageDisplay.drawPixel(i, j, Color.BLACK.getRGB());
				} else {
					float hue = 0.7f + (float) numIters / 200f;
					int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
					imageDisplay.drawPixel(i, j, rgbColor);
				}
			}
		}

		imageDisplay.repaint();
	}


	public static void main(String[] args) {
		FractalExplorer explorer = new FractalExplorer(800);
		explorer.createAndShowGUI();
		explorer.drawFractal();
	}

	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Clear")) {
				rectRange = new Rectangle2D.Double();
				fractalGenerator.getInitialRange(rectRange);
				imageDisplay.clearImage();
				imageDisplay.repaint();
				drawFractal();

			}
		}
	}

	class MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (rowsRemaining == 0) {
				super.mouseClicked(e);
				double x = FractalGenerator.getCoord(rectRange.x, rectRange.x + rectRange.width, size, e.getX());
				double y = FractalGenerator.getCoord(rectRange.y, rectRange.y + rectRange.width, size, e.getY());
				fractalGenerator.recenterAndZoomRange(rectRange, x, y, 0.5);
				drawFractal();
			}
		}
	}

	class ComboBoxActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			fractalGenerator = (FractalGenerator) ((JComboBox<FractalGenerator>) e.getSource()).getSelectedItem();
			fractalGenerator.getInitialRange(rectRange);
			imageDisplay.clearImage();
			imageDisplay.repaint();
			drawFractal();
		}
	}
}
