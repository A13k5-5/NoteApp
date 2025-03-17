package org.example.Classes.StorageItems;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Directory extends StorageItem {
    private final List <Directory> directories;
    private final List<Note> notes;
    private final boolean root;
    @JsonCreator
    public Directory(@JsonProperty("name") String name) {
        super(name);
        notes = new ArrayList<>();
        directories = new ArrayList<>();
        this.root = false;
    }
    public Directory(String name, boolean isRoot) {
        super(name);
        notes = new ArrayList<>();
        directories = new ArrayList<>();
        this.root = isRoot;
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
        if (this.getName().toLowerCase().contains(keywords.toLowerCase()) && !isRoot())
            result.addDirectory(this);
        for (Note n : notes)
            n.search(keywords, result);
        for (Directory d : directories) {
            d.search(keywords, result);
        }
    }
    public void sort(String type) {
        boolean reversed = type.equals("z-a") || type.equals("oldest-to-newest");
        if (type.equals("a-z") || type.equals("z-a")) {
            this.getNotes().sort((n1, n2) -> (reversed ? n2 : n1).getName().compareToIgnoreCase((reversed ? n1 : n2).getName()));
            this.getDirectories().sort((d1, d2) -> (reversed ? d2 : d1).getName().compareToIgnoreCase((reversed ? d1 : d2).getName()));
        } else {
            this.getNotes().sort((n1, n2) -> (reversed ? n1 : n2).getTimeCreated().compareTo((reversed ? n2 : n1).getTimeCreated()));
            this.getDirectories().sort((d1, d2) -> (reversed ? d1 : d2).getTimeCreated().compareTo((reversed ? d2 : d1).getTimeCreated()));
        }
    }
    public boolean isRoot() { return this.root; }
    public int length() { return notes.size() + directories.size(); }
}
