package com.agical.simwar.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.agical.simwar.gui.ScoreBoardListener;


public class TestScoreBoard {

	boolean success = false;

	@Test
	public void reportsResultToScoreBoardListeners() {
		ScoreBoard scoreBoard = new ScoreBoard();

		ScoreBoardListener scoreBoardListener = new ScoreBoardListener() {
			public void reportScore(String result) {
				success = true;
			}
		};

		scoreBoard.addListener(scoreBoardListener);
		scoreBoard.write("");

		assertEquals(success, true);
	}

}
