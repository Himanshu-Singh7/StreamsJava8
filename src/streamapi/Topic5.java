package streamapi;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Topic5 {

                      // Different Terminal Operation
    // Terminal operations are the ones that produces the result. It triggers the processing of the stream.
    public static void main(String[] args) {

        // 1:  forEach(Consumer<T> action) : Perform action on each element of the stream . Do not Return any Value.
        List<Integer> numbersoflist1 = Arrays.asList(2, 1, 4, 7, 10);
        numbersoflist1.stream()
                .filter((Integer val) -> val >= 3 )
                .forEach((Integer val) -> System.out.println(val));

        // 2 : toArray() : Collects the elements of stream into Array.
        List<Integer> numbersoflist2 = Arrays.asList(2, 1, 4, 7, 10);
        Object[] array = numbersoflist2.stream()
                .filter((Integer val) -> val >= 3)
                .toArray();


        Integer[] array1 = numbersoflist2.stream()
                .filter((Integer val) -> val >= 3)
                .toArray((int size) -> new Integer[size]);

        // 3 : reduce(BinaryOperator<T> accumulator ) : Does reduction on the elements of the stream.Perform associative aggregation function.
        List<Integer> numbersoflist3 = Arrays.asList(2, 1, 4, 7, 10);
        Optional<Integer> reduce = numbersoflist3
                .stream()
                .reduce((Integer val1, Integer val2) -> val1+val2);

        System.out.println(reduce);  // Output is [24]


        // 4 : collect(Collector<T,A,R> collector : use to collects the elements of of the stream into an List.
        List<Integer> numbersoflist4 = Arrays.asList(2, 1, 4, 7, 10);
        List<Integer> collect = numbersoflist4.stream()
                .filter((Integer val) -> val >= 3)
                .collect(Collectors.toList());
        System.out.println(collect);

        // 5 : min(Comparator<T> comparator) && max(Comparator <T> comparator):
        // Find the minimum or maximum elements from the stream based on Comparator provided.
                     //min
         List<Integer> numbersoflist5 = Arrays.asList(2, 1, 4, 7, 10);
        Optional<Integer> min = numbersoflist5.stream()
                .filter((Integer val) -> val >= 3)
                .min((Integer val1, Integer val2) -> val1 - val2);

        System.out.println(min); // Output is 4

        Optional<Integer> min1 = numbersoflist5.stream()
                .filter((Integer val) -> val >= 3)
                .min((Integer val1, Integer val2) -> val2 - val1);
        System.out.println(min1); // output is 10
                      //max

        Optional<Integer> max1 = numbersoflist5.stream()
                .filter((Integer val) -> val >= 3)
                .max((Integer val1, Integer val2) -> val1 - val2);
        System.out.println(max1);  // output 10

        Optional<Integer> max2 = numbersoflist5.stream()
                .filter((Integer val) -> val >= 3)
                .max((Integer val1, Integer val2) -> val2 - val1);
        System.out.println(max2); // output 4


        // 6 : count() : return the count of stream present in List
        List<Integer> numbersoflist6 = Arrays.asList(2, 1, 4, 7, 10);
        long count = numbersoflist6.stream()
                .filter((Integer val) -> val >= 3)
                .count();
        System.out.println(count);

        // 7 : anyMatch(Predicate<T> predicate) : checks if any value in the stream match the given predicate and return the boolean.

        List<Integer> numbersoflist7 = Arrays.asList(2, 1, 4, 7, 10);
        boolean hasValueGreaterthan3 = numbersoflist7.stream()
                .anyMatch((Integer val) -> val > 3);
        System.out.println(hasValueGreaterthan3);

        // 8 : findFirst() : find the first elements of the stream
        List<Integer> numbersoflist8 = Arrays.asList(2, 1, 4, 7, 10);
        Optional<Integer> first = numbersoflist8.stream()
                .filter((Integer val) -> val >= 3)
                .findFirst();
        System.out.println(first.get());

    }
}
