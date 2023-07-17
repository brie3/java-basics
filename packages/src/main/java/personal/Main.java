package personal;

import packages.user.controllers.UserController;
import packages.user.model.*;
import packages.user.utils.Validate;
import packages.user.views.ViewUser;

public class Main {

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationJSON("users.txt");
        Repository repository = new RepositoryFileJSON(fileOperation, new UserMapperJSON());
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);
        view.run();
    }
}
