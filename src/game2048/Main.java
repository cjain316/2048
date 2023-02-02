package game2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//a
public class Main extends JPanel implements KeyListener, ActionListener {
	Grid grid = new Grid();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
	}
	
	public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(222, 197, 113));
        g.fillRect(0, 0, 1000, 1000);
        Graphics2D g2 = (Graphics2D) g;
        grid.paint(g);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getExtendedKeyCode() == 65) {
			grid.shiftLeft();
			update();
		}
		if (arg0.getExtendedKeyCode() == 87) {
			grid.shiftUp();
			update();
		}
		if (arg0.getExtendedKeyCode() == 83) {
			grid.shiftDown();
			update();
		}
		if (arg0.getExtendedKeyCode() == 68) {
			grid.shiftRight();
			update();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	Timer t;
    
    public Main() {
    	
        JFrame f = new JFrame("2048");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800);
        f.add(this);
        f.addKeyListener(this);
        f.setResizable(false);
        
        t = new Timer(60, this);
        t.start();
        f.setVisible(true);
        
       
        
    }
    
    private void update() {
    	grid.generateNew();
    }
    
    
    private boolean randomBool() {
    	int ran = (int)(Math.random()*2);
    	if (ran == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    protected Image getImage(String path) {

        Image tempImage = null;
        try {
            URL imageURL = Background.class.getResource(path);
            tempImage    = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {e.printStackTrace();}
        return tempImage;
    } 

}
