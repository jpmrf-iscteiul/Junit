package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Caravel;
import battleship.Compass;
import battleship.Galleon;
import battleship.IPosition;
import battleship.Position;

class CaravelTest {
	
	private Compass compass_1;
	private IPosition position_1;
	private IPosition position_2;
	private Caravel caravel_1;
	private Galleon galleon;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		position_1 = new Position(3, 4);
		position_2 = new Position(4, 4);
		galleon = new Galleon(Compass.NORTH, position_2);	
		compass_1 = Compass.NORTH;
		caravel_1 = new Caravel(compass_1, position_1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSize() {
		assertEquals(2, caravel_1.getSize());
	}

	@Test
	void testGetCategory() {
		String test_1 = caravel_1.getCategory();
		assertEquals("Caravela",test_1);
		String test_2 = caravel_1.getCategory();
		assertNotEquals("Ola",test_2);
	}

	@Test
	void testGetPosition() {
		IPosition position = caravel_1.getPosition();
		assertEquals(position_1,position);
	}

	@Test
	void testGetBearing() {
		Compass compassAux_1 = caravel_1.getBearing();
		assertEquals(compass_1,compassAux_1);
	}

	@Test
	void testStillFloating() {
		Boolean trueTest = true;
		Boolean floating = caravel_1.stillFloating();
		assertEquals(trueTest, floating);
	}

	@Test
	void testGetTopMostPos() {
		int pos = caravel_1.getTopMostPos();
		assertEquals(3,pos);
		assertNotEquals(4,pos);
	}

	@Test
	void testGetBottomMostPos() {
		int pos = caravel_1.getBottomMostPos();
		assertEquals(4,pos);
		assertNotEquals(3,pos);
	}

	@Test
	void testGetLeftMostPos() {
		int pos = caravel_1.getLeftMostPos();
		assertEquals(4,pos);
		assertNotEquals(2,pos);
	}

	@Test
	void testGetRightMostPos() {
		int pos = caravel_1.getRightMostPos();
		assertEquals(4,pos);
		assertNotEquals(2,pos);
	}

	@Test
	void testOccupies() {
		boolean occupies = true;
		assertEquals(occupies, caravel_1.occupies(position_1));
	}

	@Test
	void testTooCloseTo() {
		boolean close = caravel_1.tooCloseTo(galleon);
		boolean TRUE = true;
		boolean FALSE = false;
		
		assertEquals(TRUE, close);
		assertNotEquals(FALSE, close);
	}

	@Test
	void testGetPositions() {
		IPosition position = caravel_1.getPosition();
		assertEquals(position_1,position);
	}

	@Test
	void testToString() {
		String content = caravel_1.toString();
		assertEquals("[Caravela n Linha = 3 Coluna = 4]", content);
	}

}