package com.example.pokedex1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pokedex1_java.Presenter.RegistroPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistroActivity extends AppCompatActivity implements RegistroPresenter.View {

    @BindView(R.id.et_usuario1)
    EditText et_usuario1;

    @BindView(R.id.et_password1)
    EditText et_password1;

    @BindView(R.id.et_password2)
    EditText et_password2;

    @BindView(R.id.btn_registrarse)
    Button btn_registrarse;

    private RegistroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ButterKnife.bind(this);

        presenter = new RegistroPresenter(this);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = et_usuario1.getText().toString().trim();
                String password1 = et_password1.getText().toString().trim();
                String password2 = et_password2.getText().toString().trim();
                presenter.registrar(usuario, password1, password2);
            }
        });
    }

    @Override
    public void pass() {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
