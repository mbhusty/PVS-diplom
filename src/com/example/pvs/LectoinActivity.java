package com.example.pvs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class LectoinActivity extends Activity 
{
	private ListView lv1;
	
	
	//������� ������ ��������:
	private String lv_arr[]={
			"00. ������",
			"01. ��� ������� ����.",
			"02. ��� ������� ����.",
			"03. ��� ���� ���.",
			"04. ��� ������ � �����.", 
			"05. ��� ������������� � �����",
			"06. ���������� ����� �� ����� �����.",
			"07. ��� ������� ����.",
			};
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lection);
      

        
        // ������� ������������� ListView
        lv1 = (ListView)findViewById(R.id.listView);
        //������������� ������ � ListView
        lv1.setAdapter(
        		new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
        lv1.setTextFilterEnabled(true);
              
        //������������ ������ �� ��������� ListView:
        lv1.setOnItemClickListener(new OnItemClickListener() 
        {
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) 
        	{
                //������� ��������, �� �������� ��������
                String itemname = new Integer(position).toString();  
                
                Intent intent = new Intent();
                
                intent.setClass(LectoinActivity.this, ViewActivity.class);
                
                Bundle b = new Bundle();
                
                //defStrID �������� ������, ������� �������� ����� itemname � ������ Activity
                b.putString("defStrID", itemname); 
                
                intent.putExtras(b);
                
                //��������� Intent
                startActivity(intent);
             }
		});
    }
}
