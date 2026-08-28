import java.util.ArrayList;

public class Chunk {

	public Position position;

	public int minX;
	public int minY;
	public int maxX;
	public int maxY;

	public ArrayList<Tile> tiles;
	
	public ArrayList<Block> blocks;

	public Chunk(Position position) {

		this.position = position;

		minX = position.x;
		minY = position.y;
		maxX = position.x + 512;
		maxY = position.y + 512;

		tiles = new ArrayList<>();
		
		blocks = new ArrayList<>();

		for (int x = 0; x < 512; x += 16) {

			for (int y = 0; y < 512; y += 16) {
	
				tiles.add(new Grass(new Position(x + minX, y + minY)));
			}
		}
	}	
}