package com.example.pro1expenseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.MyViewHolder>{
   private Context context;
   private List<ExpenseModel>expenseModelList;

   public ExpensesAdapter(Context context){

       this.context = context;
       expenseModelList=new ArrayList<>();
   }

   public void add(ExpenseModel expenseModel){
       expenseModelList.add(expenseModel);
       notifyDataSetChanged();
   }

   public void clear(){
       expenseModelList.clear();
       notifyDataSetChanged();
   }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_row,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       ExpenseModel expenseModel=expenseModelList.get(position);
       holder.note.setText(expenseModel.getNote());
        holder.category.setText(expenseModel.getCategory());
        holder.amount.setText(String.valueOf((expenseModel.getAmount())));


    }

    @Override
    public int getItemCount() {
        return expenseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       private TextView note,category,amount,date;


        public MyViewHolder(@NonNull View itemview){
            super(itemview);
            note=itemview.findViewById(R.id.note);
            category=itemview.findViewById(R.id.category);
            amount=itemview.findViewById(R.id.amount);
            date=itemview.findViewById(R.id.date);

        }

    }
}
