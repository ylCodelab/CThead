package com.example.ctheadimage;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

 public class MainActivity extends Activity {
	private TabHost tabhost;
	private RadioGroup radiogroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//��ʼ��CT����
		CTData dataset;
		dataset = CTData.getInstance();
		try {
			dataset.createCTData(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContentView(R.layout.activity_main);
		
		radiogroup = (RadioGroup)findViewById(R.id.radiogroup);
		tabhost = (TabHost)findViewById(android.R.id.tabhost); 
		tabhost.setup();
        tabhost.addTab(tabhost.newTabSpec("Home").setIndicator("Home")
                .setContent(R.id.fragment_home));
        tabhost.addTab(tabhost.newTabSpec("Front").setIndicator("Front")
                .setContent(R.id.fragment_front));
        tabhost.addTab(tabhost.newTabSpec("Top").setIndicator("Top")
                .setContent(R.id.fragment_top));
        tabhost.addTab(tabhost.newTabSpec("Side").setIndicator("Side")
                .setContent(R.id.fragment_side));
        
        radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("CTheader","checkedId  " + checkedId +"  " + R.id.fragment_front);
                switch (checkedId) {
                case R.id.HomeTab:
                Log.d("CTheader","fragment_home");
                    tabhost.setCurrentTabByTag("Home");
                    //�����Ҫ����Ч����ʹ��
                    //setCurrentTabWithAnim(currentTab, 0, "main");
                    //getSupportActionBar().setTitle("��ҳ");
                    break;
                case R.id.FrontTab:
                	Log.d("CTheader","fragment_front");
                    tabhost.setCurrentTabByTag("Front");
                    //setCurrentTabWithAnim(currentTab, 1, "mycenter");
                    //getSupportActionBar().setTitle("��������");
                    break;
                case R.id.TopTab:
                	Log.d("CTheader","fragment_top");
                    tabhost.setCurrentTabByTag("Top");
                    //getSupportActionBar().setTitle("����");
                    break;
                case R.id.SideTab:
                	Log.d("CTheader","fragment_side");
                    tabhost.setCurrentTabByTag("Side");
                    //getSupportActionBar().setTitle("����");
                    break;
                }
                // ˢ��actionbar��menu
                //getWindow().invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
            }
        });       
	}
	
}