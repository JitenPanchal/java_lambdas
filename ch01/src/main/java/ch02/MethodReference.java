package ch02;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodReference {

	public static void main(String[] args) {

		Stream.of(1, 2, 3).forEach(i -> System.out.println(i));

		Stream.of(10, 20, 30).forEach(System.out::println);

		Consumer<Integer> consumer = System.out::println;

		Stream.of(100, 200, 300).forEach(consumer);

		Consumer<Double> doubleConsumer = System.out::println;

		Stream.generate(Math::random).limit(5).forEach(doubleConsumer);

		Stream.of("C", "A", "B").sorted(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			};
		}).forEach(System.out::println);

		Stream.of("C", "A", "B").sorted(String::compareTo).forEach(System.out::println);

		Stream.of("C", "A", "B").map(String::length).forEach(System.out::println);
	}

}