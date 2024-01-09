import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,5,4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1,3,4,6,8));

        System.out.println(MathematicalOperationsSets.unionSets(set1, set2));
        System.out.println(MathematicalOperationsSets.intersectionSets(set1, set2));
        System.out.println(MathematicalOperationsSets.minusSets(set1, set2));
        System.out.println(MathematicalOperationsSets.differenceSets(set1, set2));
        System.out.println(MathematicalOperationsSets.differenceSetsStream(set1, set2));
    }
}
