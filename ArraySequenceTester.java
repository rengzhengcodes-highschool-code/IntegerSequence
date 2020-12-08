import java.util.NoSuchElementException;

public class ArraySequenceTester {

	public static void main(String[] args) {
		boolean failure = false;

		failure = failure || arrayConstructorTester(1000);
		failure = failure || lengthTester(1000);

		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("Coal for you!");
		} else {
			System.out.println("Happy Holidays!");
		}
	}

	private static void tester(String test) {
		System.out.println("\n ~~~ " + test + " ~~~\n");
	}

	private static int randInt(int end) {
		return randInt(0, end);
	}

	private static int randInt(int start, int end) {
		return (int)(Math.random()* (end - start)) + start;
	}

	private static void passMessage(int testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void passMessage(String testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void methodMessage(String method, boolean fail) {
		if (fail) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

	public static boolean arrayConstructorTester(int tests) {
		tester("arrayConstructorTester");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			int rangeLen = randInt(20);
			int[] arr = new int[rangeLen];

			for (int index = 0; index < rangeLen; index++) {
				arr[index] = randInt(-100, 100);
			}
			// tests for IntegerSequence implementation
			IntegerSequence x = new ArraySequence(arr);
			x = null;
			// proper ArraySequence
			ArraySequence arrSeq = new ArraySequence(arr);
			// tests for all values declared, should always return the same value in the same order as the above array. If it does not or gives an error message, something went wrong.
			for (int n : arr) {
				int val = arrSeq.next();
				if (n == val) {
					//passMessage(test);
				} else {
					fail = true;
					System.out.println("Expected: " + n);
					System.out.println("Received: " + val);
				}
			}
			//tests for catching end of range of values
			try {
				int val = arrSeq.next();
				fail = true;
				System.out.println("No value should be here. Received: " + val);
			} catch (NoSuchElementException e) {
				//passMessage(e.toString());
			}

		}

		methodMessage("arrayConstructorTester", fail);
		return fail;
	}

	public static boolean lengthTester(int tests) {
		tester("lengthTester");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			int rangeLen = randInt(20);
			int[] arr = new int[rangeLen];

			for (int index = 0; index < rangeLen; index++) {
				arr[index] = randInt(-100, 100);
			}

			ArraySequence arrSeq = new ArraySequence(arr);

			if (arrSeq.length() == rangeLen) {
				//passMessage(test);
			} else {
				fail = true;
				System.out.println("Expected: " + rangeLen);
				System.out.println("Returned: " + arrSeq.length());
			}
		}

		methodMessage("lengthTester", fail);
		return fail;
	}

}
