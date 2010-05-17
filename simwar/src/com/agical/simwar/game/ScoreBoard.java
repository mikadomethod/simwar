package com.agical.simwar.game;

import java.util.ArrayList;
import java.util.List;

import com.agical.simwar.gui.ScoreBoardListener;

public class ScoreBoard {

	private String result = "No result";

	private final List<ScoreBoardListener> listeners = new ArrayList<ScoreBoardListener>();

	public String getResult() {
		return result;
	}

	public void write(String result) {
		this.result = result;
		for (ScoreBoardListener scoreBoardListener : listeners) {
			scoreBoardListener.reportScore(result);
		}
	}

	public void addListener(ScoreBoardListener scoreBoardListener) {
		listeners.add(scoreBoardListener);
	}
}
