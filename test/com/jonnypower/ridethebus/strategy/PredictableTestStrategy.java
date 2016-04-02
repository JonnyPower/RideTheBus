package com.jonnypower.ridethebus.strategy;

import com.jonnypower.ridethebus.answers.*;
import com.jonnypower.ridethebus.domain.Card;

import java.util.List;

public class PredictableTestStrategy extends Strategy {

  @Override
  protected OddOrEvenAnswer oddOrEven(List<Card> playedCards) {
    return OddOrEvenAnswer.EVEN;
  }

  @Override
  protected HigherOrLowerAnswer higherOrLower(List<Card> playedCards) {
    return HigherOrLowerAnswer.HIGHER;
  }

  @Override
  protected RedOrBlackAnswer redOrBlack(List<Card> playedCards) {
    return RedOrBlackAnswer.RED;
  }

  @Override
  protected SameOrDifferentSuitAnswer sameOrDifferentSuit(List<Card> playedCards) {
    return SameOrDifferentSuitAnswer.SAME;
  }

  @Override
  protected WhichSuitAnswer whichSuit(List<Card> playedCards) {
    return WhichSuitAnswer.DIAMONDS;
  }

}
