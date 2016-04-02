package com.jonnypower.ridethebus.answers;

import com.jonnypower.ridethebus.domain.Card;
import com.jonnypower.ridethebus.domain.CardValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jonnypower.ridethebus.util.CardUtils.clubs;
import static com.jonnypower.ridethebus.util.CardUtils.hearts;
import static org.testng.Assert.assertEquals;

public class SameOrDifferentSuitAnswerTests extends AnswerableTests {

  @DataProvider
  public Object[][] testCorrect() {
    return new Object[][] {
        new Object[] {SameOrDifferentSuitAnswer.DIFFERENT, clubs(CardValue.ACE), clubs(CardValue.FOUR), false},
        new Object[] {SameOrDifferentSuitAnswer.SAME, clubs(CardValue.ACE), clubs(CardValue.FOUR), true},
        new Object[] {SameOrDifferentSuitAnswer.DIFFERENT, clubs(CardValue.ACE), hearts(CardValue.FOUR), true},
        new Object[] {SameOrDifferentSuitAnswer.SAME, clubs(CardValue.ACE), hearts(CardValue.FOUR), false},
    };
  }

  @Test(dataProvider = "testCorrect")
  public void testCorrect(SameOrDifferentSuitAnswer sameOrDifferentSuitAnswer, Card previous, Card current, boolean expected) {
    super.testCorrect(sameOrDifferentSuitAnswer, previous, current, expected);
  }

}
