
import packages.persister.PersisterImpl;
import packages.persister.User;

public class hw6 {
    public static void main(String[] args) {
        var persister = new PersisterImpl();
        var user = new User("Bob");
        persister.save(user);
        user.report();
    }
}
