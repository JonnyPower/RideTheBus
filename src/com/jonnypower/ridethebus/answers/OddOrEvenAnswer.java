package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

public enum OddOrEvenAnswer implements Answerable {
  ODD,
  EVEN;

  @Override
  public boolean isCorrect(Card previousCard, Card currentCard) {
    return (this == ODD && currentCard.isOdd()) || (this == EVEN && currentCard.isEven());
  }
}
