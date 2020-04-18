package classes;

import interfaces.SpatialEntity;
import javafx.scene.Group;

import java.util.ArrayList;

/**
 * Handles the simulation.
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Environment {

    private static ArrayList<SpatialEntity> bodies;
    private static PhysicsHandler simulator;
    private Group bodyShapes;

    /**
     * Constructs an Environment.
     */
    public Environment() {
        bodies = new ArrayList<>();
        simulator = new PhysicsHandler();
        bodyShapes = new Group();
    }

    /**
     * Accesses the bodyShapes Group.
     *
     * @return bodyShapes.
     */
    public Group getBodyShapes() {
        return bodyShapes;
    }

    /**
     * Creates a Planet and adds it to the Environment's bodies ArrayList.
     */
    public void createPlanet() {
        Planet planet = new Planet();
        bodies.add(planet);
        simulator.addBody(planet);

        bodyShapes.getChildren().add(planet.getShape());
    }

    /**
     * Creates a Star and adds it to the Environment's bodies ArrayList.
     */
    public void createStar() {
        Star star = new Star();
        bodies.add(star);
        simulator.addBody(star);

        bodyShapes.getChildren().add(star.getShape());
    }

    public void generateCoins() {
        final int numberOfCoins = 5;
        for (int index = 0; index < numberOfCoins; index++) {
            Coin coin = new Coin();
            bodies.add(coin);
            simulator.addBody(coin);

            bodyShapes.getChildren().add(coin.getShape());
        }
    }

    /**
     * Removes a given SpatialEntity from the bodies ArrayList and from the screen display.
     *
     * @param body the SpatialEntity (Body) to remove.
     */
    public void removeBody(SpatialEntity body) {
        bodies.remove(body);
        bodyShapes.getChildren().remove(body.getShape());
    }

}
