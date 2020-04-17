package classes;

import interfaces.*;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * A class to process and run the physics simulation.  TODO: @pre and @post
 *
 * @author Kayden Schmidt
 */
public class PhysicsHandler {
    /**
     * The default physics tick interval, in milliseconds.
     */
    public static final long DEFAULT_INTERVAL = 20;

    private long interval;
    private ArrayList<DynamicBody> dynamicBodies;
    private ArrayList<PhysicalBody> bodies;
    private boolean collisionsOn;
    private boolean paused;
    private double speed;
    private Thread thread;

    /**
     * Instantiate a PhysicsHandler.
     *
     * @param bodies the list of bodies assigned to this PhysicsHandler
     * @param dynamicBodies the list of dynamic bodies assigned to this PhysicsHandler
     */
    public PhysicsHandler(ArrayList<PhysicalBody> bodies, ArrayList<DynamicBody> dynamicBodies) {
        this.bodies = bodies;
        this.dynamicBodies = dynamicBodies;
        this.interval = DEFAULT_INTERVAL;
        this.speed = 1.0;
        this.collisionsOn = true;
        this.paused = false;
        this.thread = new Thread(this::run);
    }

    /**
     * Pause the simulation.
     */
    public void pause() {
        paused = true;
    }

    /**
     * Unpause the simulation.
     */
    public void unPause() {
        paused = false;
    }

    /**
     * Toggle the pausing of the simulation.
     */
    public void togglePause() {
        paused = !paused;
    }

    /**
     * Toggle collisions in the simulation.
     */
    public void toggleCollisions() {
        collisionsOn = !collisionsOn;
    }

    /**
     * Check for collisions between physical bodies, and simulate any found.
     */
    public void checkCollisions() {
        if (!paused && collisionsOn) {
            for (int i = 0; i < bodies.size() - 1; i++) {
                PhysicalBody first = bodies.get(i);
                for (int j = i + 1; j < bodies.size(); j++) {
                    PhysicalBody second = bodies.get(j);
                    Shape intersection = Shape.intersect(first.getShape(), second.getShape());
                    if (intersection.getBoundsInLocal().getWidth() != -1) {
                        simulateCollision(first, second);
                    }
                }
            }
        }
    }

    /**
     * Simulate a collision between two physical bodies.
     *
     * @param first the first physical body involved in the collision
     * @param second the second physical body involved in the collision
     */
    public void simulateCollision(PhysicalBody first, PhysicalBody second) {
        System.out.println("You hear explosions or something.");
    }

    /**
     * Move all bodies assigned to this handler, once.
     */
    public void moveBodies() {
        for (DynamicBody body : dynamicBodies) {
            body.move();
        }
    }

    /* Start the simulation. */
    private void run() {
        boolean running = true;
        while (running) {
            moveBodies();
            checkCollisions();

            try {
                Thread.sleep((long) (interval / speed));
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
            }
        }
    }
}