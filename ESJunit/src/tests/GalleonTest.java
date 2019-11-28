package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Galleon;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;

class GalleonTest {
	
	private Galleon galleon;
	private Galleon galleon2;
	private Galleon galleon3;
	private Galleon galleon4;
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
		galleon= new Galleon(Compass.EAST,new Position(4,4));
		galleon2 = new Galleon(Compass.NORTH,new Position(5,5));
		galleon3 = new Galleon(Compass.SOUTH,new Position(1,1));
		galleon4 = new Galleon(Compass.WEST,new Position(3,7));
		

		positionsE.add(new Position(4,4));
		positionsE.add(new Position(5,5));
		positionsA.add(galleon.getPosition());
		positionsA.add(galleon2.getPosition());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetSize() {
		int expected = 5;
		int actual = galleon.getSize();
		assertEquals(expected,actual,"The Galleon.getSize() should be 5");
	}

	@Test
	final void testGetCategory() {
		String expected = "Galeao";
		String actual = galleon.getCategory();
		assertEquals(expected,actual,"The Galleon.getCategory() should be Galeao");
	}

	@Test
	final void testGetPosition() {
		Position expected = new Position(4,4);
		Position actual = (Position) galleon.getPosition();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	final void testGetBearing() {
		Compass expected = Compass.EAST;
		Compass actual = galleon.getBearing();
		assertEquals(expected, actual);
		assertEquals(Compass.NORTH,galleon2.getBearing());
		assertEquals(Compass.SOUTH,galleon3.getBearing());
		assertEquals(Compass.WEST,galleon4.getBearing());
	}

	@Test
	final void testStillFloating() {
	Boolean expected = true;
	Boolean actual = galleon.stillFloating();
	assertEquals(expected, actual);
	}

	@Test
	final void testGetTopMostPos() {
	 int expected = 4;
	 int actual = galleon.getTopMostPos();
	 assertEquals(expected, actual);
}

	@Test
	final void testGetBottomMostPos() {
	int expected = 6;
	int actual = galleon.getBottomMostPos();
	assertEquals(expected,actual);
	}

	@Test
	final void testGetLeftMostPos() {
	int expected = 2;
	int actual = galleon.getLeftMostPos();
	//HELPER
	System.out.println(galleon.getBottomMostPos());
	System.out.println(galleon.getRightMostPos());
	System.out.println(galleon.getLeftMostPos());
	System.out.println(galleon.getTopMostPos());
	assertEquals(expected, actual);
	}

	@Test
	final void testGetRightMostPos() {
		int expected = 4;
		int actual = galleon.getRightMostPos();
		assertEquals(expected, actual);
	}

	@Test
	final void testOccupies() {
		Boolean expected = true;
		Boolean actual = galleon.occupies(galleon.getPosition());
		assertEquals(expected, actual);

	}

	@Test
	final void testTooCloseTo() {
		Boolean expected = true;
		Boolean FALSE = false;
		Boolean actual = galleon.tooCloseTo(galleon2);
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
	String expected =  "[" + "Galeao" + " " + Compass.EAST + " " + new Position(4,4).toString() + "]";
	String actual = galleon.toString();
	assertEquals(expected, actual);
	}

}
