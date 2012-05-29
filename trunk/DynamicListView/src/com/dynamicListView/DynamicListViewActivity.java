package com.dynamicListView;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;


public class DynamicListViewActivity extends Activity {
ListView gtumcaDynamicListView;
ArrayList<GtuMcaBean> gtuMcaBean= new ArrayList<GtuMcaBean>();
MyCustomAdaptor adaptor;
private boolean loadingMore = false;
Handler  handler = new Handler();

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   
    gtumcaDynamicListView=(ListView) findViewById(R.id.gtumcaDynamicListView);

        /*** adding data ***/      
/*    for(int i= 1;i<1000;i++){
    	gtuMcaBean.add(new GtuMcaBean(i+" First", i+" Last", i+" Birthdate"));
    }*/

    adaptor = new MyCustomAdaptor(DynamicListViewActivity.this, R.layout.data, gtuMcaBean);
    gtumcaDynamicListView.setAdapter(adaptor);
    
    gtumcaDynamicListView.setOnScrollListener(new OnScrollListener() {
		
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			// what is the bottom iten that is visible
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if((lastInScreen == totalItemCount) && !(loadingMore)) {
            	//Run background thread
            	Thread tt = new loadBackgroung(lastInScreen, adaptor);
            	tt.start();
            }
		}
	});
}

class loadBackgroung extends Thread{
	public int lastIndex;
	public MyCustomAdaptor adaptor;
	
	
	public loadBackgroung(int lastIndex, MyCustomAdaptor adaptor) {
		super();
		this.lastIndex = lastIndex;
		this.adaptor = adaptor;
	}

	@Override
    public void run() {
		
		
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i<10;i++){
					gtuMcaBean.add(new GtuMcaBean((lastIndex + i)+" First", (lastIndex + i)+" Last", (lastIndex + i)+" Birthdate"));
				}
				adaptor.notifyDataSetChanged();
			}
		});
		loadingMore = false;
		
	}
	
}
}