package factorial;

/**
 * Created by mwrobel on 23.03.16.
 */
public class FactorialRecurseImplTest extends FactorialTest{

    @Override
    public FactorialRecurseImpl createInstance() {
        return new FactorialRecurseImpl();
    }
}