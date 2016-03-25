package duplicatesInArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mwrobel on 25.03.16.
 */
public class Duplicates {

    public static final int MAX_SIZE = 5;
    private int[] arrayOfIntegers;

    public Duplicates(final int[] arrayOfIntegers) {
        this.arrayOfIntegers = arrayOfIntegers;
    }

    public int[] getArrayOfIntegers() {
        return arrayOfIntegers;
    }

    public int[] fillArrayWithRandomValues(final int[] arrayOfIntegers) {
        Random rand = new Random();
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i]=rand.nextInt(10);
        }
        return arrayOfIntegers;
    }

    public Map<Integer, Integer> findDuplicatesFaster(final int[] filledArray) {
        final Map<Integer, Integer> duplicates = new HashMap<>();

        for (int i = 0; i < filledArray.length; i++) {
            updateCount(filledArray[i], duplicates);
        }

        return duplicates;
    }

    private void updateCount(final int value, final Map<Integer, Integer> duplicates) {
        if (duplicates.containsKey(value)) {
            final Integer integer = duplicates.get(value);
            duplicates.put(value, integer+1);
        } else {
            duplicates.put(value, 1);
        }
    }

    public Map<Integer, Integer> findDuplicates(final int[] filledArray) {
        final Map<Integer,Integer> duplicateMap = new HashMap<>();
        if(filledArray.length> MAX_SIZE){
            throw new RuntimeException("Array Should have max 5 elements");
        }else if(filledArray.length==0){
            return new HashMap<>();
        }

        int duplicateCounter = 1;
        for (int i = 0; i < filledArray.length; i++) {
            for (int j = i+1; j < filledArray.length; j++) {
                if(filledArray[i]==filledArray[j]){
                    duplicateCounter++;
                }
            }
            if(duplicateCounter>1 && !duplicateMap.containsKey(filledArray[i])){
                duplicateMap.put(filledArray[i],duplicateCounter);
            }
            duplicateCounter=1;
        }

        return duplicateMap;
    }

    public int[] fillArrayWithTheSameValues(final int[] arrayOfIntegers, int fillingValue) {
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i]=fillingValue;
        }
        return arrayOfIntegers;
    }
}
