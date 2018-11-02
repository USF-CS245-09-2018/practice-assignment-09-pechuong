public class BinaryHeap {

	private int[] arr;
	private int size;
	
	public BinaryHeap() {
		this.arr = new int[10];
		this.size = 0;
	}

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

	public int remove() /*throws Exception*/ {
		if (isEmpty()) {
			return -1;
			//throw new Exception("Heap is empty");
		}
		int lowest = this.arr[0];
		this.arr[0] = this.arr[this.size - 1];
		size--;
		shiftDown(0);
		return lowest;
	}

	public void growArray() {
		int[] newArr = new int[this.arr.length * 2];
		for (int i = 0; i < size; i++) {
			newArr[i] = this.arr[i];
		}
		this.arr = newArr;
	}

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

	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public boolean isEmpty() {
		if (this.size <= 0) {
			return true;
		}
		return false;
	}

}
