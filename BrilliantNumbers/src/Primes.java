
import java.util.ArrayList;

public class Primes {
	ArrayList<Integer> primes = new ArrayList<Integer>();

	public Primes(int n) {
		for (int i = 0; n > primes.size(); i++) {
			if (Main.isPrime(i)) {
				primes.add(0,i);
			}
		}	
	}

	public boolean isPrime(int x) {
		//Order of Growth: O(n) because the amount of operations linearly depends on the size 
		//and j increases by 1 until it reaches the stop case, making it linear 
		if (x > primes.get(0)) {
			for(int j = primes.get(0) + 1; j <= x; j++) {
				if(Main.isPrime(j)) {
					primes.add(0, j);
				}
			}	
		}
		return Main.isPrime(x);
	}
}

