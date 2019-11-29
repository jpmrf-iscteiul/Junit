package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Caravel;
import battleship.Carrack;
import battleship.Compass;
import battleship.Galleon;
import battleship.IPosition;
import battleship.Position;
import battleship.Ship;

class PositionTest {
	private Ship galleon;
	private Ship caravel;
	private Ship carrack_1;
	private Ship carrack_2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		IPosition position_1 = new Position(1,1);
		IPosition position_2 = new Position(2,2);
		IPosition position_3 = new Position(1,2);
		IPosition position_4 = new Position(2,1);
		
		caravel = new Caravel(Compass.NORTH, position_1);
		galleon = new Galleon(Compass.SOUTH, position_2);
		carrack_1 = new Carrack(Compass.NORTH, position_3);
		carrack_2 = new Carrack(Compass.SOUTH, position_4);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEqualsIPosition() {
		IPosition aux = new Position(1,1);
		boolean b = true;
		boolean test_1 = aux.equals(caravel.getPosition());
		boolean test_2 = aux.equals(galleon.getPosition());
		boolean test_3 = aux.equals(carrack_1.getPosition());
		boolean test_4 = aux.equals(carrack_2.getPosition());
		
		assertEquals(b, test_1);
		assertNotEquals(b, test_2);
		assertNotEquals(b, test_3);
		assertNotEquals(b, test_4);
	}

	@Test
	void testOccupy() {
		IPosition a = new Position(4,4);
		a.isOccupied();
		
		boolean aux = false;
		
		assertEquals(aux, a.isOccupied());
		assertNotEquals(true, a.isOccupied());
	}

	@Test
	void testIsOccupied() {
		IPosition a = new Position(4,4);
		a.occupy();
		
		boolean aux = false;
		
		assertNotEquals(aux, a.isOccupied());
		assertEquals(true, a.isOccupied());
	}

}