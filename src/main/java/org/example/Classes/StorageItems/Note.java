package org.example.Classes.StorageItems;

import org.example.Classes.Contents.Content;
import org.example.Classes.Contents.Text;

import java.util.ArrayList;
import java.util.List;

public class Note extends StorageItem {
    private List<Content> content;
    public Note(String name, String content){
        super(name);
        this.content = new ArrayList<>();
        this.content.add(new Text(content));
    }
    public Note(){
        super("Unnamed Note");
        this.content = new ArrayList<>();
    }
    public List<Content> getContent() {return this.content;}
//    public void setContent(Content content) {this.content = content;}
//    public void setContent(String content) {this.content = new Text(content);}
    private Content findContent(long id) {
        for (Content c : this.getContent())
            if (c.getId() == id)
                return c;
        return null;
    }
    public void addContent(Content newContent) {
        this.content.add(newContent);
    }
    public void editTextContent(long contentIdToEdit, String newText) {
        Content toChange = findContent(contentIdToEdit);
//        assert toChange != null;
        if (!toChange.getType().equals("Text")){
            System.out.println("Not a text");
            return;
        }
        ((Text)toChange).setText(newText);
    }
}
