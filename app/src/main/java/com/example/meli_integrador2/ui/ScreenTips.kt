package com.example.meli_integrador2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.meli_integrador2.R
import com.example.meli_integrador2.databinding.ActivityScreenTipsBinding
import com.example.meli_integrador2.webService.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenTips : AppCompatActivity() {
    private var typeCategory: String? = null
    private lateinit var participants: String
    private lateinit var binding: ActivityScreenTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        showViewerror(View.VISIBLE)
        visivilityProgress(View.VISIBLE)
        visivilityTextError(View.GONE)
        binding.buttonSelectedTryAnother.visibility = View.GONE


        participants = intent.getStringExtra(getString(R.string.key_number_participants)).toString()
        typeCategory = intent.getStringExtra(getString(R.string.key_type_category))


        binding.ImageButtonBackButton.setOnClickListener {
            finish()
        }

        binding.buttonSelectedTryAnother.setOnClickListener {
            getActivityWebService()
        }


        getActivityWebService()
    }

    private fun getActivityWebService() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = Retrofit.getRetrofit.run {
                typeCategory?.let {
                    kotlin.run {
                        binding.TextViewSelectedSuggestionTitle.text = it
                        binding.linearTypeActivity.visibility = View.GONE
                    }
                    getActivity(it.lowercase(), participants)
                } ?: run {
                    getActivityrandom(
                        participants
                    )
                }
            }
            runOnUiThread {
                showViewerror(View.VISIBLE)
                visivilityProgress(View.GONE)
                visivilityTextError(View.VISIBLE)
            }
            if (response.isSuccessful) {
                val activityResponse = response.body()

                activityResponse?.let {
                    runOnUiThread {

                        it.error?.let {
                            binding.buttonSelectedTryAnother.visibility = View.GONE
                            binding.layoutError.root.visibility = View.VISIBLE
                            Handler().postDelayed({
                                finish()
                            }, 3000)
                            return@runOnUiThread
                        }

                        showViewerror(View.GONE)
                        binding.buttonSelectedTryAnother.visibility = View.VISIBLE
                        binding.textViewTittleActivity.text = it.activity
                        binding.TextViewParticipants.text = it.participants.toString()
                        binding.TextViewRandomCategoryName.text = it.type.toString()
                        val price: Float = it.price
                        binding.TextViewPrice.text = price(price)


                    }
                }
            } else showViewerror(View.VISIBLE)

        }
    }

    private fun showViewerror(visibility: Int){
        binding.layoutError.root.visibility = visibility
    }
    private fun visivilityProgress(visibility: Int) {
        binding.layoutError.progressBar.visibility = visibility
    }

    private fun visivilityTextError(visibility: Int) {
        binding.layoutError.textError.visibility = visibility
    }

    private fun price(price: Float): String {
        return when (price) {
            in 0.0..0.0 -> "Free"
            in 0.1..0.3 -> "Low"
            in 0.4..0.6 -> "Medium"
            in 0.7..1.0 -> "High"
            else -> "the price is wrong"
        }
    }
}


