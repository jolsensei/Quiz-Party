package com.jolsensei.quizparty.Entidades;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Quiz.class,
        parentColumns = "name",
        childColumns = "quiz_name",
        onDelete = CASCADE))
public class Question implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String question;
    private String answer;

    @TypeConverters(colorConverter.class)
    private colors color;

    @TypeConverters(difficultyConverter.class)
    private difficulties difficulty;

    private String quiz_name;


    public Question(String question, String answer, colors color, difficulties difficultiy, String quiz_name) {
        this.question = question;
        this.answer = answer;
        this.color = color;
        this.difficulty = difficultiy;
        this.quiz_name = quiz_name;
    }
    public Question() {

    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
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

    public difficulties getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(difficulties difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
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
        dest.writeInt(this.difficulty == null ? -1 : this.difficulty.ordinal());
    }

    protected Question(Parcel in) {
        this.question = in.readString();
        this.answer = in.readString();
        int tmpColor = in.readInt();
        this.color = tmpColor == -1 ? null : colors.values()[tmpColor];
        int tmpDifficultiy = in.readInt();
        this.difficulty = tmpDifficultiy == -1 ? null : difficulties.values()[tmpDifficultiy];
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
