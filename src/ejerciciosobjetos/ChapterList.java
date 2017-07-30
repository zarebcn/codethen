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

            if (chapter.getTitle() == title) {
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

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0 && size == 1) {
            first = null;
            last = null;
            size--;
        }

        if (index == 0) {

            first = chapter.getNext();

            while (chapter != last) {
                chapter.setNext(chapter.getNext());
                chapter = chapter.getNext();
            }
            size--;
        }

        if (index == size - 1) {

            for (int i = 0; i < size - 2; i++) {
                chapter = chapter.getNext();
            }
            last = chapter;
            last.setNext(null);
            size--;
        }

        if (index != 0 && index != size - 1) {

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

