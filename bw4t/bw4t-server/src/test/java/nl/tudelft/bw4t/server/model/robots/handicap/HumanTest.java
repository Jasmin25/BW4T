package nl.tudelft.bw4t.server.model.robots.handicap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import nl.tudelft.bw4t.server.model.epartners.EPartner;
import nl.tudelft.bw4t.server.model.robots.NavigatingRobot;
import nl.tudelft.bw4t.server.model.robots.handicap.Human;
import nl.tudelft.bw4t.server.model.robots.handicap.IRobot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import repast.simphony.context.Context;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;

/**
 * This test tests the Human bot. It currently tests whether a 
 * human bot can pick up and drop an epartner.
*/
public class HumanTest {
	
    /**
     * space Mock
     */
    @Mock private ContinuousSpace<Object> space;
    @Mock private Grid<Object> grid;

    /**
     * context Mock
     */
    @Mock private Context<Object> context;
    /**
     * point Mock
     */
    @Mock private NdPoint point;
    /**
     * ePartner Mock
     */
    @Mock private EPartner ePartner;
    /**
     * Robot mock out of reach of any epartner
     */
    @Mock private NavigatingRobot outOfReach;
    /**
     * Accompanying IRobot mock
     */
    @Mock private IRobot outBot;
    /**
     * Robot mock in reach of an epartner
     */
    @Mock private NavigatingRobot inReach;
    /**
     * Accompanying IRobot mock
     */
    @Mock private IRobot inBot;
    /**
     * Setup Mocks
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(outBot.getSuperParent()).thenReturn(outOfReach);
        when(inBot.getSuperParent()).thenReturn(inReach);
        when(outOfReach.getHandicapsList()).thenReturn(new ArrayList<String>());
        when(inReach.getHandicapsList()).thenReturn(new ArrayList<String>());
        when(ePartner.getLocation()).thenReturn(new NdPoint(0.0, 0.0));
        when(outOfReach.distanceTo((NdPoint) any())).thenReturn(999.0);
        when(inReach.distanceTo((NdPoint) any())).thenReturn(0.0);
    }
    
    /**
     * - the Human "handicap" was nicely added to the map.
     * - the Human is holding the e-Partner once picked up. 
     */
    @Test
    public void testPickUpEPartner() {
        IRobot r = new Human(new NavigatingRobot("", space, grid, context, true, 1));

        assertTrue(r.getHandicapsList().contains("Human"));

        r.pickUpEPartner(ePartner);
        assertTrue(r.isHoldingEPartner());
    }
    
    /**
     * - the Human drops the e-Partner properly. 
     */
    @Test
    public void testDropEPartner() {
        NavigatingRobot robot = spy(new NavigatingRobot("", space, grid, context, true, 1));
        
		IRobot r = new Human(robot);

        r.pickUpEPartner(ePartner);
        assertTrue(r.isHoldingEPartner());
        
        r.dropEPartner();
        assertFalse(r.isHoldingEPartner());
    	
    }
    /**
     * The human bot tries to drop an epartner without holding it
     * (behavior test).
     */
    @Test
    public void testDropEPartnerNotHolding() {
        NavigatingRobot robot = spy(new NavigatingRobot("", space, grid, context, true, 1));
        IRobot r = new Human(robot);
        r.dropEPartner();
        verifyNoMoreInteractions(ePartner);
    }
    /**
     * can pick up epartner test
     * (result is false).
     * commented out because fail
     */
    @Test
    public void canPickUpEPartnerTest() {
        Human h = new Human(outBot);
        when(ePartner.getLocation()).thenReturn(new NdPoint(4));
        when(h.getSuperParent().getLocation()).thenReturn(new NdPoint(1));
        assertNotSame(h.getLocation(), ePartner.getLocation());
        assertFalse(h.getParent().canPickUp(ePartner));
    }
    
    /**
     * can pick up epartner test
     * (result is true).
     */
    @Test
    public void canPickUpEPartnerTestTrue() {
        Human h = new Human(inBot);
        assertTrue(h.canPickUp(ePartner));
    }
    /**
     * Return EPartner for max. coverage
     */
    @Test
    public void getEPartnerTest() {
        NavigatingRobot robot = spy(new NavigatingRobot("", space, grid, context, true, 1));
        IRobot r = new Human(robot);
        r.pickUpEPartner(ePartner);
        assertTrue(r.getEPartner() == ePartner);
    }
}
