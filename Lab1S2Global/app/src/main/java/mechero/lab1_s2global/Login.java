package mechero.lab1_s2global;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void endOne(android.view.View v){
        // Prepare data intent
        Intent data = new Intent();
        TextView a = (TextView) findViewById(R.id.Email);
        TextView b = (TextView) findViewById(R.id.Pass);
        data.putExtra("Email", a.getText().toString());
        data.putExtra("Password", b.getText().toString());
        if (data.hasExtra("Email")==false || data.getExtras().getString("Email").contains("@")==false || data.hasExtra("Password")==false) {
            Toast.makeText(this, "Error in Email or Password", Toast.LENGTH_SHORT).show();
        }
        else{
            setResult(RESULT_OK, data);
            super.finish();
        }
    }

}
