package com.agical.simwar.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.agical.simwar.game.Game;

public class BattleActionListener implements ActionListener {

	private final Game battle;
	private final PlayerController controller1;
	private final PlayerController controller2;

	public BattleActionListener(Game battle, PlayerController controller1, PlayerController controller2) {
		this.battle = battle;
		this.controller1 = controller1;
		this.controller2 = controller2;

	}

	public void actionPerformed(ActionEvent e) {
		battle.simulate(controller1.getPlayer(), controller2.getPlayer());
	}

}
