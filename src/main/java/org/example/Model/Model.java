package org.example.Model;

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

    public void editFile(File file, String newData){
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

    public List<String> getData(File file) {
        return readFile(file);
    }
}
