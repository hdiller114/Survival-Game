import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

public class Block {

	public Position position;

	public BufferedImage texture;

	public Block(String texturePath) {

		position = new Position();
		
		try {

			texture = ImageIO.read(getClass().getResource(texturePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Block(Position position, String texturePath) {

		this.position = position;
		
		try {

			texture = ImageIO.read(getClass().getResource(texturePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Position getPosition() {

		return position;
	}

	public BufferedImage getTexture() {

		return texture;
	}
}