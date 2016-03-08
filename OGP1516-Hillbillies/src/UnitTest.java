import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class UnitTest {
	
	private Unit tester;
	private Unit target;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 50, 50, 50);
		target = new Unit(new PositionVector(2.0,1.0,1.0), "Ikke", 50, 50, 50, 50);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructor_LegalCase() throws Exception {
		Unit man = new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 51, 52, 55);
		assertEquals((man.getUnitPosition()).equals((new PositionVector(1.0,1.0,1.0))), true);
		assertEquals(((man.getName()).equals("Ikke")), true);
		assertEquals(man.getStrength(),50);
		assertEquals(man.getAgility(),51);
		assertEquals(man.getToughness(),52);
		assertEquals(man.getWeight(),55);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructor_IllegalPosition() throws Exception {
		new Unit(new PositionVector(-1.0,1.0,1.0), "Ikke", 50, 50, 50, 50);
	}
	@Test (expected = IllegalArgumentException.class)
	public void constructor_IllegalName() throws Exception {
		new Unit(new PositionVector(1.0,1.0,1.0), "ikke", 50, 50, 50, 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void contructor_IllegalStrength() {
		new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 101, 50, 50, 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void contructor_IllegalAgility() {
		new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 20, 50, 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void contructor_IllegalToughness() {
		new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 50, 300, 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void contructor_IllegalWeight() {
		new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 50, 50, ((50+50)/2)-1);
	}
	
	@Test
	public void sprintOn() {
		tester.setSprint(true);
		assertEquals(tester.getSprint(),true);
		tester.setSprint(false);
		assertEquals(tester.getSprint(),false);
	}
	
	
	@Test
	public void startRest_LegalCase() throws Exception {
		tester.rest();
		assertEquals(tester.getActivityStatus(),"rest");	
	}
	
	@Test
	public void moveToAdjacent_LegalCase() throws Exception {
		tester.moveToAdjacent(new PositionVector(1,0,0));
		assertEquals(tester.getActivityStatus().equals("move"),true);
		assertEquals(tester.getNextPosition().equals(new PositionVector(2.5,1.5,1.5)),true);
		
		double baseSpeed = 1.5;
		assertEquals(baseSpeed,tester.getBaseSpeed(),0.0000001);
		double distance = Math.sqrt(2.25+0.25+0.25);
		PositionVector velocity = new PositionVector(baseSpeed*1.5/distance, baseSpeed*0.5/distance, baseSpeed*0.5/distance);
		assertEquals(velocity.getXArgument(),baseSpeed*1.5/distance,0.0001);
		assertEquals(velocity.getYArgument(),baseSpeed*0.5/distance,0.0001);
		assertEquals(velocity.getZArgument(),baseSpeed*0.5/distance,0.0001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void moveToAdjacent_IllegalAdjacent() throws Exception {
		tester.moveToAdjacent(new PositionVector(1,1,0));
	}
	
	@Test (expected = IllegalStateException.class)
	public void moveToAdjacent_AlreadyMovingToAdjacent() throws Exception {
		tester.moveToAdjacent(new PositionVector(1,0,0));
		tester.moveToAdjacent(new PositionVector(1,0,0));
	}
	
	@Test
	public void getBaseSpeed() {
		assertEquals(1.5,tester.getBaseSpeed(),0.00001);
	}
	
	@Test (expected = IllegalStateException.class)
	public void startRest_IllegalState() throws Exception{
		tester.attack(target);
		tester.rest();
	}
	
	@Test
	public void startWork_LegalCase() throws Exception {
		tester.work();
		assertEquals(tester.getActivityStatus(),"work");
	}
	
	@Test
	public void advanceTime_LegalMoveToAdjacent() {
		tester.moveToAdjacent(new PositionVector(1, 0, 0));
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		tester.advanceTime(0.19);
		PositionVector position = tester.getUnitPosition();
		assertEquals(tester.getUnitPosition().equals(new PositionVector(2.5, 1.5, 1.5)),true);
	}
	
}
