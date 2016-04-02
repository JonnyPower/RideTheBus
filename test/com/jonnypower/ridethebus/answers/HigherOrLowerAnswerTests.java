package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jonnypower.ridethebus.util.CardUtils.clubs;
import static org.testng.Assert.assertEquals;

public class HigherOrLowerAnswerTests extends AnswerableTests {

  @DataProvider
  public Object[][] testCorrect() {
    return new Object[][]{
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.ACE), clubs(CardValue.TWO), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.TWO), clubs(CardValue.THREE), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.THREE), clubs(CardValue.FOUR), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.FOUR), clubs(CardValue.FIVE), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.FIVE), clubs(CardValue.SIX), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.SIX), clubs(CardValue.SEVEN), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.SEVEN), clubs(CardValue.EIGHT), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.EIGHT), clubs(CardValue.NINE), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.NINE), clubs(CardValue.TEN), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.TEN), clubs(CardValue.JACK), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.JACK), clubs(CardValue.QUEEN), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.QUEEN), clubs(CardValue.KING), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.ACE), clubs(CardValue.KING), true},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.KING), clubs(CardValue.ACE), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.TWO), clubs(CardValue.ACE), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.THREE), clubs(CardValue.TWO), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.FOUR), clubs(CardValue.THREE), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.FIVE), clubs(CardValue.FOUR), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.SIX), clubs(CardValue.FIVE), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.SEVEN), clubs(CardValue.SIX), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.EIGHT), clubs(CardValue.SEVEN), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.NINE), clubs(CardValue.EIGHT), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.TEN), clubs(CardValue.NINE), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.JACK), clubs(CardValue.TEN), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.QUEEN), clubs(CardValue.JACK), false},

        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.ACE), clubs(CardValue.TWO), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.TWO), clubs(CardValue.THREE), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.THREE), clubs(CardValue.FOUR), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.FOUR), clubs(CardValue.FIVE), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.FIVE), clubs(CardValue.SIX), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.SIX), clubs(CardValue.SEVEN), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.SEVEN), clubs(CardValue.EIGHT), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.EIGHT), clubs(CardValue.NINE), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.NINE), clubs(CardValue.TEN), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.TEN), clubs(CardValue.JACK), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.JACK), clubs(CardValue.QUEEN), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.QUEEN), clubs(CardValue.KING), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.ACE), clubs(CardValue.KING), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.KING), clubs(CardValue.ACE), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.TWO), clubs(CardValue.ACE), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.THREE), clubs(CardValue.TWO), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.FOUR), clubs(CardValue.THREE), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.FIVE), clubs(CardValue.FOUR), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.SIX), clubs(CardValue.FIVE), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.SEVEN), clubs(CardValue.SIX), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.EIGHT), clubs(CardValue.SEVEN), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.NINE), clubs(CardValue.EIGHT), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.TEN), clubs(CardValue.NINE), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.JACK), clubs(CardValue.TEN), true},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.QUEEN), clubs(CardValue.JACK), true},

        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.FOUR), clubs(CardValue.FOUR), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.FOUR), clubs(CardValue.FOUR), false},
        new Object[] {HigherOrLowerAnswer.HIGHER, clubs(CardValue.QUEEN), clubs(CardValue.QUEEN), false},
        new Object[] {HigherOrLowerAnswer.LOWER, clubs(CardValue.QUEEN), clubs(CardValue.QUEEN), false},
    };
  }

  @Test(dataProvider = "testCorrect")
  public void testCorrect(HigherOrLowerAnswer higherOrLowerAnswer, Card previous, Card current, boolean expected) {
    super.testCorrect(higherOrLowerAnswer, previous, current, expected);
  }

}
