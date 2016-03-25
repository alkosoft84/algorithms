package factorial;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mwrobel on 24.03.16.
 */
public abstract class FactorialTest {

    private Factorial tut;

    protected abstract Factorial createInstance();

    @Before
    public void setUp() throws Exception {
        tut = createInstance();
    }

    @Test
    public void factorial_of_zero_should_be_one() {
        //given
        //when
        final int factor = tut.factor(0);
        //then
        assertThat(factor).isEqualTo(1);
    }

    @Test
    public void factorial_of_one_should_be_one() {
        //given
        //when
        final int factor = tut.factor(1);
        //then
        assertThat(factor).isEqualTo(1);
    }

    @Test
    public void factorial_of_two_should_be_two() {
        //given
        //when
        final int factor = tut.factor(2);
        //then
        assertThat(factor).isEqualTo(2);
    }

    @Test
    public void factorial_of_three_should_be_six() {
        //given
        //when
        final int factor = tut.factor(3);
        //then
        assertThat(factor).isEqualTo(6);
    }

    @Test
    public void factorial_of_four_should_be_twentyFour() {
        //given
        //when
        final int factor = tut.factor(4);
        //then
        assertThat(factor).isEqualTo(24);
    }

    @Test
    public void factorial_of_ten_should_be_3_628_800() {
        //given
        //when
        final int factor = tut.factor(10);
        //then
        assertThat(factor).isEqualTo(3628800);
    }

}