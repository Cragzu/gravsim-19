package Driver;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * Background stars and decorations for the application.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class BackgroundStar extends Circle {

    /**
     * The number of stars to generate in the generateStars method.
     */
    static final int NUM_OF_STARS_TO_GENERATE = 25;

    /**
     * The color of the stars.
     */
    static final Color BACKGROUND_STARS_COLOR = Color.CORNSILK;

    /**
     * Constructor to create a background star.
     *
     * @param centerX the X position of the star.
     * @param centerY the Y position of the star.
     */
    public BackgroundStar(double centerX, double centerY) {
        super(centerX, centerY, 4);
        this.setFill(BACKGROUND_STARS_COLOR);
    }

    /**
     * Generates a random assortment of BackgroundStars to be placed in the window.
     *
     * @return a Group containing the generated BackgroundStars.
     */
    public static Group generateStars() {

        Group stars = new Group();

        for (int i = 0; i < NUM_OF_STARS_TO_GENERATE; i++) {
            int generatedX = new Random().nextInt(Driver.WINDOW_WIDTH);
            int generatedY = new Random().nextInt(Driver.WINDOW_HEIGHT);

            BackgroundStar star = new BackgroundStar(generatedX, generatedY);

            stars.getChildren().add(star);
        }
        return stars;
    }

}