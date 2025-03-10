package org.example.Classes;

import java.util.ArrayList;
import java.util.List;

public class Directory extends StorageItem {
    List <Directory> directories;
    List<Note> notes;
    public Directory(String name) {
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
    public void addDirectory(Directory directory) {
        directories.add(directory);
    }
    public void addNote (Note note) {
        notes.add(note);
    }
    public void removeDirectory(Directory directory) {
        directories.remove(directory);
    }
}
