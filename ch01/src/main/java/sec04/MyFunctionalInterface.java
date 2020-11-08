package sec04;

@FunctionalInterface
public interface MyFunctionalInterface {

	int mymethod();

	default String sayHello() {
		return "Hello Jiten";
	}

	String toString();

	boolean equals(Object obj);

	static void myStaticMethod() {
		System.out.println("static method in interface");
	}
}
