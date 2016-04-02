package com.jonnypower.ridethebus.domain;

public class Card {

	private final CardSuit suit;
	private final CardValue value;
	
	public Card(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}

	public CardValue getValue() {
		return value;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public boolean isRed() {
		return suit.getColor() == CardSuitColor.RED;
	}

	public boolean isBlack() {
		return suit.getColor() == CardSuitColor.BLACK;
	}
	
	public boolean isEven() {
		return value.asInt() % 2 == 0;
	}
	
	public boolean isOdd() {
		return !isEven();
	}

	public String toString() {
		return String.format("Card{%s OF %sS}", value.name(), suit.name());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			final Card card = (Card)obj;
			return card.getSuit() == suit && card.getValue() == value;
		}
		return false;
	}

}
