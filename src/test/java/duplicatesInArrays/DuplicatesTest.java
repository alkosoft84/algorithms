package duplicatesInArrays;

import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mwrobel on 25.03.16.
 */
public class DuplicatesTest {

    Duplicates tut;

    @Test
    public void array_should_have_five_zeros_at_the_beginning() {
        //given
        int[] newArrayOfIntegers = new int[5];
        tut = new Duplicates(newArrayOfIntegers);
        //when
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        //then
        assertThat(arrayOfIntegers[0]).isEqualTo(0);
        assertThat(arrayOfIntegers[1]).isEqualTo(0);
        assertThat(arrayOfIntegers[2]).isEqualTo(0);
        assertThat(arrayOfIntegers[3]).isEqualTo(0);
        assertThat(arrayOfIntegers[4]).isEqualTo(0);
    }

    @Test
    public void array_should_have_more_than_one_element() {
        //given
        int[] newArrayOfIntegers = new int[5];
        tut = new Duplicates(newArrayOfIntegers);
        //when
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        //then
        assertThat(arrayOfIntegers.length).isGreaterThan(1);
    }

    @Test
    public void should_throw_exception_when_array_is_bigger_than_5Elements() {
        //given
        int[] newArrayOfIntegers = new int[7];
        tut = new Duplicates(newArrayOfIntegers);
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        try{
            tut.findDuplicates(arrayOfIntegers);
            fail("Array is To Big");
        }catch(Exception e){
            //then
        }
    }

    @Test
    public void should_return_emptyMap_when_array_is_empty() {
        //given
        int[] newArrayOfIntegers = new int[0];
        tut = new Duplicates(newArrayOfIntegers);
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        //when
        final Map<Integer, Integer> duplicates = tut.findDuplicates(arrayOfIntegers);
        //then
        assertThat(duplicates).isEmpty();
    }

    @Test
    public void should_return_map_only_with_one_entry_when_values_are_the_same() {
        //given
        int[] newArrayOfIntegers = new int[5];
        tut = new Duplicates(newArrayOfIntegers);
        final int[] arrayOfIntegers = tut.fillArrayWithTheSameValues(newArrayOfIntegers, 3);
        //when
        final Map<Integer, Integer> duplicates = tut.findDuplicates(arrayOfIntegers);
        //then
        assertThat(duplicates.size()).isEqualTo(1);
    }


    //SCENARIO !!

    @Test
    public void should_return_map_only_of_duplicates() {
        //STEP 1
        int[] newArrayOfIntegers = new int[]{1,1,1,1,1};
        tut = new Duplicates(newArrayOfIntegers);
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        //STEP 2
        final Map<Integer, Integer> duplicates = tut.findDuplicates(arrayOfIntegers);
        //STEP3
        System.out.println(duplicates);
    }

    @Test
    public void should_return_map_only_of_duplicates_by_damian() {
        //STEP 1
        int[] newArrayOfIntegers = new int[]{1,1,1,1,1};
        tut = new Duplicates(newArrayOfIntegers);
        final int[] arrayOfIntegers = tut.getArrayOfIntegers();
        //STEP 2
        final Map<Integer, Integer> duplicates = tut.findDuplicatesFaster(arrayOfIntegers);
        //STEP3
        System.out.println(duplicates);
    }
}