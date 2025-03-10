package org.example.Classes;

public abstract class StorageItem {
    private String name;
    public StorageItem(String name){
        this.name = name;
    }
    private String getName(){
        return this.name;
    }
}
