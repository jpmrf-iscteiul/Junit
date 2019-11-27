package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Caravel;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;

class CaravelTest {
	
	private Caravel caravel;
	private Caravel caravel2;
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
		caravel= new Caravel(Compass.EAST,new Position(4,4));
		caravel2 = new Caravel(Compass.EAST,new Position(5,5));
		positionsE.add(new Position(4,4));
		positionsE.add(new Position(5,5));
		positionsA.add(caravel.getPosition());
		positionsA.add(caravel2.getPosition());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetSize() {
		int expected = 2;
		int actual = caravel.getSize();
		assertEquals(expected,actual,"The Caravel.getSize() should be 2");
	}

	@Test
	final void testGetCategory() {
		String expected = "Caravela";
		String actual = caravel.getCategory();
		assertEquals(expected,actual,"The Caravel.getCategory() should be Caravela");
	}

	@Test
	final void testGetPosition() {
		Position expected = new Position(4,4);
		Position actual = (Position) caravel.getPosition();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	final void testGetBearing() {
		Compass expected = Compass.EAST;
		Compass actual = caravel.getBearing();
		assertEquals(expected, actual);
	}

	@Test
	final void testStillFloating() {
	Boolean expected = true;
	Boolean actual = caravel.stillFloating();
	assertEquals(expected, actual);
	}

	@Test
	final void testGetTopMostPos() {
	 int expected = 4;
	 int actual = caravel.getTopMostPos();
	 assertEquals(expected, actual);
}

	@Test
	final void testGetBottomMostPos() {
	int expected = 4;
	int actual = caravel.getBottomMostPos();
	assertEquals(expected,actual);
	}

	@Test
	final void testGetLeftMostPos() {
	int expected = 4;
	int actual = caravel.getLeftMostPos();
	assertEquals(expected, actual);
		//HELPER
	System.out.println(caravel.getBottomMostPos());
	System.out.println(caravel.getRightMostPos());
	System.out.println(caravel.getLeftMostPos());
	System.out.println(caravel.getTopMostPos());
	}

	@Test
	final void testGetRightMostPos() {
		int expected = 5;
		int actual = caravel.getRightMostPos();
		assertEquals(expected, actual);
	}

	@Test
	final void testOccupies() {
		Boolean expected = true;
		Boolean actual = caravel.occupies(caravel.getPosition());
		assertEquals(expected, actual);

	}

	@Test
	final void testTooCloseTo() {
		Boolean expected = true;
		Boolean FALSE = false;
		Boolean actual = caravel.tooCloseTo(caravel2);
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
	String expected =  "[" + "Caravela" + " " + Compass.EAST + " " + new Position(4,4).toString() + "]";
	String actual = caravel.toString();
	assertEquals(expected, actual);
	}

}
