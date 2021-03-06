import be.kuleuven.cs.som.annotate.*;

/**
 * A class of position vectors involving arguments as double precision floating-point numbers.
 * 
 * @invar  Each PositionVector can have its arguments as arguments.
 *       | canHaveAsArgument(this.getXArgument()) && canHaveAsArgument(this.getYArgument()) && canHaveAsArgument(this.getZArgument())
 */
@Value
public class PositionVector {

	/**
	 * Initialize this new PositionVector with given arguments.
	 * 
	 * @param  x
	 *         The x argument for this new PositionVector.
	 * @param  y
	 * 		   The y argument for this new PositionVector.
	 * @param  z
	 * 		   The z argument for this new PositionVector.
	 * @post   The x argument of this new PositionVector is equal to the given
	 *         x argument.
	 *       | new.getXArgument() == x
	 * @post   The y argument of this new PositionVector is equal to the given
	 *         y argument.
	 *       | new.getYArgument() == y
	 * @post   The z argument of this new PositionVector is equal to the given
	 *         z argument.
	 *       | new.getZArgument() == z
	 */
	public PositionVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Return the x argument of this PositionVector.
	 */
	@Basic @Raw @Immutable
	public double getXArgument() {
		return this.x;
	}
	
	/**
	 * Variable registering the x argument of this PositionVector.
	 */
	private final double x;
	
	/**
	 * Return the y argument of this PositionVector.
	 */
	@Basic @Raw @Immutable
	public double getYArgument() {
		return this.y;
	}
	
	/**
	 * Variable registering the y argument of this PositionVector.
	 */
	private final double y;
	
	/**
	 * Return the z argument of this PositionVector.
	 */
	@Basic @Raw @Immutable
	public double getZArgument() {
		return this.z;
	}
	
	/**
	 * Variable registering the z argument of this PositionVector.
	 */
	private final double z;
	
	/**
	 * Return the sumvector of two given position vectors.
	 * @param vector1	First position vector.
	 * @param vector2	Second position vector.
	 * @return	A position vector that's the sum of vector1 and vector2.
	 * 			| result == new PositionVector(vector1.getXArgument()+vector2.getXArgument(),
	 * 			|								vector1.getYArgument()+vector2.getYArgument(),
	 * 			|									vector1.getZArgument()+vector2.getZArgument()))
	 * @throws	NullPointerException
	 * 			At least one of the given vectors is not effective.
	 * 			| (vector1 == null) || (vector2 == null)
	 */
	public static PositionVector sum(PositionVector vector1, PositionVector vector2) throws NullPointerException {
		return (new PositionVector(vector1.getXArgument()+vector2.getXArgument(),
					vector1.getYArgument()+vector2.getYArgument(),
						vector1.getZArgument()+vector2.getZArgument()));
	}
	
	/**
	 * Multiplies a given vector with a given number.
	 * @param a		The number.
	 * @param vector	The vector.
	 * @return	A position vector that's the result of multiplying the given vector with the given number.
	 * 			| result == new PositionVector(vector.getXArgument()*a, vector.getYArgument()*a, vector.getZArgument()*a)
	 * @throws	NullPointerException
	 * 			The vector is not effective.
	 * 			| vector == null
	 */
	public static PositionVector multiplyBy(double a, PositionVector vector) throws NullPointerException {
		double x = vector.getXArgument()*a;
		double y = vector.getYArgument()*a;
		double z = vector.getZArgument()*a;
		return (new PositionVector(x, y, z));
	}
	
	/**
	 * Compare this position vector with a given position vector.
	 * @param position	The given position vector
	 * @return	True if and only if they are equal.
	 * 			| return == (this.getXArgument() == position.getXArgument()) && (this.getYArgument() == position.getYArgument())
	 * 			| 			&& (this.getYArgument() == position.getYArgument())	
	 * @throws	NullPointerException
	 * 			The vector is not effective.
	 * 			| vector == null
	 */
	public boolean equals(PositionVector position) throws NullPointerException{
		return ((this.getXArgument() == position.getXArgument()) && (this.getYArgument() == position.getYArgument())
				&& (this.getZArgument() == position.getZArgument()));
	}
	
	/**
	 * Calculates the difference vector between to given positions.
	 * @param position	The first position.
	 * @param target	The second position.
	 * @return 	A vector with the argument differences of the given position vectors as its arguments.
	 * 			| result == new PositionVector (position1.getXArgument()-position2.getXArgument(), position1.getYArgument()-position2.getYArgument(), 
	 *			|						position1.getZArgument()-position2.getZArgument())
	 * @throws	NullPointerException
	 * 			At least one of the given vectors is not effective.
	 * 			| (position == null) || (target == null)
	 */
	public static PositionVector calcDifferenceVector(PositionVector position, PositionVector target) throws NullPointerException {
		return (new PositionVector (position.getXArgument()-target.getXArgument(), position.getYArgument()-target.getYArgument(), 
				position.getZArgument()-target.getZArgument()));
	}
	
	/**
	 * Calculates the distance between two positions.
	 * @param position	The first position.
	 * @param target	The second position.
	 * @return	The distance between the two given positions, calculated with the mathematical formula for distance.
	 * 			| result == Math.sqrt(Math.pow(2,calcDifferenceVector(position1, position2).getXArgument()) 
	 * 			| 									+ Math.pow(2,calcDifferenceVector(position1, position2).getYArgument())
	 * 			| 											 + Math.pow(2,calcDifferenceVector(position1, position2).getZArgument()))
	 * @throws	NullPointerException
	 * 			At least one of the given vectors is not effective.
	 * 			| (position == null) || (target == null)
	 */
	public static double calcDistance(PositionVector position, PositionVector target) throws NullPointerException {
		PositionVector difference = PositionVector.calcDifferenceVector(position, target);
		double xDifference = difference.getXArgument();
		double yDiffference = difference.getYArgument();
		double zDifference = difference.getZArgument();
		double xSquare = Math.pow(xDifference,2);
		double ySquare = Math.pow(yDiffference,2);
		double zSquare = Math.pow(zDifference,2);
		double distance = Math.sqrt(xSquare+ySquare+zSquare);
		return distance;
	}
}
