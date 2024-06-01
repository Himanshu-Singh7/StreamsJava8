package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Topic6 {
    public static void main(String[] args) {
        List<Integer> numbersoflist = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> filterednumber = numbersoflist.stream()
                .filter((Integer val) -> val >= 3);
         filterednumber.forEach((Integer val) -> System.out.println(val));

        List<Integer> collect = filterednumber.collect(Collectors.toList());
        System.out.println(collect);

        // One Terminal Operation is used on Stream, It is closed and can not use again for the another terminal operation
        // OtherWise it  gives a exception stream has already been operated upon or closed
    }
}
