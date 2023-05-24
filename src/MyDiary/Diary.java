package MyDiary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diary implements Serializable {
    static List<Entry> entry = new ArrayList<>();

    public void createEntry(String title, String body) {
        int id = entry.size() + 1;
        Entry newEntry = new Entry(title, body, id + 1);
        entry.add(newEntry);

    }
    public int countEntries() {
        return entry.size();
    }
    public Entry findEntry(int id) {
        validateID(id);
        return entry.get(id - 1);
    }

    public void editEntryBody(int id, String body) {
        validateID(id);
        Entry editedBody = findEntry(id);
        editedBody.setBody(body);
    }

    public void editEntryTitle(int id, String title) {
        validateID(id);
        Entry editedTitle = findEntry(id);
        editedTitle.setTitle(title);
    }

    public void entryDelete(int id) {
        validateID(id);
        entry.remove(id - 1);
    }

    private static void validateID(int id) {
        if (id < 0 || id > entry.size()) {
            throw new IllegalArgumentException("You entered an invalid id number");
        }
    }
}

