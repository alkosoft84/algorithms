package factorial;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FactorialIterImplTest extends FactorialTest{

    @Override
    public FactorialIterImpl createInstance() {
        return new FactorialIterImpl();
    }
}