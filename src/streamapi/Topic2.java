package streamapi;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
                           //Intermediate Operations
public class Topic2 {

    public static void main(String[] args) {
        // Problem No 1 using filter() : Filter the result
        Stream<String> namestream = Stream.of("HELLO","EVERYONE","HOW" , "ARE" , "YOU" , "DOING");
        Stream<String> filteredStream = namestream.filter((String name) -> name.length() <= 3);
        List<String> result = filteredStream.collect(Collectors.toList());
        System.out.println(result);

        // Problem No 2 using map() : use to transform each element
        Stream<String> namestream1 = Stream.of("HELLO","EVERYONE","HOW" , "ARE" , "YOU" , "DOING");
        Stream<String> mapedStream = namestream1.map(name -> name.toLowerCase());
        List<String>  result1 = mapedStream.collect(Collectors.toList());
        System.out.println(result1);

        // Problem No 3 using flatmap():Use to iterate over each element of the complex collection and help to flatten it.

        List<List<String>> sentencelist = Arrays.asList(
                Arrays.asList("I", "LOVE", "JAVA"),
                Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
                Arrays.asList("ITS", "VERY", "EASY")
        );

        Stream<String> wordStream1 = sentencelist.stream().flatMap(sentence -> sentence.stream());
        List<String> result3 = wordStream1.collect(Collectors.toList());
        System.out.println(result3);


        Stream<String> wordStream2 = sentencelist.stream().flatMap(sentence -> sentence.stream().map(value -> value.toLowerCase()));
        List<String>  result4 = wordStream2.collect(Collectors.toList());
        System.out.println(result4);

        //Problem No 4 using distinct() and sorted(): Use to remove duplicate from stream and sort the element

        Integer [] arr = {2,4 ,6 ,6, 9, 9, 9,8,3,4};
        Stream<Integer> distinctarry = Arrays.stream(arr).distinct().sorted((val1 ,val2) -> val2-val1);
        List<Integer>  result5 = distinctarry.collect(Collectors.toList());
        System.out.println(result5);

        // Problem No 5 using peek() : Use to see the Intermediate result of the stream which is getting processed.
        List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numbersStream = numbers.stream()
                .filter((Integer n) -> n > 2)
                .peek((Integer n) -> System.out.println(n))  // its give the 3 , 4 , 6
                .map((Integer n) -> -1 * n);

        List<Integer> collect = numbersStream.collect(Collectors.toList());
        System.out.println(collect);

        //Problem No 6 using limit(long maxSize) : Truncate the stream to have no longer than given size.
        List<Integer> numbers1 = Arrays.asList(2,1,3,4,6);
        Stream<Integer> limitstream = numbers1.stream().limit(3);
        List<Integer> result6 = limitstream.collect(Collectors.toList());
        System.out.println(result6);

        // Problem No 7  using skip() : Skip the first n elements of streams

        List<Integer> numbers2 = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> skipstream = numbers2.stream().skip(3);
        List<Integer>  result7 = skipstream.collect(Collectors.toList());
        System.out.println(result7);

        // Problem No 8 using mapToInt() : helps to work with primitive "int" data type
        List<String> numbers3 = Arrays.asList("2", "1", "4", "6");
        IntStream intStream = numbers3.stream().mapToInt(val -> Integer.parseInt(val));
        int[] arraydata = intStream.toArray();  // {2,1,4,6}
        
        int [] arraydata1 = {2,1,4,6};
        IntStream streamdata = Arrays.stream(arraydata1);
        streamdata.filter(val -> val > 2);
        int[] array = streamdata.toArray();
        List<int[]> collect1 = Arrays.asList(array).stream().collect(Collectors.toList());
        System.out.println(collect1);
        
    }
}
