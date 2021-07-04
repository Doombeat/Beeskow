package esa_ale;
import java.util.Arrays;

/*********************************************************
* @author Kevin Beeskow (s77793@beuth-hochschule.de)	
* @version 1.0, 04/2021
* Einsendeaufgabe ALE
*********************************************************/


public class MeineArrayList<E> {
    private E[] list;
    private int size;
    private int capacity;
    private int increment;

	/**
	 * constructs a MeineArrayList-Object with initial capacity c 
	 * and increment inc
	 * 
	 * @param c the initial capacity
	 * @param inc the number of positions that will be added 
	 * when the list is made bigger
	 */
    
    protected MeineArrayList(int c, int inc) {
        capacity = c;
        list = (E[]) new Object[c];
        size = 0;
        increment = inc;

    }

    protected boolean add(E e) {

        E[] tempArray = Arrays.copyOf(list, size + 1);
        tempArray[size] = e;
        list = Arrays.copyOf(tempArray, size + 1);
        size++;

        if (capacity < size) capacity++;

        return true;
    }

    protected boolean remove(int index) {

        boolean rue = false;

        if (index < size && index > -1 && size > 0) {
            E[] tempArray = (E[]) new Object[size - 1];
            System.arraycopy(list, 0, tempArray, 0, index);

            if (!(index + 1 >= size))
                System.arraycopy(list, index + 1, tempArray, index, tempArray.length - index);

            list = tempArray;
            rue = true;
            size--;
        }

        return rue;
    }

    protected void clear() {

        list = (E[]) new Object[0];
        size = 0;
        capacity = 0;
    }

    protected int size() {

        int counter = 0;

        for (E e : list) counter++;

        return counter;
    }

    public String toString() {

        StringBuilder rue = new StringBuilder();

        if (list.length > 1) {
            Arrays.stream(list).forEach(e -> rue.append(e).append(", "));
            rue.deleteCharAt(rue.lastIndexOf(","));
            rue.deleteCharAt(rue.lastIndexOf(" "));
        } else
            Arrays.stream(list).forEach(rue::append);

        return rue.toString();
    }
}