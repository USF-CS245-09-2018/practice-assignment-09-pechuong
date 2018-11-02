public class BinaryHeap {

	private int[] arr;
	private int size;
	
	/**
	 * Initializes the Heap / Priority Queue
	 */
	public BinaryHeap() {
		this.arr = new int[10];
		this.size = 0;
	}

	/**
	 * Adds a number to the Heap and puts it in the correct place
	 *
	 * @param num The number to add to the heap
	 */
	public void add(int num) {
		if (size >= this.arr.length) {
			growArray();
		}
		// put the item in the end
		this.arr[size++] = num;

		//rearrange elements
		int index = this.size-1;
		int parent = (index - 1) / 2;
		while (index > 0 && this.arr[index] < this.arr[parent]) {
			swap(this.arr, index, parent);
			index = parent;
			parent = (index - 1) / 2;
		}

	}

	/**
	 * Removes the highest priority num from the heap
	 * 
	 * @return int The highest priority num(lowest num)
	 */
	public int remove() {
		if (isEmpty()) {
			return -1;
		}
		int lowest = this.arr[0];
		this.arr[0] = this.arr[this.size - 1];
		size--;
		shiftDown(0);
		return lowest;
	}

	/**
	 * Doubles the size of the current arr 
	 */
	public void growArray() {
		int[] newArr = new int[this.arr.length * 2];
		for (int i = 0; i < size; i++) {
			newArr[i] = this.arr[i];
		}
		this.arr = newArr;
	}

	/**
	 * Shifts an element down the heap to where it belongs 
	 *
	 * @param parent The parent of the element to check for swap
	 */
	public void shiftDown(int parent) {
		int child = parent * 2 + 1;
		if (child > size) {
			return;
		}
		if (this.arr[child + 1] < this.arr[child]) {
			child++;
		}
		if (this.arr[parent] > this.arr[child]) {
			swap(this.arr, child, parent);
			shiftDown(child);
		}
	}

	/**
	 * Swaps two elements in an arr given two indexes
	 *
	 * @param a The arr you want to swap indexes in
	 * @param index1 Index of the first element you want to swap
	 * @param index2 Index of second element you want to swap
	 */
	public static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	/**
	 * Checks if the Heap is empty or not
	 */
	public boolean isEmpty() {
		if (this.size <= 0) {
			return true;
		}
		return false;
	}

}
