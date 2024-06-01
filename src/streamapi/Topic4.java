package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Topic4 {

    // Sequence of stream
  public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numberstream = numbers.stream()
                .filter(val -> val >= 3)
                .peek(val -> System.out.println("After filter : " + val))
                .map(val -> val * -1)
                .peek(val -> System.out.println("After negating : " + val))
                .sorted()
                .peek(val -> System.out.println("After sorting :" + val));

        numberstream.collect(Collectors.toList());
    }
}

//        Actual output

//        After filter : 4
//        After negating : -4
//        After filter : 7
//        After negating : -7
//        After filter : 10
//        After negating : -10
//        After sorting :-10
//        After sorting :-7
//        After sorting :-4