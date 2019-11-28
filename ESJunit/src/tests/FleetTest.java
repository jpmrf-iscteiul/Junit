package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battleship.Carrack;
import battleship.Compass;
import battleship.Fleet;
import battleship.Galleon;
import battleship.IPosition;
import battleship.IShip;
import battleship.Position;
import battleship.Ship;

class FleetTest {

	private List<IShip> ships;
	private Carrack carrack;
	private IPosition position;
	private IPosition positionGalleon;
	private IPosition positionNula;
	private Ship ship;
	private Fleet fleet;
	private Fleet fleet2;
	private Galleon galleon;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ships = new ArrayList<IShip>();
		position = new Position(6, 7);
		positionNula = new Position(30, 25);
		positionGalleon = new Position(2,2);
		carrack = new Carrack(Compass.NORTH,position);
		fleet = new Fleet();
		fleet2 = new Fleet();
		fleet.addShip(carrack);
		galleon = new Galleon(Compass.SOUTH, positionGalleon);

		ships.add(carrack);
	}

	@Test
	public void testFleet() {
		ships = new ArrayList<IShip>();
		position = new Position(6, 7);
		carrack = new Carrack(Compass.NORTH,position);
	}

	@Test
	public void testAddShip() {
		ArrayList<IShip> lista = new ArrayList<IShip>();
		lista.add(carrack);
		assertEquals(lista,ships);
		lista.add(carrack);
		lista.add(carrack);
		assertNotEquals(lista,ships);
	}

	@Test
	public void testListShipsLike() {
		List<IShip> lista = fleet.listShipsLike(carrack.getCategory());
		assertEquals(lista,ships);
		List<IShip> lista1 = fleet.listShipsLike(galleon.getCategory());
		assertNotEquals(lista1, ships);
	}

	@Test
	public void testListFloatingShips() {
		List<IShip> lista = fleet.listFloatingShips();
		List<IShip> lista_1 = null;
		assertEquals(lista, ships);
		assertNotEquals(lista_1, ships);
		
	}

	@Test
	public void testListAllShips() {
		List<IShip> lista = fleet.listAllShips();
		assertEquals(1,lista.size());
		assertNotEquals(2,lista.size());
		
	}

	@Test
	public void testShipAt() {
		IShip ship = fleet.shipAt(position);
		IShip ship2 = fleet.shipAt(positionNula);
		assertEquals(carrack, ship);
    
		Galleon g = new Galleon(Compass.NORTH, new Position(11,11));
		IShip shipo = fleet.shipAt(new Position(11,11));
		assertNotEquals(g, shipo);
		
	}
	
	

}