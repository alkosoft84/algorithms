package fibonacci;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FibonacciRecurseImpl implements Fibonacci {

    public int countFibbonachi(final int n) {
        if (n < 2) {
            return n;
        } else {
            return countFibbonachi(n - 1) + countFibbonachi(n - 2);
        }

    }
}
