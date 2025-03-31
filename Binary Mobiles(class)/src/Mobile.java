// You write this.
//
// If you make Structure a class, Mobile must extend it.
// If you make Structure an interface, Mobile must implement it.

public class Mobile extends Structure {	
	// This constructor is mandatory by problem specification
	// You have to figure out how to handle it
	private Branch left;
	private Branch right;
	
	public Mobile(Branch left, Branch right) {
		this.left = left;
		this.right = right;
	}


	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return left.getStructure().getWeight() + right.getStructure().getWeight();
	}

	@Override
	public boolean isBalanced() {
		// TODO Auto-generated method stub
		return left.torque() == right.torque() && left.getStructure().isBalanced() && 
				right.getStructure().isBalanced();
	}
	
}