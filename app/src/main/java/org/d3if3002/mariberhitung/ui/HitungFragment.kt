package org.d3if3002.mariberhitung.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.d3if3002.mariberhitung.databinding.ActivityMainBinding
import org.d3if3002.mariberhitung.databinding.FragmentHitungBinding

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        binding.btnHitung.setOnClickListener(){

            if(binding.etAngka1.text.toString() == ""){
                binding.etAngka1.error = "Angka 1 wajib diisi ya"
                return@setOnClickListener
            }
            if(binding.etAngka2.text.toString() == ""){
                binding.etAngka2.error = "Angka 2 wajib diisi ya"
                return@setOnClickListener
            }


            val nilai_angka1 = binding.etAngka1.text.toString().toInt()
            val nilai_angka2 = binding.etAngka2.text.toString().toInt()

            binding.tvHasil.text = do_hitung_hasil(nilai_angka1, nilai_angka2)
        }
        return binding.root

    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = FragmentHitungBinding.inflate(layoutInflater)
//        setContentView(binding.root)
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
//        }
//    }

    private fun do_hitung_hasil(nilai1:Int,nilai2:Int):String{
        var hitung_hasil:Int = 0
        val pilih_operator = binding.spAritmatika.selectedItem.toString()

        when(pilih_operator){
            "x" -> hitung_hasil = nilai1 * nilai2
            "/" -> hitung_hasil = nilai1 / nilai2
            "+" -> hitung_hasil = nilai1 + nilai2
            "-" -> hitung_hasil = nilai1 - nilai2
            "%" -> hitung_hasil = nilai1 % nilai2


            else -> {
                Toast.makeText(context, "Pilih operatormu", Toast.LENGTH_SHORT).show()
            }
        }
        val result_hasil = hitung_hasil
        return result_hasil.toString()
    }
}
