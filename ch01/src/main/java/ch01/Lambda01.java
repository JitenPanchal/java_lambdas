package ch01;

import java.io.File;
import java.util.Arrays;

public class Lambda01 {

	public static void main(String[] args) throws Exception {

//		AnonymousInnerClass
		new Thread(new Runnable() {

			public void run() {
				System.out.println("AnonymousInnerClass");
			}

		}).start();

//		using lambda in constructor
		new Thread(() -> {
			System.out.println("using lambda in constructor");
		}).start();

//		lambda to variable
		Runnable task = () -> {
			System.out.println("lambda to variable");
		};
		new Thread(task).start();

		File dir = new File("./src/main/java/ch01");

		System.out.println(dir.getAbsolutePath());

		System.out.println(Arrays.toString(dir.list()));

		System.out.println(Arrays.toString(dir.list((File arg0, String arg1) -> {
			return arg1.endsWith(".java");
		})));

	}
}