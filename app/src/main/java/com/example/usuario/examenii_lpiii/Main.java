package com.example.usuario.examenii_lpiii;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.examenii_lpiii.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    public static List<Person> listPerson = new ArrayList<Person>();

    public int personId=0;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);

        // String[] arrayNombres = {"Omar Calsin Curo","Juan Perez Perez","Elisabeth Choque","Lesly Aguilar","Jose Manuel Limachi"};

        // listPerson.add(new Person(1,"Omar","Calsin","Curo","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(2,"Juan","Perez","Perez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(3,"Lesly","Aguilar","Chaguares","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));
        // listPerson.add(new Person(4,"Jose Manuel","Limachi","Chavez","www.ocalsin.com","Av: Manuel Nuñez B. 212 - Juliaca"));

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, layout,listPerson);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person)parent.getItemAtPosition(position);
                personId=person.getPersonId();
                Toast.makeText(Main.this, person.getPersonId()+" Hola: "+person.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRegister();
            }
        });
    }

    public void goRegister(){
        Intent i = new Intent(this,Register.class);
        i.putExtra("personId",0);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_synchronize:
                //Intent o = new Intent(this,Register.class);
                //startActivity(o);
                break;
            case R.id.action_edit:
                Intent i = new Intent(this,Register.class);
                // envia id persona a la otra actividad
                i.putExtra("personId",personId);
                startActivity(i);
                break;
            case R.id.action_about:
                Intent ii = new Intent(this,About.class);
                startActivity(ii);
                break;
            case R.id.action_contacts:
                Intent contactIntent = new Intent(this,ContactActivity.class);
                startActivity(contactIntent);
                break;
            case R.id.action_delete:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Alerta");
                alertDialogBuilder
                        .setMessage("Esta Seguro de Eliminar?")
                        .setCancelable(false)
                        .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                deletePerson();
                                refresh();
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void refresh(){
        Intent contactIntent = new Intent(this,Main.class);
        startActivity(contactIntent);
    }

    public void deletePerson() {
        List<Person> listPerson2=new ArrayList<Person>();
        for (Person person:Main.listPerson){
            if(person.getPersonId()!=personId){
                listPerson2.add(person);
            }
        }
        listPerson=listPerson2;
        personId=0;
    }
}
