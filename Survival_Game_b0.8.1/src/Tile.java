import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.IOException;

public class Tile {

	public Position position;

	public BufferedImage texture;

	public Tile(String texturePath) {

		position = new Position();
		
		try {
		
			texture = ImageIO.read(getClass().getResource(texturePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Tile(Position position, String texturePath) {

		this.position = position;
		
		try {
		
			texture = ImageIO.read(getClass().getResource(texturePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}