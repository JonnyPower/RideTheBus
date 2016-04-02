package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardSuit;

public enum WhichSuitAnswer implements Answerable {
  DIAMONDS(CardSuit.DIAMONDS),
  HEARTS(CardSuit.HEARTS),
  CLUBS(CardSuit.CLUBS),
  SPADES(CardSuit.SPADES);

  private final CardSuit equivilantCardSuit;

  WhichSuitAnswer(CardSuit equivilantCardSuit) {
    this.equivilantCardSuit = equivilantCardSuit;
  }

  @Override
  public boolean isCorrect(Card previousCard, Card currentCard) {
    return currentCard.getSuit() == equivilantCardSuit;
  }

}
