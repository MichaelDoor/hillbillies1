package hillbillies.model;
import java.util.*;
import be.kuleuven.cs.som.annotate.*;

//work out stats in total!
/**
 * @invar  The unitPosition of each unit must be a valid unitPosition for any
 *         unit.
 *       | isValidUnitPosition(getUnitPosition())
 * @invar  The name of each unit must be a valid name for any
 *         unit.
 *       | isValidName(getName())
 * @invar  The strength of each unit must be a valid strength for any
 *         unit.
 *       | isValidStrength(getStrength())
 * @invar  The agility of each unit must be a valid agility for any
 *         unit.
 *       | isValidAgility(getAgility())
 * @invar  The toughness of each unit must be a valid toughness for any
 *         unit.
 *       | isValidToughness(getToughness())
 * @invar  The weight of each unit must be a valid weight for any
 *         unit.
 *       | isValidWeight(getWeight())
 * @invar  The maxHP of each unit must be a valid maxHP for any
 *         unit.
 *       | isValidMaxHP(getMaxHP())
 * @invar  The maxStamina of each unit must be a valid maxStamina for any
 *         unit.
 *       | isValidMaxStamina(getMaxStamina())
 * @invar  The currentHP of each unit must be a valid currentHP for any
 *         unit.
 *       | isValidCurrentHP(getCurrentHP())
 * @invar  The currentStamina of each unit must be a valid currentStamina for any
 *         unit.
 *       | isValidCurrentStamina(getCurrentStamina())
 * @invar  The orientation of each unit must be a valid orientation for any
 *         unit.
 *       | isValidOrientation(getOrientation())
 * @invar  The activityStatus of each unit must be a valid activityStatus for any
 *         unit.
 *       | isValidActivityStatus(getActivityStatus())
 * @invar  The movementstatus of each unit must be a valid movementstatus for any
 *         unit.
 *       | isValidMovementStatus(getMovementStatus())
 * @invar  The current velocity of each unit must be a valid current velocity for any
 *         unit.
 *       | isValidCurrentVelocity(getCurrentVelocity())
 * @invar  The targeted adjacent position of each unit must be a valid targeted adjacent position for any
 *         unit.
 *       | isValidNextPosition(getNextPosition())
 * @invar  The destination of each unit must be a valid destination for any
 *         unit.
 *       | isValidDestination(getDestination())
 * @invar  The decimal stamina of each unit must be a valid decimal stamina for any
 *         unit.
 *       | isValidDoubleStamina(getDoubleStamina())
 * @invar  The work time of each unit must be a valid work time for any
 *         unit.
 *       | isValidWorkTime(getWorkTime())
 * @invar  The attack time of each unit must be a valid attack time for any
 *         unit.
 *       | isValidAttackTime(getAttackTime())
 * @invar  The double type hitpoints of each unit must be a valid double type hitpoints for any
 *         unit.
 *       | isValidDoubleHP(getDoubleHP())
 * @invar  The minimum rest counter of each unit must be a valid minimum rest counter for any
 *         unit.
 *       | isValidMinRestCounter(getMinRestCounter())
 * @invar  The automatic rest counter of each unit must be a valid automatic rest counter for any
 *         unit.
 *       | isValidAutRestCounter(getAutRestCounter())
 * @author Michaël Dooreman
 * @version	0.15
 */
public class Unit {
	
	/**
	 * Initialize this new Unit with given position, name, weight, strength, agility, toughness.
	 * 
	 * @param  position
	 * 		   The position for this new unit.
	 * @param  name
	 * 		   The name for this new unit.
	 * @param  strength
	 * 		   The strength for this new unit.
	 * @param  agility
	 * 		   The agility for this new unit.
	 * @param  toughness
	 * 		   The toughness for this new unit.
	 * @param  weight
	 * 		    The weight for this new unit.
	 * @pre    The given decimal stamina must be a valid decimal stamina for any unit.
	 *       | isValidDoubleStamina(decimal stamina)
	 * @post    The position of this new unit is equal to the cube centre of the given position.
	 * 			| new.getUnitPosition() == centrePosition(position)
	 * @post    The name of this new unit equals the given name.
	 * 			| new.getName() == name
	 * @post    The strength of this new unit equals the given strength.
	 * 			| new.getStrength() == strength
	 * @post    The agility of the new unit equals the given agility.
	 * 			| new.getAgility() == agility
	 * @post    The toughness of this new unit equals the given toughness.
	 * 			| new.getToughness() == toughness
	 * @post    The weight of this new unit equals its strength times its agility, divided by 2.
	 * 			| new.getWeight() == ((new.getStrength())*(new.getAgility()))/2
	 * @post    The maximum amount of hitpoints of this new unit equals 200*(weight/100)*(toughness/100) rounded up.
	 * 			| new.getMaxHP() == 200*(new.getWeight()/100)*(new.getToughness()/100)
	 * @post    The maximum amount of stamina of this new unit equals 200*(weight/100)*(toughness/100) rounded up.
	 * 			| new.getMaxStam() == 200*(new.getWeight()/100)*(new.getToughness()/100)
	 * @post    The orientation of this new unit is Pi/2.
	 * 			| new.getOrientation() == Pi/2
	 * @post    If the given toughness is a valid toughness for any unit,
	 *          the toughness of this new unit is equal to the given
	 *          toughness. Otherwise, the toughness of this new unit is equal
	 *          to 25.
	 *       	| if (isValidToughness(toughness))
	 *       	|   then new.getToughness() == toughness
	 *       	|   else new.getToughness() == 25
	 * @post    If the given agility is a valid agility for any unit,
	 *          the agility of this new unit is equal to the given
	 *          agility. Otherwise, the agility of this new unit is equal
	 *          to 25.
	 *       	| if (isValidAgility(agility))
	 *       	|   then new.getAgility() == agility
	 *       	|   else new.getAgility() == 25
	 * @effect  The maximum hitpoints of this new unit are set.
	 * 			| setMaxHP(calcMaxHPStam(getWeight(), getToughness()))
	 * @effect  The maximum stamina of this new unit is set.
	 * 			|setMaxStamina(calcMaxHPStam(getWeight(), getToughness()))
	 * @effect  The currentStamina and double type stamina of this new unit are equal to the maximum stamina.
	 *       	| this.setDoubleStamina(this.getMaxStamina())
	 * @post    If the given orientation is a valid orientation for any unit,
	 *          the orientation of this new unit is equal to the given
	 *          orientation. Otherwise, the orientation of this new unit is equal
	 *          to Pi/2.
	 *       	| if (isValidOrientation(orientation))
	 *       	|   then new.getOrientation() == orientation
	 *       	|   else new.getOrientation() == Pi/2
	 * @effect The activityStatus of this new unit is set to
	 *         the given activityStatus.
	 *       | this.setActivityStatus(activityStatus)
	 * @effect The current velocity of this new unit is set to
	 *         the given current velocity.
	 *       | this.setCurrentVelocity(currentVelocity)
	 * @effect The targeted adjacent position of this new unit is set to it's current position.
	 *       | this.setNextPosition(new PositionVector(this.getUnitPosition().getXArgument(),this.getUnitPosition().getYArgument(),
			 |	this.getUnitPosition().getZArgument()));
	 * @effect The destination of this new unit is set to
	 *         the given destination.
	 *       | this.setDestination(destination)
	 * @effect The sprinting status of this new unit is set to
	 *         to false by default.
	 *       | this.setSprint(false)
	 * @post   The double type stamina of this new unit is equal to the maximum stamina.
	 *       | new.getDoubleStamina() == this.setDoubleStamina((double)this.getMaxStamina())
	 * @effect The work time of this new unit is set to
	 *         the given work time.
	 *       | this.resetWorkTime()
	 * @effect The attack time of this new unit is set to 0.
	 *       | this.setAttackTime(0)
	 * @effect   The double type hitpoints and current hitpoints of this new unit are set to the maximum amount of hitpoints this unit
	 * 			 can have
	 *       | this.setDoubleHP(this.getMaxHP())
	 * @effect The minimum rest counter of this new unit is set to 0.
	 *       | this.setMinRestCounter(0)
	 * @effect The automatic rest counter of this new unit is set to 0.
	 *       | this.setAutRestCounter(0)
	 * @effect The default behaviour of this new unit is off.
	 *       | this.setDefaultBehaviour(false)
	 * @throws  IllegalArgumentException
	 * 		    One of the given attributes (strength, agility, toughness, weight) does not have a legal initial value.
	 * 			| (! isValidInitialAtt(strength)) || (! isValidInitialAtt(agility)) || (! isValidInitialAtt(toughness))
	 * 			|																	|| (! isValidInitialAtt(weight))
	 * @throws  IllegalArgumentException
	 * 		    The given name is not a valid name.
	 * 			| ! isValidName(name)
	 */
	public Unit(PositionVector position, String name, int strength, int agility, int toughness,int weight) 
													throws IllegalArgumentException {
		if((! isValidInitialAtt(strength)) || (! isValidInitialAtt(agility)) || 
				(! isValidInitialAtt(toughness)) || (! isValidInitialAtt(weight)) || (! isValidName(name)) 
					|| (!isValidUnitPosition(position)) || (!(weight >= ((strength+agility)/2)))) {
			throw new IllegalArgumentException();
		}
		this.setUnitPosition(centrePosition(position));
		this.setName(name);
		this.setStrength(strength);
		this.setAgility(agility);
		this.setToughness(toughness);
		this.setWeight(weight);
		this.setMaxHP(calcMaxHPStam(getWeight(), getToughness()));
		this.setMaxStamina(calcMaxHPStam(getWeight(), getToughness()));
		this.setDoubleHP(this.getMaxHP());
		this.setDoubleStamina(this.getMaxStamina());
		this.setOrientation(Math.PI/2.0);
		this.setActivityStatus("default");
		this.setCurrentVelocity(null);
		this.setNextPosition(new PositionVector(this.getUnitPosition().getXArgument(),this.getUnitPosition().getYArgument(),
				this.getUnitPosition().getZArgument()));
		this.setDestination(new PositionVector(this.getUnitPosition().getXArgument(),this.getUnitPosition().getYArgument(),
				this.getUnitPosition().getZArgument()));
		this.setSprint(false);
		this.setDoubleStamina((double)this.getMaxStamina());
		this.resetWorkTime();
		this.setAttackTime(0);
		this.setMinRestCounter(0);
		this.setAutRestCounter(0);
		this.setDefaultBehaviour(false);
	}


	/**
	 * Return the unitPosition of this unit.
	 */
	@Basic @Raw
	public PositionVector getUnitPosition() {
		return this.position;
	}
	
	/**
	 * Check whether the given unitPosition is a valid unitPosition for
	 * any unit.
	 *  
	 * @param  unitPosition
	 *         The unitPosition to check.
	 * @return 
	 *       | result == ((position.getXArgument() >= 0) && (position.getYArgument() >= 0) && (position.getZArgument() >= 0) &&
	 *       					(position.getXArgument() < 50) && (position.getYArgument() < 50) && (position.getZArgument() < 50))
	*/
	private static boolean isValidUnitPosition(PositionVector position) {
		return ((position.getXArgument() >= 0) && (position.getYArgument() >= 0) && (position.getZArgument() >= 0) &&
				      		(position.getXArgument() < 50) && (position.getYArgument() < 50) && (position.getZArgument() < 50));
	}
	
	/**
	 * Set the unitPosition of this unit to the given unitPosition.
	 * 
	 * @param  position
	 *         The new unitPosition for this unit.
	 * @post   The unitPosition of this new unit is equal to
	 *         the given unitPosition.
	 *       | new.getUnitPosition() == position
	 * @throws IllegalArgumentException
	 *         The given unitPosition is not a valid unitPosition for any
	 *         unit.
	 *       | ! isValidUnitPosition(getUnitPosition())
	 */
	@Raw
	private void setUnitPosition(PositionVector position) 
			throws IllegalArgumentException {
		if (! isValidUnitPosition(position))
			throw new IllegalArgumentException("Out of bounds!");
		this.position = new PositionVector (position.getXArgument(), position.getYArgument(), position.getZArgument());
	}
	
	/**
	 * Variable registering the unitPosition of this unit.
	 */
	private PositionVector position;
		
	/**
	 * Return the cubePosition of this unit.
	 * @effect
	 * 			| result == {(int) this.getUnitPosition().getXArgument(), (int) this.getUnitPosition().getYArgument(),
	 * 			|										(int) this.getUnitPosition().getZArgument()}
	 */
	public int[] getCubePosition() {
		int x = (int) this.getUnitPosition().getXArgument();
		int y = (int) this.getUnitPosition().getYArgument();
		int z = (int) this.getUnitPosition().getZArgument();
		int[] position = {x,y,z};
		return position;
	}
	
	
	/**
	 * Return the name of this unit.
	 */
	@Basic @Raw
	public String getName() {
		return this.name;
	}
	
	/**
	 * Check whether the given name is a valid name for
	 * any unit.
	 *  
	 * @param  name
	 *         The name to check.
	 * @return	True if and only if, the name is longer than 2 character, starts with an uppercase letter and only contains valid
	 * 			characters.
	 *       | result == ((name.length() >= 2) && (Character.isLetter(name.charAt(0))) && (Character.isUpperCase(name.charAt(0)))
	 *       | 																								&& (validCharInName(name))
	*/
	private static boolean isValidName(String name) {
		return ((name.length() >= 2) && (Character.isLetter(name.charAt(0))) && (Character.isUpperCase(name.charAt(0)))
				&& (validCharInName(name)));
	}
	
	private static boolean validCharInName(String name) {
		ArrayList<Character> validCharactersList = new ArrayList<Character>();
		char[] validCharacters = getValidCharacters();
		for(char character: validCharacters){
			validCharactersList.add(character);
		}
		List<Character> characters = new ArrayList<>();
		int k = 0;
		while(k < name.length()) {
			characters.add(name.charAt(k));
			k++;
		}
		int i = 0;
		boolean result = true;
		while ((i < characters.size()) && (result == true)) {
			if (! validCharactersList.contains(Character.toLowerCase(characters.get(i)))) {
				result = false;
			}
			i++;
		}
		return result;
	}
	
	private static char[] validCharacters = {' ','"','\'','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	private static char[] getValidCharacters() {
		return validCharacters;
	}
	
	/**
	 * Set the name of this unit to the given name.
	 * 
	 * @param  name
	 *         The new name for this unit.
	 * @post   The name of this new unit is equal to
	 *         the given name.
	 *       | new.getName() == name
	 * @throws IllegalArgumentException
	 *         The given name is not a valid name for any
	 *         unit.
	 *       | ! isValidName(getName())
	 */
	@Raw
	private void setName(String name) 
			throws IllegalArgumentException {
		if (! isValidName(name))
			throw new IllegalArgumentException();
		this.name = name;
	}
	
	
	
	
	/**
	 * Variable registering the name of this unit.
	 */
	private String name;
	
	/**
	 * Rename this unit to a given name.
	 * @param  name
	 * 		   The new name for this unit.
	 * @effect ...
	 * 			| this.setName(name)
	 */
	public void changeName(String name) {
		this.setName(name);
	}

	/**
	 * Return the weight of this unit.
	 */
	@Basic @Raw
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Check whether the given weight is a valid weight for
	 * any unit.
	 *  
	 * @param  weight
	 *         The weight to check.
	 * @return 
	 *       | result == ((weight >= 1) && (weight <= 200) && (weight >= ((this.getStrength()+this.getAgility())/2)))
	*/
	private boolean isValidWeight(int weight) {
		int strength = this.getStrength();
		int agility = this.getAgility();
		int minBorder = (int) ((strength + agility)/2.0);
		return ((weight >= 1) && (weight <= 200) && (weight >= minBorder));
	}
	
	/**
	 * Set the weight of this unit to the given weight.
	 * 
	 * @param  weight
	 *         The new weight for this unit.
	 * @post   If the given weight is a valid weight for any unit,
	 *         the weight of this new unit is equal to the given
	 *         weight.
	 *       | if (isValidWeight(weight))
	 *       |   then new.getWeight() == weight
	 */
	public void setWeight(int weight) {
		if (isValidWeight(weight))
			this.weight = weight;
	}
	
	/**
	 * Variable registering the weight of this unit.
	 */
	private int weight;
	
	
	/**
	 * Return the strength of this unit.
	 */
	@Basic @Raw
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Check whether the given strength is a valid strength for
	 * any unit.
	 *  
	 * @param  strength
	 *         The strength to check.
	 * @return 
	 *       | result == ((strength >= 1) && (strength <= 200))
	*/
	private static boolean isValidStrength(int strength) {
		return ((strength >= 1) && (strength <= 200));
	}
	
	/**
	 * Set the strength of this unit to the given strength.
	 * 
	 * @param  strength
	 *         The new strength for this unit.
	 * @post   If the given strength is a valid strength for any unit,
	 *         the strength of this new unit is equal to the given
	 *         strength.
	 *       | if (isValidStrength(strength))
	 *       |   then new.getStrength() == strength
	 */
	@Raw
	public void setStrength(int strength) {
		if (isValidStrength(strength))
			this.strength = strength;
	}
	
	/**
	 * Variable registering the strength of this unit.
	 */
	private int strength;

	
	
	/**
	 * Return the agility of this unit.
	 */
	@Basic @Raw
	public int getAgility() {
		return this.agility;
	}
	
	/**
	 * Check whether the given agility is a valid agility for
	 * any unit.
	 *  
	 * @param  agility
	 *         The agility to check.
	 * @return 
	 *       | result == ((agility >= 1) && (agility <= 200))
	*/
	private static boolean isValidAgility(int agility) {
		return ((agility >= 1) && (agility <= 200));
	}
	
	/**
	 * Set the agility of this unit to the given agility.
	 * 
	 * @param  agility
	 *         The new agility for this unit.
	 * @post   If the given agility is a valid agility for any unit,
	 *         the agility of this new unit is equal to the given
	 *         agility.
	 *       | if (isValidAgility(agility))
	 *       |   then new.getAgility() == agility
	 */
	@Raw
	public void setAgility(int agility) {
		if (isValidAgility(agility))
			this.agility = agility;
	}
	
	/**
	 * Variable registering the agility of this unit.
	 */
	private int agility;

	
	
	
	/**
	 * Return the toughness of this unit.
	 */
	@Basic @Raw
	public int getToughness() {
		return this.toughness;
	}
	
	/**
	 * Check whether the given toughness is a valid toughness for
	 * any unit.
	 *  
	 * @param  toughness
	 *         The toughness to check.
	 * @return 
	 *       | result == ((toughness >=1) && (toughness <= 200))
	*/
	private static boolean isValidToughness(int toughness) {
		return ((toughness >=1) && (toughness <= 200));
	}
	
	/**
	 * Set the toughness of this unit to the given toughness.
	 * 
	 * @param  toughness
	 *         The new toughness for this unit.
	 * @post   If the given toughness is a valid toughness for any unit,
	 *         the toughness of this new unit is equal to the given
	 *         toughness.
	 *       | if (isValidToughness(toughness))
	 *       |   then new.getToughness() == toughness
	 */
	@Raw
	public void setToughness(int toughness) {
		if (isValidToughness(toughness))
			this.toughness = toughness;
	}
	
	/**
	 * Variable registering the toughness of this unit.
	 */
	private int toughness;
	
	/**
	 * Check whether the value of the given attribute is a valid initial value.
	 * @param attribute	The value of the attribute.
	 * @return
	 * 		| result == (attribute >= 25) && (attribute <= 100)
	 */
	private static boolean isValidInitialAtt(int attribute) {
		return ((attribute >= 25) && (attribute <= 100));
	}
	
	/**
	 * Return the maxHP of this unit.
	 */
	@Basic @Raw
	public int getMaxHP() {
		return this.maxHP;
	}
	
	/**
	 * Check whether the given maxHP is a valid maxHP for
	 * any unit.
	 *  
	 * @param  maxHP
	 *         The maxHP to check.
	 * @return 
	 *       | result == calcMaxHPStam(getWeight(), getToughness())
	*/
	private boolean isValidMaxHP(int maxHP) {
		return (maxHP == calcMaxHPStam(getWeight(), getToughness()));
	}
	
	/**
	 * Set the maxHP of this unit to the given maxHP.
	 * 
	 * @param  maxHP
	 *         The new maxHP for this unit.
	 * @pre    The given maxHP must be a valid maxHP for any
	 *         unit.
	 *       | isValidMaxHP(maxHP)
	 * @post   The maxHP of this unit is equal to the given
	 *         maxHP.
	 *       | new.getMaxHP() == maxHP
	 */
	@Raw
	private void setMaxHP(int maxHP) {
		assert isValidMaxHP(maxHP);
		this.maxHP = maxHP;
	}
	
	/**
	 * Variable registering the maxHP of this unit.
	 */
	private int maxHP;

	
	/**
	 * Return the maxStamina of this unit.
	 */
	@Basic @Raw
	public int getMaxStamina() {
		return this.maxStamina;
	}
	
	/**
	 * Check whether the given maxStamina is a valid maxStamina for
	 * any unit.
	 *  
	 * @param  maxStamina
	 *         The maxStamina to check.
	 * @return 
	 *       | result == calcMaxHPStam(this.getWeight(), this.getToughness())
	*/
	private boolean isValidMaxStamina(int maxStamina) {
		return (maxStamina == calcMaxHPStam(this.getWeight(), this.getToughness()));
	}
	
	/**
	 * Set the maxStamina of this unit to the given maxStamina.
	 * 
	 * @param  maxStamina
	 *         The new maxStamina for this unit.
	 * @pre    The given maxStamina must be a valid maxStamina for any
	 *         unit.
	 *       | isValidMaxStamina(maxStamina)
	 * @post   The maxStamina of this unit is equal to the given
	 *         maxStamina.
	 *       | new.getMaxStamina() == maxStamina
	 */
	@Raw
	private void setMaxStamina(int maxStamina) {
		assert isValidMaxStamina(maxStamina);
		this.maxStamina = maxStamina;
	}
	
	/**
	 * Variable registering the maxStamina of this unit.
	 */
	private int maxStamina;
	
	/**
	 * Calculates the value for maxHP and maxStamina (hence they are calculated with the same formula) for a given weight and toughness.
	 * @param   weight
	 * 		    The weight.
	 * @param   toughness
	 * 		    The toughness.
	 * @pre     The weight has to be a valid weight.
	 * 			| isValidWeight(weight)
	 * @pre     The toughness has to be a valid toughness.
	 * 			| isValidToughness(toughness)
	 * @effect  
	 * 			| result == 200*((int) Math.ceil(this.getWeight()/100.0))*((int) Math.ceil(this.getToughness()/100.0))
	 */
	private int calcMaxHPStam(int weight, int toughness) {
		assert ((isValidWeight(weight)) && (isValidToughness(toughness)));
		return 200*((int) Math.ceil(this.getWeight()/100.0))*((int) Math.ceil(this.getToughness()/100.0));
	}
	
	/**
	 * Return the currentHP of this unit.
	 */
	@Basic @Raw
	public int getCurrentHP() {
		return this.currentHP;
	}
	
	/**
	 * Check whether the given currentHP is a valid currentHP for
	 * any unit.
	 *  
	 * @param  currentHP
	 *         The currentHP to check.
	 * @return 
	 *       | result == ((currentHP <= this.getMaxHP()) && (currentHP >= 0))
	*/
	private boolean isValidCurrentHP(int currentHP) {
		return ((currentHP <= this.getMaxHP()) && (currentHP >= 0));
	}
	
	/**
	 * Set the currentHP of this unit to the given currentHP.
	 * 
	 * @param  currentHP
	 *         The new currentHP for this unit.
	 * @pre    The given currentHP must be a valid currentHP for any
	 *         unit.
	 *       | isValidCurrentHP(currentHP)
	 * @post   The currentHP of this unit is equal to the given
	 *         currentHP.
	 *       | new.getCurrentHP() == currentHP
	 */
	@Raw
	private void setCurrentHP(int currentHP) {
		assert isValidCurrentHP(currentHP);
		this.currentHP = currentHP;
	}
	
	/**
	 * Variable registering the currentHP of this unit.
	 */
	private int currentHP;
	
	
	
	/**
	 * Return the currentStamina of this unit.
	 */
	@Basic @Raw
	public int getCurrentStamina() {
		return this.currentStamina;
	}
	
	/**
	 * Check whether the given currentStamina is a valid currentStamina for
	 * any unit.
	 *  
	 * @param  currentStamina
	 *         The currentStamina to check.
	 * @return 
	 *       | result == ((currentStamina >= 0) && (currentStamina <= this.getMaxStamina()))
	*/
	private boolean isValidCurrentStamina(int currentStamina) {
		return ((currentStamina >= 0) && (currentStamina <= this.getMaxStamina()));
	}
	
	/**
	 * Set the currentStamina of this unit to the given currentStamina.
	 * 
	 * @param  currentStamina
	 *         The new currentStamina for this unit.
	 * @pre    The given currentStamina must be a valid currentStamina for any
	 *         unit.
	 *       | isValidCurrentStamina(currentStamina)
	 * @post   The currentStamina of this unit is equal to the given
	 *         currentStamina.
	 *       | new.getCurrentStamina() == currentStamina
	 */
	@Raw
	private void setCurrentStamina(int currentStamina) {
		assert isValidCurrentStamina(currentStamina);
		this.currentStamina = currentStamina;
	}
	
	/**
	 * Variable registering the currentStamina of this unit.
	 */
	private int currentStamina;
	
	
	
	/**
	 * Return the orientation of this unit.
	 */
	@Basic @Raw
	public double getOrientation() {
		return this.orientation;
	}
	
	
	/**
	 * Set the orientation of this unit to the given orientation.
	 * 
	 * @param  orientation
	 *         The new orientation for this unit.
	 * @post   If the given orientation is a valid orientation for any unit,
	 *         the orientation of this new unit is equal to the given
	 *         orientation.
	 *       | if (isValidOrientation(orientation))
	 *       |   then new.getOrientation() == orientation
	 */
	@Raw
	private void setOrientation(double orientation) {
			this.orientation =  orientation %(2*Math.PI);
	}
	
	/**
	 * Variable registering the orientation of this unit.
	 */
	private double orientation;
	
	//////////////////////////////////////////////////////// update informal /////////////////////////////
	/**
	 * Let time advance for this unit for a given amount of time.
	 * @param time	The given amount of time.
	 * @effect	This unit's activity status is checked.
	 * 			If the unit is attacking, it continues it's attack.
	 * 			If it's minimum rest counter isn't zero yet, it'll continue to rest until the counter reaches zero, then it'll 
	 * 			continue or start with it's planned activity.
	 * 			If it didn't reach it's destination or next position yet or it's activity status is move, it moves.
	 * 			If it's activity status is wor, it works.
	 * 			If it's activity status is rest, it rests.
	 * 			If it's activity status is default and default behaviour is activated, is starts doing a random activity.
	 * @throws	IllegalArgumentException
	 * 			Time is either negative or equal to or greater then 0.2s.
	 */
	public void advanceTime(double time) 
								throws IllegalArgumentException {
		if ((time < 0) || (time >= 0.2)) {
			throw new IllegalArgumentException();
		}
		String status = this.getActivityStatus();
		if ((status == "default") && (this.getDefaultBehaviour() == true) && ((this.getUnitPosition()).equals(this.getNextPosition())
				|| (this.getUnitPosition()).equals(this.getDestination()))){
			this.randomBehaviour();
			status = this.getActivityStatus();
		}
		if (status == "attack") {
			this.doAttack(time);
		}
		if (this.getMinRestCounter() != 0){
			if (time < this.getMinRestCounter()){
				this.doRest(time);
			}
			else {
				double restingTime = time - this.getMinRestCounter();
				this.doRest(this.getMinRestCounter());
				this.advanceTime(restingTime);
			}
		}
		else if ((status == "move") || ((this.getActivityStatus() == "default") && ((!(this.getUnitPosition()).equals(this.getNextPosition()))
				|| (!(this.getUnitPosition()).equals(this.getDestination()))))) {
				if (this.getUnitPosition().equals(this.getDestination())){
					this.setActivityStatus("default");
					this.advanceTime(time);
				}
				else {
					if (this.getUnitPosition().equals(this.getNextPosition())) {
						this.moveTo(this.getDestination());
						this.move(time);
						}
					else {
						this.move(time);
					}
				}
			}
		else if (status == "work") {
			this.doWork(time);
			}
		else if (status == "rest") {
			this.doRest(time);
		}
	}
	
	/**
	 * Gives this unit a given destination and determines which adjacent cube he has to move to start it's journey.
	 * @param destination	The given destination.
	 * @effect	The unit's destination is set to the centre of the cube of the given destination.
	 * 			| this.setDestination(centrePosition(destination))
	 * @effect	Set this unit's next position to the adjacent cube he has to take on the path to it's destination.
	 * 			| this.moveToAdjacent(adjacent)
	 */
	public void moveTo(PositionVector destination) throws IllegalArgumentException {
		this.setDestination(centrePosition(destination));
		int[] adjacent = {0,0,0};
		int[] destinationCube = {(int) destination.getXArgument(), (int) destination.getYArgument(), (int) destination.getZArgument()};
		if (this.getCubePosition()[0] == destinationCube[0]) {
			adjacent[0] = 0;
					}
		else { if (this.getCubePosition()[0] < destinationCube[0]) {
			adjacent[0] = 1;
			}
			else {
				adjacent[0] = -1;
			}
		}
		if (this.getCubePosition()[1] == destinationCube[1]) {
			adjacent[1] = 0;
					}
		else { if (this.getCubePosition()[1] < destinationCube[1]) {
			adjacent[1] = 1;
			}
			else {
				adjacent[1] = -1;
			}
		}
		if (this.getCubePosition()[2] == destinationCube[2]) {
			adjacent[2] = 0;
					}
		else { if (this.getCubePosition()[2] < destinationCube[2]) {
			adjacent[2] = 1;
			}
			else {
				adjacent[2] = -1;
			}
		}
		this.moveToAdjacent(new PositionVector((double) adjacent[0], (double) adjacent[1], (double) adjacent[2]));
	}
	
	/**
	 * Return the base speed of this unit.
	 * @return	The base speed of this unit calculated with a formula using the strength, agility and weight of this unit.
	 * 			| result == 1.5*(this.getStrength() + this.getAgility())/(200*(this.getWeight()/100.0))
	 */
	public double getBaseSpeed() {
		return (1.5*(this.getStrength() + this.getAgility())/(200*(this.getWeight()/100.0)));
	}
	
	/**
	 * Calculate the walking speed of this unit for a given position in an adjacent cube.
	 * @param targetPosition	The target position, which is in an adjacent cube of this unit's position
	 * @return	The walking speed, calculated by a formula using the current position of the unit and the target position.
	 * 			| if ((targetPosition.getZArgument() - this.getUnitPosition().getZArgument()) == -1) {
	 * 			|		result == 0.5*(this.getBaseSpeed())
	 * 			| else if((targetPosition.getZArgument() - this.getUnitPosition().getZArgument()) == 1) {
	 * 			|			result == 1.2*(this.getBaseSpeed())
	 * 			| return this.getBaseSpeed()
	 * @throws	IllegalArgumentException
	 * 			The given target position is not in an adjacent cube of the unit's position.
	 * 			| !isAdjacent(targetPosition)
	 */
	private double calcWalkingSpeed(PositionVector targetPosition) throws IllegalArgumentException {
		if (! isValidAdjacent(targetPosition)) {
			throw new IllegalArgumentException();
		}
		double zDifference = targetPosition.getZArgument() - this.getUnitPosition().getZArgument();
		double baseSpeed = this.getBaseSpeed();
		if (zDifference == -1) {
			return 0.5*baseSpeed;
		}
		if(zDifference == -1) {
				return 1.2*(baseSpeed);
		}
		return baseSpeed;
	}
	
	/**
	 * Check whether a given position is located in an adjacent cube of the position of this unit.
	 * @param position	The position to check.
	 * @return	True if and only if the given position is in an adjacent cube of this unit's position.
	 * 			| result == (((Math.abs(this.getCubePosition()[0] - (int) position.getXArgument()) == 1) && (Math.abs(this.getCubePosition()[1] - (int) position.getYArgument()) == 0) && (Math.abs(this.getCubePosition()[2] - (int) position.getZArgument()) == 0))
				|	|| (((Math.abs(this.getCubePosition()[0] - (int) position.getXArgument()) == 0) && (Math.abs(this.getCubePosition()[1] - (int) position.getYArgument()) == 1) && (Math.abs(this.getCubePosition()[2] - (int) position.getZArgument()) == 0))
				|		|| (((Math.abs(this.getCubePosition()[0] - (int) position.getXArgument()) == 0) && (Math.abs(this.getCubePosition()[1] - (int) position.getYArgument()) == 0) && (Math.abs(this.getCubePosition()[2] - (int) position.getZArgument()) == 1)))
	 */
	private boolean isValidAdjacent(PositionVector position) {
		int positionX = (int) position.getXArgument();
		int positionY = (int) position.getYArgument();
		int positionZ = (int) position.getZArgument();
		int unitX = this.getCubePosition()[0];
		int unitY = this.getCubePosition()[1];
		int unitZ = this.getCubePosition()[2];
		int[] difference = {Math.abs(unitX-positionX), Math.abs(unitY-positionY), Math.abs(unitZ-positionZ)};
		if (((difference[0] == -1) || (difference[0] == 0) || (difference[0] == 1))
				&& ((difference[1] == -1) || (difference[1] == 0) || (difference[1] == 1))
				&& ((difference[2] == -1) || (difference[2] == 0) || (difference[2] == 1))){
			return true;
		}
		return false;
	}
	
	/**
	 * Let's this unit move to the centre of the adjacent cube of which a position in it is given, if the unit is not already moving
	 * and the given position does not equal the unit's position.
	 * @param position	A combination of an x,y, and z unit PositionVector.
	 * @effect	The current velocity of this unit is set by using the given position.
	 * 			| this.setCurrentVelocity(calcVelocity(this.calcWalkingSpeed(PositionVector.sum(this.getUnitPosition(),position)),
	 * 			|						this.getUnitPosition(),centrePosition(PositionVector.sum(this.getUnitPosition(), position))))
	 * @effect	The next position of this unit is set by using the given position.
	 * 			| this.setNextPosition(centrePosition(PositionVector.sum(this.getUnitPosition(), position)))
	 * @effect	If the given position is the final destination of this unit, than this unit's destination is set to the given position.
	 * 			| this.setDestination(this.getNextPosition());
	 * @throws	IllegalArgumentException
	 * 			The the sum of the given position and the unit's current position is out of bounds.
	 * 			| ! isValidUnitPosition(PositionVector.sum(this.getUnitPosition(),position))
	 * @throws	IllegalArgumentException
	 * 			The sum of the given position and the unit's current position is not in an adjacent cube.
	 * 			| ! isValidAdjacent(PositionVector.sum(this.getUnitPosition(),position))
	 * @throws	IllegalStateException
	 * 			This unit is already moving to an adjacent cube
	 * 			| (this.getActivityStatus() == "move") &&(! this.getUnitPosition().equals(this.getNextPosition()))
	 */
	public void moveToAdjacent(PositionVector position) throws IllegalArgumentException, IllegalStateException {
		if(! position.equals(this.getUnitPosition())){
			if((!isValidUnitPosition(PositionVector.sum(this.getUnitPosition(),position))) || 
								(!isValidAdjacent(PositionVector.sum(this.getUnitPosition(),position)))) {
				throw new IllegalArgumentException();
			}
			if((this.getActivityStatus() == "move") && (! this.getUnitPosition().equals(this.getNextPosition()))) {
				throw new IllegalStateException();
			}
			if(this.getActivityStatus() != "move") {
				this.setActivityStatus("move");
				PositionVector destination = centrePosition(PositionVector.sum(this.getUnitPosition(), position));
				PositionVector velocity = calcVelocity(this.calcWalkingSpeed(PositionVector.sum(this.getUnitPosition(),position)),
						destination, this.getUnitPosition());
				this.setCurrentVelocity(velocity);
				this.setNextPosition(destination);	
			}
			if(this.getUnitPosition().equals(this.getDestination())){
				this.setDestination(this.getNextPosition());
			}
		}
	}
	
	
	
	/**
	 * Calculates the distance between two positions.
	 * @param position	The first position.
	 * @param target	The second position.
	 * @return	The distance between the two given positions, calculated with the mathematical formula for distance.
	 * 			| result == Math.sqrt(Math.pow(2,calcDifferenceVector(position1, position2).getXArgument()) 
	 * 			| 									+ Math.pow(2,calcDifferenceVector(position1, position2).getYArgument())
	 * 			| 											 + Math.pow(2,calcDifferenceVector(position1, position2).getZArgument()))
	 */
	public static double calcDistance(PositionVector position, PositionVector target) {
		PositionVector difference = calcDifferenceVector(position, target);
		double xDifference = difference.getXArgument();
		double yDiffference = difference.getYArgument();
		double zDifference = difference.getZArgument();
		double xSquare = Math.pow(xDifference,2);
		double ySquare = Math.pow(yDiffference,2);
		double zSquare = Math.pow(zDifference,2);
		double distance = Math.sqrt(xSquare+ySquare+zSquare);
		return distance;
	}
	
	/**
	 * Calculates the velocity for a given speed, the target position vector and the start position vector.
	 * @param speed	The speed.
	 * @param targetPosition	The first position.
	 * @param startPosition	The second position.
	 * @return	The velocity vector for the given speed.
	 * 			| result == new PositionVector(speed*calcDifferenceVector(position1, position2).getXArgument()/calcDistance(position1,position2),
	 * 			|					speed*calcDifferenceVector(position1, position2).getYArgument()/calcDistance(position1,position2),
	 * 			|							speed*calcDifferenceVector(position1, position2).getZArgument()/calcDistance(position1,position2))
	 */
	private static PositionVector calcVelocity(double speed, PositionVector targetPosition, PositionVector startPosition) {
		PositionVector difference = calcDifferenceVector(targetPosition, startPosition);
		double xDifference = difference.getXArgument();
		double yDifference = difference.getYArgument();
		double zDifference = difference.getZArgument();
		double distance = calcDistance(targetPosition, startPosition);
		return (new PositionVector(speed*xDifference/distance, speed*yDifference/distance, speed*zDifference/distance));
	}
	
	
	
	/**
	 * Calculates the difference vector between to given positions.
	 * @param position	The first position.
	 * @param target	The second position.
	 * @return 	A vector with the argument differences of the given position vectors as its arguments.
	 * 			| result == new PositionVector (position1.getXArgument()-position2.getXArgument(), position1.getYArgument()-position2.getYArgument(), 
	 *			|						position1.getZArgument()-position2.getZArgument())
	 */
	private static PositionVector calcDifferenceVector(PositionVector position, PositionVector target) {
		return (new PositionVector (position.getXArgument()-target.getXArgument(), position.getYArgument()-target.getYArgument(), 
				position.getZArgument()-target.getZArgument()));
	}
	
	
	/**
	 * Calculates the centre position of the cube that contains the given position.
	 * @param position	The given position.
	 * @return	The centre position as a vector.
	 * 			| result == new PositionVector(
	 */
	private static PositionVector centrePosition(PositionVector position) {
		double x = Math.floor(position.getXArgument()) + (cubeLength/2);
		double y = Math.floor(position.getYArgument()) + (cubeLength/2);
		double z = Math.floor(position.getZArgument()) + (cubeLength/2);
		return (new PositionVector(x,y,z));
	}
	
	/**
	 * A class variable, defining the length of one cube.
	 */
	private final static double cubeLength = 1.0;
	
	
	/**
	 * Return the activityStatus of this unit.
	 */
	@Basic @Raw
	public String getActivityStatus() {
		return this.activityStatus;
	}
	
	/**
	 * Check whether the given activityStatus is a valid activityStatus for
	 * any unit.
	 *  
	 * @param  activityStatus
	 *         The activityStatus to check.
	 * @return 
	 *       | result == ((this.getActivityStatus() == "move") || (this.getActivityStatus() =="work") || 
			 |					(this.getActivityStatus() == "rest") || (this.getActivityStatus() == "attack") ||
			 |						 (this.getActivityStatus() == "default"));
	*/
	private boolean isValidActivityStatus(String activityStatus) {
		return ((activityStatus.equals("move") || (activityStatus.equals("work")) || 
					(activityStatus.equals("rest")) || (activityStatus.equals("attack")) ||
						(activityStatus.equals("default"))));
	}
	
	/**
	 * Set the activityStatus of this unit to the given activityStatus.
	 * 
	 * @param  activityStatus
	 *         The new activityStatus for this unit.
	 * @post   The activityStatus of this new unit is equal to
	 *         the given activityStatus.
	 *       | new.getActivityStatus() == activityStatus
	 * @throws IllegalArgumentException
	 *         The given activityStatus is not a valid activityStatus for any
	 *         unit.
	 *       | ! isValidActivityStatus(getActivityStatus())
	 */
	@Raw
	private void setActivityStatus(String activityStatus) 
			throws IllegalArgumentException {
		if (! isValidActivityStatus(activityStatus))
			throw new IllegalArgumentException();
		this.activityStatus = activityStatus;
	}
	
	/**
	 * Variable registering the activityStatus of this unit.
	 */
	private String activityStatus;
	
	
	/**
	 * Return the current velocity of this unit.
	 */
	@Basic @Raw
	public PositionVector getCurrentVelocity() {
		return this.currentVelocity;
	}
	
	/**
	 * Check whether the given current velocity is a valid current velocity for
	 * any unit.
	 *  
	 * @param  current velocity
	 *         The current velocity to check.
	 * @return 
	 *       | result == true
	*/
	private static boolean isValidCurrentVelocity(PositionVector currentVelocity) {
		return true;
	}
	
	/**
	 * Set the current velocity of this unit to the given current velocity.
	 * 
	 * @param  currentVelocity
	 *         The new current velocity for this unit.
	 * @post   The current velocity of this new unit is equal to
	 *         the given current velocity.
	 *       | new.getCurrentVelocity() == currentVelocity
	 * @throws IllegalArgumentException
	 *         The given current velocity is not a valid current velocity for any
	 *         unit.
	 *       | ! isValidCurrentVelocity(getCurrentVelocity())
	 */
	@Raw
	private void setCurrentVelocity(PositionVector currentVelocity) 
			throws IllegalArgumentException {
		if (! isValidCurrentVelocity(currentVelocity))
			throw new IllegalArgumentException();
		this.currentVelocity = currentVelocity;
	}
	
	/**
	 * Variable registering the current velocity of this unit.
	 */
	private PositionVector currentVelocity;
	
	
	/**
	 * Return the targeted adjacent position of this unit.
	 */
	@Basic @Raw
	public PositionVector getNextPosition() {
		return this.nextPosition;
	}
	
	/**
	 * Check whether the given targeted adjacent position is a valid targeted adjacent position for
	 * any unit.
	 *  
	 * @param  targeted adjacent position
	 *         The targeted adjacent position to check.
	 * @return 
	 *       | result == (this.isValidAdjacent(nextPosition)) ||  (this.getUnitPosition().equals(nextPosition))
	*/
	private boolean isValidNextPosition(PositionVector nextPosition) {
		return ((this.isValidAdjacent(nextPosition)) ||  (this.getUnitPosition().equals(nextPosition)));
	}
	
	/**
	 * Set the targeted adjacent position of this unit to the given targeted adjacent position.
	 * 
	 * @param  nextPosition
	 *         The new targeted adjacent position for this unit.
	 * @post   The targeted adjacent position of this new unit is equal to
	 *         the given targeted adjacent position.
	 *       | new.getNextPosition() == new PositionVector(nextPosition.getXArgument(), nextPosition.getYArgument(),
	 *       | 																					 nextPosition.getZArgument())
	 * @throws IllegalArgumentException
	 *         The given targeted adjacent position is not a valid targeted adjacent position for any
	 *         unit.
	 *       | (! isValidNextPosition(getNextPosition()))
	 */
	@Raw
	private void setNextPosition(PositionVector nextPosition) 
			throws IllegalArgumentException {
		if (! isValidNextPosition(nextPosition)) {
			throw new IllegalArgumentException();
		}
		this.nextPosition = new PositionVector(nextPosition.getXArgument(), nextPosition.getYArgument(), nextPosition.getZArgument());
	}
	
	/**
	 * Variable registering the targeted adjacent position of this unit.
	 */
	private PositionVector nextPosition;
	
	
	/**
	 * Return the destination of this unit.
	 */
	@Basic @Raw
	public PositionVector getDestination() {
		return this.destination;
	}
	
	/**
	 * Check whether the given destination is a valid destination for
	 * any unit.
	 *  
	 * @param  destination
	 *         The destination to check.
	 * @return 
	 *       | result == isValidUnitPosition(destination)
	*/
	private static boolean isValidDestination(PositionVector destination) {
		return isValidUnitPosition(destination);
	}
	
	/**
	 * Set the destination of this unit to the given destination.
	 * 
	 * @param  destination
	 *         The new destination for this unit.
	 * @post   The destination of this new unit is equal to
	 *         the given destination.
	 *       | new.getDestination() == destination
	 * @throws IllegalArgumentException
	 *         The given destination is not a valid destination for any
	 *         unit.
	 *       | ! isValidDestination(getDestination())
	 */
	@Raw
	private void setDestination(PositionVector destination) 
			throws IllegalArgumentException {
		if (! isValidDestination(destination))
			throw new IllegalArgumentException();
		this.destination = destination;
	}
	
	/**
	 * Variable registering the destination of this unit.
	 */
	private PositionVector destination;


	/**
	 * Return the sprinting status of this unit.
	 */
	@Basic @Raw
	public boolean getSprint() {
		return this.sprintStatus;
	}
	
	
	/**
	 * Set the sprinting status of this unit to the given sprinting status.
	 * 
	 * @param  sprintStatus
	 *         The new sprinting status for this unit.
	 * @post   The sprinting status of this new unit is equal to
	 *         the given sprinting status.
	 *       | new.getSprint() == sprintStatus
	 */
	@Raw
	public void setSprint(boolean sprintStatus) {
		this.sprintStatus = sprintStatus;
	}
	
	/**
	 * Variable registering the sprinting status of this unit.
	 */
	private boolean sprintStatus;
	
	/**
	 * Moves this unit for a given amount of time.
	 * @param time	The given amount of time.
	 * @effect	The unit either walks or sprints depending on the sprint status (on or off).
	 * 			| if(this.getSprint() == true) {
	 * 			| 	this.sprint(time) }
	 * 			| else {this.walk(time)}
	 */
	private void move(double time) {
		if(this.getSprint() == true) {
			this.sprint(time);
		} else {
			this.walk(time);
		}
	}
	/**
	 * Lets this unit sprint for a given amount of time, as long as his stamina suffices, else it continues to walk.
	 * @param time	the given amount of time.
	 * @effect	The unit moves at double speed until it's stamina is depleted.
	 * 			| this.miniMove(sprintTime, 2)
	 * @effect	the unit's stamina is decreased for the amount of time that it sprints.
	 * 			| this.decreaseStamina(sprintTime)
	 * @effect	If the unit runs out of stamina, it continues by walking for the resting amount of time and sprint mode is turned off.
	 * 			| this.walk(walkTime)
	 */
	private void sprint(double time) {
		double sprintTime = this.getSprintTime(time);
		double walkTime = time - sprintTime;
		if (sprintTime > 0) {
			this.miniMove(sprintTime, 2);
			this.decreaseStam(sprintTime);
		}
		if (walkTime > 0){
			this.walk(walkTime);
		}	
	}
	/**
	 * Calculates the amount of time this unit is able to sprint of a given amount of time
	 * @param time	The given amount of time
	 * @return	The amount of time this unit is able to sprint.
	 * 			| result ==  (this.getCurrentStam()*0.1) %(time + 0.00001)
	 */
	private double getSprintTime(double time){
		return ((this.getCurrentStamina()*0.1) %(time + 0.0001));	
	}
	
	/**
	 * Decreases the stamina of this unit for a given sprint time.
	 * @param sprintTime	The given sprint time.
	 * @effect	The stamina in double type of this unit is set to the difference of the old stamina and the lost stamina.
	 * 			| this.setDoubleStamina(this.getDoubleStamina() - sprintTime/0.1)
	 * @effect	The stamina of this unit is set to the rounded up double type stamina of this unit.
	 * 			| this.setCurrentStamina((int) Math.round(this.getDoubleStamina()))
	 * @effect	If this unit's stamina is depleted, the sprint mode is set off.
	 * 			| this.setSprint(false)
	 */
	private void decreaseStam(double sprintTime) {
		double lostStamina = sprintTime/0.1;
		this.setDoubleStamina(this.getDoubleStamina() - lostStamina);
		if (this.getCurrentStamina() == 0) {
			this.setSprint(false);
		}
	}
	
	/**
	 * Makes this unit walk for a given amount of time.
	 * @param walkTime The given amount of time.
	 * @effect	This unit moves for the given time at normal walking speed.
	 * 			| this.miniMove(walkTime, 1)
	 */
	private void walk(double walkTime) {
		this.miniMove(walkTime, 1);
	}
	
	/**
	 * Makes this unit move for a given amount of time at a given amount time it's speed.
	 * @param dt	The amount of time.
	 * @param multiplyer How many times the unit's speed.
	 * @effect	This unit's orientation is updated according to the direction it'll move.
	 * 			| this.setOrientation( Math.atan2(this.getCurrentVelocity().getYArgument(),
	 * 			|												 this.getCurrentVelocity().getXArgument()))
	 * @effect	This unit covered a distance by moving at it's speed times multiplier for the given time.
	 * 			| this.setUnitPosition(PositionVector.sum(this.getUnitPosition(), PositionVector.multiplyBy(dt, this.getCurrentVelocity())))
	 * @effect	This unit has reached it's next position if time was sufficient to reach it.
	 * 			| this.setUnitPosition(new PositionVector(this.getNextPosition().getXArgument(),this.getNextPosition().getYArgument(),
				|	this.getNextPosition().getZArgument())))
	 * @effect	In case the unit has time left after reaching it's next position, time advances.
	 * 			| this.advanceTime(restingTime)
	 * @effect	The automatic rest counter is increased with the given amount of time.
	 * 			| this.increaseAutRestCounter(dt)
	 */
	private void miniMove(double dt, int multiplier) {
		double distance = calcDistance(this.getUnitPosition(), this.getNextPosition());
		double speed = calcDistance((new PositionVector(0,0,0)), this.getCurrentVelocity());
		double travelTime = distance/speed;
		this.setOrientation( Math.atan2(this.getCurrentVelocity().getYArgument(), this.getCurrentVelocity().getXArgument()));
		if (travelTime <= dt) {
			this.setUnitPosition(new PositionVector(this.getNextPosition().getXArgument(),this.getNextPosition().getYArgument(),
					this.getNextPosition().getZArgument()));
			this.setActivityStatus("default");
			double restingTime = dt-travelTime;
			if (restingTime > 0) {
				this.advanceTime(restingTime);
			}
		}
		else {
			//PositionVector displacement = PositionVector.multiplyBy(dt, this.getCurrentVelocity());
			//PositionVector newPosition = PositionVector.sum(this.getUnitPosition(), displacement);
			this.setUnitPosition(PositionVector.sum(this.getUnitPosition(), PositionVector.multiplyBy(dt, this.getCurrentVelocity())));
		}
		this.increaseAutRestCounter(dt);
	}
	
	/**
	 * Return the double type stamina of this unit.
	 */
	@Basic
	private double getDoubleStamina() {
		return this.doubleStamina;
	}
	
	/**
	 * Check whether the given decimal stamina is a valid decimal stamina for
	 * any unit.
	 * @param  decimal stamina
	 *         The decimal stamina to check.
	 * @return 
	 *       | result == (doubleStamina > 0) && (doubleStamina <= this.getMaxStamina())
	*/
	private boolean isValidDoubleStamina(double doubleStamina) {
		return ((doubleStamina > 0) && (doubleStamina <= this.getMaxStamina()));
	}
	
	/**
	 * Set the double type stamina and current stamina of this unit to respectively the given double type stamina and it's integer form.
	 * 
	 * @param  doubleStamina
	 *         The new decimal stamina for this unit.
	 * @pre    The given decimal stamina must be a valid decimal stamina for any
	 *         unit.
	 *       | isValidDoubleStamina(doubleStamina)
	 * @effect   The double type stamina of this unit is equal to the given
	 *         double type stamina.
	 *       | new.getDoubleStamina() == doubleStamina
	 *       | this.setCurrentStamina((int) doubleStamina)
	 */

	private void setDoubleStamina(double doubleStamina) {
		assert isValidDoubleStamina(doubleStamina);
		this.doubleStamina = doubleStamina;
		this.setCurrentStamina((int) doubleStamina);
	}
	
	/**
	 * Variable registering the decimal stamina of this unit.
	 */
	private double doubleStamina;
	
	
	/**
	 * Return the work time of this unit.
	 */
	@Basic @Raw
	private double getWorkTime() {
		return this.workTime;
	}
	
	/**
	 * Check whether the given work time is a valid work time for
	 * any unit.
	 *  
	 * @param  work time
	 *         The work time to check.
	 * @return 
	 *       | result == (workTime >= 0) && (workTime <= (500/this.getStrength())
	*/
	private boolean isValidWorkTime(double workTime) {
		return ((workTime >= 0) && (workTime <= (500/this.getStrength())));
	}
	
	/**
	 * Set the work time of this unit to the given work time.
	 * 
	 * @param  workTime
	 *         The new work time for this unit.
	 * @post   The work time of this new unit is equal to
	 *         the given work time.
	 *       | new.getWorkTime() == workTime
	 * @throws IllegalArgumentException
	 *         The given work time is not a valid work time for any
	 *         unit.
	 *       | ! isValidWorkTime(getWorkTime())
	 */
	@Raw
	private void setWorkTime(double workTime) 
			throws IllegalArgumentException {
		if (! isValidWorkTime(workTime))
			throw new IllegalArgumentException();
		this.workTime = workTime;
	}
	
	/**
	 * Reset the work time of this unit to it's maximum.
	 * @effect	The work time of this unit is set to it's maximum.
	 * 			| this.setWorkTime(500/this.getStrength())
	 */
	@Raw
	private void resetWorkTime() {
		this.setWorkTime(500/this.getStrength());
	}
	
	/**
	 * Variable registering the work time of this unit.
	 */
	private double workTime;
	
	/**
	 * Command this unit to work.
	 * @effect	The activity status of this unit is set to work mode.
	 * 			| this.setActivityStatus("work")
	 * @effect	This unit's work time is reset.
	 * 			| this.resetWorkTime()
	 */
	public void work() {
		this.setActivityStatus("work");
		this.resetWorkTime();
	}
	
	/**
	 * Makes this unit work for a given amount of time.
	 * @param time	The given time.
	 * @effect	This unit's work time is reduced by the given amount of time, if the amount of time is smaller than or equal to 
	 * 			the work time.
	 * 			| if (time < this.getWorkTime()) {
	 * 			| 	this.setWorkTime(this.getWorkTime - time) }
	 * @effect	This unit's work time is set to 0 and it's activity status to default, if the given time equals the unit's work time.
	 * 			| if (time == this.getWorkTime()) {
	 * 			| 	this.setWorkTime(0)
	 * 			| 	this.setActivityStatus("default")}
	 * @effect	This unit's work time is depleted and time advances if there's time left, activity status is set to default.
	 * 			| if (this.getWorkTime() < time) {
	 * 			| 	double restingTime = time - this.getWorkTime()
	 * 			| 	this.setWorkTime(0)
	 * 			| 	this.setActivityStatus("default")
	 * 			| 	this.advanceTime(restingTime)}
	 * @effect	The automatic rest counter is increased with the given amount of time.
	 * 			| this.increaseAutRestCounter(time)
	 */
	private void doWork(double time) {
		if (this.getWorkTime() < time) {
			 double restingTime = time - this.getWorkTime();
			 this.setWorkTime(0);
			 this.setActivityStatus("default");
			 this.advanceTime(restingTime);
		}
		if (time == this.getWorkTime()) {
			 this.setWorkTime(0);
			 this.setActivityStatus("default");
		}
		if (time < this.getWorkTime()) {
			 this.setWorkTime(this.getWorkTime() - time);
		}
		this.increaseAutRestCounter(time);
	}
	
	/**
	 * Make this unit attack another unit that's occupying this unit's cube or an adjacent cube when it's not already fighting and does
	 * nothing when already fighting.
	 * @param target	The target unit.
	 * @effect	This unit's minimum resttime is set to zero.
	 * 			| this.setMinRestCounter(0)
	 * @effect	This unit's activity status is set to "attack".
	 * 			| this.setActivityStatus("attack")
	 * @effect	This unit's attack time is reset if it's zero
	 * 			| this.resetAttackTime();
	 * @effect	This unit's orientation is updated to face it's target.
	 * 			| this.setOrientation(Math.atan2((target.getUnitPosition().getYArgument() - this.getUnitPosition().getYArgument()),
	 * 			| 	target.getUnitPosition().getXArgument() - this.getUnitPosition().getXArgument()))
	 */
	public void attack(Unit target) throws IllegalStateException {
		if ((this.getActivityStatus() != "attack") && (this.getActivityStatus() != "defend")) {
			throw new IllegalStateException();
		}
		this.setMinRestCounter(0);
		this.setActivityStatus("attack");
		this.resetAttackTime();
		this.setOrientation(Math.atan2((target.getUnitPosition().getYArgument() - this.getUnitPosition().getYArgument()),
		target.getUnitPosition().getXArgument() - this.getUnitPosition().getXArgument()));
	}
	
	/**
	 * Makes this unit conduct it's attack for a given amount of time and when the attack is over advance time.
	 * @param time	The given amount of time.
	 * @effect	If this unit's attack time is less then the given time, activity status is set default, attack time 0
	 * 			and time advances for the resting time.
	 * 			| if (this.getAttackTime() < time) {
	 * 			| 	double restingTime = time - this.getAttackTime()
	 * 			| 	this.setAttackTime(0)
	 * 			| 	this.setActivityStatus("default")
	 * 			| 	this.advanceTime(restingTime) }
	 * @effect	If this unit's attack time equals the given time, attack time is set 0and activity status to default.
	 * 			| if (this.getAttackTime() == time) {
	 * 			| 	this.setAttackTime(0)
	 * 			| 	this.setActivityStatus("default")}
	 * @effect	When this unit's attack time is larger then the given time, the given time is subtracted from it's attack time.
	 * 			| if (this.getAttackTime > time) {
	 * 			| 	this.setAttackTime(this.getAttackTime() - time)}
	 * @effect	The automatic rest counter is increased with the given amount of time.
	 * 			| this.increaseAutRestCounter(time)
	 */
	private void doAttack(double time) {
		if (this.getAttackTime() < time) {
			 double restingTime = time - this.getAttackTime();
			 this.setAttackTime(0);
			 this.setActivityStatus("default");
			 this.advanceTime(restingTime);
			 }
		if (this.getAttackTime() == time) {
			 this.setAttackTime(0);
			 this.setActivityStatus("default");
		}
		else {
			this.setAttackTime(this.getAttackTime() - time);
		}
		this.increaseAutRestCounter(time);
	}
	
	/**
	 * Return the attack time of this unit.
	 */
	@Basic @Raw
	private double getAttackTime() {
		return this.attackTime;
	}
	
	/**
	 * Check whether the given attack time is a valid attack time for
	 * any unit.
	 *  
	 * @param  attack time
	 *         The attack time to check.
	 * @return 
	 *       | result == (attackTime >= 0) && (attackTime <= 1)
	*/
	private static boolean isValidAttackTime(double attackTime) {
		return ((attackTime >= 0) && (attackTime <= 1));
	}
	
	/**
	 * Set the attack time of this unit to the given attack time.
	 * @param  attackTime
	 *         The new attack time for this unit.
	 * @post   The attack time of this new unit is equal to
	 *         the given attack time.
	 *       | new.getAttackTime() == attackTime
	 * @throws IllegalArgumentException
	 *         The given attack time is not a valid attack time for any
	 *         unit.
	 *       | ! isValidAttackTime(getAttackTime())
	 */
	@Raw
	private void setAttackTime(double attackTime) 
			throws IllegalArgumentException {
		if (! isValidAttackTime(attackTime))
			throw new IllegalArgumentException();
		this.attackTime = attackTime;
	}
	
	/**
	 * Set this unit's attack time to 1 second.
	 * @effect	This unit's attack time is set to 1.
	 * 			| this.setAttackTime(1)
	 */
	@Raw
	private void resetAttackTime() {
		this.setAttackTime(1);
	}
	
	/**
	 * Variable registering the attack time of this unit.
	 */
	private double attackTime;
	
	/**
	 * Makes this unit react to an attack of an enemy by either dodging the attack, blocking it or simply taking damage.
	 * @param enemy	The enemy attacking.
	 * @effect	This unit's minimum resttime is set to zero.
	 * 			| this.setMinRestCounter(0)
	 * @effect	This unit's activity status is set to default.
	 * 			| this.setActivityStatus("default")
	 * @effect	This unit's orientation is set to face it's enemy.
	 * 			| this.setOrientation(Math.atan2((enemy.getUnitPosition().getYArgument() - this.getUnitPosition().getYArgument()),
	 *			|	enemy.getUnitPosition().getXArgument() - this.getUnitPosition().getXArgument()))
	 * @effect	If by chance this unit is able to dodge, it moves to an adjacent cube.
	 * 			| if(this.dodge() == true) {
	 * 			| 	this.moveToAdjacent(this.randomAdjacent())}
	 * @effect	If dodging failed, this unit tries to block the incoming attack by chance, resulting in no damage if successful,
	 * 			else this unit's hitpoints are decreased by the enemy's strength level or is set to 0 if this unit runs out of hitpoints. 
	 * 			| if(this.block() == false) {
	 * 			| 	if(enemy.getStrength() > this.getCurrentHP()) {
	 *			|		this.decreaseHP(this.getCurrentHP())}
	 *			| else{ this.decreaseHP(enemy.getStrength())}
	 */
	public void defend(Unit enemy) {
		this.setMinRestCounter(0);
		this.setActivityStatus("default");
		this.setOrientation(Math.atan2((enemy.getUnitPosition().getYArgument() - this.getUnitPosition().getYArgument()),
				enemy.getUnitPosition().getXArgument() - this.getUnitPosition().getXArgument()));
		if(this.dodge(enemy) == true) {
			this.moveToAdjacent(this.randomAdjacent());
		}
		else if(this.block(enemy) == false) {
			if(enemy.getStrength() > this.getCurrentHP()) {
				this.decreaseHP(this.getCurrentHP());
			}
			else {
				this.decreaseHP(enemy.getStrength());
			}
		}
	}
	
	/**
	 * Return if by chance this unit is able to dodge an attack of the given enemy at this moment.
	 * @param enemy	The given enemy.
	 * @return	True if and only if this unit made it by chance (according to given formula).
	 * 		| result == (new Random()).nextDouble() <= (0.20*(this.getAgility()/enemy.getAgility()))
	 */
	private boolean dodge(Unit enemy) {
		double chance = 0.20*(this.getAgility()/enemy.getAgility());
		Random generator = new Random();
		double random = generator.nextDouble();
		if (random <= chance) {
			return true;
		}
		return false;
	}
	
	/**
	 * Return a random unit vector, giving the direction to a random adjacent cube of this unit.
	 * @return	A random unit vector.
	 * 			| result == 
	 */
	private PositionVector randomAdjacent() {
		PositionVector xPlus = new PositionVector(1, 0, 0);
		PositionVector yPlus = new PositionVector(0, 1, 0);
		PositionVector zPlus = new PositionVector(0, 0, 1);
		PositionVector xMin = new PositionVector(-1, 0, 0);
		PositionVector yMin = new PositionVector(0, -1, 0);
		PositionVector zMin = new PositionVector(0, 0, -1);
		PositionVector[] possibilities = {xPlus,yPlus,zPlus,xMin,yMin,zMin};
		Random generator = new Random();
		int random = generator.nextInt(possibilities.length - 1);
		if (this.isValidAdjacent(PositionVector.sum(this.getUnitPosition(), possibilities[random]))) {
			return possibilities[random];
		}
		else {
			return randomAdjacent();
		}
	}
	
	/**
	 * Return if this unit is able to block an attack of the given enemy at this moment.
	 * @param enemy	The given enemy.
	 * @return	True if and only if this unit made it by chance (according to given formula).
	 * 			| 
	 */
	private boolean block(Unit enemy) {
		double chance = 0.25*((this.getStrength() + this.getAgility())/(enemy.getStrength() + enemy.getAgility()));
		Random generator = new Random();
		double random = generator.nextDouble();
		if (random <= chance) {
			return true;
		}
		return false;
	}
	
	/**
	 * Decrease this unit's hitpoints with a given amount until it has no hitpoints left.
	 * @param amount	The given amount of hitpoints.
	 * @pre 	The given amount has to be smaller then or equals to this Unit's hitpoints.
	 * 			| amount <= this.getCurrentHP()
	 * @effect	This unit's hitpoints are set to the difference of it's old hitpoints and the given amount.
	 * 			| this.setCurrentHP(this.getCurrentHP() - amount)
	 */
	private void decreaseHP(int amount) {
		assert (amount <= this.getCurrentHP());
		
		this.setCurrentHP(this.getCurrentHP() - amount);
	}
	
	// moveToAdjacent ALWAYS has first priority before doing anything else
	// heal1HP ALWAYS has priority except when attacked
	// implement this in advanceTime
	
	/**
	 * Command this unit to rest.
	 * @effect	This unit's activity status is set to 'rest'.
	 * 			| this.setActivityStatus("rest")
	 * @effect	This unit's minimum rest counter is reset.
	 * 			| this.resetMinRestCounter()
	 * @throws	IllegalModelException
	 * 			The unit is in combat or is moving to an adjacent cube.
	 * 			| (this.getActivityStatus() == "attack") || ( (this.getActivityStatus() == "move") &&
	 * 			|														this.getUnitPosition() != this.getNextPosition())
	 */
	public void rest() throws IllegalStateException{
		if((this.getActivityStatus() == "attack") || ( (this.getActivityStatus() == "move") &&
				this.getUnitPosition() != this.getNextPosition())) {
			throw new IllegalStateException("Busy");
		}
		this.setActivityStatus("rest");
		this.resetMinRestCounter();
		
	}
	/**
	 * Makes this unit rest for a given amount of time, resulting in recovering hitpoints and then stamina when all hitpoints 
	 * are recovered.
	 * @param time	The given amount of time.
	 * 			| this.resetRecoveryTime();
	 * @effect	The minimum rest counter of this unit is decreased by the given amount of time.
	 * 			| this.decreaseMinRestCounter(time)
	 * @effect	Hitpoints are recovered.
	 * 			| this.recoverHP(time)
	 * @effect	If after recovering hitpoints for the given time, there's time left, stamina is recovered.
	 * 			| this.recoverStamina(this.recoverHP(time))
	 * @effect	If there's still time left after recovering stamina, this unit's activity status is set to default and time advances
	 * 			for the resting time.
	 * 			| this.setActivityStatus("default")
	 * 			| this.advanceTime(this.recoverStamina(this.recoverHP(time)))
	 * @throws	IllegalStateException
	 * 			This unit's activity status is not 'rest'.
	 * 			| this.getActivityStatus() != "rest"
	 * @throws	IllegalArgumentException
	 *			The given amount of time is negative.
	 *			| time < 0
	 * @effect	The automatic rest counter is increased with the given amount of time.
	 * 			| this.increaseAutRestCounter(time)
	 */
	private void doRest(double time) throws IllegalArgumentException, IllegalStateException {
		if(this.getActivityStatus() != "rest") {
			throw new IllegalStateException();
		}
		if(time < 0){
			throw new IllegalArgumentException();
		}
		
		double t = this.recoverHP(time);
		this.decreaseMinRestCounter(time);
		if(t > 0){
			t = this.recoverStamina(t);
			if(t > 0){
				this.setActivityStatus("default");
				this.advanceTime(t);
			}
		}
		this.increaseAutRestCounter(time);
	}
	
	/**
	 * Regenerate this unit's hitpoints for a given amount of time and give back the unused time.
	 * @param time	The given amount of time.
	 * @return	The unused time.
	 * 			| if(this.getMaxHP() == this.getCurrentHP()) {
	 * 			|		result == time
	 *			|		}
	 *			| double recoveryRate = (this.getToughness()/200)/0.2
	 *			| double neededTime = (this.getMaxHP() - this.getCurrentDoubleHP())/recoveryRate
	 *			| if(neededTime <= time) {
	 *			|	this.setCurrentDoubleHP(this.getMaxHP())
	 *			|	result == (time - neededTime)
	 *			| }
	 *			| this.setCurrentDoubleHP(this.getDoubleHP()+time*recoveryRate)
	 *			| result == 0
	 *@throws	IllegalArgumentException
	 *			The given amount of time is negative.
	 *			| time < 0
	 */
	private double recoverHP(double time)throws IllegalArgumentException {
		if(time < 0){
			throw new IllegalArgumentException();
		}
		if(this.getMaxHP() == this.getCurrentHP()) {
			return time;
			}
		double recoveryRate = (this.getToughness()/200)/0.2;
		double neededTime = (this.getMaxHP() - this.getDoubleHP())/recoveryRate;
		if(neededTime <= time) {
			this.setDoubleHP(this.getMaxHP()); 
			return (time - neededTime);
		}
		this.setDoubleHP(this.getDoubleHP()+time*recoveryRate);
		return 0;
	}
	
	/**
	 * Return the double type hitpoints of this unit.
	 */
	@Basic @Raw
	private double getDoubleHP() {
		return this.doubleHP;
	}
	
	/**
	 * Check whether the given double type hitpoints is a valid double type hitpoints for
	 * any unit.
	 *  
	 * @param  double type hitpoints
	 *         The double type hitpoints to check.
	 * @return 
	 *       | result == (doubleHP >= 0) && (doubleHP <= this.getMaxHP())
	*/
	private boolean isValidDoubleHP(double doubleHP) {
		return ((doubleHP >= 0) && (doubleHP <= this.getMaxHP()));
	}
	
	/**
	 * Set the double type hitpoints and also the current hitpoints of this unit to the given double type hitpoints.
	 * 
	 * @param  doubleHP
	 *         The new double type hitpoints for this unit.
	 * @pre    The given double type hitpoints must be a valid double type hitpoints for any
	 *         unit.
	 *       | isValidDoubleHP(doubleHP)
	 * @effect   The double type hitpoints and current hitpoints of this unit are respectively equal to the given
	 *         double type hitpoints and it's integer form.
	 *       | new.getDoubleHP() == doubleHP
	 *       | this.setDoubleHP(doubleHP)
	 */
	private void setDoubleHP(double doubleHP) {
		assert isValidDoubleHP(doubleHP);
		this.doubleHP = doubleHP;
		this.setCurrentHP((int) doubleHP);
	}
	
	/**
	 * Variable registering the double type hitpoints of this unit.
	 */
	private double doubleHP;
	
	
	/**
	 * Regenerate this unit's stamina for a given amount of time and give back the unused time.
	 * @param time	The given amount of time.
	 * @return	The unused time.
	 * 			| if(this.getMaxStamina() == this.getCurrentStamina()) {
	 * 			|		result == time
	 *			|		}
	 *			| double recoveryRate = (this.getToughness()/100)/0.2
	 *			| double neededTime = (this.getMaxStamina() - this.getCurrentDoubleStamina())/recoveryRate
	 *			| if(neededTime <= time) {
	 *			|	this.setCurrentDoubleStamina(this.getMaxStamina())
	 *			|	result == (time - neededTime)
	 *			| }
	 *			| this.setCurrentDoubleStamina(this.getDoubleStamina()+time*recoveryRate)
	 *			| result == 0
	 *@throws	IllegalArgumentException
	 *			The given amount of time is negative.
	 *			| time < 0
	 */
	private double recoverStamina(double time)throws IllegalArgumentException {
		if(time < 0){
			throw new IllegalArgumentException();
		}
		if(this.getMaxStamina() == this.getCurrentStamina()) {
			return time;
			}
		double recoveryRate = (this.getToughness()/100)/0.2;
		double neededTime = (this.getMaxStamina() - this.getDoubleStamina())/recoveryRate;
		if(neededTime <= time) {
			this.setDoubleStamina(this.getMaxStamina()); 
			return (time - neededTime);
		}
		this.setDoubleStamina(this.getDoubleStamina()+time*recoveryRate);
		return 0;
	}
	
	
	/**
	 * Return the minimum rest counter of this unit.
	 */
	@Basic @Raw
	public double getMinRestCounter() {
		return this.minRestCounter;
	}
	
	/**
	 * Check whether the given minimum rest counter is a valid minimum rest counter for
	 * any unit.
	 *  
	 * @param  minimum rest counter
	 *         The minimum rest counter to check.
	 * @return 
	 *       | result == minRestCounter <= 0.2/(this.getToughness()/200)) || (minRestCounter >= 0)
	*/
	private boolean isValidMinRestCounter(double minRestCounter) {
		return ((minRestCounter <= 0.2/(this.getToughness()/200)) || (minRestCounter >= 0));
	}
	
	/**
	 * Set the minimum rest counter of this unit to the given minimum rest counter.
	 * 
	 * @param  minRestCounter
	 *         The new minimum rest counter for this unit.
	 * @post   The minimum rest counter of this new unit is equal to
	 *         the given minimum rest counter.
	 *       | new.getMinRestCounter() == minRestCounter
	 * @throws IllegalArgumentException
	 *         The given minimum rest counter is not a valid minimum rest counter for any
	 *         unit.
	 *       | ! isValidMinRestCounter(getMinRestCounter())
	 */
	private void setMinRestCounter(double minRestCounter) 
			throws IllegalArgumentException {
		if (! isValidMinRestCounter(minRestCounter))
			throw new IllegalArgumentException();
		this.minRestCounter = minRestCounter;
	}
	
	/**
	 * Reset the minimum rest counter.
	 * @post	The minimum rest counter is set to the amount of time it takes this unit to recover 1 hitpoint.
	 * 			| this.setMinRestCounter(0.2/(this.getToughness()/200))
	 */
	private void resetMinRestCounter() {
		this.setMinRestCounter(0.2/(this.getToughness()/200));
	}
	
	/**
	 * Decreases the minimum rest counter of this unit by the given amount of time, until the counter reaches 0.
	 * @param time	The given amount of time.
	 * @effect	The minimum rest counter is decreased by the given amount of time.
	 * 			| this.setMinRestCounter(this.getMinRestCounter() - time)
	 * @throws IllegalArgumentException
	 * 			The given time is negative.
	 * 			| (time < 0)
	 * @throws IllegalArgumentException
	 * 			The given time is greater than the minimum rest counter.
	 * 			| ((this.getMinRestCounter() - time) < 0)
	 */
	private void decreaseMinRestCounter(double time) throws IllegalArgumentException {
		if(time < 0) {
			throw new IllegalArgumentException();
		}
		try {
			this.setMinRestCounter(this.getMinRestCounter() - time);
		}
		catch (IllegalArgumentException exc) {
			this.setMinRestCounter(0);
		}
	}
	
	/**
	 * Variable registering the minimum rest counter of this unit.
	 */
	private double minRestCounter;
	
	/**
	 * Return the automatic rest counter of this unit.
	 */
	@Basic @Raw
	private double getAutRestCounter() {
		return this.autRestCounter;
	}
	
	/**
	 * Check whether the given automatic rest counter is a valid automatic rest counter for
	 * any unit.
	 *  
	 * @param  automatic rest counter
	 *         The automatic rest counter to check.
	 * @return 
	 *       | result == (autRestCounter >= 0)
	*/
	private static boolean isValidAutRestCounter(double autRestCounter) {
		return (autRestCounter >= 0);
	}
	
	/**
	 * Set the automatic rest counter of this unit to the given automatic rest counter.
	 * 
	 * @param  autRestCounter
	 *         The new automatic rest counter for this unit.
	 * @post   The automatic rest counter of this new unit is equal to
	 *         the given automatic rest counter.
	 *       | new.getAutRestCounter() == autRestCounter
	 * @throws IllegalArgumentException
	 *         The given automatic rest counter is not a valid automatic rest counter for any
	 *         unit.
	 *       | ! isValidAutRestCounter(getAutRestCounter())
	 */
	@Raw
	private void setAutRestCounter(double autRestCounter) 
			throws IllegalArgumentException {
		if (! isValidAutRestCounter(autRestCounter))
			throw new IllegalArgumentException();
		this.autRestCounter = autRestCounter;
	}
	
	/**
	 * Resets the automatic rest counter to zero.
	 * @effect	The automatic rest counter is set to zero.
	 * 			| this.setAutRestCounter(0)
	 */
	private void resetAutRestCounter() {
		this.setAutRestCounter(0);
	}
	
	/**
	 * Increases the automatic rest counter by a given amount of time, when it reaches 3 minutes, this unit automatically rests.
	 * @param time	The given amount of time.
	 * @effect	The automatic rest counter is set at the sum of the old time and the given time.
	 * 			| this.setAutRestCounter(this.getAutRestCounter() + time)
	 * @effect	If the counter is larger than 3 minutes, it is reset and the unit automatically rests.
	 * 			| if(this.getAutRestCounter() >= 180) {
	 * 			| 	this.resetAutRestCounter()
	 * 			| 	this.rest()
	 * @throws IllegalArgumentException
	 * 			The given time is negative.
	 * 			| (time < 0)
	 */
	private void increaseAutRestCounter(double time) throws IllegalArgumentException {
		if(time < 0) {
			throw new IllegalArgumentException();
		}
		this.setAutRestCounter(this.getAutRestCounter() + time);
		if(this.getAutRestCounter() >= 180) {
			this.resetAutRestCounter();
			this.rest();
		}
	}
	/**
	 * Variable registering the automatic rest counter of this unit.
	 */
	private double autRestCounter;


	/**
	 * Return the default behaviour of this unit.
	 */
	@Basic @Raw
	public boolean getDefaultBehaviour() {
		return this.defaultBehaviour;
	}
	
	/**
	 * Set the default behaviour of this unit to the given default behaviour.
	 * 
	 * @param  defaultBehaviour
	 *         The new default behaviour for this unit.
	 * @post   The default behaviour of this new unit is equal to
	 *         the given default behaviour.
	 *       | new.getDefaultBehaviour() == defaultBehaviour
	 * @throws IllegalArgumentException
	 *         The given default behaviour is not a valid default behaviour for any
	 *         unit.
	 *       | ! isValidDefaultBehaviour(getDefaultBehaviour())
	 */
	@Raw
	private void setDefaultBehaviour(boolean defaultBehaviour) {
		this.defaultBehaviour = defaultBehaviour;
	}
	
	/**
	 * Variable registering the default behaviour of this unit.
	 */
	private boolean defaultBehaviour;
	
	/**
	 * Start the default behaviour of this unit.
	 * @effect	The default behaviour is set true.
	 * 			| this.setDefaultBehaviour(true)
	 */
	public void startDefaultBehaviour() {
		this.setDefaultBehaviour(true);
	}
	
	/**
	 * Stop the default behaviour of this unit.
	 * @effect	The default behaviour is set false.
	 * 			| this.setDefaultBehaviour(false)
	 */
	public void stopDefaultBehaviour() {
		this.setDefaultBehaviour(false);
	}
	
	/**
	 * Make this unit do a random action of either walking, sprinting, working, resting or moving.
	 * 
	 */
	private void randomBehaviour() throws IllegalArgumentException{
		Random generator = new Random();
		int action = generator.nextInt(2);
		if (action == 0){
			int sprint = generator.nextInt(1);
			this.moveTo(new PositionVector(generator.nextDouble()*49.99, generator.nextDouble()*49.99, generator.nextDouble()*49.99));
			this.setSprint(sprint == 1);
		}
		if (action == 1){
			this.work();
		}
		if (action == 2) {
			this.rest();
		}
	}
}
