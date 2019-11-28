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

class GalleonTest {
	
	private Compass compass_1;
	private Compass compass_2;
	private Compass compass_3;
	private Compass compass_4;
	private IPosition position_1;
	private IPosition position_2;
	private Galleon galleon_1;
	private Galleon galleon_2;
	private Galleon galleon_3;
	private Galleon galleon_4;
	private Caravel caravel;

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
		caravel = new Caravel(Compass.NORTH, position_2);
		compass_1 = Compass.NORTH;
		compass_2 = Compass.SOUTH;
		compass_3 = Compass.EAST;
		compass_4 = Compass.WEST;
		galleon_1 = new Galleon(compass_1, position_1);	
		galleon_2 = new Galleon(compass_2, position_1);	
		galleon_3 = new Galleon(compass_3, position_1);	
		galleon_4 = new Galleon(compass_4, position_1);	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSize() {
		assertEquals(5, galleon_1.getSize());
	}

	@Test
	void testGetCategory() {
		String test_1 = galleon_1.getCategory();
		assertEquals(test_1,"Galeao");
		String test_2 = galleon_1.getCategory();
		assertNotEquals(test_2, "Sheep");
	}

	@Test
	void testGetPosition() {
		IPosition position = galleon_1.getPosition();
		assertEquals(position, position_1);
	}

	@Test
	void testGetBearing() {
		Compass compassAux_1 = galleon_1.getBearing();
		assertEquals(compassAux_1, compass_1);
		assertNotEquals(compassAux_1, compass_2);
		assertNotEquals(compassAux_1, compass_3);
		assertNotEquals(compassAux_1, compass_4);
		Compass compassAux_2 = galleon_2.getBearing();
		assertEquals(compassAux_2, compass_2);
		Compass compassAux_3 = galleon_3.getBearing();
		assertEquals(compassAux_3, compass_3);
		Compass compassAux_4 = galleon_4.getBearing();
		assertEquals(compassAux_4, compass_4);
	}

	@Test
	void testStillFloating() {
		Boolean trueTest = true;
		Boolean falseTest = false;
		Boolean floating = galleon_1.stillFloating();
		assertEquals(trueTest, floating);
		assertNotEquals(falseTest, floating);
	}

	@Test
	void testGetTopMostPos() {
		int pos = galleon_1.getTopMostPos();
		assertEquals(pos, 3);
		assertNotEquals(pos, 4);
	}

	@Test
	void testGetBottomMostPos() {
		int pos = galleon_1.getBottomMostPos();
		assertEquals(pos, 5);
		assertNotEquals(pos, 3);
	}

	@Test
	void testGetLeftMostPos() {
		int pos = galleon_1.getLeftMostPos();
		assertEquals(pos, 4);
		assertNotEquals(pos, 2);
	}

	@Test
	void testGetRightMostPos() {
		int pos = galleon_1.getRightMostPos();
		assertEquals(pos, 6);
		assertNotEquals(pos, 2);
	}

	@Test
	void testOccupies() {
		boolean occupies = true;
		assertEquals(occupies, galleon_1.occupies(position_1));
	}

	@Test
	void testTooCloseTo() {
		boolean close = galleon_1.tooCloseTo(caravel);
		boolean TRUE = true;
		boolean FALSE = false;
		
		assertEquals(TRUE, close);
		assertNotEquals(FALSE, close);
	}

	@Test
	void testGetPositions() {
		IPosition position = galleon_1.getPosition();
		assertEquals(position, position_1);
	}

	@Test
	void testToString() {
		String content = galleon_1.toString();
		assertEquals("[Galeao n Linha = 3 Coluna = 4]", content);
	}

}