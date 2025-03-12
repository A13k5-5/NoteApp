package org.example.Classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class StorageItem {
    private String name;
    private final long id;
    @JsonCreator
    public StorageItem(@JsonProperty("name") String name){
        this.name = name;
        this.id = System.currentTimeMillis();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public long getId() { return this.id; }
}
