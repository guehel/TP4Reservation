/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservationTest;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reservation.ReservationHelper;
import reservation.donnes.Chambre;
import reservation.dto.ChambreDTO;

/**
 *
 * @author boug18087415
 */
public class ReservationTest {
    
    public ReservationTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void reservationTest(){
        ReservationHelper reservation = new ReservationHelper();
        ChambreDTO[] liste  = reservation.getAvailableRoom();
        System.out.println("Test"+liste.length);
        assertTrue(liste.length>0);
    }
}
