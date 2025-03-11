package org.example.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.Directory;
import org.example.Classes.Note;
import org.example.Classes.StorageItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private Directory mainDirectory;
    public Model(){
        mainDirectory = loadFiles();
    }
    public Directory getMainDirectory() { return mainDirectory; }
    public Directory loadFiles() {
        Directory directory = new Directory("");
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
}
