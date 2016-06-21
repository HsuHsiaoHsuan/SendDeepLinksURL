package hkasianark.senddeeplinksurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean D = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText u = (EditText) findViewById(R.id.et_u);
        final EditText p = (EditText) findViewById(R.id.et_p);
        final EditText pid = (EditText) findViewById(R.id.et_pid);

        Button b_send = (Button) findViewById(R.id.button);

        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String uri = "FREEMAN://login?u=" + u.getText().toString() +
                        "&p=" + p.getText().toString() + "&pid=" + pid.getText().toString();

                Log.d(TAG, "URI = " + uri.toString());

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uri));

                startActivity(intent);
            }
        });
    }
}
