package fibonacci;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FibonacciIterationImplTest extends FibonacciTest {

    @Override
    protected FibonacciIterationImpl createInstance() {
        return new FibonacciIterationImpl();
    }
}