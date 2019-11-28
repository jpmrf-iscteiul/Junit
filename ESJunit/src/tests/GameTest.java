package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Game;
import battleship.IFleet;
import battleship.IPosition;
import battleship.Position;

class GameTest {
	
	private List<IPosition> shots;
	private IFleet fleet;
	private int countInvalidShots;
	private int countRepeatedShots;
	private int countHits;
	private int countSinks;
	private IPosition pos;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		shots = new ArrayList<IPosition>();
		countInvalidShots = 0;
		countRepeatedShots = 0;
		this.fleet = fleet;
		IPosition pos = new Position(4,4);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testFire(IPosition pos1) {
		
		
	}

	@Test
	final void testGetShots() {
		
	}

	@Test
	final void testGetRepeatedShots() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetInvalidShots() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetHits() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetSunkShips() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetRemainingShips() {
		fail("Not yet implemented"); // TODO
	}

}
