package ejerciciosobjetos;


public class ChapterList {

    private Chapter first;
    private Chapter last;
    private int size;

    public ChapterList() {
        first = null;
        last = null;
        size = 0;
    }

    /** Gets element at specified index */
    public Chapter get(int index) {

        Chapter chapter = first;

        for (int i = 0; i < index; i++) {
            chapter = chapter.getNext();
        }

        if (chapter == null && size == 0) {
            throw new IndexOutOfBoundsException();
        }

        return chapter;
    }

    /** Adds an element to the list */
    public void add(Chapter chapter) {

        if (last != null) {
            last.setNext(chapter);
            last = chapter;
        } else {
            first = chapter;
            last = chapter;
        }

        size++;
    }

    /** Gets number of elements in the list */
    public int size() {
        return size;
    }


    /** Tells if the list contains the given value */
    public boolean contains(String title) {

        Chapter chapter = first;

        for (int i = 0; i < size; i++) {

            if (chapter.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return true;
            }

            chapter = chapter.getNext();
        }

        return false;
    }

    /**
     * Removes the element at the given index.
     * @throws IndexOutOfBoundsException if the index is out of the list.
     */
    public void remove(int index) {

        Chapter chapter = first;
        Chapter anterior = first;
        Chapter posterior = first;

        if (index < 0 || (index > size - 1 && size > 0) || (index == size && index == 0 && chapter == null)) {
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

            first = chapter.getNext();

            while (chapter != last) {
                chapter.setNext(chapter.getNext());
                chapter = chapter.getNext();
            }
            size--;
        }

        /**
         * para borrar el ultimo elemento de una lista de varios elementos
         */
        if (index == size - 1) {

            for (int i = 0; i < size - 2; i++) {
                chapter = chapter.getNext();
            }
            last = chapter;
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
                    anterior = chapter;
                }
                if (i == index + 1) {
                    posterior = chapter;
                }
                chapter = chapter.getNext();
            }
            chapter = anterior;
            chapter.setNext(posterior);
            size--;
        }

    }
}

