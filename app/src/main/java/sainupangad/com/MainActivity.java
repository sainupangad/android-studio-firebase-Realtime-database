package sainupangad.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
     FirebaseAnalytics mFirebaseAnalytics;
    Button button;
    EditText one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (EditText)findViewById(R.id.edit);
        button = (Button)findViewById(R.id.button4);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sainu = one.getText().toString();
                DatabaseReference myRef = database.getReference(sainu);


                myRef.setValue(sainu);



            }
        });


    }
}