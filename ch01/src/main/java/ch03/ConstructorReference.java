package ch03;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorReference {

	public static void main(String[] args) {

		List<String> names = Stream
				.of(new Person("jiten"), new Person("prexa"), new Person("vristi"), new Person("krishni"))
				.map(p -> p.getName()).collect(Collectors.toList());

		System.out.println(names);

		names = Stream.of(new Person("jiten"), new Person("prexa"), new Person("vristi"), new Person("krishni"))
				.map(Person::getName).collect(Collectors.toList());

		System.out.println(names);

		List<Person> people = names.stream().map(n -> new Person(n)).collect(Collectors.toList());

		System.out.println(people);

		people = names.stream().map(Person::new).collect(Collectors.toList());

		System.out.println(people);

		/************************/
		Person before = new Person("Grace Hopper");
		people = Stream.of(before).collect(Collectors.toList());
		Person after = people.get(0);
		if (before == after)
			System.out.println("Same object");

		before.setName("Grace Murray Hopper");
		if ("Grace Murray Hopper" == after.getName())
			System.out.println("Name has changed in the after reference");

		System.out.println(before);
		System.out.println(after);
		/************************/
		Person before2 = new Person("Grace Hopper");
		people = Stream.of(before2).map(Person::new).collect(Collectors.toList());
		Person after2 = people.get(0);
		if (before2 == after2)
			System.out.println("Same object");
		else 
			System.out.println("Not Same object");
		before2.setName("Grace Murray Hopper");
		if ("Grace Murray Hopper" == after2.getName())
			System.out.println("Name has changed in the after reference");
		else 
			System.out.println("Not Same name");

		System.out.println(before2);
		System.out.println(after2);
	}

}