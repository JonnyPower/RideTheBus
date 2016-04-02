package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

public interface Answerable {

  public boolean isCorrect(Card previousCard, Card currentCard);

}
