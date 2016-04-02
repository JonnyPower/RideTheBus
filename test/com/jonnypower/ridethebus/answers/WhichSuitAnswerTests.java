package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jonnypower.ridethebus.util.CardUtils.*;

public class WhichSuitAnswerTests extends AnswerableTests {

  @DataProvider
  public Object[][] testCorrect() {
    return new Object[][] {
        new Object[]{WhichSuitAnswer.HEARTS, hearts(CardValue.ACE), true},
        new Object[]{WhichSuitAnswer.CLUBS, hearts(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.DIAMONDS, hearts(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.SPADES, hearts(CardValue.ACE), false},

        new Object[]{WhichSuitAnswer.HEARTS, clubs(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.CLUBS, clubs(CardValue.ACE), true},
        new Object[]{WhichSuitAnswer.DIAMONDS, clubs(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.SPADES, clubs(CardValue.ACE), false},

        new Object[]{WhichSuitAnswer.HEARTS, diamonds(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.CLUBS, diamonds(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.DIAMONDS, diamonds(CardValue.ACE), true},
        new Object[]{WhichSuitAnswer.SPADES, diamonds(CardValue.ACE), false},

        new Object[]{WhichSuitAnswer.HEARTS, spades(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.CLUBS, spades(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.DIAMONDS, spades(CardValue.ACE), false},
        new Object[]{WhichSuitAnswer.SPADES, spades(CardValue.ACE), true},
    };
  }

  @Test(dataProvider = "testCorrect")
  public void testCorrect(WhichSuitAnswer whichSuitAnswer, Card current, boolean expected) {
    super.testCorrect(whichSuitAnswer, null, current, expected);
  }

}
