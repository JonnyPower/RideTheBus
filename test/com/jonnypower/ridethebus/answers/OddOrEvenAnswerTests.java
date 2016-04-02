package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jonnypower.ridethebus.util.CardUtils.clubs;
import static org.testng.Assert.assertEquals;

public class OddOrEvenAnswerTests extends AnswerableTests {

  @DataProvider
  public Object[][] testCorrect() {
    return new Object[][] {
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.ACE), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.TWO), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.THREE), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.FOUR), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.FIVE), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.SIX), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.SEVEN), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.EIGHT), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.NINE), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.TEN), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.JACK), false},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.QUEEN), true},
        new Object[] {OddOrEvenAnswer.EVEN, clubs(CardValue.KING), false},

        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.ACE), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.TWO), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.THREE), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.FOUR), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.FIVE), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.SIX), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.SEVEN), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.EIGHT), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.NINE), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.TEN), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.JACK), true},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.QUEEN), false},
        new Object[] {OddOrEvenAnswer.ODD, clubs(CardValue.KING), true},
    };
  }

  @Test(dataProvider = "testCorrect")
  public void testCorrect(OddOrEvenAnswer oddOrEvenAnswer, Card current, boolean expected) {
    super.testCorrect(oddOrEvenAnswer, null, current, expected);
  }

}
