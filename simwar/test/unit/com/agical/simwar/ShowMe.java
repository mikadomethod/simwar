package com.agical.simwar;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ShowMe {

	JFrame frame = new JFrame();

	private int length = 1;

	private int width = 400;

	private int height = 300;

	private int duration;

	private boolean interrupted;

	public ShowMe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
	}

	public ShowMe a(JComponent panel) {
		frame.add(panel);
		frame.setTitle("Testing: " + panel.getClass().toString());
		return this;
	}

	public ShowMe in800x600() {
		frame.setSize(800, 600);
		return this;
	}

	public ShowMe in1024x768() {
		frame.setSize(1024, 768);
		return this;
	}

	public void untilExit() {
		duration = 1000000000;

		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		JMenuItem menuItem = new JMenuItem(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				interrupted = true;
			}
		});
		menuItem.setText("Exit");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.ALT_DOWN_MASK));
		menu.add(menuItem);
		menubar.add(menu);
		frame.setJMenuBar(menubar);
		show();
	}

	public ShowMe forAbout(int length) {
		this.length = length;
		return this;
	}

	public void seconds() {
		duration = length * 1000;
		show();
	}

	private void show() {
		frame.setVisible(true);
		int timeLeft = duration;
		while (!interrupted || timeLeft < 1) {
			try {
				Thread.sleep(100);
				duration -= 100;
			} catch (InterruptedException e) {
			}
		}
	}
}
