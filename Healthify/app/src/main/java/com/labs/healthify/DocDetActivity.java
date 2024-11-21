package com.labs.healthify;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DocDetActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Rakesh Patel", "Hospital Address : Mumbai", "Exp : 12yrs", "Mobile No: 9898989898", "700"},
            {"Doctor Name : Seema Gupta", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No: 8888888888", "800"},
            {"Doctor Name : Rajesh Verma", "Hospital Address : Kolkata", "Exp : 15yrs", "Mobile No: 7777777777", "900"},
            {"Doctor Name : Priya Singh", "Hospital Address : Chennai", "Exp : 8yrs", "Mobile No: 6666666666", "600"},
            {"Doctor Name : Suresh Patel", "Hospital Address : Bangalore", "Exp : 11yrs", "Mobile No: 5555555555", "750"} };

    private String[][] doctor_details2 = {
            {"Doctor Name : Neha Sharma", "Hospital Address : Hyderabad", "Exp : 9yrs", "Mobile No: 9999999999", "850"},
            {"Doctor Name : Rohit Singh", "Hospital Address : Ahmedabad", "Exp : 14yrs", "Mobile No: 8877777777", "950"},
            {"Doctor Name : Anjali Patel", "Hospital Address : Pune", "Exp : 7yrs", "Mobile No: 7766666666", "650"},
            {"Doctor Name : Ganesh Rao", "Hospital Address : Jaipur", "Exp : 13yrs", "Mobile No: 6655555555", "850"},
            {"Doctor Name : Pooja Verma", "Hospital Address : Lucknow", "Exp : 10yrs", "Mobile No: 5544444444", "750"} };

    private String[][] doctor_details3 = {
            {"Doctor Name : Sangeeta Singh", "Hospital Address : Surat", "Exp : 11yrs", "Mobile No: 9876543210", "800"},
            {"Doctor Name : Vipin Patel", "Hospital Address : Nagpur", "Exp : 16yrs", "Mobile No: 8765432109", "1000"},
            {"Doctor Name : Neha Verma", "Hospital Address : Indore", "Exp : 6yrs", "Mobile No: 7654321098", "500"},
            {"Doctor Name : Rohit Verma", "Hospital Address : Bhopal", "Exp : 12yrs", "Mobile No: 6543210987", "700"},
            {"Doctor Name : Priya Patel", "Hospital Address : Chandigarh", "Exp : 9yrs", "Mobile No: 5432109876", "600"} };

    private String[][] doctor_details4 = {
            {"Doctor Name : Rajesh Patel", "Hospital Address : Coimbatore", "Exp : 8yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name : Seema Gupta", "Hospital Address : Bhubaneswar", "Exp : 10yrs", "Mobile No: 8888888888", "700"}, {"Doctor Name : Rajesh Verma", "Hospital Address : Visakhapatnam", "Exp : 15yrs", "Mobile No: 7777777777", "800"}, {"Doctor Name : Priya Singh", "Hospital Address : Thiruvananthapuram", "Exp : 8yrs", "Mobile No: 6666666666", "600"}, {"Doctor Name :Suresh Patel", "Hospital Address : Kochi", "Exp : 11yrs", "Mobile No: 5555555555", "750"} };private String[][] doctor_details10 = {
            {"Doctor Name : Nisha Patel", "Hospital Address : Kolkata", "Exp : 9yrs", "Mobile No: 9898989898 ", "650"},
            {"Doctor Name : Rakesh Verma", "Hospital Address : Mumbai", "Exp : 12yrs", "Mobile No: 8888888888", "700"},
            {"Doctor Name : Priya Gupta", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No: 7777777777 ", "600"},
            {"Doctor Name : Rohit Singh", "Hospital Address : Bangalore", "Exp : 10yrs", "Mobile No: 6666666666", " 550"},
            {"Doctor Name : Anjali Verma", "Hospital Address : Chennai", "Exp : 14yrs", "Mobile No: 5555555555", "800"} };
    private String[][] doctor_details5 = {
            {"Doctor Name : Sangeeta Singh", "Hospital Address : Surat", "Exp : 11yrs", "Mobile No: 9876543210", "800"},
            {"Doctor Name : Vipin Patel", "Hospital Address : Nagpur", "Exp : 16yrs", "Mobile No: 8765432109", "1000"},
            {"Doctor Name : Neha Verma", "Hospital Address : Indore", "Exp : 6yrs", "Mobile No: 7654321098", "500"},
            {"Doctor Name : Rohit Verma", "Hospital Address : Bhopal", "Exp : 12yrs", "Mobile No: 6543210987", "700"},
            {"Doctor Name : Priya Patel", "Hospital Address : Chandigarh", "Exp : 9yrs", "Mobile No: 5432109876", "600"} };
    TextView tv;
    Button btn;
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    String[][] doctor_detail = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_det);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_detail=doctor_details1;
        else

        if(title.compareTo("Dietitian")==0)
        doctor_detail=doctor_details2;
        else

        if(title.compareTo("Dentist")==0)
            doctor_detail=doctor_details3;
        else

        if(title.compareTo("Surgeon")==0)
            doctor_detail=doctor_details4;
        else
            doctor_detail=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocDetActivity.this,FinDocActivity.class));
            }
        });

        list = new ArrayList();

        for(int i=0;i<doctor_detail.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",doctor_detail[i][0]);
            item.put("Line2",doctor_detail[i][1]);
            item.put("Line3",doctor_detail[i][2]);
            item.put("Line4",doctor_detail[i][3]);
            item.put("Line5","Cons Fees : "+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DocDetActivity.this ,BookAppointActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}