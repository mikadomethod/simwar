package com.agical.simwar.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.agical.simwar.game.Game;
import com.agical.simwar.game.ScoreBoard;

public class CombatPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CombatPanel() {
		ScoreBoard scoreBoard = new ScoreBoard();
		Game game = new Game(scoreBoard);

		setName("CombatPanel");
		setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		PlayerController player1Controller = new PlayerController("P1");
		PlayerController player2Controller = new PlayerController("P2");
		PlayerPanel playerPanel1 = new PlayerPanel("P1", player1Controller, game);
		PlayerPanel playerPanel2 = new PlayerPanel("P2", player2Controller, game);

		JLabel label = new JLabel("Click simulate for result");
		label.setName("Results");
		JButton button = new JButton("Simulate");
		button.setMnemonic(KeyEvent.VK_S);

		ResultPanel resultPanel = new ResultPanel(label, button);
		scoreBoard.addListener(resultPanel);
		button.addActionListener(new BattleActionListener(game, player1Controller, player2Controller));

		centerPanel.add(playerPanel1, BorderLayout.EAST);
		centerPanel.add(playerPanel2, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.NORTH);
	}

}
