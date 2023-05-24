package MyDiary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    private Diary eBook;

    @BeforeEach
    public void alwaysTestThisFirst() {
        eBook = new Diary();
        eBook.createEntry("Semicolon", "Military Camp");
    }

    @Test
    public void entryCanBeCreatedTest() {
        eBook = new Diary();
        eBook.createEntry("Semicolon", "Military Camp");
        assertEquals(2, eBook.countEntries());
    }
    @Test
    public void entryCanBeViewedAfterCreationTest() {
        String expected ="""
                 ======================
                 Title: Semicolon
                 Body:
                 Military Camp
                 ======================
                 """;
        assertEquals(expected, eBook.findEntry(1).toString());
    }
    @Test
    public void countNumberOfEntriesTest(){
        eBook.createEntry("Tinubu", "Politician");
        assertEquals(2,eBook.countEntries());
    }
    @Test
    public void entryBodiesCanBeEditedTest() {
        eBook.createEntry("daily","Moments");
        eBook.editEntryBody(2, "Good Moments");
        String expected ="""
                 ======================
                 Title: daily
                 Body:
                 Good Moments
                 ======================
                 """;
        assertEquals(expected, eBook.findEntry(2).toString());
    }
    @Test
    public void entryTitleCanBeEditedTest() {
        eBook.createEntry("daily","Moments");
        eBook.editEntryTitle(2, "weekly");
        String expected ="""
                 ======================
                 Title: weekly
                 Body:
                 Moments
                 ======================
                 """;
        assertEquals(expected, eBook.findEntry(2).toString());
    }
    @Test
    public void deleteEntryTest(){
        eBook.createEntry("daily","Moments");
        eBook.entryDelete(2);
        assertEquals(1, eBook.countEntries());
    }
}