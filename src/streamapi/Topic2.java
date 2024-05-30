package streamapi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        Stream<Integer> distinctarry = Arrays.stream(arr).distinct().sorted(Collections.reverseOrder());
        List<Integer>  result5 = distinctarry.collect(Collectors.toList());
        System.out.println(result5);

    }
}
