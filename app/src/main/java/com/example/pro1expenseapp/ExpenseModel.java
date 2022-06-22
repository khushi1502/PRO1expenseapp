package com.example.pro1expenseapp;

public class ExpenseModel {
    private String expenseId;
    private String note;
    private String category;
    private String type;
    private long amount;
    private long time;
    private String uid;



    public ExpenseModel(String expenseId, String note, String category, String type, long l, long timeInMillis) {
    }

    public ExpenseModel(String expenseId, String expanseId, String note, String category, long amount, long time, String uid){
        this.expenseId = this.expenseId;
        this.note = note;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.uid = this.uid;
        }

        public String getType(){
            return type;
        }

        public void setType(String type){
        this.type=type;
        }

        public String getExpenseId(){
          return expenseId;
        }

        public void setExpenseId(String expenseId) {
            this.expenseId = expenseId;
        }

        public String getNote() {
            return note;
        }


        public void setNote(String note) {
            this.note = note;
        }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUid(){
        return uid;
    }

    public void setUid(){
        this.uid = uid;
    }
}
