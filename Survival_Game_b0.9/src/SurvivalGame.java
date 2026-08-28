import javax.swing.JFrame;

public class SurvivalGame {

	public static void main(String[] args) {

		new SurvivalGame();
	}
	
	private SurvivalGame() {

		JFrame frame = new JFrame("Survival Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(512, 512);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(new MenuPanel(frame));
		frame.setVisible(true);
	}
}