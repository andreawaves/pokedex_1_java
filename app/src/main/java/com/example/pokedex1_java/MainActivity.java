package com.example.pokedex1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokedex1_java.Presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @BindView(R.id.et_usuario)
    EditText et_usuario;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.btn_registro)
    Button btn_registro;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = et_usuario.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                presenter.verificar(usuario, password);
            }
        });

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), RegistroActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void pass() {
        Toast.makeText(this,"Amazing!",Toast.LENGTH_SHORT).show();
    }
}
