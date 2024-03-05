import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnValidatorTest
{
  private LuhnValidator luhnValidator;

  @Before
  public void setUp()
  {
    luhnValidator = new LuhnValidator();
  }

  @Test
  public void testSingleDigitStringInvalid()
  {
    assertFalse( LuhnValidator.isValid( "1" ) );
  }

  @Test
  public void testSingleZeroIsInvalid()
  {
    assertFalse( LuhnValidator.isValid( "0" ) );
  }

  @Test
  public void testSimpleValidSINReversedRemainsValid()
  {
    assertTrue( LuhnValidator.isValid( "059" ) );
  }

  @Test
  public void testSimpleValidSINReversedBecomesInvalid()
  {
    assertTrue( LuhnValidator.isValid( "59" ) );
  }

  @Test
  public void testValidCanadianSINValid()
  {
    assertTrue( LuhnValidator.isValid( "055 444 285" ) );
  }

  @Test
  public void testInvalidCanadianSINInvalid()
  {
    assertFalse( LuhnValidator.isValid( "055 444 286" ) );
  }

  @Test
  public void testInvalidCreditCardInvalid()
  {
    assertFalse( LuhnValidator.isValid( "8273 1232 7352 0569" ) );
  }

  @Test
  public void testInvalidLongNumberWithAnEvenRemainder()
  {
    assertFalse( LuhnValidator.isValid( "1 2345 6789 1234 5678 9012" ) );
  }

  @Test
  public void testValidNumberWithAnEvenNumberOfDigits()
  {
    assertTrue( LuhnValidator.isValid( "095 245 88" ) );
  }

  @Test
  public void testValidNumberWithAnOddNumberOfSpaces()
  {
    assertTrue( LuhnValidator.isValid( "234 567 891 234" ) );
  }

  @Test
  public void testValidStringsWithANonDigitAtEndInvalid()
  {
    assertFalse( LuhnValidator.isValid( "059a" ) );
  }

  @Test
  public void testStringContainingPunctuationInvalid()
  {
    assertFalse( LuhnValidator.isValid( "055-444-285" ) );
  }

  @Test
  public void testStringContainingSymbolsInvalid()
  {
    assertFalse( LuhnValidator.isValid( "055# 444$ 285" ) );
  }

  @Test
  public void testSingleSpaceWithZeroInvalid()
  {
    assertFalse( LuhnValidator.isValid( " 0" ) );
  }

  @Test
  public void testMoreThanSingleZeroValid()
  {
    assertTrue( LuhnValidator.isValid( "0000 0" ) );
  }

  @Test
  public void testDigitNineConvertedToOutputNine()
  {
    assertTrue( LuhnValidator.isValid( "091" ) );
  }


  @Test
  public void testUsingASCIIValueForNonDoubledNonDigitNotAllowed()
  {
    assertFalse( LuhnValidator.isValid( "055b 444 285" ) );
  }

  @Test
  public void testUsingASCIIValueForDoubledNonDigitNotAllowed()
  {
    assertFalse( LuhnValidator.isValid( ":9" ) );
  }

  /* The following test diverges from the canonical test data. This is because the corresponding canonical test does
   * not account for Java specific functions (such as Character.getNumericValue()), which can be part of incorrect yet
   * passing implementations. For more detail, check out issue #972 here:
   * (https://github.com/exercism/java/issues/972).
   */
  @Test
  public void testStringContainingSymbolsInvalidJavaTrackSpecific()
  {
    assertFalse( LuhnValidator.isValid( "85&" ) );
  }
}
