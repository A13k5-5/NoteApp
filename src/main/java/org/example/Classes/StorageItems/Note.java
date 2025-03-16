package org.example.Classes.StorageItems;

import org.example.Classes.Contents.Content;
import org.example.Classes.Contents.Image;
import org.example.Classes.Contents.Text;
import org.example.Model.ModelFactory;

import java.io.File;
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
    private Content findContent(long id) {
        for (Content c : this.getContent())
            if (c.getId() == id)
                return c;
        return null;
    }
    public void addContent(Content newContent) {
        this.content.add(newContent);
    }
    public void removeContent(long contentId) {
        Content toRemove = findContent(contentId);
        if (toRemove.getType().equals("Image")) {
//            ModelFactory.getModel();
        }
        content.removeIf(content -> content.getId() == contentId);
    }
    public void editTextContent(long contentIdToEdit, String newText) {
        Content toChange = findContent(contentIdToEdit);
        if (!toChange.getType().equals("Text")){
            System.out.println("Not a text");
            return;
        }
        ((Text)toChange).setText(newText);
    }
    public void editImageContent(long contentIdToEdit, File newImage) {
        Content toChange = findContent(contentIdToEdit);
        if (!toChange.getType().equals("Image"))
            return;
        String relativePath = "images/" + newImage.getName();
        ((Image)toChange).setPath(relativePath);
        // To do - image description
    }
}
