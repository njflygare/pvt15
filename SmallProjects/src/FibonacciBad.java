
public class FibonacciBad {
	
	// Recursive way to calculate Fibonacci numbers. It's bad. Integer overflow at 57th number.
	public int fibo(int i) {
			if (i == 0) return 0;
			else if (i == 1) return 1;
			else return fibo(i-1) + fibo(i-2);
	}
}
