package MyDiary;

public class Entry{
    private String title;
    private String body;
    private int id;


    public Entry(String title, String body, int id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void edit(String body) {
    }

    @Override
    public String toString() {
        return String.format("""
                 ======================
                 Title: %s
                 Body:
                 %s
                 ======================
                 """, title, body);
    }
}
