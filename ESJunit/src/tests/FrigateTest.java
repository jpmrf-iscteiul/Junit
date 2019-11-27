package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Frigate;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;

class FrigateTest {
	
	private Frigate frigate;
	private Frigate frigate2;
	private List<IPosition> positionsE = new ArrayList<IPosition>();
	private List<IPosition> positionsA = new ArrayList<IPosition>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		frigate= new Frigate(Compass.EAST,new Position(4,4));
		frigate2 = new Frigate(Compass.EAST,new Position(5,5));
		positionsE.add(new Position(4,4));
		positionsE.add(new Position(5,5));
		positionsA.add(frigate.getPosition());
		positionsA.add(frigate2.getPosition());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetSize() {
		int expected = 4;
		int actual = frigate.getSize();
		assertEquals(expected,actual,"The Frigate.getSize() should be 4");
	}

	@Test
	final void testGetCategory() {
		String expected = "Fragata";
		String actual = frigate.getCategory();
		assertEquals(expected,actual,"The Frigate.getCategory() should be Fragata");
	}

	@Test
	final void testGetPosition() {
		Position expected = new Position(4,4);
		Position actual = (Position) frigate.getPosition();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	final void testGetBearing() {
		Compass expected = Compass.EAST;
		Compass actual = frigate.getBearing();
		assertEquals(expected, actual);
	}

	@Test
	final void testStillFloating() {
	Boolean expected = true;
	Boolean actual = frigate.stillFloating();
	assertEquals(expected, actual);
	}

	@Test
	final void testGetTopMostPos() {
	 int expected = 4;
	 int actual = frigate.getTopMostPos();
	 assertEquals(expected, actual);
}

	@Test
	final void testGetBottomMostPos() {
	int expected = 4;
	int actual = frigate.getBottomMostPos();
	assertEquals(expected,actual);
	}

	@Test
	final void testGetLeftMostPos() {
	int expected = 4;
	int actual = frigate.getLeftMostPos();
	assertEquals(expected, actual);
		//HELPER
	System.out.println(frigate.getBottomMostPos());
	System.out.println(frigate.getRightMostPos());
	System.out.println(frigate.getLeftMostPos());
	System.out.println(frigate.getTopMostPos());
	}

	@Test
	final void testGetRightMostPos() {
		int expected = 7;
		int actual = frigate.getRightMostPos();
		assertEquals(expected, actual);
	}

	@Test
	final void testOccupies() {
		Boolean expected = true;
		Boolean actual = frigate.occupies(frigate.getPosition());
		assertEquals(expected, actual);

	}

	@Test
	final void testTooCloseTo() {
		Boolean expected = true;
		Boolean FALSE = false;
		Boolean actual = frigate.tooCloseTo(frigate2);
		assertEquals(expected, actual);
		assertNotEquals(FALSE, actual);
	}

	@Test
	final void testGetPositions() {
		List<IPosition> expected = positionsE;
		List<IPosition> actual = positionsA;
		assertEquals(expected.toString(), actual.toString());
		
	}

	@Test
	final void testToString() {
	String expected =  "[" + "Fragata" + " " + Compass.EAST + " " + new Position(4,4).toString() + "]";
	String actual = frigate.toString();
	assertEquals(expected, actual);
	}

}
