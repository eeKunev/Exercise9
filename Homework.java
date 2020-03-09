package Exercise9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;

public class Homework extends Rock {

	public static void main(String[] args) {
		Homework1();
		Homework2();
		Homework3();
		Homework4();		
		
	}
		
		public static void Homework1() {
		Stream.of(Student.StudentGenerator.make(),
				Student.StudentGenerator.make(), Student.StudentGenerator.make())
				 .filter(s -> s.getName().length() >= 5)
				 .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
				 .forEach(System.out::println);
		}
		
		public static void Homework2() {
			Stream.of("cat", "dog", "cow", "bird")
			.map(String::toUpperCase)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		}
		
		public static void Homework3() {
			List<Student> studs = new ArrayList<>();
			for (int i = 0; i < 5; ++i) studs.add(Student.StudentGenerator.make());
			String studNames = studs.stream()
			 .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
			 .map(s -> s.getName())
			 .reduce((s1, s2) -> {
			 if (s2 != null) return s1 + ", " + s2;
			 return s1;
			 })
			 .get();
			System.out.println(studNames);
		}
		
	    public static void Homework4() {
	    	IntStream.iterate(0, i -> i + 1)
	    	.skip(5)
	    	.limit(10)
	    	.forEach(i -> {
	    	if (i % 2 == 0) System.out.println(i);
	    	});
	    }
}

	


