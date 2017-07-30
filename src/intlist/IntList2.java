package intlist;

public class IntList2 {

    private IntElement first;
    private IntElement last;
    private int size;

    public IntList2() {
        first = null;
        last = null;
        size = 0;
    }

    /** Gets element at specified index */
    public int get(int index) {

        IntElement e = first;

        for (int i = 0; i < index; i++) {
            e = e.getNext();
        }

        return e.getValue();
    }

    /** Adds an element to the list */
    public void add(int value) {

        IntElement e = new IntElement(value);

        if (last != null) {
            last.setNext(e);
            last = e;
        } else {
            first = e;
            last = e;
        }

        size++;
    }

    /** Gets number of elements in the list */
    public int size() {
        return size;
    }


    /** Tells if the list contains the given value */
    public boolean contains(int value) {

        IntElement e = first;

        for (int i = 0; i < size; i++) {

            if (e.getValue() == value) {
                return true;
            }

            e = e.getNext();
        }

        return false;
    }

    /**
     * Removes the element at the given index.
     * @throws IndexOutOfBoundsException if the index is out of the list.
     */
    public void remove(int index) {

        IntElement e = first;
        IntElement anterior = first;
        IntElement posterior = first;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0 && size == 1) {
            first = null;
            last = null;
            size--;
        }

        if (index == 0) {

            first = e.getNext();

            while (e != last) {
                e.setNext(e.getNext());
                e = e.getNext();
            }
            size--;
        }

        if (index == size - 1) {

            for (int i = 0; i < size - 2; i++) {
                e = e.getNext();
            }
            last = e;
            last.setNext(null);
            size--;
        }

        if (index != 0 && index != size - 1) {

            for (int i = 0; i < size; i++) {

                if (i == index - 1) {
                    anterior = e;
                }
                if (i == index + 1) {
                    posterior = e;
                }
                e = e.getNext();
            }
            e = anterior;
            e.setNext(posterior);
            size--;
        }

    }
}
