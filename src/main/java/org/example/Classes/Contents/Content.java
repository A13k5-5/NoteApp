package org.example.Classes.Contents;

public abstract class Content {
    protected String type;
    protected final long id;
    public Content(String type) {
        this.type = type;
        this.id = System.currentTimeMillis();
    }
    public String getType() { return this.type; }
}
