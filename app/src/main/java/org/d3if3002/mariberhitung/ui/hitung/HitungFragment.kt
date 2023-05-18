package org.d3if3002.mariberhitung.ui.hitung

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if3002.mariberhitung.R
import org.d3if3002.mariberhitung.databinding.FragmentHitungBinding
import org.d3if3002.mariberhitung.db.HitungDb

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    private val viewModel : HitungViewModel by lazy {
        val db = HitungDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_historiFragment
                )
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_profileFragment
                )
                return true
            }
        }
            return super.onOptionsItemSelected(item)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getHasil().observe(viewLifecycleOwner) {
            binding.tvHasil.text = it.toString()
        }

//        viewModel.data.observe(viewLifecycleOwner, {
//            if (it == null) return@observe
//            Log.d("HitungFragment", "Data tersimpan. ID = ${it.id}")
//        })

        binding.tentangAplikasiButton.setOnClickListener() {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment3
            )
        }



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
            val pilih_operator = binding.spAritmatika.selectedItem.toString()

            viewModel.do_hitung_hasil(nilai_angka1, nilai_angka2, pilih_operator)
        }
    }
}
