package org.example.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Part;
import org.example.Classes.Contents.Image;
import org.example.Classes.Contents.Text;
import org.example.Classes.StorageItems.Directory;
import org.example.Classes.StorageItems.Note;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final Directory mainDirectory;
    private List<Directory> pathToCur;
    private final String IMAGE_DIRECTORY = "images";
    public Model(){
        mainDirectory = loadFiles();
        pathToCur = new ArrayList<>();
        pathToCur.add(mainDirectory);
    }
    public Directory getMainDirectory() { return mainDirectory; }
    public Directory loadFiles() {
        Directory directory = new Directory("root");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            directory = objectMapper.readValue(new File("data/note.json"), Directory.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    // Text Content
    public void editNote(long noteIdToEdit, long contentIdToEdit, String newContent, String newTitle){
        Note noteToEdit = find(noteIdToEdit);
        noteToEdit.editTextContent(contentIdToEdit, newContent);
        noteToEdit.setName(newTitle);
        saveFiles();
    }
    // Image Content
    public void editNote(long noteIdToEdit, long contentIdToEdit, Part part) throws IOException {
        File uploadsDir = new File(System.getProperty("user.dir"), "images");
        if (!uploadsDir.exists())
            uploadsDir.mkdirs();

        String submittedFileName = part.getSubmittedFileName();
        String fileExtension = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
        String filename = contentIdToEdit + fileExtension;
        File destFile = new File(uploadsDir, filename);
        part.write(destFile.getAbsolutePath());

        Note noteToEdit = find(noteIdToEdit);
        noteToEdit.editImageContent(contentIdToEdit, destFile);
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
    public void serveImage(String imageName, OutputStream outputStream) throws IOException {
        File imageFile = new File(IMAGE_DIRECTORY, imageName);

        if (!imageFile.exists()) {
            throw new FileNotFoundException("Image not found");
        }

        String contentType = Files.probeContentType(imageFile.toPath());

        try (FileInputStream inputStream = new FileInputStream(imageFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
