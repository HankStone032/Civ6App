package com.example.civ6app;

public class Wonder {
    private long id;
    private String wonder;
    private String era;
    private String provides;
    private String tile;
    private String tech;
    private String cost;
    private String description;
    private String dominationFlag;
    private String cultureFlag;
    private String scienceFlag;
    private String religionFlag;
    private String diplomaticFlag;
    private String scoreFlag;

    public String getDominationFlag() {
        return dominationFlag;
    }

    public void setDominationFlag(String dominationFlag) {
        this.dominationFlag = dominationFlag;
    }

    public String getCultureFlag() {
        return cultureFlag;
    }

    public void setCultureFlag(String cultureFlag) {
        this.cultureFlag = cultureFlag;
    }

    public String getScienceFlag() {
        return scienceFlag;
    }

    public void setScienceFlag(String scienceFlag) {
        this.scienceFlag = scienceFlag;
    }

    public String getReligionFlag() {
        return religionFlag;
    }

    public void setReligionFlag(String religionFlag) {
        this.religionFlag = religionFlag;
    }

    public String getDiplomaticFlag() {
        return diplomaticFlag;
    }

    public void setDiplomaticFlag(String diplomaticFlag) {
        this.diplomaticFlag = diplomaticFlag;
    }

    public String getScoreFlag() {
        return scoreFlag;
    }

    public void setScoreFlag(String scoreFlag) {
        this.scoreFlag = scoreFlag;
    }

    public String getProvides() {
        return provides;
    }

    public void setProvides(String provides) {
        this.provides = provides;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return wonder;
    }
}