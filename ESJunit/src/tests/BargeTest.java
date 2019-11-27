package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Barge;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;

class BargeTest {
	
	private  Barge barge;
	private Barge barge2;
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
		barge= new Barge(Compass.EAST,new Position(4,4));
		barge2 = new Barge(Compass.EAST,new Position(5,5));
		positionsE.add(new Position(4,4));
		positionsE.add(new Position(5,5));
		positionsA.add(barge.getPosition());
		positionsA.add(barge2.getPosition());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetSize() {
		int expected = 1;
		int actual = barge.getSize();
		assertEquals(expected,actual,"The barge.getSize() should be 1");
	}

	@Test
	final void testGetCategory() {
		String expected = "Barca";
		String actual = barge.getCategory();
		assertEquals(expected,actual,"The barge.getCategory() should be Barca");
	}

	@Test
	final void testGetPosition() {
		Position expected = new Position(4,4);
		Position actual = (Position) barge.getPosition();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	final void testGetBearing() {
		Compass expected = Compass.EAST;
		Compass actual = barge.getBearing();
		assertEquals(expected, actual);
	}

	@Test
	final void testStillFloating() {
	Boolean expected = true;
	Boolean actual = barge.stillFloating();
	assertEquals(expected, actual);
	}

	@Test
	final void testGetTopMostPos() {
	 int expected = 4;
	 int actual = barge.getTopMostPos();
	 assertEquals(expected, actual);
}

	@Test
	final void testGetBottomMostPos() {
	int expected = 4;
	int actual = barge.getBottomMostPos();
	assertEquals(expected,actual);
	}

	@Test
	final void testGetLeftMostPos() {
	int expected = 4;
	int actual = barge.getLeftMostPos();
	assertEquals(expected, actual);
		//HELPER
	System.out.println(barge.getBottomMostPos());
	System.out.println(barge.getRightMostPos());
	System.out.println(barge.getLeftMostPos());
	System.out.println(barge.getTopMostPos());
	}

	@Test
	final void testGetRightMostPos() {
		int expected = 4;
		int actual = barge.getRightMostPos();
		assertEquals(expected, actual);
	}

	@Test
	final void testOccupies() {
		Boolean expected = true;
		Boolean actual = barge.occupies(barge.getPosition());
		assertEquals(expected, actual);

	}

	@Test
	final void testTooCloseTo() {
		Boolean expected = true;
		Boolean FALSE = false;
		Boolean actual = barge.tooCloseTo(barge2);
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
	String expected =  "[" + "Barca" + " " + Compass.EAST + " " + new Position(4,4).toString() + "]";
	String actual = barge.toString();
	assertEquals(expected, actual);
	}

}
