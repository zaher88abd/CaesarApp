package ca.zaher.m.caesarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ecrypt_decrypt_output;
    private EditText input_value;
    private TextView shift_value;
    private SeekBar seek_bar;
    private Button encrypt_decrypt;
    private CaesarCipher caesarCipher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecrypt_decrypt_output = findViewById(R.id.encrypt_decrypt_output);
        input_value = findViewById(R.id.input_value);
        shift_value = findViewById(R.id.shift_value);
        encrypt_decrypt = findViewById(R.id.encrypt_decrypt);
        caesarCipher = new CaesarCipher();
        seek_bar = findViewById(R.id.seek_bar);

        // set the shift_value with the value of the seek_bar
        shift_value.setText(String.valueOf(seek_bar.getProgress()));

        // to be sure the value always is Capital letter
        input_value.setFilters(new InputFilter[]{new InputFilter.AllCaps()});


        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                shift_value.setText(String.valueOf(seek_bar.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        encrypt_decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set the input value
                caesarCipher.setInput(input_value.getText().toString());

                caesarCipher.setShiftValue(seek_bar.getProgress());

                caesarCipher.caesar();

                ecrypt_decrypt_output.setText(caesarCipher.getCryptedInput());
            }
        });
    }
}
