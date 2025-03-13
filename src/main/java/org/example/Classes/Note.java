package org.example.Classes;

public class Note extends StorageItem {
    private String content;
    public Note(String name, String content){
        super(name);
        this.content = content;
    }
    public Note(String content) {
        super("Unnamed Not");
        this.content = content;
    }
    public Note(){
        super("Unnamed Note");
        this.content = "";
    }
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}
