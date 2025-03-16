package org.example.Classes.StorageItems;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Directory extends StorageItem {
    List <Directory> directories;
    List<Note> notes;
    @JsonCreator
    public Directory(@JsonProperty("name") String name) {
        super(name);
        notes = new ArrayList<>();
        directories = new ArrayList<>();
    }
    public List<Directory> getDirectories() {
        return directories;
    }
    public List<Note> getNotes() {
        return notes;
    }
    public void addNote (Note note) {
        notes.add(note);
    }
    public void addDirectory(Directory directory) {
        directories.add(directory);
    }
    // Note not found
    public Note findNote(long noteId) {
        for (Note n : notes)
            if (n.getId() == noteId)
                return n;
        return null;
    }
    public Directory findDirectory(long dirId) {
        for (Directory d : directories)
            if (d.getId() == dirId)
                return d;
        return null;
    }
    public void removeDirectory(long id) {
        directories.removeIf(directory -> directory.getId() == id);
    }
    public void removeNote(long id) { notes.removeIf(note -> note.getId() == id); }
    public void search(String keywords, Directory result) {
        if (this.getName().contains(keywords))
            result.addDirectory(this);
        for (Note n : notes)
            n.search(keywords, result);
        for (Directory d : directories)
            d.search(keywords, result);
    }
    public void sort() {
        this.getNotes().sort((n1, n2) -> n1.getName().compareToIgnoreCase(n2.getName()));
        this.getDirectories().sort((d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));
    }
}
