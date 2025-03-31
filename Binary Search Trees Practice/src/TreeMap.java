
public class TreeMap<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private TreeMap<K,V> left;   
	private TreeMap<K,V> right;
	public TreeMap(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {return value;} 			
	
	public void setValue(V value) {
		this.value = value;
	}
	public TreeMap<K,V> getLeft(){
		return left;
	}
	public TreeMap<K,V> getRight(){
		return right;
	}
	public void setLeft(TreeMap<K,V> left){
		this.left = left;
	}
	public void setRight(TreeMap<K,V> right) {
		this.right = right;
	}
	public void insert(K key, V value)  {
		if (key.compareTo(this.key) < 0){
			if (left == null) {
				setLeft(new TreeMap<>(key, value));
			}
			else {
				left.insert(key, value);
			}
		}
		else if (key.compareTo(this.key) > 0){
			if (right == null) {
				setRight(new TreeMap<>(key, value));
			}
			else {
				right.insert(key, value);
			}
		}
		else {
			setValue(value);
		}
	}
	
	public String toString() {
		String s = "" + key + " " + value + ",   ";
		if (left != null)
			s = s + left.toString();
		if (right != null)
			s = s + right.toString();
		return s;
	}
}
