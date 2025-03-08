package org.example.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Classes.Note;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<String> readFile(File file) {
        List<String> data = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void editFile(File file, String newData) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newData);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Note> readNotes() {
        List<Note> notes = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            notes = mapper.readValue(new File("data/note.json"), new TypeReference<List<Note>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notes;
    }

    public void writeNotes(List<Note> notes) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("data/note.json"), notes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNote(Note note) {
        List<Note> notes = readNotes();
        notes.add(note);
        writeNotes(notes);
    }
//    public static void main(String[] args) {
//        Model model = new Model();
//        Note note = model.readNote();
//        System.out.println(note.getTitle() + " " + note.getContent());
//    }
}

