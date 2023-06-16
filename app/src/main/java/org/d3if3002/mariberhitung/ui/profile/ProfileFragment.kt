package org.d3if3002.mariberhitung.ui.profile

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import org.d3if3002.mariberhitung.MainActivity
import org.d3if3002.mariberhitung.R
import org.d3if3002.mariberhitung.databinding.FragmentProfileBinding
import org.d3if3002.mariberhitung.network.KalkulatorApi


class ProfileFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                MainActivity.PERMISSION_REQUEST_CODE
            )
        }
    }

    private lateinit var binding: FragmentProfileBinding
    private val viewModel : ProfileViewModel by lazy {
        ViewModelProvider(this)[ProfileViewModel::class.java]
    }


    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
    return binding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getData().observe(viewLifecycleOwner){
            binding.textViewProfile.text = it.profile
        }

        Glide.with(binding.imageViewProfile.context)
            .load(KalkulatorApi.getProfileUrl())
            .error(R.drawable.baseline_broken_image_24)
            .into(binding.imageViewProfile)

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }

        viewModel.scheduleUpdater(requireActivity().application)
    }

    private fun updateProgress(status: KalkulatorApi.ApiStatus) {
        when (status) {
            KalkulatorApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            KalkulatorApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestNotificationPermission()
                }

            }
            KalkulatorApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

}