import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

public class Player {

	public Position position;

	public BufferedImage texture;

	public Player() {

		position = new Position();

		try {

			texture = ImageIO.read(getClass().getResource("textures/player.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Boolean isOverlapping(Block block) {

		int aRight = position.x + 16;	
		int aLeft = position.x;
		int aTop = position.y;
		int aBottom = position.y + 16;

		int bRight = block.position.x + 16;	
		int bLeft = block.position.x;
		int bTop = block.position.y;
		int bBottom = block.position.y + 16;

		boolean xOverlap = aRight > bLeft && aLeft < bRight;
   		boolean yOverlap = aBottom > bTop && aTop < bBottom;

    		return xOverlap && yOverlap;
	}
}