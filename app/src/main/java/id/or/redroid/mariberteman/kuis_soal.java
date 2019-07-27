package id.or.redroid.mariberteman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis_soal extends AppCompatActivity {

    //Kamus:
    ImageView gambar;
    TextView quis;
    RadioGroup radiogroup;
    RadioButton pilihA, pilihB, pilihC, pilihD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[] pertanyaan = new String[]{
            " 378 Sebutkan nama bilangan dari lambang bilangan di samping adalah ….",
            " Bilangan 728 jika ditulis dalam bentuk panjang maka akan menjadi ….",
            " Dari 21 siswa kelas II akan dibentuk beberapa kelompok. Jumlah anggota kelompok sama banyak. Berapa banyak siswa di setiap kelompok jika terdapat 3 kelompok?\n",
            " Andi memiliki 18 bola bekel yang akan dibagikan kepada 6 temannya. Setiap orang mendapatkan sama banyak. Berapa banyak bola bekel yang didapat setiap orang?",
            " Sebanyak 24 karet gelang akan dimasukkan ke dalam 4 kotak. Jika setiap kotak memuat karet gelang sama banyak, berapa banyak karet gelang dalam tiap kotak?\n ",
            " Lengkapi kalimat berikut \n Sebelum berangkat ke sekolah aku…..terlebih dahulu",
            " Ibu Guru berkata bahwa Jojo sedang sakit, sehingga Jojo tidak bisa bersekolah, apa yang harus kita lakukan sebagai teman yang baik ….",
            " Rendi akan bermain di taman bersama Bela, Agar bisa bermain maka harus memiliki tubuh sehat dan kuat maka harus ….\n",
            " 1. Meletakkan tas di tempatnya\n 2. Mencuci tangan\n 3. Membersihkan meja makan\n 4. Makan\n 5. Mencuci tangan kembali",
            " 1. Memakai sepatu\n 2. Sarapan\n 3. Bangun tidur\n 4. Memakai seragam\n 5. Mandi\n ",

    };
    String[] pilih_jawaban = new String[]{
            "Tiga Tujuh Delapan", "Tiga puluh tujuh delapan", "Tiga ratus tujuh puluh delapan","Tiga Satu Delapan",
            "7+2+8", "70+20+80","700+20+8","70+20+8",
            "7 Kelompok", "5 Kelompok", "6 Kelompok", "8 Kelompok",
            "6 Kelereng", "8 Kelereng", "3 Kelereng", "4 Kelereng",
            "4 karet gelang", "6 karet gelang", "5 karet gelang", "3 karet gelang",
            "Mencuci pakaiann", "Sarapan pagi", "Bermain di taman","Menjenguk teman",
            "Menjenguk Jojo", "Mengajak Jojo bermain","Memberi Makan Jojo","Pergi Ke Pantai",
            "Menonton tv setiap hari", "Membaca buku setiap waktu", "Bermain bersama teman", "Makan makanan 4 sehat 5 sempurna",
            "2-4-3-1-5", "1-2-4-3-5", "4-3-5-2-1", " 3-5-2-1-4",
            "1-3-2-4-5", "2-4-3-5-1", "3-5-4-2-1", "5-4-3-2-1",

    };
    String[] jawaban_benar = new String[]{
            "Tiga ratus tujuh puluh delapan",
            "700+20+8",
            "7 Kelompok",
            "3 Kelereng",
            "6 karet gelang",

            "Sarapan pagi",
            "Menjenguk Jojo",
            "Makan makanan 4 sehat 5 sempurna",
            "1-2-4-3-5",
            "3-5-4-2-1",
    };
    Integer[] Images = new Integer[]{
            R.drawable.satu,
            R.drawable.dua,
            R.drawable.tiga,
            R.drawable.empat,
            R.drawable.satu,
            R.drawable.dua,
            R.drawable.tiga,
            R.drawable.empat,
            R.drawable.satu,
            R.drawable.dua,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_soal);

        //Diskripsi:
        quis = (TextView) findViewById(R.id.quis);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        pilihA = (RadioButton) findViewById(R.id.pilihA);
        pilihB = (RadioButton) findViewById(R.id.pilihB);
        pilihC = (RadioButton) findViewById(R.id.pilihC);
        pilihD = (RadioButton) findViewById(R.id.pilihD);
        gambar = (ImageView) findViewById(R.id.iv_gambar);

        radiogroup.check(0);
        benar = 0;
        salah = 0;

        //Fungtion
        quis.setText(pertanyaan[nomor]);
        pilihA.setText(pilih_jawaban[0]);
        pilihB.setText(pilih_jawaban[1]);
        pilihC.setText(pilih_jawaban[2]);
        pilihD.setText(pilih_jawaban[3]);
        gambar.setImageResource(Images[nomor]);

    }

    //Function:
    public void next(View view) {
        if (pilihA.isChecked() || pilihB.isChecked() || pilihC.isChecked() || pilihD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
            String ambil_jawaban = jawaban_user.getText().toString();
            radiogroup.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan.length) {
                quis.setText(pertanyaan[nomor]);
                pilihA.setText(pilih_jawaban[(nomor*4)+0]);
                pilihB.setText(pilih_jawaban[(nomor*4)+1]);
                pilihC.setText(pilih_jawaban[(nomor*4)+2]);
                pilihD.setText(pilih_jawaban[(nomor*4)+3]);
                gambar.setImageResource(Images[nomor]);

            } else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), score_kuis.class);
                startActivity(selesai);
            }
        }
        else
        {
            Toast.makeText(this, "Choise You're Answer",Toast.LENGTH_SHORT).show();
        }
    }

}
