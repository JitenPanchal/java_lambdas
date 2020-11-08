package sec01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OptionalTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoë", "Jayne", "Simon", "River",
				"Shepherd Book");
		Optional<String> first = names.stream().filter(name -> name.startsWith("C")).findFirst();
		System.out.println(first);

		System.out.println(first.isPresent());

		System.out.println(first.orElse("None"));
		System.out.println(
				first.orElse(String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));
		System.out.println(first.orElseGet(
				() -> String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));

		first = names.stream().filter((name -> name.startsWith("C"))).findFirst();
		System.out.println(first);

		Predicate<String> p = s -> s.length() > 3;
		p = p.and(s -> s.startsWith("W"));

		System.out.println(first = names.stream().filter(p).findFirst());
		
		System.out.println(names.stream().collect(Collectors.partitioningBy(p,Collectors.toList())));
	}
}
