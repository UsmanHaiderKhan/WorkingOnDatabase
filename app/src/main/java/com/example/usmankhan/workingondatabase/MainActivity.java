package com.example.usmankhan.workingondatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myinput;
    TextView textView;
    ProductContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        EditText myEdit = (EditText) findViewById( R.id.myinput );
        TextView textView = (TextView) findViewById( R.id.myText );
        dbContext = new ProductContext( this, null, null, 1 );
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbContext.databasetostring();
        textView.setText( dbString );
        myinput.setText( "" );
    }

    public void onAddProduct(View view) {
        Products products = new Products( myinput.getText().toString() );
        dbContext.addProduct( products );
        printDatabase();
    }

    public void onDelete(View view) {
        String inputtext = myinput.getText().toString();
        dbContext.deleteProduct( inputtext );
        printDatabase();
    }
}
