package com.jonnypower.ridethebus.strategy;

import com.jonnypower.ridethebus.answers.*;
import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.Question;

import java.util.List;

public abstract class Strategy {

  public Answerable ask(Question question, List<Card> playedCards) {
    switch (question) {
      default:
        return oddOrEven(playedCards);
      case HIGHER_OR_LOWER:
        return higherOrLower(playedCards);
      case RED_OR_BLACK:
        return redOrBlack(playedCards);
      case SAME_OR_DIFFERENT_SUIT:
        return sameOrDifferentSuit(playedCards);
      case WHICH_SUIT:
        return whichSuit(playedCards);
    }
  }

  protected abstract OddOrEvenAnswer oddOrEven(List<Card> playedCards);

  protected abstract HigherOrLowerAnswer higherOrLower(List<Card> playedCards);

  protected abstract RedOrBlackAnswer redOrBlack(List<Card> playedCards);

  protected abstract SameOrDifferentSuitAnswer sameOrDifferentSuit(List<Card> playedCards);

  protected abstract WhichSuitAnswer whichSuit(List<Card> playedCards);

}
