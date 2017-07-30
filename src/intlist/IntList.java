package intlist;

/**
 * This is similar to a {@link java.util.List} but much more simple.
 * It contains integer values.
 */
class IntList {

    private IntElement first;
    private IntElement last;
    private int size;

    public IntList() {
        first = null;
        last = null;
        size = 0;
    }

    /** Gets element at specified index */
    public IntElement get(int index) {

        IntElement e = first;

        for (int i = 0; i < index; i++) {
            e = e.getNext();
        }

        if (e == null && size == 0) {
            throw new IndexOutOfBoundsException();
        }

        return e;
    }

    /** Adds an element to the list */
    public void add(IntElement e) {

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

        if (index < 0 || (index > size - 1 && size > 0) || (index == size && index == 0 && e == null)) {
            throw new IndexOutOfBoundsException();
        }

        /**
         * para borrar el elemento de una lista de un solo elemento
         */
        if (index == 0 && size == 1) {
            first = null;
            last = null;
            size--;
        }

        /**
         * para borrar el primer elemento de una lista de varios elementos
         */
        if (index == 0 && size > 1) {

            first = e.getNext();

            while (e != last) {
                e.setNext(e.getNext());
                e = e.getNext();
            }
            size--;
        }

        /**
         * para borrar el ultimo elemento de una lista de varios elementos
         */
        if (index == size - 1) {

            for (int i = 0; i < size - 2; i++) {
                e = e.getNext();
            }
            last = e;
            last.setNext(null);
            size--;
        }

        /**
         * para borrar un elemento que no sea ni el primero ni el ultimo en una lista
         * de varios elementos
         */
        if (index != 0 && index != size - 1 && size != 0) {

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
