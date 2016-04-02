package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

public enum RedOrBlackAnswer implements Answerable {
  RED,
  BLACK;

  @Override
  public boolean isCorrect(Card previousCard, Card currentCard) {
    return (this == RED && currentCard.isRed()) || (this == BLACK && currentCard.isBlack());
  }
}
