package org.example.Classes.Contents;

public class Image extends Content {
    String path;
    String description;
    public Image() {
        super("Image");
        this.path = "";
        this.description = "";
    }
    public Image(String path, String description){
        super("Image");
        this.path = path;
        this.description = description;
    }
}
