package streamapi;
import java.util.Arrays;
import java.util.List;


/*Parallel Stream:

        Helps to perform operation on stream concurrently, taking advantage of multicore CPU.
        ParallelStream() method is used instead of regular stream() method.

        Internally it does:
          -Task splitting: it uses "spliterator" function to split the data into multiple chunks
          - Task submission and parallel processing: Uses Fork-Join pool technique.*/
public class Topic7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 44, 55, 66, 77, 88, 99, 110);
        // Sequential Processing
        long sequentialprocessstarttime = System.currentTimeMillis();
         numbers.stream()
                .map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.println(val));

         System.out.println("Sequential Processing Time Taken : " +(System.currentTimeMillis() - sequentialprocessstarttime) +  " millisecond");

         long parallelprocessstarttime = System.currentTimeMillis();
         numbers.parallelStream()
                 .map((Integer val) -> val * val)
                 .forEach((Integer val) -> System.out.println(val));

        System.out.println("Parallel Processing Time Taken : " +(System.currentTimeMillis() - parallelprocessstarttime) +  "  millisecond");



    }
}
