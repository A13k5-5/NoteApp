package org.example.Classes.Contents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Image extends Content {
    private byte[] imageData;
    private String description;

    public Image() {
        super("Image");
        this.imageData = new byte[0];
        this.description = "";
    }

    @JsonCreator
    public Image(@JsonProperty("imageData") byte[] imageData,
                 @JsonProperty("description") String description) {
        super("Image");
        this.imageData = imageData;
        this.description = description;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}