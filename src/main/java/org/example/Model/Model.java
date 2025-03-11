package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.Directory;
import org.example.Classes.Note;
import org.example.Classes.StorageItem;

import java.io.*;
import java.util.HashMap;

public class Model {
    private final Directory mainDirectory;
    private Directory curDir;
    public Model(){
        mainDirectory = loadFiles();
        curDir = mainDirectory;
    }
    public Directory getMainDirectory() { return mainDirectory; }
    public Directory loadFiles() {
        Directory directory = new Directory("");
        HashMap<Long, StorageItem> map = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            directory = objectMapper.readValue(new File("data/note.json"), Directory.class);
        } catch (Exception e) {
            System.out.println("Could not load the files");;
        }
        return directory;
    }
    public void saveFiles() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("data/note.json"), mainDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addItem(Note n) {
        mainDirectory.addNote(n);
        saveFiles();
    }
    public void addItem(Directory d) {
        mainDirectory.addDirectory(d);
        saveFiles();
    }
//    would be cool to add NOTENOTFOUND exception
    public Note find(long id) {
        for (Note note : mainDirectory.getNotes())
            if (note.getId() == id)
                return note;
        return null;
    }
    public void editNote(long idToEdit, String newContent, String newTitle){
        Note noteToEdit = find(idToEdit);
        noteToEdit.setContent(newContent);
        noteToEdit.setName(newTitle);
        saveFiles();
    }
    public Directory getCurDir(){ return curDir; }
    public void setCurDir(Directory newCurDir) { this.curDir = newCurDir; }
}
