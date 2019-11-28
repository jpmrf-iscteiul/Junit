package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Compass;
import battleship.Frigate;
import battleship.Galleon;
import battleship.IPosition;
import battleship.Position;

class FrigateTest {
	
	private Compass compass_1;
	private Compass compass_2;
	private Compass compass_3;
	private Compass compass_4;
	private IPosition position_1;
	private IPosition position_2;
	private IPosition position_3;
	private IPosition position_4;
	private IPosition position_g_1;
	private Frigate frigate_1;
	private Frigate frigate_2;
	private Frigate frigate_3;
	private Frigate frigate_4;
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
		position_2 = new Position(4, 5);
		position_3 = new Position(5, 6);
		position_4 = new Position(6, 7);
		position_g_1 = new Position(4, 4);
		galleon = new Galleon(Compass.NORTH, position_g_1);
		compass_1 = Compass.NORTH;
		frigate_1 = new Frigate(compass_1, position_1);	
		compass_2 = Compass.SOUTH;
		frigate_2 = new Frigate(compass_2, position_2);
		compass_3 = Compass.EAST;
		frigate_3 = new Frigate(compass_3, position_3);	
		compass_4 = Compass.WEST;
		frigate_4 = new Frigate(compass_4, position_4);	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSize() {
		assertEquals(4, frigate_1.getSize());
		assertNotEquals(5, frigate_1.getSize());
		assertEquals(4, frigate_2.getSize());
		assertNotEquals(5, frigate_2.getSize());
		assertEquals(4, frigate_3.getSize());
		assertNotEquals(5, frigate_3.getSize());
		assertEquals(4, frigate_4.getSize());
		assertNotEquals(5, frigate_4.getSize());
	}

	@Test
	void testGetCategory() {
		String test_1 = frigate_1.getCategory();
		assertEquals(test_1,"Fragata");
		String test_2 = frigate_1.getCategory();
		assertNotEquals(test_2, "Ola");
		
		String test_3 = frigate_2.getCategory();
		assertEquals(test_3,"Fragata");
		String test_4 = frigate_2.getCategory();
		assertNotEquals(test_4, "Ola");
		
		String test_5 = frigate_3.getCategory();
		assertEquals(test_5,"Fragata");
		String test_6 = frigate_3.getCategory();
		assertNotEquals(test_6, "Ola");
		
		String test_7 = frigate_4.getCategory();
		assertEquals(test_7,"Fragata");
		String test_8 = frigate_4.getCategory();
		assertNotEquals(test_8, "Ola");
	}

	@Test
	void testGetPosition() {
		IPosition position_i_1 = frigate_1.getPosition();
		assertEquals(position_i_1, position_1);
		IPosition position_i_2 = frigate_2.getPosition();
		assertEquals(position_i_2, position_2);
		IPosition position_i_3 = frigate_3.getPosition();
		assertEquals(position_i_3, position_3);
		IPosition position_i_4 = frigate_4.getPosition();
		assertEquals(position_i_4, position_4);
		
		assertNotEquals(position_i_1, position_2);
		assertNotEquals(position_i_2, position_3);
		assertNotEquals(position_i_3, position_4);
		assertNotEquals(position_i_4, position_1);
	}

	@Test
	void testGetBearing() {
		Compass compassAux_1 = frigate_1.getBearing();
		assertEquals(compassAux_1, compass_1);
		Compass compassAux_2 = frigate_2.getBearing();
		assertEquals(compassAux_2, compass_2);
		Compass compassAux_3 = frigate_3.getBearing();
		assertEquals(compassAux_3, compass_3);
		Compass compassAux_4 = frigate_4.getBearing();
		assertEquals(compassAux_4, compass_4);
		
		assertNotEquals(compassAux_1, compass_2);
		assertNotEquals(compassAux_2, compass_3);
		assertNotEquals(compassAux_3, compass_4);
		assertNotEquals(compassAux_4, compass_1);
	}

	@Test
	void testStillFloating() {
		Boolean trueTest = true;
		Boolean falseTest = false;
		
		Boolean floating_1 = frigate_1.stillFloating();
		assertEquals(trueTest, floating_1);
		assertNotEquals(falseTest, floating_1);
		
		Boolean floating_2 = frigate_2.stillFloating();
		assertEquals(trueTest, floating_2);
		assertNotEquals(falseTest, floating_2);
		
		Boolean floating_3 = frigate_3.stillFloating();
		assertEquals(trueTest, floating_3);
		assertNotEquals(falseTest, floating_3);
		
		Boolean floating_4 = frigate_4.stillFloating();
		assertEquals(trueTest, floating_4);
		assertNotEquals(falseTest, floating_4);
	}

	@Test
	void testGetTopMostPos() {
		int pos_1 = frigate_1.getTopMostPos();
		assertEquals(pos_1, 3);
		assertNotEquals(pos_1, 4);
		
		int pos_2 = frigate_2.getTopMostPos();
		assertEquals(pos_2, 4);
		assertNotEquals(pos_2, 5);
		
		int pos_3 = frigate_3.getTopMostPos();
		assertEquals(pos_3, 5);
		assertNotEquals(pos_3, 6);
		
		int pos_4 = frigate_4.getTopMostPos();
		assertEquals(pos_4, 6);
		assertNotEquals(pos_4, 7);
	}

	@Test
	void testGetBottomMostPos() {
		int pos_1 = frigate_1.getBottomMostPos();
		assertEquals(pos_1, 6);
		assertNotEquals(pos_1, 3);
		
		int pos_2 = frigate_2.getBottomMostPos();
		assertEquals(pos_2, 7);
		assertNotEquals(pos_2, 4);
		
		int pos_3 = frigate_3.getBottomMostPos();
		assertEquals(pos_3, 5);
		assertNotEquals(pos_3, 9);
		
		int pos_4 = frigate_4.getBottomMostPos();
		assertEquals(pos_4, 6);
		assertNotEquals(pos_4, 7);
	}

	@Test
	void testGetLeftMostPos() {
		int pos_1 = frigate_1.getLeftMostPos();
		assertEquals(pos_1, 4);
		assertNotEquals(pos_1, 2);
		
		int pos_2 = frigate_2.getLeftMostPos();
		assertEquals(pos_2, 5);
		assertNotEquals(pos_2, 2);
		
		int pos_3 = frigate_3.getLeftMostPos();
		assertEquals(pos_3, 6);
		assertNotEquals(pos_3, 2);
		
		int pos_4 = frigate_4.getLeftMostPos();
		assertEquals(pos_4, 7);
		assertNotEquals(pos_4, 2);
	}

	@Test
	void testGetRightMostPos() {
		int pos_1 = frigate_1.getRightMostPos();
		assertEquals(pos_1, 4);
		assertNotEquals(pos_1, 2);
		
		int pos_2 = frigate_2.getRightMostPos();
		assertEquals(pos_2, 5);
		assertNotEquals(pos_2, 2);
		
		int pos_3 = frigate_3.getRightMostPos();
		assertEquals(pos_3, 9);
		assertNotEquals(pos_3, 2);
		
		int pos_4 = frigate_4.getRightMostPos();
		assertEquals(pos_4, 10);
		assertNotEquals(pos_4, 2);
	}

	@Test
	void testOccupies() {
		boolean occupies = true;
		boolean notOccupies = false;
		
		assertEquals(occupies, frigate_1.occupies(position_1));
		assertNotEquals(notOccupies, frigate_1.occupies(position_1));

		assertEquals(occupies, frigate_2.occupies(position_2));
		assertNotEquals(notOccupies, frigate_2.occupies(position_2));
		
		assertEquals(occupies, frigate_3.occupies(position_3));
		assertNotEquals(notOccupies, frigate_3.occupies(position_3));
		
		assertEquals(occupies, frigate_4.occupies(position_4));
		assertNotEquals(notOccupies, frigate_4.occupies(position_4));
	}

	@Test
	void testTooCloseTo() {
		boolean close_1 = frigate_1.tooCloseTo(galleon);
		boolean close_2 = frigate_2.tooCloseTo(galleon);
		boolean close_3 = frigate_3.tooCloseTo(galleon);
		boolean close_4 = frigate_4.tooCloseTo(galleon);
		
		boolean TRUE = true;
		boolean FALSE = false;
		
		assertEquals(TRUE, close_1);
		assertNotEquals(FALSE, close_1);
		assertEquals(TRUE, close_2);
		assertNotEquals(FALSE, close_2);
		assertEquals(TRUE, close_3);
		assertNotEquals(FALSE, close_3);
		assertEquals(FALSE, close_4);
		assertNotEquals(TRUE, close_4);
	}

	@Test
	void testGetPositions() {
		IPosition position_i_1 = frigate_1.getPosition();
		assertEquals(position_i_1, position_1);
		IPosition position_i_2 = frigate_2.getPosition();
		assertEquals(position_i_2, position_2);
		IPosition position_i_3 = frigate_3.getPosition();
		assertEquals(position_i_3, position_3);
		IPosition position_i_4 = frigate_4.getPosition();
		assertEquals(position_i_4, position_4);
		
		assertNotEquals(position_i_1, position_2);
		assertNotEquals(position_i_2, position_3);
		assertNotEquals(position_i_3, position_4);
		assertNotEquals(position_i_4, position_1);
	}

	@Test
	void testToString() {
		String content_1 = frigate_1.toString();
		assertEquals("[Fragata n Linha = 3 Coluna = 4]", content_1);
		assertNotEquals("[Fragata n Linha = 6 Coluna = 2]", content_1);
		
		String content_2 = frigate_2.toString();
		assertEquals("[Fragata s Linha = 4 Coluna = 5]", content_2);
		assertNotEquals("[Fragata n Linha = 6 Coluna = 2]", content_2);
		
		String content_3 = frigate_3.toString();
		assertEquals("[Fragata e Linha = 5 Coluna = 6]", content_3);
		assertNotEquals("[Fragata n Linha = 6 Coluna = 2]", content_3);
		
		String content_4 = frigate_4.toString();
		assertEquals("[Fragata o Linha = 6 Coluna = 7]", content_4);
		assertNotEquals("[Fragata n Linha = 6 Coluna = 2]", content_4);
	}

}