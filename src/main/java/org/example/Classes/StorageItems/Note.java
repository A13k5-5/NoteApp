package org.example.Classes.StorageItems;

import org.example.Classes.Contents.Content;
import org.example.Classes.Contents.Text;

public class Note extends StorageItem {
    private Content content;
    public Note(String name, String content){
        super(name);
        this.content = new Text(content);
    }
    public Note(){
        super("Unnamed Note");
        this.content = new Text("");
    }
    public Content getContent() {return content;}
    public void setContent(Content content) {this.content = content;}
    public void setContent(String content) {this.content = new Text(content);}
}
