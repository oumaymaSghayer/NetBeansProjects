/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oumayma
 */
public class NavigationControllerIT {
    
    public NavigationControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPageId method, of class NavigationController.
     */
    @Test
    public void testGetPageId() {
        System.out.println("getPageId");
        NavigationController instance = new NavigationController();
        String expResult = "";
        String result = instance.getPageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPageId method, of class NavigationController.
     */
    @Test
    public void testSetPageId() {
        System.out.println("setPageId");
        String pageId = "";
        NavigationController instance = new NavigationController();
        instance.setPageId(pageId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveToPage1 method, of class NavigationController.
     */
    @Test
    public void testMoveToPage1() {
        System.out.println("moveToPage1");
        NavigationController instance = new NavigationController();
        String expResult = "";
        String result = instance.moveToPage1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showPage method, of class NavigationController.
     */
    @Test
    public void testShowPage() {
        System.out.println("showPage");
        NavigationController instance = new NavigationController();
        String expResult = "";
        String result = instance.showPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processPage1 method, of class NavigationController.
     */
    @Test
    public void testProcessPage1() {
        System.out.println("processPage1");
        NavigationController instance = new NavigationController();
        String expResult = "";
        String result = instance.processPage1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processPage2 method, of class NavigationController.
     */
    @Test
    public void testProcessPage2() {
        System.out.println("processPage2");
        NavigationController instance = new NavigationController();
        String expResult = "";
        String result = instance.processPage2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
