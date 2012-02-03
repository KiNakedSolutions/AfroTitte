package com.kinakedsolutions.afrotitte;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.kinakedsolutions.afrotitte.loveobjects.FemaleLOFactory;
import com.kinakedsolutions.afrotitte.loveobjects.LoveObject;


public class ATApplication {
	
	public UserTracker viewer;
	private boolean shouldRun = true;
	private JFrame mainFrame;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame atFrame = new JFrame("AfroTitte Prototype");
        atFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	System.exit(0);
            }
        });
        
        ATApplication app = new ATApplication(atFrame);
        
        app.viewer = new UserTracker();
        atFrame.add("Center", app.viewer);
        atFrame.pack();
        atFrame.setVisible(true);
        
        // just for fun, not the intended usage
        FemaleLOFactory x = new FemaleLOFactory();
        LoveObject lo = x.getRandomLoveObject();
        
        System.out.println("today you swing your hips at " + lo + " !");
        
        app.run();
	}
	


    public ATApplication (JFrame frame) {
    	this.mainFrame = frame;
    	frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {}
			@Override
			public void keyReleased(KeyEvent ke) {}
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					shouldRun = false;
				}
			}
		});
    }
    
    void run()
    {
        while(shouldRun) {
            viewer.updateDepth();
            viewer.repaint();
        }
        mainFrame.dispose();
    }

}
