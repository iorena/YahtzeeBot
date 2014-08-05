    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartyahtzee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author essalmen
 */
public class DiceSetTest {
    
    public DiceSetTest() {
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
     * Test of throwDice method, of class DiceSet.
     */
    @Test
    public void testThrowDice() {
        System.out.println("throwDice");
        DiceSet instance = new DiceSet();
        
        int[] results = new int[6];
        for (int i = 0; i<10000; i++)
        {
            instance.throwDice();
            for (int j = 0; j < 5; j++)
            {
                int result = instance.getDie(j).getNumber();
                results[result-1]++;
                
            }
        }
        int difference = Math.abs(results[0]-results[2]);
        System.out.println(difference);
        assertTrue(difference < 20); 
    }

    /**
     * Test of toggleLock method, of class DiceSet.
     */
    @Test
    public void testToggleLock() {
        System.out.println("toggleLock");
        int index = 0;
        DiceSet instance = new DiceSet();
        instance.toggleLock(index);
        assertTrue(instance.getDie(index).isLocked());
    }

    /**
     * Test of unlockAll method, of class DiceSet.
     */
    @Test
    public void testUnlockAll() {
        System.out.println("unlockAll");
        DiceSet instance = new DiceSet();
        instance.toggleLock(1);
        instance.unlockAll();
        
        assertFalse(instance.getDie(1).isLocked());
    
    }

    /**
     * Test of asArray method, of class DiceSet.
     */
    @Test
    public void testAsArray() {
        System.out.println("asArray");
        DiceSet instance = new DiceSet();
        instance.getDie(0).setNumber(3);
        instance.getDie(1).setNumber(2);
        instance.getDie(2).setNumber(1);
        instance.getDie(3).setNumber(5);
        instance.getDie(4).setNumber(4);
        int[] expResult = {1, 2, 3, 4, 5};
        int[] result = instance.asArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of toString method, of class DiceSet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DiceSet instance = new DiceSet();
        for (Die d : instance.getDice())
        {
            d.setNumber(1);
        }
        instance.getDie(1).lock();
        String expResult = "1 (1) 1 1 1 ";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
    
}