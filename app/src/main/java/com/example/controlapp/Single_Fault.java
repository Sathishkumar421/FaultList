package com.example.controlapp;

public class Single_Fault {
    public String ID, TaskStatus, Title, place, days,Type1,Type2,Type3;

    public Single_Fault(String ID, String taskStatus, String title, String place, String days, String Type1, String Type2, String Type3) {
        this.ID = ID;
        TaskStatus = taskStatus;
        Title = title;
        this.place = place;
        this.days = days;
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.Type3 = Type3;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        TaskStatus = taskStatus;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    public String getType1() {
        return Type1;
    }

    public void setType1(String Type1) {
        this.Type1 = Type1;
    }
    public String getType2() {
        return Type2;
    }

    public void setType2(String Type2) {
        this.Type2 = Type2;
    }
    public String getType3() {
        return Type3;
    }

    public void setType3(String Type3) {
        this.Type3 = Type3;
    }

}

