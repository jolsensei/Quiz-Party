package com.jolsensei.quizparty.Entidades;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {

    private String question;
    private String answer;
    private colors color;
    private difficulties difficultiy;


    public Question(String question, String answer, colors color, difficulties difficultiy) {
        this.question = question;
        this.answer = answer;
        this.color = color;
        this.difficultiy = difficultiy;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public colors getColor() {
        return color;
    }

    public void setColor(colors color) {
        this.color = color;
    }

    public difficulties getDifficultiy() {
        return difficultiy;
    }

    public void setDifficultiy(difficulties difficultiy) {
        this.difficultiy = difficultiy;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.question);
        dest.writeString(this.answer);
        dest.writeInt(this.color == null ? -1 : this.color.ordinal());
        dest.writeInt(this.difficultiy == null ? -1 : this.difficultiy.ordinal());
    }

    protected Question(Parcel in) {
        this.question = in.readString();
        this.answer = in.readString();
        int tmpColor = in.readInt();
        this.color = tmpColor == -1 ? null : colors.values()[tmpColor];
        int tmpDifficultiy = in.readInt();
        this.difficultiy = tmpDifficultiy == -1 ? null : difficulties.values()[tmpDifficultiy];
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
