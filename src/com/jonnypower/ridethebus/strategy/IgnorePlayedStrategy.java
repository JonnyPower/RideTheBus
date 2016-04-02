package com.jonnypower.ridethebus.strategy;

import com.jonnypower.ridethebus.answers.*;
import com.jonnypower.ridethebus.domain.Card;

import java.util.List;
import java.util.Random;

public class IgnorePlayedStrategy extends Strategy {

  private final Random random = new Random();

  @Override
  protected OddOrEvenAnswer oddOrEven(List<Card> playedCards) {
    return random.nextBoolean() ? OddOrEvenAnswer.ODD : OddOrEvenAnswer.EVEN;
  }

  @Override
  protected HigherOrLowerAnswer higherOrLower(List<Card> playedCards) {
    return random.nextBoolean() ? HigherOrLowerAnswer.HIGHER : HigherOrLowerAnswer.LOWER;
  }

  @Override
  protected RedOrBlackAnswer redOrBlack(List<Card> playedCards) {
    return random.nextBoolean() ? RedOrBlackAnswer.RED : RedOrBlackAnswer.BLACK;
  }

  @Override
  protected SameOrDifferentSuitAnswer sameOrDifferentSuit(List<Card> playedCards) {
    return SameOrDifferentSuitAnswer.DIFFERENT;
  }

  @Override
  protected WhichSuitAnswer whichSuit(List<Card> playedCards) {
    return WhichSuitAnswer.HEARTS;
  }
}
