
public class Cow implements Comparable<Cow> {
	int weight;
	String name;
	
	public Cow() {
        this(1800, "Anonymous Cow");
    }
	
	public Cow(int weight, String name) {
		this.weight = weight;
		this.name = name;	
	}
	
	public int getWeight() { return weight; }
    public String getName() { return name; }

	@Override
    public int compareTo(Cow otherCow) {
		return Integer.compare(weight, otherCow.getWeight());
    }
   
    public String toString() {
        return (name);
    }
}

