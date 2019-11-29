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
import battleship.Fleet;
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
	private Game game;
	private IPosition position;
	private IPosition badPosition;
	private Carrack carrack;
	
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
		fleet = new Fleet();
		game = new Game(fleet);
		position = new Position(3, 6);
		badPosition = new Position(-2, 19);
		carrack = new Carrack(Compass.NORTH, position);
		fleet.addShip(carrack);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFire() {
		assertEquals(countInvalidShots, 0);
		assertEquals(countRepeatedShots, 0);
		game.fire(position);
		game.fire(position);
		game.fire(badPosition);
		assertNotEquals(countInvalidShots, 2);
		assertNotEquals(countRepeatedShots, 2);
		
	}

	@Test
	void testGetShots() {
		List<IPosition> a = game.getShots();
		List<IPosition> b = new ArrayList<>();
		b.add(position);
		assertEquals(shots, a);
		assertNotEquals(shots, b);
	}

	@Test
	void testGetRepeatedShots() {
		int a = game.getRepeatedShots();
		int b = 99;
		assertEquals(a, countRepeatedShots);
		assertNotEquals(b, countRepeatedShots);
	}

	@Test
	void testGetInvalidShots() {
		int a = game.getInvalidShots();
		int b = 99;
		assertEquals(a, countInvalidShots);
		assertNotEquals(b, countInvalidShots);
	}

	@Test
	void testGetHits() {
		int a = game.getHits();
		int b = 99;
		assertEquals(a, countHits);
		assertNotEquals(b, countHits);
	}

	@Test
	void testGetSunkShips() {
		int a = game.getSunkShips();
		int b = 99;
		assertEquals(a, countSinks);
		assertNotEquals(b, countSinks);
	}

	@Test
	void testGetRemainingShips() {
		int a = game.getRemainingShips();
		int b = 99;
		assertEquals(fleet.listAllShips().size(), a);
		assertNotEquals(fleet.listAllShips().size(), b);
	}

}
