package id.sulthoni.ridhwan

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class LaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        val extras = intent.extras
        val tmp = extras!!.getString("hjumPinjam")
        val jumPinjam = findViewById<TextView>(R.id.hasilJumPinjam)
        jumPinjam.append(tmp)

        val ten = extras.getString("hTenor")
        val tenor = findViewById<TextView>(R.id.hasilTenor)
        tenor.append(ten)

        val biayaLayanan: Long = Math.round(Integer.parseInt(tmp) * 0.005)
        val layanan = findViewById<TextView>(R.id.hasilLayanan)
        layanan.append(biayaLayanan.toString())

        val r = 0.0375*100
        val sukuBunga : Int = r.roundToInt()
        val bunga = findViewById<TextView>(R.id.hasilBunga)
        bunga.append(r.toString()+"%")

        val cair = Integer.parseInt(tmp) - Integer.parseInt(biayaLayanan.toString())
        val pencairan = findViewById<TextView>(R.id.hPencairan)
        pencairan.append(cair.toString())

        val total = Integer.parseInt(tmp) + (Integer.parseInt(sukuBunga.toString()) * Integer.parseInt(ten))
        val hasil_total = findViewById<TextView>(R.id.hTotal)
        hasil_total.append(total.toString())
    }
}