import java.util.ArrayList;

public class World {

	public ArrayList<Chunk> chunks;

	public World() {

		chunks = new ArrayList<>();

		chunks.add(new Chunk(new Position(-512, -512)));

		chunks.add(new Chunk(new Position(0, 0)));
	}
}