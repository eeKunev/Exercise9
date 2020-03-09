package Exercise9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;
import junit.framework.Assert;

class HomeworkTest {

	@Test
	void test() {
		ArrayList<Student> student = new ArrayList<Student>(); 
			Stream.of(Student.StudentGenerator.make(),
					Student.StudentGenerator.make(), Student.StudentGenerator.make())
					 .filter(s -> s.getName().length() >= 5)
					 .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
					 .forEach(System.out::println);
			
			Assert.assertEquals(student.get(2).toString(),"Lilly");
	}
	@Test
	void test1() {
		ArrayList<String> pet = new ArrayList<String>();
			Stream.of("cat", "dog", "cow", "bird")
			.map(String::toUpperCase)
			.collect(Collectors.toList())
			.forEach(System.out::println);	
			
			Assert.assertEquals(pet.get(2),"cat");
	}
	
	@Test
	void test2() {
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
			
			Assert.assertEquals(studs.get(2),"Ivan");
		}
	
	@Test
	void test3() {
		Rock pluton= new Rock();
		pluton.drop(10);
		Rock saturn= new Rock();
		saturn.drop(9);
		Assert.assertEquals(pluton,saturn);
	    
	}
	
	@Test
	void test4() {
		    	IntStream.iterate(0, i -> i + 1)
		    	.skip(5)
		    	.limit(10)
		    	.forEach(i -> {
		    	if (i % 2 == 0) System.out.println(i);
		    	});
		    	
		    }
}

	
	
	



