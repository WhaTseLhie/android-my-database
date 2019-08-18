package pardillo.john.jv.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName, txtPhone;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = new MyDatabase(this);
        this.txtName = this.findViewById(R.id.editText);
        this.txtPhone = this.findViewById(R.id.editText2);

        this.findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = this.txtName.getText().toString();
        String phone = this.txtPhone.getText().toString();

        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
        } else if(TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Please enter phone", Toast.LENGTH_SHORT).show();
        } else {
            this.txtName.setText("");
            this.txtPhone.setText("");
            this.db.addPerson(name, phone);

            Toast.makeText(this, name+ " successfully added to the database", Toast.LENGTH_SHORT).show();
        }
    }
}
