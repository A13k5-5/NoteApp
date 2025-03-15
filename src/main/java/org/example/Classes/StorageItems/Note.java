package org.example.Classes.StorageItems;

import org.example.Classes.StorageItems.StorageItem;

public class Note extends StorageItem {
    private String content;
    public Note(String name, String content){
        super(name);
        this.content = content;
    }
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}
