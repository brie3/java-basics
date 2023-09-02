package packages.GoodsStore.Repository.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import packages.GoodsStore.Entry;
import packages.GoodsStore.Repository.Repository;

public class Files implements Repository {
    private String fileName = null;

    public Files(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Create(Entry entry) {
        if (entry.GetQuantity() <= 0) {
            return;
        }
        var entries = fetch();
        var maxID = 0;
        for (Entry fetched : entries) {
            maxID = fetched.GetID();
        }
        entry.SetID(maxID + 1);
        entries.add(entry);
        store(entries);
    }

    public Entry GetRandom() {
        var entries = fetch();
        var queue = new PriorityQueue<Entry>();
        for (Entry fetched : entries) {
            queue.add(fetched);
        }
        var entry = queue.remove();
        entry.SetQuantity(entry.GetQuantity()-1);
        if (entry.GetQuantity() < 1) {
            entries.remove(entry);
        }
        store(entries);
        return entry;
    }

    private List<Entry> fetch() {
        List<Entry> entries = new ArrayList<>();
        try {
            File file = new File(this.fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                entries.add(Entry.fromString(line));
                line = reader.readLine();
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return entries;
    }

    private void store(List<Entry> entries) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Entry entry : entries) {
                writer.write(entry.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
