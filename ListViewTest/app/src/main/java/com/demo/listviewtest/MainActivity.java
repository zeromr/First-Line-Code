package com.demo.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    /*private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
    "Strawbery","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape",
            "Pineapple", "Strawbery","Cherry","Mango"};*/
    private List<Fruit> fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化水果数据
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1, data
        );
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for(int i=0;i<2;i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.apple_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.apple_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.apple_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.apple_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.apple_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.apple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.apple_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.apple_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.apple_pic);
            fruitList.add(mango);
        }
    }
}
