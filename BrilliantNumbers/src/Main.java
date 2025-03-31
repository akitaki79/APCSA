
public class Main {


	public static void main(String args[]) {
		Primes p = new Primes(50);
		System.out.println(p.primes);	
		
		//first 20 Brilliant Numbers
		Brilliant b = new Brilliant(20);
		System.out.println(b.brilliants);
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false; 
		for (int i = 2; i < Math.sqrt(n) + .1; i++)
			if (n % i == 0)
				return false; 
		return true; 
	}

	public static boolean sameDigit(int n, int x) {
		int lenN = String.valueOf(n).length();
		int lenX = String.valueOf(x).length();
		return lenX == lenN;
	}
	
	public static boolean isBrilliant(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i*j == n && sameDigit(i , j) && isPrime(i) && isPrime(j)) {
					return true;
				}
			}
		}
		return false;
	}

}
