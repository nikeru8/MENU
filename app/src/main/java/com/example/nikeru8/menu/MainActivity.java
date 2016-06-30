package com.example.nikeru8.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        registerForContextMenu(textView);
        registerForContextMenu(textView2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case R.id.textView:
                menu.add(0, 101, Menu.NONE, "大麥克");
                menu.add(0, 102, Menu.NONE, "麥香魚");
                break;
            case R.id.textView2:
                menu.add(0, 201, Menu.NONE, "Coca");
                menu.add(0, 202, Menu.NONE, "Ice Cream");

                Menu sub = menu.addSubMenu(0, 203, Menu.NONE, "Coffee");
                sub.add(0, 901, Menu.NONE, "冷");
                sub.add(0, 902, Menu.NONE, "熱");

                break;
        }



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 101:
                textView.setText(item.getTitle());
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.big_mac, 0);
                break;
            case 102:
                textView.setText(item.getTitle());
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.fish, 0);
                break;

            case 201:
                textView2.setText(item.getTitle());
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.coca_cola, 0);
                break;
            case 202:
                textView2.setText(item.getTitle());
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ice_cream, 0);
                break;
            case 203:
                textView2.setText(item.getTitle());
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.iced_coffee, 0);
                break;
            case 901:
            case 902:
                textView2.setText(textView2.getText().toString() + item.getTitle());


        }
        return super.onContextItemSelected(item);

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, Menu.NONE, "結帳");
        menu.add(0, 1, Menu.NONE, "離開");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(context, "結帳", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
