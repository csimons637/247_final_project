import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getAllUsers();

    @BeforeEach
    public void setup() {
        userList.clear();
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Date date = new Date();
        ArrayList<Passport> friendsList = DataLoader.getAllPassports();
        userList.add(new RegisteredUser(id1, "Carlos", "Santana", "C_Santana", "123 Hollywood Blvd", date, "csantana@gmail.com", friendsList));
        userList.add(new RegisteredUser(id2, "Olivia", "Santana", "O_Santana", "123 Hollywood Blvd", date, "osantana@gmail.com", friendsList));
        DataWriter.saveUsers();
    }

    // @AfterEach
    // public void tearDown() {
    //     Users.getInstance().getAllUsers().clear();
    //     DataWriter.saveUsers();
    // }

// Test cases below

    @Test
    public void testGetUsersSize() {
        userList = DataLoader.getAllUsers();
        assertEquals(2, userList.size());
    }

    @Test
    public void testGetUsername() {
        userList = DataLoader.getAllUsers();
        assertEquals("C_Santana", userList.get(0).getUsername());
    }

    @Test
    public void testGetUserAddress() {
        userList = DataLoader.getAllUsers();
        assertEquals("123 Hollywood Blvd", userList.get(0).getAddress());
    }
}
