package com.jonnypower.ridethebus;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardSuit;
import com.jonnypower.ridethebus.domain.CardValue;
import com.jonnypower.ridethebus.domain.GameResult;
import com.jonnypower.ridethebus.strategy.PredictableTestStrategy;
import com.jonnypower.ridethebus.util.CardUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GameTests {

  private final static List<Card> predictableWinCards = Collections.unmodifiableList(
      new ArrayList<Card>(
          Arrays.asList(
              new Card(CardSuit.DIAMONDS, CardValue.FOUR),
              new Card(CardSuit.DIAMONDS, CardValue.NINE),
              new Card(CardSuit.DIAMONDS, CardValue.TEN),
              new Card(CardSuit.DIAMONDS, CardValue.JACK),
              new Card(CardSuit.DIAMONDS, CardValue.KING)
          )
      )
  );

  private final static List<Card> prefictableJokerCards = Collections.unmodifiableList(
      new ArrayList<Card>(
          Arrays.asList(
              new Card(CardSuit.DIAMONDS, CardValue.JOKER)
          )
      )
  );

  @Test
  public void testPlayerWin() {
    final Game game = new Game(deckWithPrepend(predictableWinCards), new PredictableTestStrategy());
    assertEquals(game.play(), GameResult.PLAYER_WINS);
  }

  @Test
  public void testJoker() {
    final Game game = new Game(deckWithPrepend(prefictableJokerCards), new PredictableTestStrategy());
    assertEquals(game.play(), GameResult.JOKER);
  }

  private static List<Card> deckWithPrepend(List<Card> prepend) {

    final List<Card> deck = CardUtils.getDeck();
    deck.removeAll(prepend);

    final List<Card> startingDeck = new ArrayList<Card>();
    startingDeck.addAll(prepend);
    startingDeck.addAll(deck);

    return startingDeck;
  }

}
