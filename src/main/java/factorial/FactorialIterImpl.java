package factorial;

import java.math.BigInteger;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FactorialIterImpl implements Factorial {

    @Override
    public int factor(final int n) {
        int x = 1;
        if(n>x){
            for (int i = 2; i <= n; i++) {
                x*=i;
            }
        }
        return x;
    }

    @Override
    public BigInteger factor(final BigInteger n) {
        return null;
    }
}
