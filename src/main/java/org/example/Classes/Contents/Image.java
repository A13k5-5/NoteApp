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
    public String getPath() { return this.path; }
    public void setPath(String newPath) { this.path = newPath; }
    public String getDescription() { return this.description; }
    public void setDescription(String newDescription) { this.description = newDescription; }
}
