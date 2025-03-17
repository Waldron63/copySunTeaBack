package edu.eci.cvds.labReserves;

import edu.eci.cvds.labReserves.model.Administrator;
import edu.eci.cvds.labReserves.model.LabReserveException;
import edu.eci.cvds.labReserves.model.Reserve;
import edu.eci.cvds.labReserves.model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveTest {

    private Reserve reseve;

    @BeforeEach
    void setUp() throws LabReserveException {
        Teacher rodrigo = new Teacher(1, "Rodrigo", "rodrigo@mail", "rodrigo");
        reseve = new Reserve("lesson", "CVDS", 1);
    }

    @Test
    void testMakeReserveOfTeachers(){
        Teacher irma = new Teacher(2, "Irma", "irma@mail", "irma");
        try {
            Reserve reserveTest = new Reserve("lesson", "POOB", 2);
            assertEquals(reserveTest.getReason(), "POOB");
            assertEquals(reserveTest.getUser(), 2);
        }catch (LabReserveException e){
            fail(e.getMessage());
        }
    }

    @Test
    void testMakeReserveOfAdmin() {
        Administrator aurora = new Administrator(3, "Aurora", "aurora@mail", "aurora");
        try {
            Reserve reserveTest = new Reserve("lesson", "MBDA", 3);
            assertEquals(reserveTest.getReason(), "MBDA");
            assertEquals(reserveTest.getUser(), 3);
        }catch (LabReserveException e) {
            fail(e.getMessage());
        }
    }
}
