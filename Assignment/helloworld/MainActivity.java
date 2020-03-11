package Assignment.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "Assignment.HelloWorld.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Button to Second Activity
            Button button_1 = (Button) findViewById(R.id.Button_1);
            button_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity_2();
                }
            });

        //Receiving Input from Activity_3
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView textView_0 = (TextView) findViewById(R.id.EditText_0);
        textView_0.setText(text);

    }

        private void openActivity_2() {
            EditText editText_1 = (EditText) findViewById(R.id.EditText_1);
            String text_1 = editText_1.getText().toString();
            Intent intent = new Intent(this, Activity_2.class);
            intent.putExtra(EXTRA_TEXT, text_1);
            startActivity(intent);
        }

}
