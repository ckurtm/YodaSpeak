package com.peirr.yodaspeak.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.peirr.yodaspeak.R;
import com.peirr.yodaspeak.model.ModelFactory;
import com.peirr.yodaspeak.model.YodaModel;
import com.peirr.yodaspeak.view.YodaView;
import com.peirr.yodaspeak.viewmodel.YodaViewModel;

public class MainActivity extends AppCompatActivity implements YodaView {
    private static final String TAG = "MainActivity";

    private YodaViewModel viewModel;
    private YodaModel model;

    TextView resultText;
    EditText inputText;
    View progress;
    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = (TextView) findViewById(R.id.out_text);
        inputText = (EditText) findViewById(R.id.input_text);
        progress = findViewById(R.id.input_progress);
        request = (Button) findViewById(R.id.button);

        model = ModelFactory.getModel(this,false);
        viewModel = new YodaViewModel(this,model);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();
                viewModel.requestText(text);
            }
        });
    }


    @Override
    public void showTextLoading(boolean show) {
        resultText.setText("");
        progress.setVisibility(show?View.VISIBLE:View.GONE);
        inputText.setVisibility(show?View.GONE:View.VISIBLE);
        request.setEnabled(!show);
    }

    @Override
    public void showText(String text) {
        resultText.setText(getString(R.string.quote,text));
    }

    @Override
    public void showLoadingError() {
        resultText.setText("ERROR!!!");
    }
}
