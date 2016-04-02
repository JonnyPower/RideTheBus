package com.jonnypower.ridethebus;

import com.jonnypower.ridethebus.domain.GameResult;
import com.jonnypower.ridethebus.strategy.CardCountingStrategy;
import com.jonnypower.ridethebus.strategy.IgnorePlayedStrategy;
import com.jonnypower.ridethebus.strategy.Strategy;
import com.jonnypower.ridethebus.util.CardUtils;

public class Simulation {

	private static final int SIMULATION_COUNT = 1000000;

	public static void main(String[] args) {
    System.out.println("Win percent for IgnorePlayedStrategy: " + winPercent(new IgnorePlayedStrategy()));
    System.out.println("Win percent for CardCountingStrategy: " + winPercent(new CardCountingStrategy()));
	}

  public static float winPercent(Strategy startegy) {
    int playerWins = 0;
    for (int i = 0; i < SIMULATION_COUNT; i++) {
      final Game game = new Game(CardUtils.getShuffledDeck(), startegy);
      final GameResult result = game.play();
      if(result == GameResult.PLAYER_WINS) {
        playerWins++;
      }
    }
    System.out.println("player wins: "+playerWins);
    return (playerWins * 100.0f) / SIMULATION_COUNT;
  }

}
