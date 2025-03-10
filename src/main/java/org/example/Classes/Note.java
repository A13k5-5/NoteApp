package org.example.Classes;

public class Note extends StorageItem {
    private static int num = 0;
    private String title;
    private String content;
    private int id;
    public Note(String content, String title){
        super(title);
        this.content = content;
        id = generateId();
    }
    public Note(String content) {
        super("Unnamed Note");
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
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public int getId() {return id;}
}
