package org.example.Classes;

public class Note {
    private static int num = 0;
    private String title;
    private String content;
    private int id;
    public Note(String content, String title){
        this.content = content;
        this.title = title;
        id = generateId();
    }
    public Note(String content) {
        this.content = content;
        this.title = "Unnamed Note";
        id = generateId();
    }
    public Note(){
        this.content = "";
        this.title = "Notes";
        id = generateId();
    }
    private static synchronized int generateId() {
        return num++;
    }
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public int getId() {return id;}
}
