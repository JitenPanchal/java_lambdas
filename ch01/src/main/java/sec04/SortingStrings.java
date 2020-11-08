package sec04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStrings {

	public static void main(String[] args) {
		List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");

		List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

		System.out.println(sorted);
		
		sorted = bonds.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		System.out.println(sorted);
		
		sorted = bonds.stream()
				.sorted(Comparator.comparing(String::toLowerCase))
				.collect(Collectors.toList());
		
		System.out.println(sorted);
		
		sorted = bonds.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		
		System.out.println(sorted);
		
		sorted = bonds.stream()
				.sorted(Comparator.comparingInt(String::length)
				.thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		
		System.out.println(sorted);
	}

}
