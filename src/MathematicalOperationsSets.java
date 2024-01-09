import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MathematicalOperationsSets<E> extends HashSet<E> {

    public static <T> Set<T> unionSets(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        set1.addAll(set2);
        return set1;
    }

    public static <T> Set<T> unionSetsStream(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        return Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
    }

    public static <T> Set<T> intersectionSets(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        set1.retainAll(set2);
        return set1;
    }

    public static <T> Set<T> intersectionSetsStream(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        //return set1.stream().filter(value -> set2.stream().anyMatch(value1 -> value == value1)).collect(Collectors.toSet());
        return set1.stream().filter(set2::contains).collect(Collectors.toSet());
    }

    public static <T> Set<T> minusSets(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        set1.removeAll(set2);
        return set1;
    }

    public static <T> Set<T> minusSetsStream(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        return set1.stream().filter(set2::add).collect(Collectors.toSet());
    }

    public static <T> Set<T> differenceSets(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        HashSet<T> set3 = new HashSet<>(set1);
        minusSets(set1, set2);
        minusSets(set2, set3);
        unionSets(set1, set2);
        return set1;
    }

    public static <T> Set<T> differenceSetsStream(HashSet<T> set1, HashSet<T> set2) {
        validateInputData(set1, set2);
        return Stream.concat(set1.stream()
                        .filter(((HashSet<T>) set2.clone())::add),
                set2.stream()
                        .filter(((HashSet<T>) set1.clone())::add))
                .collect(Collectors.toSet());
    }

    private static <T> void validateInputData(HashSet<T> set1, HashSet<T> set2) {
        if (set1 == null || set2 == null) {
            throw new InvalidDataException("HashSet shouldn't be null");
        }
        if (set1.size() == 0 || set2.size() == 0) {
            throw new InvalidDataException("HashSet length cannot be 0");
        }
    }
}
