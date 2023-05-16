package org.d3if3002.mariberhitung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.d3if3002.mariberhitung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//
//
//        binding.btnHitung.setOnClickListener(){
//
//            if(binding.etAngka1.text.toString() == ""){
//                binding.etAngka1.error = "Angka 1 wajib diisi ya"
//                return@setOnClickListener
//            }
//            if(binding.etAngka2.text.toString() == ""){
//                binding.etAngka2.error = "Angka 2 wajib diisi ya"
//                return@setOnClickListener
//            }
//
//
//            val nilai_angka1 = binding.etAngka1.text.toString().toInt()
//            val nilai_angka2 = binding.etAngka2.text.toString().toInt()
//
//            binding.tvHasil.text = do_hitung_hasil(nilai_angka1, nilai_angka2)
        }
    }

//    private fun do_hitung_hasil(nilai1:Int,nilai2:Int):String{
//        var hitung_hasil:Int = 0
//        val pilih_operator = binding.spAritmatika.selectedItem.toString()
//
//        when(pilih_operator){
//            "x" -> hitung_hasil = nilai1 * nilai2
//            "/" -> hitung_hasil = nilai1 / nilai2
//            "+" -> hitung_hasil = nilai1 + nilai2
//            "-" -> hitung_hasil = nilai1 - nilai2
//            "%" -> hitung_hasil = nilai1 % nilai2
//
//
//            else -> {
//                Toast.makeText(this, "Pilih operatormu", Toast.LENGTH_SHORT).show()
//            }
//        }
//        val result_hasil = hitung_hasil
//        return result_hasil.toString()
//    }

