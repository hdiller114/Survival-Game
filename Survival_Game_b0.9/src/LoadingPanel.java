import javax.swing.JPanel;

import javax.imageio.ImageIO;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.io.IOException;

public class LoadingPanel extends JPanel {

	public LoadingPanel() {

	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		try {

			g.drawImage(ImageIO.read(getClass().getResource("textures/loading_screen.png")), 0, 0, this);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}