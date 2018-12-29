/**
 * Class to contain the method used for transforming mathematical coordinates into coordinates that fit the Window Space
 */

public class DisplayTransformations {

    public static Coordinate origin = new Coordinate(ApplicationWindow.windowWidth / 2,
            ApplicationWindow.windowHeight / 2);

    private static int mathematicalToPixelsFactor = 100;

    public static Coordinate transformMathematicalToPixelCoordinates(Coordinate mathematicalCoordinate)
    {
        int pixelX = (int) origin.x + (int) (mathematicalCoordinate.x * mathematicalToPixelsFactor);
        int pixelY = (int) origin.y - (int) (mathematicalCoordinate.y * mathematicalToPixelsFactor);

        Coordinate pixelCoordinate = new Coordinate(pixelX, pixelY);

        //mapping the mathematical coordinates onto the screen

        return  pixelCoordinate;
    }

}
