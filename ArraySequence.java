import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence {
	private int currentIndex;
	private int[] data;

	/*Construct the sequence by copying values from the other array into the data array*/
	public ArraySequence(int[] other) {
		this.data = other.clone();
	}

	public void reset() {
		this.currentIndex = 0;
	}

	public int length() {
		return this.data.length;
	}

	public int next() {
		if (hasNext()) {
			return this.data[this.currentIndex++];
		} else {
			throw new NoSuchElementException("No element after this. Current: " + this.currentIndex + "\t End: " + (this.length() - 1));
		}
	}

	public boolean hasNext() {
		return this.currentIndex < this.data.length;
	}

}
