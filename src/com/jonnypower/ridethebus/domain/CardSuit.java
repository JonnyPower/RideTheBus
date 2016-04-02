package com.jonnypower.ridethebus.domain;

public enum CardSuit {
	CLUBS(CardSuitColor.BLACK),
	HEARTS(CardSuitColor.RED),
	SPADES(CardSuitColor.BLACK),
	DIAMONDS(CardSuitColor.RED);
	
	private final CardSuitColor color;
	
	CardSuit(CardSuitColor color) {
		this.color = color;
	}

	public CardSuitColor getColor() {
		return color;
	}
}
