package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

public enum SameOrDifferentSuitAnswer implements Answerable {
  SAME,
  DIFFERENT;

  @Override
  public boolean isCorrect(Card previousCard, Card currentCard) {
    return (this == SAME && previousCard.getSuit() == currentCard.getSuit()) || (this == DIFFERENT && previousCard.getSuit() != currentCard.getSuit());
  }
}
