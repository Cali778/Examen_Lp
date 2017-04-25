package com.example.usuario.examenii_lpiii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.examenii_lpiii.bean.Person;

import java.util.List;

/**
 * Created by Usuario on 25/04/2017.
 */

public class PersonListAdapter extends ArrayAdapter<Person> {

    private Context contextGeneral;

    private class ViewHolder{
        TextView name;
        TextView lastNames;
        TextView userName;
        ImageView photo;
    }


    public PersonListAdapter(Context context, List<Person> rowItem) {
        super(context, R.layout.list_person, rowItem);
    }

    public View getView(int position, View contentView, ViewGroup parent){
        Person person = getItem(position);

        ViewHolder viewHolder;
        if(contentView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.list_person,null);
            viewHolder.name = (TextView)contentView.findViewById(R.id.name);
            viewHolder.lastNames = (TextView)contentView.findViewById(R.id.lastNames);
            viewHolder.userName = (TextView)contentView.findViewById(R.id.nameUser);
            viewHolder.photo = (ImageView)contentView.findViewById(R.id.photo);
            contentView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)contentView.getTag();
        }
        viewHolder.name.setText(person.getName());
        viewHolder.lastNames.setText(person.getLastNames());
        viewHolder.userName.setText(person.getUserName());


        viewHolder.photo.setImageResource(person.getPhoto());

        return contentView;
    }





}
