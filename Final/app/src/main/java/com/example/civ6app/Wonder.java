package com.example.civ6app;

public class Wonder {
    private long id;
    private String wonder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWonder() {
        return wonder;
    }

    public void setWonder(String wonder) {
        this.wonder = wonder;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return wonder;
    }
}