package com.example.pokedex1_java.Presenter;

import android.content.Context;
import android.widget.Toast;

public class MainPresenter {

    private View view;
    private Context mContext;
    public MainPresenter(View view) {
        this.view = view;
        this.mContext = view.getContext();
    }

    public void verificar(String usuario, String password){
        if (usuario.isEmpty()) {
            Toast.makeText(this.mContext,"Complete su usuario",Toast.LENGTH_SHORT).show();
        } else {
            if (password.isEmpty()) {
                Toast.makeText(this.mContext,"Complete su contraseña",Toast.LENGTH_SHORT).show();
            } else {
                view.pass();
            }
        }
    }

    public interface View {
        void pass();
        Context getContext();
    }
}
