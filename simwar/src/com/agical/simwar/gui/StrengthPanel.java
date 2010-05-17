package com.agical.simwar.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StrengthPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public StrengthPanel(final PlayerController controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setName("StrengthPanel");
		final JLabel calculatedAttackRating = new JLabel("0");

		final JLabel calculatedDefenseRating = new JLabel("0");

		JButton updateButton = new JButton("Update");
		PanelHelper helper = new PanelHelper(this);
		helper.addRow("Total defense", calculatedDefenseRating, "Total offense", calculatedAttackRating);
		helper.addRow("", updateButton);

		calculatedAttackRating.setName("AttackRating");
		calculatedDefenseRating.setName("DefenseRating");

		updateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.getPlayer().reportAttackRatingTo(calculatedAttackRating);
				controller.getPlayer().reportDefenseRatingTo(calculatedDefenseRating);

			}
		});

		add(updateButton);
	}

}
