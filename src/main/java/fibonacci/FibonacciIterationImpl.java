package fibonacci;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FibonacciIterationImpl implements Fibonacci {

    public int countFibbonachi(final int n) {
        if(n<2){
            return n;
        }else{
            int el1=0;
            int el2=1;
            int sum = el1+el2;
            for (int i = 2; i <= n; i++) {
                sum = el1+el2;
                el1=el2;
                el2 = sum;
            }
            return sum;
        }
    }
}
