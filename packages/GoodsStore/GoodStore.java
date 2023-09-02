package packages.GoodsStore;

import java.io.InputStream;
import java.util.Scanner;

import packages.GoodsStore.Repository.Repository;
import packages.GoodsStore.Repository.Files.Files;

public class GoodStore {
    private String createMessage = "Введите имя, количество, вес выигрыша\n"
            + "через пробелы без запятых.\n";
    private Scanner is = null;
    private Repository repo = null;

    public GoodStore(InputStream is, String filename) {
        this.is = new Scanner(is);
        this.repo = new Files(filename);
    }

    public void Run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                var command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case GET:
                        get();
                        break;
                    default:
                        continue;
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.toString());
            }
        }
    }

    private String prompt(String message) {
        System.out.print(message);
        return is.nextLine();
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    private void create() throws Exception {
        String[] input = prompt(createMessage).split(" ");
        repo.Create(new Entry(input[0], input[1], input[2]));
    }

    private void get() {
        System.out.println(repo.GetRandom());
    }
}
