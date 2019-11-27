package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Carrack;
import battleship.Compass;
import battleship.IPosition;
import battleship.Position;

class CarrackTest {
	
	private Carrack carrack;
	private Carrack carrack2;
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
		carrack= new Carrack(Compass.EAST,new Position(4,4));
		carrack2 = new Carrack(Compass.EAST,new Position(5,5));
		positionsE.add(new Position(4,4));
		positionsE.add(new Position(5,5));
		positionsA.add(carrack.getPosition());
		positionsA.add(carrack2.getPosition());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetSize() {
		int expected = 3;
		int actual = carrack.getSize();
		assertEquals(expected,actual,"The Carrack.getSize() should be 3");
	}

	@Test
	final void testGetCategory() {
		String expected = "Nau";
		String actual = carrack.getCategory();
		assertEquals(expected,actual,"The Carrack.getCategory() should be Nau");
	}

	@Test
	final void testGetPosition() {
		Position expected = new Position(4,4);
		Position actual = (Position) carrack.getPosition();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	final void testGetBearing() {
		Compass expected = Compass.EAST;
		Compass actual = carrack.getBearing();
		assertEquals(expected, actual);
	}

	@Test
	final void testStillFloating() {
	Boolean expected = true;
	Boolean actual = carrack.stillFloating();
	assertEquals(expected, actual);
	}

	@Test
	final void testGetTopMostPos() {
	 int expected = 4;
	 int actual = carrack.getTopMostPos();
	 assertEquals(expected, actual);
}

	@Test
	final void testGetBottomMostPos() {
	int expected = 4;
	int actual = carrack.getBottomMostPos();
	assertEquals(expected,actual);
	}

	@Test
	final void testGetLeftMostPos() {
	int expected = 4;
	int actual = carrack.getLeftMostPos();
	assertEquals(expected, actual);
		//HELPER
	System.out.println(carrack.getBottomMostPos());
	System.out.println(carrack.getRightMostPos());
	System.out.println(carrack.getLeftMostPos());
	System.out.println(carrack.getTopMostPos());
	}

	@Test
	final void testGetRightMostPos() {
		int expected = 6;
		int actual = carrack.getRightMostPos();
		assertEquals(expected, actual);
	}

	@Test
	final void testOccupies() {
		Boolean expected = true;
		Boolean actual = carrack.occupies(carrack.getPosition());
		assertEquals(expected, actual);

	}

	@Test
	final void testTooCloseTo() {
		Boolean expected = true;
		Boolean FALSE = false;
		Boolean actual = carrack.tooCloseTo(carrack2);
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
	String expected =  "[" + "Nau" + " " + Compass.EAST + " " + new Position(4,4).toString() + "]";
	String actual = carrack.toString();
	assertEquals(expected, actual);
	}

}
