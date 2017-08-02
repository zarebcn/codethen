package game.players;

import game.Entity;

/**
 * Base class por all players in the game.
 *
 * Notes about abstract classes:
 * - They may have abstract methods (i.e. not implemented).
 * - They can't be instantiated (can't do `new Player()`).
 * - They are meant to be extended (e.g. `class Rat extends Player`)
 */
public abstract class Player implements Entity {

    private double health;

    public Player() {
        this.health = 10;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public abstract int attack();

    public void receiveHit(double hit) {
        this.health -= hit;
    }

    @Override
    public boolean giantHasAttacked() {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" + health + ")";
    }
}