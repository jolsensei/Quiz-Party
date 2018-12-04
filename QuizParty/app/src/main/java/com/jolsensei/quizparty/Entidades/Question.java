package com.jolsensei.quizparty.Entidades;

public class Question {

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
}
