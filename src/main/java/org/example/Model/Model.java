package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.Part;
import org.example.Classes.Contents.Content;
import org.example.Classes.Contents.Image;
import org.example.Classes.StorageItems.Directory;
import org.example.Classes.StorageItems.Note;
import org.example.Exceptions.ContentNotFound;
import org.example.Exceptions.DirectoryNotFound;
import org.example.Exceptions.NoteNotFound;

import java.io.*;
import java.util.Stack;

public class Model {
    private final Directory rootDirectory;
    private final Stack<Directory> pathToCur;
    private Directory curDir;
    public Model(){
        rootDirectory = loadFiles();
        pathToCur = new Stack<>();
        pathToCur.add(rootDirectory);
        curDir = rootDirectory;
    }
    public Directory loadFiles() {
        Directory directory = new Directory("root",true);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            directory = objectMapper.readValue(new File("data/note.json"), Directory.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return directory;
    }
    public void saveFiles() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File("data/note.json"), rootDirectory);
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
    public Note findNote(long id) throws NoteNotFound {
        return this.getCurDir().findNote(id);
    }
    public Directory findDir(long id) throws DirectoryNotFound{
        for (Directory d : getCurDir().getDirectories())
            if (d.getId() == id)
                return d;
        throw new DirectoryNotFound("Directory not found");
    }
    public void editText(long noteIdToEdit, long contentIdToEdit, String newContent, String newTitle) throws ContentNotFound, NoteNotFound {
        Note noteToEdit = this.getCurDir().findNote(noteIdToEdit);
        noteToEdit.editText(contentIdToEdit, newContent);
        noteToEdit.setName(newTitle);
        saveFiles();
    }
    public void editImage(long noteIdToEdit, long contentIdToEdit, Part part) throws IOException, ContentNotFound, NoteNotFound {
        File uploadsDir = new File(System.getProperty("user.dir"), "images");
        if (!uploadsDir.exists())
            uploadsDir.mkdirs();

        String submittedFileName = part.getSubmittedFileName();
        String fileExtension = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
        String filename = contentIdToEdit + fileExtension;
        File destFile = new File(uploadsDir, filename);
        part.write(destFile.getAbsolutePath());

        Note noteToEdit = this.getCurDir().findNote(noteIdToEdit);
        noteToEdit.editImage(contentIdToEdit, destFile);
        saveFiles();
    }
    public void editImageDescription(long noteIdToEdit, long contentIdToEdit, String imgDescription) throws ContentNotFound, NoteNotFound {
        getCurDir().findNote(noteIdToEdit).editImageDescription(contentIdToEdit, imgDescription);
        saveFiles();
    }
    public Directory getCurDir(){ return this.curDir; }
    public void changeCurDir(Long newDirId) throws DirectoryNotFound {
        Directory newCurDir = findDir(newDirId);
        if (newCurDir == null)
            return;
        pathToCur.push(newCurDir);
        curDir = newCurDir;
    }
    // No parent directory of current directory exception
    public void goDirBack() {
        if (pathToCur.peek() == rootDirectory)
            return;
        pathToCur.pop();
        curDir = pathToCur.peek();
    }
    public void deleteNote(long idToDelete) {
        getCurDir().removeNote(idToDelete);
        saveFiles();
    }
    public void deleteDir(long idToDelete) {
        getCurDir().removeDirectory(idToDelete);
        saveFiles();
    }
    public void removeContent(long noteId, long contentId) throws ContentNotFound, NoteNotFound {
        Content removed = this.getCurDir().findNote(noteId).removeContent(contentId);
        if (removed.getType().equals("Image")) {
            String imagePath = ((Image) removed).getPath();
            File imageFile = new File(imagePath);
            if (imageFile.exists())
                imageFile.delete();
        }
        saveFiles();
    }
    public void serveImage(String imageName, OutputStream outputStream) throws IOException {
        String IMAGE_DIRECTORY = "images";
        File imageFile = new File(IMAGE_DIRECTORY, imageName);
        if (!imageFile.exists()) {
            throw new FileNotFoundException("Image not found");
        }
        try (FileInputStream inputStream = new FileInputStream(imageFile)) {
            byte[] buffer = new byte[4 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
    public void changeDirName(long dirId, String newName) {
        Directory dirToEdit = getCurDir().findDirectory(dirId);
        dirToEdit.setName(newName);
        saveFiles();
    }
    public boolean search(String keywords) {
        Directory result = new Directory('"' + keywords+ '"' + " search result");
        curDir.search(keywords, result);
        if (result.length() == 0)
            return false;
        pathToCur.push(result);
        curDir = pathToCur.peek();
        return true;
    }
    public void sort(String type) {
        curDir.sort(type);
        saveFiles();
    }
}
