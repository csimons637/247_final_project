import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
    private Date date;
    private LocalTime time;
    
    @BeforeEach
    public void setup() {
        date = DataLoader.parseDate("04-08-2022");
        time = DataLoader.parseTime("16:13");
    }

// Test cases below

    @Test
    public void testDateToString() {
        String newDate = DataWriter.toString(date);
        assertEquals("04-08-2022", newDate);
    }

    @Test
    public void testTimeToString() {
        String newTime = DataWriter.toString(time);
        assertEquals("16:13", newTime);
    }
}
