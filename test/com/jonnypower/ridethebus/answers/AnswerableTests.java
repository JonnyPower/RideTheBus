package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;

import static org.testng.Assert.assertEquals;

public class AnswerableTests {

  public void testCorrect(Answerable answerable, Card previous, Card current, boolean expected) {
    assertEquals(answerable.isCorrect(previous, current), expected, "Answered: "+answerable+" for "+previous+" to "+current);
  }

}
