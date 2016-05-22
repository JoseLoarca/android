package org.jcloarca.laboratorio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.jcloarca.laboratorio2.bean.Usuario;
import org.jcloarca.laboratorio2.volley.WebService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtEmail, txtPassword;
    private Usuario loggedUser=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("correo", txtEmail.getText().toString());
                params.put("password", txtPassword.getText().toString());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, WebService.autenticar, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray listaUsuarios = response.getJSONArray("user");
                            if(listaUsuarios.length()>0){
                                JSONObject user = listaUsuarios.getJSONObject(0);
                                loggedUser = new Usuario(
                                        user.getInt("idUsuario"),
                                        user.getString("nombreCompleto"),
                                        user.getString("telefono"),
                                        user.getString("correo"),
                                        user.getString("direccion"),
                                        user.getString("username"),
                                        "",
                                        response.getString("token"),
                                        response.getString("exp")
                                );
                                startActivity(new Intent(LoginActivity.this, Listado.class));
                            }else{
                                Toast.makeText(getApplicationContext(), "Verifique sus credenciales.", Toast.LENGTH_LONG).show();
                            }

                        }catch(Exception ex){
                            Log.e("Error: ",ex.getMessage());
                        }
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("Error: Response", " " + error.getMessage());
                    }
                });
                WebService.getInstance(v.getContext()).addToRequestQueue(request);
            }
        });

    }
}
