package edu.eci.cvds.labReserves;

import edu.eci.cvds.labReserves.model.User;
import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTest {

    private Reserve reseve;

    @BeforeEach
    void setUp() throws LabReserveException {
        User rodrigo = new User(1, "Rodrigo", "rodrigo@mail", "rodrigo","teacher");
        reseve = new Reserve("lesson", "CVDS", 1);
    }

    @Test
    void testMakeReserveOfTeachers() throws LabReserveException {
        User irma = new User(2, "Irma", "irma@mail", "irma","teacher");
        try {
            Reserve reserveTest = new Reserve("lesson", "POOB", 2);
            assertEquals(reserveTest.getReason(), "POOB");
            assertEquals(reserveTest.getUser(), 2);
        }catch (LabReserveException e){
            fail(e.getMessage());
        }
    }

    @Test
    void testMakeReserveOfAdmin() throws LabReserveException {
        User aurora = new User(3, "Aurora", "aurora@mail", "aurora","admin");
        try {
            Reserve reserveTest = new Reserve("lesson", "MBDA", 3);
            assertEquals(reserveTest.getReason(), "MBDA");
            assertEquals(reserveTest.getUser(), 3);
        }catch (LabReserveException e) {
            fail(e.getMessage());
        }
    }
}
