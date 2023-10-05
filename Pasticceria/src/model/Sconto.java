package model;

import java.util.Random;

public class Sconto {
	private double valoreSconto = 0;

	public Sconto() {
	}

	public double getSconto() {
		Random random = new Random();
		int scelta = random.nextInt(3);
		valoreSconto = 0;
		switch (scelta) {
		case 0:
			valoreSconto = 0.15;
			break;
		case 1:
			valoreSconto = 0.30;
			break;
		case 2:
			valoreSconto = 0.50;
			break;
		}
		return valoreSconto;
	}
}
