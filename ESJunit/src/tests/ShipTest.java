package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Carrack;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;
import battleship.Ship;

class ShipTest {
	
	private Compass compass_1;
	private Compass compass_2;
	private Compass compass_3;
	private Compass compass_4;
	private IPosition position_1;
	private IPosition position_2;
	private IPosition position_3;
	private IPosition position_4;
	private Ship ship_1;
	private Ship ship_2;
	private Ship ship_3;
	private Ship ship_4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {	
		position_1 = new Position(3, 4);
		position_2 = new Position(5, 1);
		position_3 = new Position(2, 6);
		position_4 = new Position(4, 8);
		compass_1 = Compass.NORTH;
		ship_1 = new Carrack(compass_1, position_1);	
		compass_2 = Compass.SOUTH;
		ship_2 = new Carrack(compass_2, position_2);	
		compass_3 = Compass.EAST;
		ship_3 = new Carrack(compass_3, position_3);	
		compass_4 = Compass.WEST;
		ship_4 = new Carrack(compass_4, position_4);	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStillFloating() {
		Boolean trueTest = true;
		Boolean falseTest = false;
		
		Boolean floating_1 = ship_1.stillFloating();
		assertEquals(trueTest, floating_1);
		assertNotEquals(falseTest, floating_1);
		
		Boolean floating_2 = ship_2.stillFloating();
		assertEquals(trueTest, floating_2);
		assertNotEquals(falseTest, floating_2);
		
		Boolean floating_3 = ship_3.stillFloating();
		assertEquals(trueTest, floating_3);
		assertNotEquals(falseTest, floating_3);
		
		Boolean floating_4 = ship_4.stillFloating();
		assertEquals(trueTest, floating_4);
		assertNotEquals(falseTest, floating_4);
	}

	@Test
	void testGetTopMostPos() {
		int pos_1 = ship_1.getTopMostPos();
		assertEquals(pos_1, 3);
		assertNotEquals(pos_1, 4);
		
		int pos_2 = ship_2.getTopMostPos();
		assertEquals(pos_2, 5);
		assertNotEquals(pos_2, 4);
		
		int pos_3 = ship_3.getTopMostPos();
		assertEquals(pos_3, 2);
		assertNotEquals(pos_3, 4);
		
		int pos_4 = ship_4.getTopMostPos();
		assertEquals(pos_4, 4);
		assertNotEquals(pos_4, 5);
	}

	@Test
	void testGetLeftMostPos() {
		int pos_1 = ship_1.getLeftMostPos();
		assertEquals(pos_1, 4);
		assertNotEquals(pos_1, 2);
		
		int pos_2 = ship_2.getLeftMostPos();
		assertEquals(pos_2, 1);
		assertNotEquals(pos_2, 2);
		
		int pos_3 = ship_3.getLeftMostPos();
		assertEquals(pos_3, 6);
		assertNotEquals(pos_3, 2);
		
		int pos_4 = ship_4.getLeftMostPos();
		assertEquals(pos_4, 8);
		assertNotEquals(pos_4, 2);
	}

//	@Test
//	void testShoot() {
//	}

}