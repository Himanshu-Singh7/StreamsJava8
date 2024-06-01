package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Topic3 {
    public static void main(String[] args) {
     // Why we call Intermediate Operation "Lazy"
        List<Integer> numberslist = Arrays.asList(1, 3, 4, 6, 7, 9);
        Stream<Integer> streamnumbers = numberslist.stream().filter(val -> val > 3).peek(val -> System.out.println(val));
        streamnumbers.count();  // Count is a terminal operation

        // These are Lazy in Nature means these operations get executed only when terminal operation is invoked.
    }
}
