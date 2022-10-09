// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

package design5;

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public abstract class PointCP5
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;

  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double xOrRho;

  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double yOrTheta;


  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP5(char type, double xOrRho, double yOrTheta)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    this.typeCoord = type;
    this.xOrRho = xOrRho;
    this.yOrTheta = yOrTheta;
  }


  //Instance methods **************************************************


  public double getX()
  {
    if(typeCoord == 'C')
      return xOrRho;
    else
      return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
  }

  public double getY()
  {
    if(typeCoord == 'C')
      return yOrTheta;
    else
      return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
  }

  public double getRho()
  {
    if(typeCoord == 'P')
      return xOrRho;
    else
      return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
  }

  public double getTheta()
  {
    if(typeCoord == 'P')
      return yOrTheta;
    else
      return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP5 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();

    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP5 rotatePoint(double rotation) {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

    return new PointCP5Polar('C',
            (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
            (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as " + (typeCoord == 'C'
            ? "Cartesian  (" + getX() + "," + getY() + ")"
            : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}
