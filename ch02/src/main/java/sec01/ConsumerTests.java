package sec01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTests {

	public static void main(String[] args) throws Exception {
		List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

		Consumer<String> consumer = new Consumer<String>() {

			public void accept(String t) {
				System.out.println(t);
			}

		};

		strings.forEach(consumer);

		List<Integer> numbers = Arrays.asList(3, 4, 5, 6);

		IntConsumer intConsumer = new IntConsumer() {

			public void accept(int value) {
				System.out.println(value);
			}
		};

		// Create a IntConsimer Instance
		IntConsumer display = a -> System.out.println(a * 10);
		IntConsumer mul = a -> a *= 10;

		// Using andThen() method
		IntConsumer composite = mul.andThen(display);
		composite.accept(3);

	}
}
