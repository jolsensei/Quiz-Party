package com.jolsensei.quizparty.Entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Quiz implements Parcelable {

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


    public ArrayList<Question> questionFilter(difficulties d, colors c){

        ArrayList<Question> filteredQuiz = new ArrayList<>();

        ArrayList<Question> selectedDifficulty = null;

        switch (d){


            case EASY:

                selectedDifficulty = this.easyQuestions;

                break;

            case HARD:

                selectedDifficulty = this.hardQuestions;

                break;

        }

        for (int i = 0; i < selectedDifficulty.size(); i++){

            if (selectedDifficulty.get(i).getColor().equals(c)){

                filteredQuiz.add(selectedDifficulty.get(i));

            }
        }


        return filteredQuiz;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.orangeDef);
        dest.writeString(this.greenDef);
        dest.writeString(this.blueDef);
        dest.writeString(this.yellowDef);
        dest.writeString(this.brownDef);
        dest.writeString(this.pinkDef);
        dest.writeList(this.easyQuestions);
        dest.writeList(this.hardQuestions);
    }

    protected Quiz(Parcel in) {
        this.name = in.readString();
        this.orangeDef = in.readString();
        this.greenDef = in.readString();
        this.blueDef = in.readString();
        this.yellowDef = in.readString();
        this.brownDef = in.readString();
        this.pinkDef = in.readString();
        this.easyQuestions = new ArrayList<Question>();
        in.readList(this.easyQuestions, Question.class.getClassLoader());
        this.hardQuestions = new ArrayList<Question>();
        in.readList(this.hardQuestions, Question.class.getClassLoader());
    }

    public static final Parcelable.Creator<Quiz> CREATOR = new Parcelable.Creator<Quiz>() {
        @Override
        public Quiz createFromParcel(Parcel source) {
            return new Quiz(source);
        }

        @Override
        public Quiz[] newArray(int size) {
            return new Quiz[size];
        }
    };
}
