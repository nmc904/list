package list;

/**
 * The {@code BasicArrayList} class represents a list that is indexable
 * and can dynamically grow.
 */
public class CapacityArrayList<E>{
	private static final int START_SIZE = 10;
	
	private E[] data; // underlying array of elements
	private int size; // number of elements in arraylist
	private int capacityIncrement = 0; 
	//how much to increase the capacity when arraylist is full
	//default, i.e., 0, doubles it


	@SuppressWarnings("unchecked")
	public CapacityArrayList() {
		data = (E[]) new Object[START_SIZE];
		size = 0;
	}
	
	/**
	 * Constructs an ArrayList with the specified capacity and default to doubleing when resizing.
	 */
	@SuppressWarnings("unchecked")
	public CapacityArrayList(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * Constructs an ArrayList with the specified capacity and extends capacity by capacity increments or doubles if argument is 0.
	 */
	@SuppressWarnings("unchecked")
	public CapacityArrayList(int capacity, int capacityIncrement) {
		data = (E[]) new Object[capacity];
		size = 0;
		this.capacityIncrement = capacityIncrement;
	}
	
	public E get(int index) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		return data[index];
	}

	public E set(int index, E element) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		E old = data[index];
		data[index] = element;

		return old;
	}
		
	public void add(E element) {
		if (size == data.length){
			if(capacityIncrement == 0){
			    resize(2 * data.length);
            }
            else{
                resize(data.length+capacityIncrement);
            }
		}
		data[size] = element;
		size++;
	}

	public int size() {
		return size;
	}	
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}

		data = temp;
	}

	public String toString() {
		StringBuilder s = new StringBuilder("ArrayList: [");
		
		for( int i = 0; i < size; i++ ) {
			s.append(data[i] + ", ");
		}
		
		return s.substring(0, s.length()-2) + "]";
	}
}
