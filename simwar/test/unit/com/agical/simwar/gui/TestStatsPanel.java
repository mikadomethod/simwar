package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import org.junit.Before;
import org.junit.Test;
import org.uispec4j.Panel;
import org.uispec4j.TextBox;


public class TestStatsPanel {

	private Panel panel;

	private final static String panelName = "P1Stats";

	private PlayerController playerController;

	private StatsPanel statsPanel;

	@Before
	public void setUp() {
		playerController = new PlayerController("P1");
		statsPanel = new StatsPanel(panelName, playerController);
		panel = new Panel(statsPanel);
	}


	@Test
	public void userCanSpecifyTrainingGroundsPercentage() {
		TextBox inputTextBox = panel.getInputTextBox("Training Grounds");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void userCanSpecifyFortsPercentage() {
		TextBox inputTextBox = panel.getInputTextBox("Forts");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void isEasyToDistinguish() {
		assertEquals(((TitledBorder)statsPanel.getBorder()).getTitle(), BorderFactory.createTitledBorder("Stats").getTitle());
	}

	@Test
	public void userCanSpecifyAttackRating() {
		TextBox inputTextBox = panel.getInputTextBox("Attackrating");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void userCanSpecifyDefenseRating() {
		TextBox inputTextBox = panel.getInputTextBox("Defenserating");
		assertEquals("0", inputTextBox.getText());
	}


}
