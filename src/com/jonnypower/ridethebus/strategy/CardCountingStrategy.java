package com.jonnypower.ridethebus.strategy;

import com.jonnypower.ridethebus.answers.*;
import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardSuitColor;
import com.jonnypower.ridethebus.util.CardUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CardCountingStrategy extends Strategy {

  // ===============================================================
  // IMPLEMENTATION OF Strategy
  // ===============================================================

  @Override
  protected OddOrEvenAnswer oddOrEven(List<Card> playedCards) {
    int oddCardCount = 0;
    int evenCardCount = 0;
    for(Card card : playedCards) {
      if (card.isEven()) {
        evenCardCount++;
      } else {
        oddCardCount++;
      }
    }

    if(oddCardCount > evenCardCount) {
      return OddOrEvenAnswer.EVEN;
    }
    return OddOrEvenAnswer.ODD;
  }

  @Override
  protected HigherOrLowerAnswer higherOrLower(List<Card> playedCards) {
    final Card lastPlayed = playedCards.remove(playedCards.size() - 1);

    final List<Card> remainingDeck = CardUtils.getDeck();
    remainingDeck.removeAll(playedCards);

    int higherCardCount = 0;
    int lowerCardCount = 0;
    for (Card card : remainingDeck) {
      if(card.getValue().asInt() > lastPlayed.getValue().asInt()) {
        higherCardCount++;
      } else if (card.getValue().asInt() < lastPlayed.getValue().asInt()) {
        lowerCardCount++;
      }
    }

    return higherCardCount > lowerCardCount ? HigherOrLowerAnswer.HIGHER : HigherOrLowerAnswer.LOWER;
  }

  @Override
  protected RedOrBlackAnswer redOrBlack(List<Card> playedCards) {
    int redCardCount = 0;
    int blackCardCount = 0;
    for(Card card : playedCards) {
      if (card.isRed()) {
        redCardCount++;
      } else {
        blackCardCount++;
      }
    }

    if (redCardCount > blackCardCount) {
      return RedOrBlackAnswer.BLACK;
    }
    return RedOrBlackAnswer.RED;
  }

  @Override
  protected SameOrDifferentSuitAnswer sameOrDifferentSuit(List<Card> playedCards) {
    final Card lastPlayed = playedCards.remove(playedCards.size() - 1);

    final List<Card> remainingDeck = CardUtils.getDeck();
    remainingDeck.removeAll(playedCards);
    remainingDeck.remove(lastPlayed);

    int sameSuitCount = 0;
    int diffSuitCount = 0;
    for (Card card : remainingDeck) {
      if(card.getSuit() == lastPlayed.getSuit()) {
        sameSuitCount++;
      } else {
        diffSuitCount++;
      }
    }

    return sameSuitCount > diffSuitCount ? SameOrDifferentSuitAnswer.SAME : SameOrDifferentSuitAnswer.DIFFERENT;
  }

  @Override
  protected WhichSuitAnswer whichSuit(List<Card> playedCards) {

    int diamondSuitCount = 0;
    int heartSuitCount = 0;
    int clubSuitCount = 0;
    int spadeSuitCount = 0;
    for (Card card : playedCards) {
      switch (card.getSuit()) {
        case CLUBS:
          clubSuitCount++;
          break;
        case HEARTS:
          heartSuitCount++;
          break;
        case SPADES:
          spadeSuitCount++;
          break;
        case DIAMONDS:
          diamondSuitCount++;
          break;
      }
    }

    if(diamondSuitCount <= heartSuitCount && diamondSuitCount <= clubSuitCount && diamondSuitCount <= spadeSuitCount) {
      return WhichSuitAnswer.DIAMONDS;
    } else if (heartSuitCount <= diamondSuitCount && heartSuitCount <= clubSuitCount && heartSuitCount <= spadeSuitCount) {
      return WhichSuitAnswer.HEARTS;
    } else if (clubSuitCount <= diamondSuitCount && clubSuitCount <= heartSuitCount && clubSuitCount <= spadeSuitCount) {
      return WhichSuitAnswer.CLUBS;
    }
    return WhichSuitAnswer.SPADES;
  }

}
