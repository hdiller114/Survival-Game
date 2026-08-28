import javax.swing.JPanel;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.image.BufferedImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener, MouseListener, Runnable {

	private boolean isWPressed;
	private boolean isSPressed;
	private boolean isDPressed;
	private boolean isAPressed;

	private int selectedBlock;

	private World world;

	private Player player;

	public Thread gameThread;

	public GamePanel() {

		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		addMouseListener(this);

		isWPressed = false;
		isSPressed = false;
		isDPressed = false;
		isAPressed = false;

		selectedBlock = 1;
		
		world = new World();
	
		player = new Player();

		gameThread = new Thread(this);
		gameThread.start();
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (Tile tile : world.tiles) {

			g.drawImage(tile.texture, 248 - (player.position.x - tile.position.x), 248 + (player.position.y - tile.position.y), this);
		}	

		for (Block block : world.blocks) {

			g.drawImage(block.texture, 248 - (player.position.x - block.position.x), (player.position.y - block.position.y) + 248, this);
		}

		g.drawImage(player.texture, 248, 248, this);

		try {

			g.drawImage(ImageIO.read(getClass().getResource("textures/hot_bar.png")), 196, 420, this);

			g.setColor(Color.GREEN);

			switch (selectedBlock) {

				case 1: {
						
					g.drawRect(197, 421, 17, 17);

					break;
				}

				case 2: {

					g.drawRect(217, 421, 17, 17);

					break;
				}

				case 3: {

					g.drawRect(237, 421, 17, 17);

					break;
				}

				case 4: {

					g.drawRect(257, 421, 17, 17);

					break;
				}

				case 5: {

					g.drawRect(277, 421, 17, 17);

					break;
				}

				case 6: {

					g.drawRect(297, 421, 17, 17);

					break;
				}
			}

		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		switch (keyCode) {

			case KeyEvent.VK_W: {

				isWPressed = true;

				break;
			}

			case KeyEvent.VK_S: {

				isSPressed = true;

				break;
			}

			case KeyEvent.VK_D: {

				isDPressed = true;

				break;
			}

			case KeyEvent.VK_A: {

				isAPressed = true;

				break;
			}

			case KeyEvent.VK_1: {
				
				selectedBlock = 1;

				break;
			}

			case KeyEvent.VK_2: {

				selectedBlock = 2;

				break;
			}

			case KeyEvent.VK_3: {

				selectedBlock = 3;

				break;
			}

			case KeyEvent.VK_4: {

				selectedBlock = 4;

				break;
			}

			case KeyEvent.VK_5: {

				selectedBlock = 5;

				break;
			}

			case KeyEvent.VK_6: {

				selectedBlock = 6;

				break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();

		switch (keyCode) {

			case KeyEvent.VK_W: {

				isWPressed = false;

				break;
			}

			case KeyEvent.VK_S: {

				isSPressed = false;

				break;
			}

			case KeyEvent.VK_D: {

				isDPressed = false;

				break;
			}

			case KeyEvent.VK_A: {

				isAPressed = false;

				break;
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

		int button = e.getButton();

		int x0 = e.getX();
		int y0 = e.getY();

		int x1 = player.position.x + (x0 - 256);
		int y1 = player.position.y + (256 - y0);
	
		double x2 = (double) x1 / 16;
		double y2 = (double) y1 / 16;	

		double x3 = Math.round(x2);
		double y3 = Math.round(y2);			
				
		double x4 = x3 * 16;
		double y4 = y3 * 16;

		int x5 = (int) x4;
		int y5 = (int) y4;

		switch(button) {

			case MouseEvent.BUTTON1: {

				for (Block block : world.blocks) {

					if (block.position.x == x5 && block.position.y == y5) {

						world.blocks.remove(block);
						
						break;
					}
				}
					
				break;
			}

			case MouseEvent.BUTTON3: {

				switch (selectedBlock) {	

					case 1: {

						for (Block block : world.blocks) {

							if (block.position.x == x5 && block.position.y == y5) {

								world.blocks.remove(block);
						
								break;
							}
						}
	
						world.blocks.add(new Dirt(new Position(x5, y5)));

						break;
					}

					case 2: {

						for (Block block : world.blocks) {

							if (block.position.x == x5 && block.position.y == y5) {

								world.blocks.remove(block);
						
								break;
							}
						}

						world.blocks.add(new Stone(new Position(x5, y5)));

						break;
					}	

					case 3: {

						for (Block block : world.blocks) {

							if (block.position.x == x5 && block.position.y == y5) {

								world.blocks.remove(block);
						
								break;
							}
						}

						world.blocks.add(new Sand(new Position(x5, y5)));

						break;
					}

					case 4: {

						for (Block block : world.blocks) {

							if (block.position.x == x5 && block.position.y == y5) {

								world.blocks.remove(block);
						
								break;
							}
						}

						world.blocks.add(new Metal(new Position(x5, y5)));

						break;
					}

					case 5: {

						for (Tile tile : world.tiles) {

							if (tile.position.x == x5 && tile.position.y == y5) {

								world.tiles.remove(tile);
								
								break;
							}
						}

						world.tiles.add(new WoodFloor(new Position(x5, y5)));

						break;
					}

					case 6: {

						for (Tile tile : world.tiles) {

							if (tile.position.x == x5 && tile.position.y == y5) {

								world.tiles.remove(tile);
								
								break;
							}
						}

						world.tiles.add(new Grass(new Position(x5, y5)));

						break;
					}
				}

				break;
			}
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

	public void run() {

		while (gameThread != null) {

			if (isWPressed) {

				player.position.y += 1;

				for (Block block : world.blocks) {

					if (player.isOverlapping(block)) {
			
						player.position.y -= 1;
		
						break;
					}
				}
			}

			if (isSPressed) {

				player.position.y -= 1;

				for (Block block : world.blocks) {

					if (player.isOverlapping(block)) {
			
						player.position.y += 1;
		
						break;
					}
				}
			}

			if (isDPressed) {

				player.position.x += 1;

				for (Block block : world.blocks) {

					if (player.isOverlapping(block)) {
			
						player.position.x -= 1;
		
						break;
					}
				}
			}

			if (isAPressed) {

				player.position.x -= 1;

				for (Block block : world.blocks) {

					if (player.isOverlapping(block)) {
			
						player.position.x += 1;
		
						break;
					}
				}
			}
			
			repaint();	
			
			try {
				gameThread.sleep(10);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}