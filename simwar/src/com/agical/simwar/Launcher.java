package com.agical.simwar;

import javax.swing.JFrame;

import com.agical.simwar.gui.GameFrame;

public class Launcher {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		GameFrame frame = new GameFrame();
		frame.setVisible(true);
	}
}
