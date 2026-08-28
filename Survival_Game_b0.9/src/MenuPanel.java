import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

import javax.imageio.ImageIO;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.IOException;

public class MenuPanel extends JPanel implements MouseListener {

    	private JFrame frame;

    	public MenuPanel(JFrame frame) {	

		setFocusable(true);
		addMouseListener(this);

        	this.frame = frame;
    	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		try {

			g.drawImage(ImageIO.read(getClass().getResource("textures/menu_background.png")), 0, 0, this);
			g.drawImage(ImageIO.read(getClass().getResource("textures/start_button.png")), 192, 128, this);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

    	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		if (e.getButton() == MouseEvent.BUTTON1 && x >= 192 && x <= 320 && y >= 128 && y <= 160) {

			LoadingPanel loadingPanel = new LoadingPanel();

        		frame.remove(this);
        		frame.add(loadingPanel);
        		frame.repaint();
        		frame.revalidate();

        		new SwingWorker<Void, Void>() {
    
				protected Void doInBackground() throws Exception {
            
                			Thread.sleep(500);
                			return null;
            			}

      
            			protected void done() {

					frame.remove(loadingPanel);

               	 			GamePanel gamePanel = new GamePanel();
                			frame.add(gamePanel);

                			frame.repaint();
                			frame.revalidate();

                			gamePanel.requestFocusInWindow();
            			}

        		}.execute();
		}
    	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
