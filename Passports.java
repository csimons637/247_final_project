import java.util.ArrayList;
import java.util.UUID;

public class Passports {
    private static Passports passport;
    private ArrayList<Passport> passports = new ArrayList<Passport>();

    private Passports(){
        passports = DataLoader.getAllFriends();
    }

    public static Passports getInstance(){
        if(passport == null){
            passport = new Passports();
        }
        return passport;
    }

    public boolean havePassport(String keyword){
        return true;
    }

    public ArrayList<Passport> getAllPassports(){
        return DataLoader.getAllFriends();
    }
    
    public Passport getPassportsByUUID(UUID passport_id) {
        for(Passport passport: passports) {
            if(passport.getUUID().equals(passport_id)) {
                return passport;
            }
        }
        return null;
    }
}
