package sainupangad.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
     FirebaseAnalytics mFirebaseAnalytics;
    DatabaseReference myRef;
    Button button4,button33;
    String sainu,TAG;
    EditText one;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (EditText)findViewById(R.id.edit);
        button4 = (Button)findViewById(R.id.button4);
        button33 = (Button)findViewById(R.id.button33);
        tx1 = (TextView)findViewById(R.id.tx1);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();





        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 sainu = one.getText().toString();
                 myRef = database.getReference(sainu);


                myRef.setValue(sainu);



            }
        });

        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.

                        String value = dataSnapshot.getValue(String.class);
                       // Log.d(TAG, "Value is: " + value);





                            tx1.setText(value);

                        tx1.setText(value);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }
        });



    }
}