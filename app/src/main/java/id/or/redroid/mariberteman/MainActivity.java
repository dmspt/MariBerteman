package id.or.redroid.mariberteman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_Eval, btn_Materi, mute, kompetensi;
    LinearLayout btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (LinearLayout)findViewById(R.id.btn);
        btn_Eval=findViewById(R.id.btn_Eval);
        btn_Materi=findViewById(R.id.btn_Materi);
        mute=findViewById(R.id.btn_Mute);
        kompetensi=findViewById(R.id.btn_Kompetensi);

    }
    public void evaluasi(View view)
    {
        Intent intent=new Intent(MainActivity.this,kuis_intruksi.class);
        startActivity(intent);
    }
}
