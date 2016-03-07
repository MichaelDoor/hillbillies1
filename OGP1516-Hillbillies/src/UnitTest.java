import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ogp.framework.util.ModelException;

public class UnitTest {
	
	private Unit tester;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 50, 50, 50);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructor_LegalCase() {
		new Unit(new PositionVector(1.0,1.0,1.0), "Ikke", 50, 50, 50, 50);
	}
	
	@Test
	public void rest_LegalCase() throws ModelException {
		tester.rest();
		assertEquals(tester.getActivityStatus(),"rest");
		
	}

}
