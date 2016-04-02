package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

public enum HigherOrLowerAnswer implements Answerable {
  HIGHER,
  LOWER;

  @Override
  public boolean isCorrect(Card previousCard, Card currentCard) {
    return (this == HIGHER && currentCard.getValue().asInt() > previousCard.getValue().asInt()) || (this == LOWER && currentCard.getValue().asInt() < previousCard.getValue().asInt());
  }
}
