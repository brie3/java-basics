package packages.persister;

public class PersisterImpl implements Persister {
    public PersisterImpl() {
    }

    public void save(User user) {
        System.out.println("Save user: " + user.getName());
    }
}
