package com.bsoftwares.login_car.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bsoftwares.login_car.R;
import com.bsoftwares.login_car.Utils.Values;
import com.bsoftwares.login_car.data.Model.AuthModel;
import com.bsoftwares.login_car.ui.PerfilActivity.PerfilActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private MainViewModel mainViewModel;
    Button btn_login;
    EditText et_Usuario;
    EditText et_Senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.defineGlobalVariables();
        this.loadEditText();
        this.setUi();
        this.setObservers();
    }

    private void setObservers() {
        mainViewModel.getToken().observe(this, new Observer<AuthModel>() {
            @Override
            public void onChanged(AuthModel authModel) {
                btn_login.setClickable(true);
                if(authModel==null){
                    Toast.makeText(MainActivity.this,"Sem internet",Toast.LENGTH_SHORT).show();
                    return;
                }
                Values.setTOKEN(authModel.getToken());
                startActivity(new Intent(MainActivity.this, PerfilActivity.class));
            }
        });
    }

    private void setUi() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mainViewModel.tryLogin(et_Usuario.getText().toString(),et_Senha.getText().toString());
                    saveEditTextInfo();
                    btn_login.setClickable(false);
                }
            }
        );
    }

    private void saveEditTextInfo() {
        pref.edit().putString("email",et_Usuario.getText().toString())
        .putString("senha",et_Senha.getText().toString())
        .apply();
    }

    private void defineGlobalVariables() {
        pref = getSharedPreferences(Values.PREF_NAME(), Values.PREF_SECURITY());
        btn_login = findViewById(R.id.btn_login);
        et_Usuario = findViewById(R.id.etEmail);
        et_Senha = findViewById(R.id.etSenha);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void loadEditText() {
        et_Usuario.setText(pref.getString("email",""));
        et_Senha.setText(pref.getString("senha",""));
    }
}
