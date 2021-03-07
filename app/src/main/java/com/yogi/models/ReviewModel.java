package com.yogi.models;

public class ReviewModel {
    private String comment;
    public ReviewModel(){
        this.comment="";
    }
    public ReviewModel(String comment){
        this.comment=comment;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
