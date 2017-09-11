package com.mostafaabdel_fatah.searchboxdmo;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] ar = {"Mostafa","Abd El_Fatah","Mohammed","Ali","Ismael","Saad","Khaled","Walid","Omer"
                ,"Ahemad","Mostafa Abd El_Fatah","Khaled AbdEl_Fatah","Omer AbdEl_Fatah","Mohamed AbdEl_Fatah"
                ,"Osam","Ahemad Saad" , "Ali Saad" , "Hesssin Saad" , "Hessuin" ,"Mohoumd"};
        for (String item : ar ) {
            arrayList.add(item);
        }
        listView = (ListView) findViewById(R.id.listview);
        updateListView(arrayList);
    }

    public  void  updateListView(ArrayList<String> list){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items,menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.searchItem));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       switch (id){
           case R.id.all:
               updateListView(arrayList);
               break;
           case R.id.help:
               Toast.makeText(this,"Help...",Toast.LENGTH_LONG).show();
               break;
           case R.id.exit:
               finish();
               break;
           default:
               updateListView(arrayList);
       }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchtext(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchtext(newText);
        return false;
    }
    public void searchtext(String query){
        ArrayList<String> searchlist = new ArrayList<>();
        for (String item : arrayList){
            if (item.contains(query))
                searchlist.add(item);
        }
        updateListView(searchlist);
    }
}
