package classes;

import classes.driver.Driver;
import interfaces.DynamicBody;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import java.util.Random;

/**
 * Simulates a planet.
 *
 * @author Janelle Kwok
 * @author Chloe Glave
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Planet implements DynamicBody {
    /* Private constant for a Random object. */
    private static final Random RANDOM = new Random();

    /* The radius is stored in kilometers(km) */
    private final int radius;

    /* Mass stored in 10^24 kilograms (kg).
    * If mass = 0.35 then the mass of that planet would be 3.5 * 10^23 */
    private final double mass;

    /* The shape of the planet */
    private final Circle shape;

    /* The velocity of the planets x direction */
    private double vx;

    /* The velocity of the planets y direction */
    private double vy;

    /* A boolean of whether the planet is destructible */
    private final boolean destructible;

    /**
     * Constructs a planet with default values.
     */
    public Planet() {
        this(generateRadius(), generateVelocity(), generateVelocity(), true);
    }

    /**
     * Constructs a planet with default values and x, y positions.
     *
     * @param xPosition the x position for the planet
     * @param yPosition the y position for the planet
     */
    public Planet(double xPosition, double yPosition) {
        this(generateRadius(), generateVelocity(), generateVelocity(), true, xPosition, yPosition);
    }

    /**D
     * Constructs a planet.
     *
     * @param radius the radius of the planet stored in km
     * @param vx the x direction velocity of the planet
     * @param vy the y direction velocity of the planet
     * @param destructible boolean determining if the planet can be destroyed
     */
    public Planet(int radius, double vx, double vy, boolean destructible) {
        final int circleRadiusModifier = 500;
        final int colourBound = 255;
        final int shapeRadius = radius / circleRadiusModifier;
        final int planetMassModifier = 1000;
        if (radius < circleRadiusModifier) {
            radius = circleRadiusModifier;
        }
        this.radius = radius;
        this.mass = (radius * 1.0) / planetMassModifier;
        this.shape = new Circle(generateXPosition(shapeRadius), generateYPosition(shapeRadius),
                shapeRadius, Color.rgb(RANDOM.nextInt(colourBound),
                RANDOM.nextInt(colourBound), RANDOM.nextInt(colourBound)));
        this.vx = vx;
        this.vy = vy;
        this.destructible = destructible;
    }

    /**
     * Constructs a planet with an assigned position.
     *
     * @param radius the radius of the planet stored in km
     * @param vx the x direction velocity of the planet
     * @param vy the y direction velocity of the planet
     * @param destructible boolean determining if the planet can be destroyed
     * @param xPosition the x position for the planet
     * @param yPosition the y position for the planet
     */
    public Planet(int radius, double vx, double vy, boolean destructible,
                  double xPosition, double yPosition) {
        final int circleRadiusModifier = 500;
        final int colourBound = 255;
        final int shapeRadius = radius / circleRadiusModifier;
        final int planetMassModifier = 1000;
        if (radius < circleRadiusModifier) {
            radius = circleRadiusModifier;
        }
        this.radius = radius;
        this.mass = (radius * 1.0) / planetMassModifier;
        this.shape = new Circle(xPosition, yPosition,
                shapeRadius, Color.rgb(RANDOM.nextInt(colourBound),
                RANDOM.nextInt(colourBound), RANDOM.nextInt(colourBound)));
        this.vx = vx;
        this.vy = vy;
        this.destructible = destructible;
    }

    private static double generateXPosition(int shapeRadius) {
        return RANDOM.nextInt(Driver.WINDOW_WIDTH - (shapeRadius * 2)) + shapeRadius;
    }

    private static double generateYPosition(int shapeRadius) {
        final int maxYSpawnRange = 640;
        return RANDOM.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius;
    }

    private static double generateVelocity() {
        final double velocityModifier = 6.0;
        return RANDOM.nextDouble() * velocityModifier - (velocityModifier / 2);
    }

    private static int generateRadius() {
        final int planetsRadiusBound = 6000;
        return RANDOM.nextInt(planetsRadiusBound) + planetsRadiusBound;
    }

    /**
     * Gets the radius of the planet.
     * @return the radius of the planet
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Gets the planets x velocity.
     * @return the planets x velocity
     */
    @Override
    public double getVx() {
        return vx;
    }

    /**
     * Gets the planets y velocity.
     * @return the planets y velocity.
     */
    @Override
    public double getVy() {
        return vy;
    }

    /**
     * Adds a double number to the velocity in the x direction.
     * @param num the number to add to vx
     */
    @Override
    public void addVx(double num) {
        vx += num;
    }

    /**
     * Adds a double number to the velocity in the y direction.
     * @param num the number to add to vy
     */
    @Override
    public void addVy(double num) {
        vy += num;
    }

    /**
     * Updates the planets X and Y centers by the Velocity in the X and Y directions.
     */
    @Override
    public void move() {
        shape.setCenterX(shape.getCenterX() + vx);
        shape.setCenterY(shape.getCenterY() + vy);
    }

    /**
     * Gets the mass of the planet.
     * @return the mass of the planet
     */
    @Override
    public double getMass() {
        return mass;
    }

    /**
     * Gets the boolean for the planets destructibility.
     * @return the boolean for destructibility
     */
    @Override
    public boolean getDestructible() {
        return destructible;
    }

    /**
     * Gets the Shape of the planet.
     * @return the Shape of the planet
     */
    @Override
    public Shape getShape() {
        return shape;
    }

    /**
     * Sets the x values of shape.
     *
     * @param x The value for it to be changed to.
     */
    @Override
    public void setX(double x) {
        shape.setCenterX(x);
    }

    /**
     * Sets the y values of shape.
     *
     * @param y The value for it to be changed to.
     */
    @Override
    public void setY(double y) {
        shape.setCenterX(y);
    }

    /**
     * Gets the current x position of the planet.
     * @return the x position.
     */
    @Override
    public double getX() {
        return shape.getCenterX();
    }

    /**
     * Gets the current y position of the planet.
     * @return the y position
     */
    @Override
    public double getY() {
        return shape.getCenterY();
    }



}
