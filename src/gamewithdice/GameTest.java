package gamewithdice;

public class GameTest {

    public static void main(String[] args) {

        testGiant();

        System.out.println("tests passed!");
    }

    private static void testGiant() {

        Knight knight = new Knight();
        Giant giant = new Giant();

        FakeDice dice = new FakeDice(new int[] { 6, 0, 2, 2, 1 });
        Game game = new Game(dice);
        game.fightTurn(knight, giant);

        assertEquals(giant.getHealth(), 7);
        assertEquals(knight.getHealth(), 44);
        assertEquals(giant.isVulnerable(), true);


        game.fightTurn(knight, giant);


        assertEquals(giant.getHealth(), 3);
        assertEquals(knight.getHealth(), 44);
        assertEquals(giant.isVulnerable(), false);
    }

    private static void testSkeleton() {

        Knight knight = new Knight();
        Skeleton skeleton = new Skeleton();

        FakeDice dice = new FakeDice(new int[] { 1, 4, 3, 5 });
        Game game = new Game(dice);
        game.fightTurn(knight, skeleton);

        assertEquals(skeleton.getHealth(), 10);
        assertEquals(knight.getHealth(), 46);

        game.fightTurn(knight, skeleton);

        assertEquals(skeleton.getHealth(), 7);
        assertEquals(knight.getHealth(), 41);
    }


    static void assertEquals(Object actual, Object expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException("actual " + actual + " is not equals to expected " + expected);
        }
    }
}
