
public class Train {
	private int trainNo;
	private boolean ac;
	private int capacity; // get and set

	Train(int no, boolean ac, int cap) {
		this.trainNo = no;
		this.ac = ac;
		this.capacity = cap;
	}

	public int getTrainNo() { // accessors
		return trainNo;
	}

	public boolean isAc() {
		return ac;
	}

	public int getCapacity() { // accessor method
		return capacity;
	}

	public void setAc(boolean val) { // mutators
		ac = val;
	}

	public void setCapacity(int cap) { // mutator
		capacity = cap;
	}

}
