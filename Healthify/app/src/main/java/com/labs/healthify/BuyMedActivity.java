package com.labs.healthify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedActivity extends AppCompatActivity {

    private String[][] medicines ={
            {"Tramadol"," "," "," ","10"},
        {"Paracetamol"," "," "," ","8"},
        {"Omeprazole"," "," "," ","15"},
        {"Ibuprofen"," "," "," ","5"},
        {"Alprazolam"," "," "," ","12"},
        {"Amoxicillin"," "," "," ","18"},
        {"Vitamin C"," "," "," ","10"},
        {"Strepsils"," "," "," ","5"},
        {"Diclofenac"," "," "," ","15"},
        {"Mentat"," "," "," ","20"},
        {"Diazepam"," "," "," ","15"}
    };

    private String[] med_det={
            "Used to treat moderate to moderately severe pain.",
            "Used to relieve symptoms of the common cold and flu, such as nasal congestion, sore throat, and cough.",
            "Used to treat gastrointestinal disorders such as heartburn, acid reflux, and stomach ulcers.",
            "Used to relieve pain and reduce inflammation in various conditions such as arthritis, muscle pain, and menstrual cramps.",
            "Used to treat anxiety and depression.",
            "Zifi 200 provides an antibiotic drug to the body for bacteria killing.",
            "Used to prevent and treat vitamin C deficiency.",
            "Used to relieve throat pain and discomfort.",
            "Used to relieve pain and reduce inflammation in various conditions such as arthritis, muscle pain, and menstrual cramps.",
            "Used in Ayurvedic medicine to treat various health conditions such as stress, anxiety, and digestive disorders.",
            "Used to treat insomnia and sleep disorders."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button back,gotocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_med);

        lst = findViewById(R.id.listViewBM);
        back=findViewById(R.id.buttonBMBack);
        gotocart=findViewById(R.id.btnBMgotocart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedActivity.this,HomeActivity.class));
            }
        });

        gotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedActivity.this,CartBuyMedActivity.class));
            }
        });

        list = new ArrayList();
        for (int i =0;i<medicines.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",medicines[i][0]);
            item.put("line2",medicines[i][1]);
            item.put("line3",medicines[i][2]);
            item.put("line4",medicines[i][3]);
            item.put("line5","Total Cost : "+medicines[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedActivity.this,BuyMedDetActivity.class);
                it.putExtra("text1",medicines[i][0]);
                it.putExtra("text2",med_det[i]);
                it.putExtra("text3",medicines[i][4]);
                startActivity(it);
            }
        });
    }

}