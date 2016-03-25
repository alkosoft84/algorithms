package fibonacci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mwrobel on 23.03.16.
 */
public abstract class FibonacciTest {

    private Fibonacci tut;

    protected abstract Fibonacci createInstance();

    @Before
    public void setUp() {
        tut = createInstance();
    }

    @Test
    public void first_element_should_be_zero() {
        // given
        // when
        final int firstElement = tut.countFibbonachi(0);
        // then
        assertTrue(firstElement == 0);
    }

    @Test
    public void second_element_should_be_one() {
        // given
        // when
        final int secondElement = tut.countFibbonachi(1);
        // then
        assertTrue(secondElement == 1);
    }

    @Test
    public void third_element_should_be_one() {
        // given
        // when
        final int thirdElement = tut.countFibbonachi(2);
        // then
        assertThat(thirdElement).isEqualTo(1);
    }

    @Test
    public void fourth_element_should_be_two() {
        // given
        // when
        final int fourthElement = tut.countFibbonachi(3);
        // then
        assertThat(fourthElement).isEqualTo(2);
    }

    @Test
    public void tenth_element_should_be_thirtyFour() {
        // given
        // when
        final int tenthElement = tut.countFibbonachi(9);
        // then
        assertThat(tenthElement).isEqualTo(34);
    }

    @Test
    public void twentieth_should_be_a_sum_of_previous_two() {
        // given
        final int eighteenthElement = tut.countFibbonachi(17);
        final int nineteenthElement = tut.countFibbonachi(18);
        final int sum = eighteenthElement + nineteenthElement;
        // when
        final int twentiethElement = tut.countFibbonachi(19);
        // then
        assertThat(twentiethElement).isEqualTo(sum);
    }

}
