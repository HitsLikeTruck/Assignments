package Assignment.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_3 extends AppCompatActivity {
    public static final String EXTRA_TEXT = "Assignment.HelloWorld.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //Receiving Input from Activity_2

            Intent intent = getIntent();
            String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
            TextView textView_0 = (TextView) findViewById(R.id.EditText_0);
            textView_0.setText(text);

            //Button to MainActivity
            Button button_3 = (Button) findViewById(R.id.Button_3);
            button_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMainActivity();
                }
            });

    }

            private void openMainActivity() {
                EditText editText_3 = (EditText) findViewById(R.id.EditText_3);
                String text = editText_3.getText().toString();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(EXTRA_TEXT, text);
                startActivity(intent);
            }

}
