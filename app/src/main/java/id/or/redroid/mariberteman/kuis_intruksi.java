package id.or.redroid.mariberteman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class kuis_intruksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_intruksi);

    }

    public void next(View view)
    {
        Intent intent=new Intent(kuis_intruksi.this, kuis_soal.class);
        startActivity(intent);
    }
    public void close(View view)
    {
        Intent intent=new Intent(kuis_intruksi.this,MainActivity.class);
        startActivity(intent);
    }
}
