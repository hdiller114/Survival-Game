import java.util.ArrayList;

public class World {

	public ArrayList<Tile> tiles;

	public ArrayList<Block> blocks;

	public World() {

		tiles = new ArrayList<>();

		blocks = new ArrayList<>();

		for (int y = 1024; y >= -1024; y -= 16) {

       	 		for (int x = -1024; x <= 1024; x += 16) {

            			tiles.add(new Grass(new Position(x, y)));
        		}		
    		}
	}
}