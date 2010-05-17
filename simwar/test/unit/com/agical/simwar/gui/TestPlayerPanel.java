package com.agical.simwar.gui;

import static org.junit.Assert.assertEquals;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.uispec4j.ComboBox;
import org.uispec4j.Panel;
import org.uispec4j.TextBox;
import org.uispec4j.assertion.UISpecAssert;

import com.agical.simwar.combatant.WizardCombatant;
import com.agical.simwar.game.Army;
import com.agical.simwar.game.Game;
import com.agical.simwar.game.ScoreBoard;
import com.agical.simwar.player.Player;
import com.agical.simwar.player.Stats;

public class TestPlayerPanel {

	private Panel panel;

	private PlayerController playerController;

	private final static String playerName = "P1";

	private JComponent playerPanel;

	@Before
	public void setUp() {
		playerController = new PlayerController(playerName);
		Game game = new Game(new ScoreBoard());
		playerPanel = new PlayerPanel(playerName, playerController, game);
		panel = new Panel(playerPanel);
	}

	@Ignore
	@Test
	public void userCanSelectPlayerType() {
		ComboBox listBox = panel.getComboBox("PlayerType");
		String[] strings = new String[] { "Visionary", "General", "Warmonger", "Mogul", "Wizard", "Slayer", "Necromancer", "Automator" };
		UISpecAssert.assertTrue(listBox.contentEquals(strings));
	}

	@Test
	public void isEasyToDistinguish() {
		assertEquals(((TitledBorder) playerPanel.getBorder()).getTitle(), BorderFactory.createTitledBorder("Player: P1").getTitle());
	}

	@Test
	public void firstCombatantAddedIsDefaultSelection() {
		ComboBox listBox = panel.getComboBox("PlayerType");
		UISpecAssert.assertTrue(listBox.selectionEquals("Wizard"));
	}

	@Test
	public void userCanSpecifyAmountOfSoldiers() {
		TextBox inputTextBox = panel.getInputTextBox("Soldiers");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void userCanSpecifyAmountOfKnights() {
		TextBox inputTextBox = panel.getInputTextBox("Knights");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void userCanSpecifyAmountOfPikemen() {
		TextBox inputTextBox = panel.getInputTextBox("Pikemen");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void userCanSpecifyAmountOfElites() {
		TextBox inputTextBox = panel.getInputTextBox("Elites");
		assertEquals("0", inputTextBox.getText());
	}

	@Test
	public void combatantsStatsAreSpecifiedByTheUser() {
		panel.getInputTextBox("Soldiers").setText("100");
		panel.getInputTextBox("Knights").setText("100");
		panel.getInputTextBox("Pikemen").setText("100");
		panel.getInputTextBox("Elites").setText("100");

		panel.getInputTextBox("Attackrating").setText("100");
		panel.getInputTextBox("Defenserating").setText("100");
		panel.getInputTextBox("Training Grounds").setText("100");
		panel.getInputTextBox("Forts").setText("100");

		Player player = new Player("P1", new Army(100, 100, 100, 100), new Stats(100, 100, 100, 100), new WizardCombatant());
		assertEquals(player, playerController.getPlayer());
	}

	@Test
	public void canBeNamed() {
		String panelName = "PlayerPanel" + playerName;
		assertEquals(panel.getName(), panelName);

	}

	@Test
	public void calculatedAttackAndDefenseIsShownToUser() {
		UISpecAssert.assertTrue(panel.getPanel("StrengthPanel").isVisible());
	}
}
