package javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javastreams.models.Student;

public class JavaStreams {

    public static void main(String[] args) {
//        List<Student> students = Arrays.asList(
//                new Student("Ali", 20, 85.5),
//                new Student("Sara", 22, 91.5),
//                new Student("Omat", 19, 72.0),
//                new Student("Noor", 21, 65.5),
//                new Student("Huda", 23, 88.0)
//        );

//        List<String> result = new ArrayList<>();
//        
//        for(Student s : students){
//            if(s.getAge()>20){
//                result.add(s.getName().toUpperCase());
//            }
//        }
//        
//        Collections.sort(result);
//        
//        for(String name: result){
//            System.out.println(name);
//        }
//        students
//                .stream()
//                .filter(s -> s.getAge() > 20)
//                .map(s -> s.getName().toUpperCase())
//                .sorted()
//                .forEach(System.out::println);
//        System.out.println("******************* Passed students");
//        List<Student> passed = students.stream()
//                .filter(s -> s.getGrade() >= 70)
//                .collect(Collectors.toList());
//
//        passed.forEach(s -> System.out.println(s.getName()));
//
//        double totalGrades = students.stream()
//                .map(s -> s.getGrade())
//                .reduce(0.0, Double::sum);
//
//        System.out.println("Total Grades: " + totalGrades);
//
        ////        // get average grade for students who are older that 20 years old
//        double avg = students.stream()
//                .filter(s -> s.getAge() > 20)
//                .mapToDouble(s -> s.getGrade())
//                .average()
//                .orElse(0.0);
//
//        System.out.println("avg: " + avg);
//
//        Map<String, List<Student>> grouped
//                = students.stream()
//                        .collect(Collectors.groupingBy(s -> s.getGrade() > 70 ? "pass" : "fail"));
//   
//   int max= Arrays.asList(5, 3, 9, 2, 9, 1).stream()
//                        .reduce(Integer.MIN_VALUE, Integer::max);
//        System.out.println(max);
//
//    }



List<Product> ps = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0, 2),
                new Product("Chair", "Furniture", 150.0, 4),
                new Product("Headphones", "Electronics", 80.0, 5),
                new Product("Desk", "Furniture", 300.0, 1),
                new Product("Mouse", "Electronics", 25.0, 10),
                new Product("Lamp", "Home", 40.0, 3)
        );

        List<String> cheapestTwo
                = ps.stream()
                        .sorted(Comparator.comparingDouble(Product::getPrice).thenComparing(Product::getName))
                        .skip(1)
                        .limit(2)
                        .map(Product::getName)
                        .collect(Collectors.toList());
        System.out.println(cheapestTwo);

    }
}

class Product {

    String name;
    String category;
    double price;
    int quantity;

    Product(String n, String c, double p, int q) {
        name = n;
        category = c;
        price = p;
        quantity = q;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }
}
