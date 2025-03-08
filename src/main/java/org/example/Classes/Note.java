package org.example.Classes;

public class Note {
    private static int num = 0;
    private String title;
    private String content;
    public Note(String content) {
        this.content = content;
        this.title = "Notes " + num;
        num++;
    }
    public Note(){
        this.content = "";
        this.title = "Notes " + num;
        num++;
    }
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
}
