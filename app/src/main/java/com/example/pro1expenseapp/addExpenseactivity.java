package com.example.pro1expenseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pro1expenseapp.databinding.ActivityAddExpenseactivityBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.UUID;

public class addExpenseactivity extends AppCompatActivity {
    ActivityAddExpenseactivityBinding binding;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddExpenseactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type=getIntent().getStringExtra("type");

        if(type.equals("Income")) {
            binding.incomebutton.setChecked(true);
        }else {
            binding.expensebutton.setChecked(false);
        }


        binding.incomebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Income";
            }
        });

        binding.expensebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Expense";
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.saveExpense) {
            createExpense();
            return true;
        }
        return false;

    }
    private void createExpense(){

        String expenseId= UUID.randomUUID().toString();
        String amount=binding.amount.getText().toString();
        String note=binding.note.getText().toString();
        String category=binding.category.getText().toString();

        boolean incomebuttonChecked=binding.incomebutton.isChecked();


        if(incomebuttonChecked){
            type="Income";
        }else{
             type="Expense";
        }

        if(amount.trim().length()==0){
            binding.amount.setError("Empty");
            return;
        }
        ExpenseModel expenseModel=new ExpenseModel(expenseId,note,category,type,Long.parseLong(amount),Calendar.getInstance().getTimeInMillis(),
                FirebaseAuth.getInstance().getUid());

        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(expenseModel);
        finish();



    }
}






