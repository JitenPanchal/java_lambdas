package ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VarArgsConstructor {
	public static void main(String[] args) {

		List<String> names = Stream.of(new Person("jiten panchal"), new Person("prexa panchal"),
				new Person("vristi panchal"), new Person("krishni panchal")).map(p -> p.getName())
				.collect(Collectors.toList());

		System.out.println(names);

		List<Person> people = names.stream().map(n -> n.split(" ")).map(Person::new).collect(Collectors.toList());

		System.out.println(people);

		Person[] peopleArray = people.toArray(new IntFunction<Person[]>() {
			@Override
			public Person[] apply(int value) {
				// TODO Auto-generated method stub
				return new Person[value];
			}
		});

		System.out.println(Arrays.toString(peopleArray));

		Person[] peopleArray2 = people.toArray(Person[]::new);

		System.out.println(Arrays.toString(peopleArray2));
	}
}
