package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Compass;
import battleship.Frigate;
import battleship.Galleon;
import battleship.IPosition;
import battleship.IShip;
import battleship.Position;

class FleetTest {
	
	private List<IShip> ships;
	private List<IShip> ships1;
	private Galleon galleon;
	private Frigate	frigate;
	private Frigate	frigate2;
	private List<IShip> shipsLikeA = new ArrayList<IShip>();
	private List<IShip> shipsLikeE = new ArrayList<IShip>();
	private List<IShip> floatingShips = new ArrayList<IShip>();
	private List<IShip> allShips = new ArrayList<IShip>();

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ships = new ArrayList<IShip>();
		galleon = new Galleon(Compass.EAST,new Position(4,4));
		frigate = new Frigate(Compass.EAST,new Position(3,3));
		frigate2 = new Frigate(Compass.EAST,new Position(5,5));
		ships.add(galleon);
		ships.add(frigate);
		ships.add(frigate2);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	

@Test
	final void testFleet() {
		System.out.println("This test ran");
		System.out.println(ships.size());
	}

	@Test
	final void testAddShip() {
	Boolean expected = true;
	assertEquals(expected, ships.add(galleon));
	
	}

	@Test
	final void testListShipsLike() {	
		String category = "Fragata";
		for (IShip s: ships) {
			if (s.getCategory().equals(category)) 
				shipsLikeE.add(s);
			
		}
		shipsLikeA.add(frigate);
		shipsLikeA.add(frigate2);
		assertEquals(shipsLikeE, shipsLikeA);
	}

	@Test
	final void testListFloatingShips() {
		for (IShip s: ships) {
			if (s.stillFloating()) {
				floatingShips.add(s);
			}
		}
		assertEquals(ships,floatingShips);
	}

	@Test
	final void testListAllShips() {
		for (IShip s: ships) {
			allShips.add(s);
		}
		assertEquals(ships, allShips);
		
	}

//	@Ignore
//	final void testShipAt() {
//		String a = null;
//		Position position = new Position(3,3);
////		ships.get(i).occupies(position));
//		
//		System.out.println(a);
//		
//		
//	}

}
