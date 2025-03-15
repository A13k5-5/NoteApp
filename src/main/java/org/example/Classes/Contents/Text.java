package org.example.Classes.Contents;

public class Text extends Content{
    String text;
    public Text() {
        super("Text");
        this.text = "";
    }
    public Text(String text){
        super("Text");
        this.text = text;
    }
    public String getText() { return this.text; }
    public void setText(String newText) { this.text = newText; }
}
