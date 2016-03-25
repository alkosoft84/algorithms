package factorial;

import java.math.BigInteger;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FactorialRecurseImpl implements Factorial {

    @Override
    public int factor(final int n) {
        if(n<2) {
            return 1;
        }else{
            return n*factor(n-1);
        }
    }

    @Override
    public BigInteger factor(final BigInteger n) {
        return null;
    }
}
