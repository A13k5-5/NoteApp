package org.example.Classes.StorageItems;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class StorageItem {
    private String name;
    private final long id;
    private final LocalTime timeCreated;
    @JsonCreator
    public StorageItem(@JsonProperty("name") String name){
        this.name = name;
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.timeCreated = LocalTime.now();
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public long getId() { return this.id; }
    public LocalTime getTimeCreated() { return this.timeCreated; }
}
