package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.StorageItems.Directory;
import org.example.Classes.StorageItems.Note;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final Directory mainDirectory;
    private List<Directory> pathToCur;
    public Model(){
        mainDirectory = loadFiles();
        pathToCur = new ArrayList<>();
        pathToCur.add(mainDirectory);
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
        getCurDir().addNote(n);
        saveFiles();
    }
    public void addItem(Directory d) {
        getCurDir().addDirectory(d);
        saveFiles();
    }
//    would be cool to add NoteNotFound exception
    public Note find(long id) {
        for (Note note : getCurDir().getNotes())
            if (note.getId() == id)
                return note;
        return null;
    }
//    Add DirNotFound exception
    public Directory findDir(long id) {
        for (Directory d : getCurDir().getDirectories())
            if (d.getId() == id)
                return d;
        return null;
    }
    public void editNote(long idToEdit, String newContent, String newTitle){
        Note noteToEdit = find(idToEdit);
        noteToEdit.setContent(newContent);
        noteToEdit.setName(newTitle);
        saveFiles();
    }
    public Directory getCurDir(){ return pathToCur.getLast(); }
    public void changeCurDir(Long newDirId) {
        Directory newCurDir = findDir(newDirId);
        if (newCurDir == null)
            return;
        // new dir is valid
        pathToCur.add(newCurDir);
    }
    // No parent directory of current directory exception
    public void goDirBack() {
        if (pathToCur.size() == 1)
            return;
        pathToCur.removeLast();
    }
    public void deleteNote(long idToDelete) {
        getCurDir().removeNote(idToDelete);
        saveFiles();
    }
}
