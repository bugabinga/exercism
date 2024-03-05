import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SayTest {

    private Say say = new Say();
    
    @Test
    public void zero() {
        assertThat( Say.say(0)).isEqualTo("zero");
    }
    
    @Test
    public void one() {
        assertThat( Say.say(1)).isEqualTo("one");
    }

    @Test
    public void fourteen() {
        assertThat( Say.say(14)).isEqualTo("fourteen");
    }

    @Test
    public void twenty() {
        assertThat( Say.say(20)).isEqualTo("twenty");
    }

    @Test
    public void twentyTwo() {
        assertThat( Say.say(22)).isEqualTo("twenty-two");
    }

    @Test
    public void oneHundred() {
        assertThat( Say.say(100)).isEqualTo("one hundred");
    }

    @Test
    public void oneHundredTwentyThree() {
        assertThat( Say.say(123)).isEqualTo("one hundred twenty-three");
    }

    @Test
    public void oneThousand() {
        assertThat( Say.say(1_000)).isEqualTo("one thousand");
    }

    @Test
    public void oneThousandTwoHundredThirtyFour() {
        assertThat( Say.say(1_234)).isEqualTo("one thousand two hundred thirty-four");
    }

    @Test
    public void oneMillion() {
        assertThat( Say.say(1_000_000)).isEqualTo("one million");
    }
    
    @Test
    public void oneMillionTwoThousandThreeHundredFortyFive() {
        assertThat( Say.say(1_002_345)).isEqualTo("one million two thousand three hundred forty-five");
    }
    
    @Test
    public void oneBillion() {
        assertThat( Say.say(1_000_000_000)).isEqualTo("one billion");
    }
    
    @Test
    public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
        assertThat( Say.say(987_654_321_123L))
            .isEqualTo("nine hundred eighty-seven billion six hundred fifty-four million" + 
                       " three hundred twenty-one thousand one hundred twenty-three");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalNegativeNumber() {
        Say.say(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalTooBigNumber() {
        Say.say(1_000_000_000_000L);
    }    
}
