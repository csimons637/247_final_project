import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getAllUsers();
    
    @BeforeEach
    public void setup() {
        userList.clear();
        UUID userID = UUID.randomUUID();
        Date date = new Date();
        ArrayList<Passport> friendsList = DataLoader.getAllPassports();
        userList.add(new RegisteredUser(userID, "Matt", "Crowe", "M_Crowe", "6 Holly Ct", date, "mcrowe@gmail.com", friendsList));
        userList.add(new RegisteredUser(userID, "Rebekah", "Crowe", "R_Crowe", "6 Holly Ct", date,"rcrowe@gmail.com", friendsList));
        DataWriter.saveUsers();
    }
    
//Test cases
    @Test
    public void testHaveUserOne(){
        boolean hasMatt = users.haveUser("Matt");
        assertTrue(hasMatt);
    }

    @Test
    public void testHaveUserTwo(){
        boolean hasBeks = users.haveUser("Rebekah");
        assertTrue(hasBeks);
    }

    @Test
    public void testNoUser(){
        Boolean hasBailey = users.haveUser("bseymour");
        assertFalse(hasBailey);
    }

    @Test
    public void testUserNull(){
        boolean hasNull = users.haveUser(null);
        assertFalse(hasNull);
    }

}
