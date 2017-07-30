package intlist;

/**
 * This is a test for {@link IntList}.
 * We test different situations.
 */
public class IntListTest {

    public static void main(String[] args) {

        testEmptyList();
        testAddOneElement();
        testAddMultipleElements();
        testContains();
        testRemove();

        // This line will only be executed if all tests pass
        System.out.println("All tests OK!");
    }

    private static void testEmptyList() {
        IntList list = new IntList();
        IntList2 list2 = new IntList2();
        assertEquals( list.size(), 0 );
        assertEquals( list2.size(), 0 );
    }

    private static void testAddOneElement() {

        IntList list = new IntList();
        IntList2 list2 = new IntList2();
        IntElement e = new IntElement(15);
        list.add(e);
        list2.add(15);
        assertEquals( list.size(), 1 );
        assertEquals( list.get(0).getValue(), 15 );
        assertEquals( list2.size(), 1 );
        assertEquals( list2.get(0), 15 );
    }

    private static void testAddMultipleElements() {

        IntList list = new IntList();
        IntList2 list2 = new IntList2();

        list.add(new IntElement(10));
        list.add(new IntElement(20));
        list.add(new IntElement(30));
        list.add(new IntElement(40));

        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);

        assertEquals( list.size(), 4 );
        assertEquals( list.get(2).getValue(), 30 );

        assertEquals( list2.size(), 4 );
        assertEquals( list2.get(2), 30 );
    }

    private static void testContains() {

        IntList list = new IntList();
        IntList2 list2 = new IntList2();

        list.add(new IntElement(5));
        list.add(new IntElement(10));
        list.add(new IntElement(15));

        list2.add(5);
        list2.add(10);
        list2.add(15);

        assertEquals( list.contains(5), true );
        assertEquals( list.contains(10), true );
        assertEquals( list.contains(15), true );
        assertEquals( list.contains(20), false );

        assertEquals( list2.contains(5), true );
        assertEquals( list2.contains(10), true );
        assertEquals( list2.contains(15), true );
        assertEquals( list2.contains(20), false );
    }

    private static void testRemove() {

        IntList list = new IntList();
        IntList2 list2 = new IntList2();

        list.add(new IntElement(5));
        list.add(new IntElement(10));
        list.add(new IntElement(15));
        list.add(new IntElement(40));
        list.remove(2);

        list2.add(5);
        list2.add(10);
        list2.add(15);
        list2.add(40);
        list2.remove(1);

        assertEquals( list.get(2).getValue(), 40 );
        assertEquals( list2.get(1), 15 );

    }



    /** Checks that 2 values are equal; throws an exception if not. */
    private static void assertEquals(Object actual, Object expected) {

        if (!actual.equals(expected)) {
            throw new RuntimeException("not equals!!");
        }
    }
}
