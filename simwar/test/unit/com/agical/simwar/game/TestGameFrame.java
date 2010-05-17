package com.agical.simwar.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uispec4j.Panel;
import org.uispec4j.assertion.UISpecAssert;

import com.agical.simwar.gui.GameFrame;

public class TestGameFrame {

	GameFrame frame = new GameFrame();

	public void gameContainsCombatPanel() {
		Panel panel = new Panel(frame);
		UISpecAssert.assertTrue(panel.getPanel("CombatPanel").isVisible());
	}

	@Test
	public void frameTitleReflectsVersionAndApplicationName() {
		assertEquals("SimWar 0.2", frame.getTitle());
	}
}
