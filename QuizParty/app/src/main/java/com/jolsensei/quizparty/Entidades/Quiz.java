package com.jolsensei.quizparty.Entidades;

import java.util.ArrayList;

public class Quiz {

    private String name;
    private String orangeDef;
    private String greenDef;
    private String blueDef;
    private String yellowDef;
    private String brownDef;
    private String pinkDef;
    private ArrayList<Question> easyQuestions;
    private ArrayList<Question> hardQuestions;

    public Quiz(String name, String orangeDef, String greenDef, String blueDef, String yellowDef, String brownDef, String pinkDef, ArrayList<Question> easyQuestions, ArrayList<Question> hardQuestions) {
        this.name = name;
        this.orangeDef = orangeDef;
        this.greenDef = greenDef;
        this.blueDef = blueDef;
        this.yellowDef = yellowDef;
        this.brownDef = brownDef;
        this.pinkDef = pinkDef;
        this.easyQuestions = easyQuestions;
        this.hardQuestions = hardQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrangeDef() {
        return orangeDef;
    }

    public void setOrangeDef(String orangeDef) {
        this.orangeDef = orangeDef;
    }

    public String getGreenDef() {
        return greenDef;
    }

    public void setGreenDef(String greenDef) {
        this.greenDef = greenDef;
    }

    public String getBlueDef() {
        return blueDef;
    }

    public void setBlueDef(String blueDef) {
        this.blueDef = blueDef;
    }

    public String getYellowDef() {
        return yellowDef;
    }

    public void setYellowDef(String yellowDef) {
        this.yellowDef = yellowDef;
    }

    public String getBrownDef() {
        return brownDef;
    }

    public void setBrownDef(String brownDef) {
        this.brownDef = brownDef;
    }

    public String getPinkDef() {
        return pinkDef;
    }

    public void setPinkDef(String pinkDef) {
        this.pinkDef = pinkDef;
    }

    public ArrayList<Question> getEasyQuestions() {
        return easyQuestions;
    }

    public void setEasyQuestions(ArrayList<Question> easyQuestions) {
        this.easyQuestions = easyQuestions;
    }

    public ArrayList<Question> getHardQuestions() {
        return hardQuestions;
    }

    public void setHardQuestions(ArrayList<Question> hardQuestions) {
        this.hardQuestions = hardQuestions;
    }
}
