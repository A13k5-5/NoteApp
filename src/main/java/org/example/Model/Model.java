package org.example.Model;

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
        try{
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newData);
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Note readNote(){
        Note note = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            note = mapper.readValue(new File("data/note.json"), Note.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return note;
    }
    public void writeNote(Note note){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("data/note.json"), note);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Model model = new Model();
        Note note = model.readNote();
        System.out.println(note.getTitle() + " " + note.getContent());
    }
}
