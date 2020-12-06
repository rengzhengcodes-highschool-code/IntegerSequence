public class RangeTester {

	public static void main(String[] args) {
		boolean failure = false;
		failure = failure || constructorTester(1000);

		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("Coal for you!");
		} else {
			System.out.println("Happy Holidays!");
		}
	}

	private static void tester(String test) {
		System.out.println("\n ~~~ " + test + "~~~\n");
	}

	private static int randInt(int end) {
		return (int)(Math.random() * end);
	}

	private static int randInt(int start, int end) {
		return (int)(Math.random()* (start - end)) + start;
	}

	private static void passMessage(int testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void passMessage(String testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void methodMessage(String method, boolean failure) {
		if (failure) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

	public static boolean constructorTester(int tests) {
		String method = "constructorTester";
		tester(method);
		boolean fail = false;
		//should return true
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				//passMessage(test);
			} catch (Exception e) {
				e.printStackTrace();
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			}

			end = start - (1 + randInt(10));
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				fail = true;
				System.out.println("Expected error!");
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			} catch (Exception e) {
				//passMessage(test);
			}

		}

		methodMessage(method, fail);
		return fail;
	}

	public static boolean hasNextTester(int tests) {
		tester("lengthTester");
		boolean fail = false;

		int start = randInt(-100, 100);
		int end = start + randInt(10);
		Range r = new Range(start, end);
		int[] equivalent = new int[end - start + 1];

		for (int n = start; n <= end; n++) {
			equivalent[n - start] = n;
		}

		for (int n : equivalent) {
			if (n != equivalent[end - start /* last digit of equivalent*/]) {
				if (r.hasNext()) {
					passMessage(n);
				} else {
					System.out.println();
				}
			}
		}

		return fail;
	}
}
