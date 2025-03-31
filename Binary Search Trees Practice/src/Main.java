
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> t = new TreeMap<Integer, String>(10, "James");
		
		t.insert(5, "John");
		t.insert(15, "William");
		t.insert(3, "John");
		t.insert(12, "Franklin");
		t.insert(16, "George");
		System.out.println(t);
		t.insert(5, "Bob");
		System.out.println(t);

	}

}
