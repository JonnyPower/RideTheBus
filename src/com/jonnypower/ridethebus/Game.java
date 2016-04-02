package com.jonnypower.ridethebus;

import com.jonnypower.ridethebus.answers.Answerable;
import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import com.jonnypower.ridethebus.domain.GameResult;
import com.jonnypower.ridethebus.domain.Question;
import com.jonnypower.ridethebus.exception.GameStateInvalidException;
import com.jonnypower.ridethebus.strategy.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

  // ===============================================================
  // ATTRIBUTES
  // ===============================================================

  private static final List<Question> QUESTIONS = new ArrayList<Question>(Arrays.asList(Question.ODD_OR_EVEN, Question.HIGHER_OR_LOWER, Question.RED_OR_BLACK, Question.SAME_OR_DIFFERENT_SUIT, Question.WHICH_SUIT));

  private final List<Card> deadPile;
  private final List<Card> hand;
  private final List<Card> deck;

  private final Strategy strategy;

  // ===============================================================
  // CONSTRUCTORS
  // ===============================================================

  public Game(List<Card> startingDeck, Strategy strategy) {
    this.deadPile = new ArrayList<Card>();
    this.hand = new ArrayList<Card>();
    this.deck = startingDeck;
    this.strategy = strategy;
  }

  // ===============================================================
  // PUBLIC METHODS
  // ===============================================================

  public GameResult play() {
    if (!canPlay()) {
      throw new GameStateInvalidException();
    }

    // Game loop
    int rounds = 1;
    while (true) {
      //System.out.println("========== Round "+rounds+" ==========");

      Card previousCard = null;
      Card currentCard;
      boolean playerWonHand = true;
      for (Question question : QUESTIONS) {
        final ArrayList<Card> playedCards = playedCards();
        currentCard = takeCardFromDeckToHand();
        if (deck.isEmpty()) {
          return GameResult.DECK_FINISHED;
        }

        //System.out.println("deck: " + deck);
        //System.out.println("deadPile: " + deadPile);
        //System.out.println("hand: " + hand);

        if (currentCard.getValue() == CardValue.JOKER) {
          return GameResult.JOKER;
        }

        //System.out.println("Asking " + question + " (playedCards: "+ playedCards +")");
        Answerable answer = strategy.ask(question, playedCards);
        //System.out.println("Answer: " + answer);
        //System.out.println("previousCard: " + previousCard + ", currentCard: " + currentCard);
        boolean correct = answer.isCorrect(previousCard, currentCard);
        //System.out.println("correct: " + (correct ? "Yes" : "No") );
        if (!correct) {
          playerWonHand = false;
          deadPile.addAll(hand);
          hand.clear();
          break;
        } else if (question == Question.WHICH_SUIT) {
          return GameResult.PLAYER_WINS;
        }

        previousCard = currentCard;
      }

      //System.out.println("=============================");
      rounds++;
    }

  }

  // ===============================================================
  // PRIVATE METHODS
  // ===============================================================

  private ArrayList<Card> playedCards() {
    final ArrayList<Card> playedCards = new ArrayList<Card>(deadPile.size() + hand.size());
    playedCards.addAll(deadPile);
    playedCards.addAll(hand);
    return playedCards;
  }

  private Card takeCardFromDeckToHand() {
    final Card latest = deck.remove(0);
    hand.add(latest);
    return latest;
  }

  private boolean canPlay() {
    if (deck.size() == 56 && hand.size() == 0 && deadPile.size() == 0) {
      return true;
    }
    return false;
  }

}
