package com.agical.simwar.gui;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.Test;
import org.uispec4j.Panel;
import org.uispec4j.assertion.UISpecAssert;

import com.agical.simwar.game.ScoreBoard;


public class TestResultPanel {

	@Test
	public void battleSimulationResultsAreReportedToThisPanel() {
		ScoreBoard scoreBoard = new ScoreBoard();

		JLabel label = new JLabel();
		ResultPanel resultPanel = new ResultPanel(label, new JButton());
		scoreBoard.addListener(resultPanel);

		Panel panel = new Panel(resultPanel);
		scoreBoard.write("You won");
		UISpecAssert.assertTrue(panel.containsLabel("You won"));
	}
}
