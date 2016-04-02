package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jonnypower.ridethebus.util.CardUtils.*;
import static org.testng.Assert.assertEquals;

public class RedOrBlackAnswerTests extends AnswerableTests {

  @DataProvider
  public Object[][] testCorrect() {
    return new Object[][] {
        new Object[]{RedOrBlackAnswer.BLACK, clubs(CardValue.ACE), true},
        new Object[]{RedOrBlackAnswer.RED, clubs(CardValue.ACE), false},
        new Object[]{RedOrBlackAnswer.BLACK, spades(CardValue.ACE), true},
        new Object[]{RedOrBlackAnswer.RED, spades(CardValue.ACE), false},
        new Object[]{RedOrBlackAnswer.BLACK, diamonds(CardValue.ACE), false},
        new Object[]{RedOrBlackAnswer.RED, diamonds(CardValue.ACE), true},
        new Object[]{RedOrBlackAnswer.BLACK, hearts(CardValue.ACE), false},
        new Object[]{RedOrBlackAnswer.RED, hearts(CardValue.ACE), true},
    };
  }

  @Test(dataProvider = "testCorrect")
  public void testCorrect(RedOrBlackAnswer redOrBlackAnswer, Card current, boolean expected) {
    super.testCorrect(redOrBlackAnswer, null, current, expected);
  }

}
