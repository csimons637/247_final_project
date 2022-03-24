import java.util.ArrayList;
import java.util.UUID;

public class Passports {
    private static Passports passport;
    private ArrayList<Passport> passports = new ArrayList<Passport>();

    private Passports() {
        passports = DataLoader.getAllFriends();
    }
    public static Passports getInstance() {
        if (passport == null)
            passport = new Passports();
        return passport;
    }

    public ArrayList<Passport> getAllPassports(){
        return null;
    }
    
    public Passport getPassportsByUUID(UUID passport_id) {
        return null;
    }
}
