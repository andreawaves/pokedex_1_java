package com.example.pokedex1_java.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.pokedex1_java.Model.Usuario;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RegistroPresenter {

    private RegistroPresenter.View view;
    private Context mContext;
    private Realm realm;
    public RegistroPresenter(RegistroPresenter.View view) {
        this.view = view;
        this.mContext = view.getContext();

        Realm.init(mContext);
        RealmConfiguration config = new RealmConfiguration.Builder().name("usuario.realm").build();
        realm = Realm.getInstance(config);
    }

    public void registrar(String usuario, String password1, String password2){
        if (!vacios(usuario, password1, password2)){ //y no existe
            if (password1.equals(password2)){
                almacenar(usuario,password1);
            } else {
                Toast.makeText(mContext,"Contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void almacenar(String usuario, String password){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        Usuario newUsuario = realm.createObject(Usuario.class);
        newUsuario.setUsuario(usuario);
        newUsuario.setPassword(password);

        realm.commitTransaction();
    }


    private boolean vacios(String usuario, String password1, String password2) {
        if (usuario.isEmpty() && password1.isEmpty() && password2.isEmpty()){
            Toast.makeText(mContext,"Complete los campos",Toast.LENGTH_SHORT).show();
        } else {
            if (usuario.isEmpty()){
                Toast.makeText(mContext,"Complete su usuario",Toast.LENGTH_SHORT).show();
            } else {
                if (password1.isEmpty()) {
                    Toast.makeText(mContext,"Complete su contraseña",Toast.LENGTH_SHORT).show();
                } else {
                    if (password2.isEmpty()){
                        Toast.makeText(mContext,"Repita su constraseña",Toast.LENGTH_SHORT).show();
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public interface View {
        void pass();
        Context getContext();
    }
}
