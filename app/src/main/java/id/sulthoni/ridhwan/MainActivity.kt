package id.sulthoni.ridhwan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(),  View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.submit -> {
                val jumPinjam = findViewById<EditText>(R.id.tJumPinjam)
                val jumPinjam_pesan = jumPinjam.text.toString()
                val launch = Intent(this, LaporanActivity::class.java ).apply {
                    putExtra("hjumPinjam", jumPinjam_pesan)
                }
                val tenor = findViewById(R.id.tTenor) as EditText
                val tenor_pesan = tenor.text.toString()
                launch.putExtra("hTenor", tenor_pesan)
                startActivity(launch)
            }
        }
    }
}

