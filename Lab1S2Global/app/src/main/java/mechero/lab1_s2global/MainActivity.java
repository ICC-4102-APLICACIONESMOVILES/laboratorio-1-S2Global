package mechero.lab1_s2global;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String email = prefs.getString("Email",null);
        String password = prefs.getString("Password",null);
        if (email != null && password != null) {
            loginGo();
        }
    }

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public void clear(android.view.View v){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.clear();
        editor.remove("Email");
        editor.remove("Password");
        TextView mail = (TextView) findViewById(R.id.fin1);
        TextView pass = (TextView) findViewById(R.id.fin2);
        mail.setText("Not Logged In");
        pass.setText("Not Logged In");
        editor.apply();
    }

    public  void logIn(android.view.View v){
        loginGo();
    }

    public void loginGo(){
        TextView mail = (TextView) findViewById(R.id.fin1);
        TextView pass = (TextView) findViewById(R.id.fin2);
        Intent data = new Intent(this, Login.class);
        data.putExtra("Email", "example@mail.com");
        data.putExtra("Password", "0000");
        startActivityForResult(data,20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 20) {
            TextView mail = (TextView) findViewById(R.id.fin1);
            TextView pass = (TextView) findViewById(R.id.fin2);
            mail.setText(data.getExtras().getString("Email"));
            pass.setText(data.getExtras().getString("Password"));
            Credencials creds = new Credencials(this);
            creds.setCreds(RESULT_OK,20, data, MY_PREFS_NAME);
        }
    }

}
