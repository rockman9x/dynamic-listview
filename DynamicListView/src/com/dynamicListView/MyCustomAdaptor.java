package com.dynamicListView;
import java.util.ArrayList;
import java.util.Vector;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyCustomAdaptor extends ArrayAdapter<GtuMcaBean>{

    Context context;
    int layoutResourceId;  
    static String datesort;
   
    GtuMcaBean currentMRB;
    ArrayList<GtuMcaBean>data;
    /** Called when the activity is first created. */
    // TODO Auto-generated constructor stub
    public MyCustomAdaptor(Context context, int layoutResourceId, ArrayList<GtuMcaBean> data)
    {
        super(context,layoutResourceId,data);
        this.layoutResourceId = layoutResourceId;
        this.context=context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        MyStringReaderHolder holder;
       
        if(row==null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent,false);
           
            holder= new MyStringReaderHolder();
           
            holder.gtumcaTvFirstName =(TextView)row.findViewById(R.id.gtumcaTvFirstName);
            holder.gtumcaTvLastName =(TextView)row.findViewById(R.id.gtumcaTvLastName);
            holder.gtumcaTvBirthDate  =(TextView)row.findViewById(R.id.gtumcaTvBirthDate);
            holder.gtumcaIvIcon=(ImageView) row.findViewById(R.id.gtumcaIvIcon);
           
            row.setTag(holder);
        }
        else
        {
            holder=(MyStringReaderHolder) row.getTag();
        }
       
        GtuMcaBean mrb =data.get(position);
        System.out.println("Position="+position);
     
         holder.gtumcaTvFirstName.setText(mrb.getGtumcaFirstName());
        holder.gtumcaTvLastName.setText(mrb.getGtumcaLastName());
        holder.gtumcaTvBirthDate.setText(mrb.getGtumcaBirthdate());
        holder.gtumcaIvIcon.setImageResource(R.drawable.ic_launcher);
        return row;
    }
    static class MyStringReaderHolder
    {
        TextView gtumcaTvFirstName,gtumcaTvLastName,gtumcaTvBirthDate;
        ImageView gtumcaIvIcon;
    }
}
