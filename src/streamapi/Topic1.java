package streamapi;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Different way to Create a Stream
public class Topic1 {

    public static void main(String[] args) {
        // 1 : From Collection
        List<Integer> sararyList = Arrays.asList(3000, 4100, 1000, 3500);
        Stream<Integer> streamfromInteger = sararyList.stream();
        
        // 2 : From Arrays
        Integer[] salaryArray = {3000, 4100, 1000, 3500};
        Stream<Integer> streamformIntegerArray = Arrays.stream(salaryArray);
        
        // 3 : From Static Method
        Stream<Integer> streamfromStatic = Stream.of(3000, 4100, 1000, 3500);
        
        // 4 : From Stream Builder
        Stream.Builder<Integer> stremBuilder = Stream.builder();
        stremBuilder.add(100).add(9000).add(1000);
        Stream<Integer> stremformStreamBuilder = stremBuilder.build();

        // 5 : From Stream Iterate
        Stream<Integer> limit = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);
    }
}
