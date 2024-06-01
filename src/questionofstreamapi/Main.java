package questionofstreamapi;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        // Question no 1 : Find list of students whose first name starts with alphabet "A" and age greater than 20
        List<Student> studentnamestartwitha = list.stream()
                .filter((name) -> name.getFirstName().startsWith("A") && name.getAge() > 20).collect(Collectors.toList());
        System.out.println(studentnamestartwitha);

        // Question no 2 : 2- Group The Student By Department Names
        Map<String, List<Student>> groupofstudentbydepartment = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println(groupofstudentbydepartment);

        // Question no 3 : 3- Find the total count of student using stream
        long countstudent = list.stream()
                .count();
        System.out.println(countstudent);
        // Question no 4 : 4- Find the max age of student
        OptionalInt maximumage = list.stream()
                .mapToInt(age -> age.getAge())
                .max();
        System.out.println(maximumage);

        // Question no 5 : 5- Find all departments names
        List<String> getalldepartmentname = list.stream()
                .map(name -> name.getDepartmantName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(getalldepartmentname);

        // Question no 6 : 6- Find the count of student in each department

        Map<String, Long> countthestudent = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println(countthestudent);

        // Question no 7 : 7- Find the list of students whose age is less than 30
        List<Student> agelesstan30 = list.stream().filter(age -> age.getAge() < 30).collect(Collectors.toList());
        System.out.println(agelesstan30);
    }
}
