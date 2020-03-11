package Assignment.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {
    public static final String EXTRA_TEXT = "Assignment.HelloWorld.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

            //Receiving Input from MainActivity

            Intent intent = getIntent();
            String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
            TextView textView_0 = (TextView) findViewById(R.id.EditText_0);
            textView_0.setText(text);

            //Button to Third Activity
            Button button_2 = (Button) findViewById(R.id.Button_2);
            button_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity_3();
                }
            });

    }

        private void openActivity_3() {
            EditText editText_2 = (EditText) findViewById(R.id.EditText_2);
            String text = editText_2.getText().toString();
            Intent intent = new Intent(this, Activity_3.class);
            intent.putExtra(EXTRA_TEXT, text);
            startActivity(intent);
        }


}
