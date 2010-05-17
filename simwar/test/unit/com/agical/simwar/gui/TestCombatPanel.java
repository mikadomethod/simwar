package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uispec4j.Panel;
import org.uispec4j.TextBox;
import org.uispec4j.assertion.UISpecAssert;

public class TestCombatPanel {

	private Panel panel;

	private CombatPanel combatPanel;

	@Before
	public void setUp() {
		combatPanel = new CombatPanel();
		panel = new Panel(combatPanel);
	}

	@Test
	public void hasTwoPlayerPanels() {
		assertEquals(panel.getPanel("PlayerPanelP1").getName(), "PlayerPanelP1");
		assertEquals(panel.getPanel("PlayerPanelP2").getName(), "PlayerPanelP2");
	}

	@Test
	public void hasASimulateButton() {
		UISpecAssert.assertTrue(panel.getButton("Simulate").textEquals("Simulate"));
	}

	@Test
	public void usesInputTextFieldsToCreateBattleStats() {
		String panelNameP1 = "PlayerPanelP1";
		panel.getPanel(panelNameP1).getComboBox("PlayerType").select("Wizard");
		panel.getPanel(panelNameP1).getInputTextBox("Soldiers").setText("100");
		panel.getPanel(panelNameP1).getInputTextBox("Knights").setText("100");
		panel.getPanel(panelNameP1).getInputTextBox("Pikemen").setText("100");
		panel.getPanel(panelNameP1).getInputTextBox("Elites").setText("100");
		panel.getPanel(panelNameP1).getInputTextBox("Training Grounds").setText("100");
		panel.getPanel(panelNameP1).getInputTextBox("Forts").setText("100");

		String panelNameP2 = "PlayerPanelP2";
		panel.getPanel(panelNameP2).getComboBox("PlayerType").select("Wizard");
		panel.getPanel(panelNameP2).getInputTextBox("Soldiers").setText("100");
		panel.getPanel(panelNameP2).getInputTextBox("Knights").setText("100");
		panel.getPanel(panelNameP2).getInputTextBox("Pikemen").setText("100");
		panel.getPanel(panelNameP2).getInputTextBox("Elites").setText("100");
		panel.getPanel(panelNameP2).getInputTextBox("Training Grounds").setText("100");
		panel.getPanel(panelNameP2).getInputTextBox("Forts").setText("100");
	}

	@Test
	public void simulationsUpdatesResult() {
		panel.getButton("Simulate").click();

		TextBox textBox = panel.getTextBox("Results");
		UISpecAssert.assertTrue(textBox.textContains("Simulation winner is P1"));
	}
}
