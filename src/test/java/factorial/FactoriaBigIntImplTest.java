package factorial;

import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FactoriaBigIntImplTest extends FactorialTest{

    @Override
    public FactorialBigIntImpl createInstance() {
        return new FactorialBigIntImpl();
    }

    @Test
    public void factorial_for_15_should_be_1_307_674_368_000() {
        //given
        final FactorialBigIntImpl tut = createInstance();
        //when
        final BigInteger factor = tut.factor(BigInteger.valueOf(15));
        //then
        assertThat(factor).isEqualTo(BigInteger.valueOf(1_307_674_368_000l));

    }
}