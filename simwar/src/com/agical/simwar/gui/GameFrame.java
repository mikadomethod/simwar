package com.agical.simwar.gui;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("SimWar 0.2");
		URL resource = Thread.currentThread().getContextClassLoader().getResource("images/war.png");
		setIconImage(new ImageIcon(resource).getImage());
		add(new CombatPanel());
		pack();
		setSize(750, 500);
	}
}