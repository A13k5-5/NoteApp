package org.example.Classes;

public class Note extends StorageItem {
    private static int num = 0;
    private String content;
    private int id;
    public Note(String content, String name){
        super(name);
        this.content = content;
        id = generateId();
    }
    public Note(String content) {
        super("Unnamed Not");
        this.content = content;
        id = generateId();
    }
    public Note(){
        super("Unnamed Note");
        this.content = "";
        id = generateId();
    }
    private static synchronized int generateId() {
        return num++;
    }
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public int getId() {return id;}
}
