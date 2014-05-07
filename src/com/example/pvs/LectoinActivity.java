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
	
	
	//Создаем массив разделов:
	private String lv_arr[]={
			"00. Начало",
			"01. Чем кормить кота.",
			"02. Как гладить кота.",
			"03. Как спит кот.",
			"04. Как играть с котом.", 
			"05. Как разговаривать с котом",
			"06. Интересные факты из жизни котов.",
			"07. Как назвать кота.",
			};
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lection);
      

        
        // Получим идентификатор ListView
        lv1 = (ListView)findViewById(R.id.listView);
        //устанавливаем массив в ListView
        lv1.setAdapter(
        		new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
        lv1.setTextFilterEnabled(true);
              
        //Обрабатываем щелчки на элементах ListView:
        lv1.setOnItemClickListener(new OnItemClickListener() 
        {
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) 
        	{
                //Позиция элемента, по которому щелкнули
                String itemname = new Integer(position).toString();  
                
                Intent intent = new Intent();
                
                intent.setClass(LectoinActivity.this, ViewActivity.class);
                
                Bundle b = new Bundle();
                
                //defStrID содержит строку, которую отправим через itemname в другое Activity
                b.putString("defStrID", itemname); 
                
                intent.putExtras(b);
                
                //запускаем Intent
                startActivity(intent);
             }
		});
    }
}
