package org.example.Classes.StorageItems;

import org.example.Classes.Contents.Content;
import org.example.Classes.Contents.Image;
import org.example.Classes.Contents.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Note extends StorageItem {
    private final List<Content> content;
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
    public Content removeContent(long contentId) {
        Content toRemove = findContent(contentId);
        content.removeIf(content -> content.getId() == contentId);
        return toRemove;
    }
    public void editText(long contentIdToEdit, String newText) {
        Content toChange = findContent(contentIdToEdit);
        if (!toChange.getType().equals("Text")){
            System.out.println("Not a text");
            return;
        }
        ((Text)toChange).setText(newText);
    }
    public void editImage(long contentIdToEdit, File newImage) {
        Content toChange = findContent(contentIdToEdit);
        if (!toChange.getType().equals("Image"))
            return;
        String relativePath = "images/" + newImage.getName();
        ((Image)toChange).setPath(relativePath);
    }
    public void editImageDescription(long contentIdToEdit, String imgDescription) {
        Content toChange = findContent(contentIdToEdit);
        if (!toChange.getType().equals("Image"))
            return;
        ((Image)toChange).setDescription(imgDescription);
    }
    public void search(String keywords, Directory result) {
        if (this.getName().toLowerCase().contains(keywords.toLowerCase())){
            result.addNote(this);
            return;
        }
        for (Content c : content) {
            if(c.getType().equals("Text") && ((Text)c).getText().toLowerCase().contains(keywords.toLowerCase()) || c.getType().equals("Image") && ((Image)c).getDescription().toLowerCase().contains(keywords.toLowerCase())) {
                result.addNote(this);
            }
        }
    }
}
