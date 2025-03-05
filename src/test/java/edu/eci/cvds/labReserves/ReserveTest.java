package edu.eci.cvds.labReserves;

import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTest {

    private Reserve reseve;

    @BeforeEach
    void setUp() throws LabReserveException {
        reseve = new Reserve("CVDS", "Rodrigo");
    }

    @Test
    void testMakeReserveOfTeachers(){
        try {
            Reserve reserveTest = new Reserve("POOB", "Irma");
            assertEquals(reserveTest.getReason(), "POOB");
            assertEquals(reserveTest.getUser(), "Irma");
        }catch (LabReserveException e){
            fail(e.getMessage());
        }
    }

    @Test
    void testMakeReserveOfAdmin() {
        try {
            Reserve reserveTest = new Reserve("lesson", "MBDA", "Laura");
            assertEquals(reserveTest.getReason(), "POOB");
            assertEquals(reserveTest.getUser(), "Irma");
        }catch (LabReserveException e) {
            fail(e.getMessage());
        }
    }
}
