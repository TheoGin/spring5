package com.study.spring.beans;

public class Monster {
    private int monsterId;
    private String name;
    private String skill;

    public Monster() {
    }

    public Monster(int monsterId, String name, String skill) {
        this.monsterId = monsterId;
        this.name = name;
        this.skill = skill;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
