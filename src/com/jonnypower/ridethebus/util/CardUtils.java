package com.jonnypower.ridethebus.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardSuit;
import com.jonnypower.ridethebus.domain.CardValue;

public class CardUtils {

	public CardUtils() {
		throw new UnsupportedOperationException("This is a static util class and shouldn't be instantiated");
	}

	public static Card diamonds(CardValue cardValue) {
		return new Card(CardSuit.DIAMONDS, cardValue);
	}

	public static Card hearts(CardValue cardValue) {
		return new Card(CardSuit.HEARTS, cardValue);
	}

	public static Card clubs(CardValue cardValue) {
		return new Card(CardSuit.CLUBS, cardValue);
	}

	public static Card spades(CardValue cardValue) {
		return new Card(CardSuit.SPADES, cardValue);
	}

	public static List<Card> getDeck() {
		final List<Card> deck = new ArrayList<Card>();
		for(CardSuit suit : CardSuit.values()) {
			for(CardValue value : CardValue.values()) {
				deck.add(new Card(suit, value));
			}
		}
		return deck;
	}
	
	public static List<Card> getShuffledDeck() {
		final List<Card> deck = getDeck();
		Collections.shuffle(deck);
		return deck;
	}
	
}
