package com.example.meli_integrador2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.meli_integrador2.R
import com.example.meli_integrador2.databinding.ActivityScreenTipsBinding
import com.example.meli_integrador2.model.Activity
import com.example.meli_integrador2.webService.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ScreenTips : AppCompatActivity() {
    private var typeCategory: String? = null
    private lateinit var participants: String
    private lateinit var price: String
    private lateinit var binding: ActivityScreenTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        showViewError(View.VISIBLE)
        visibilityProgress(View.VISIBLE)
        visibilityTextError(View.GONE)
        binding.buttonSelectedTryAnother.visibility = View.GONE


        participants = intent.getStringExtra(getString(R.string.key_number_participants)).toString()
        price = intent.getStringExtra(getString(R.string.key_price)).toString()
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
                    getActivity(it.lowercase(), participants, price)
                } ?: run {
                    getActivityRandom(
                        participants, price
                    )
                }
            }
            runOnUiThread {
                showViewError(View.VISIBLE)
                visibilityProgress(View.GONE)
                visibilityTextError(View.VISIBLE)
                if (response.isSuccessful) {
                    val activityResponse = response.body()

                    activityResponse?.let {


                        it.error?.let {
                            binding.buttonSelectedTryAnother.visibility = View.GONE
                            binding.layoutError.root.visibility = View.VISIBLE
                            Handler().postDelayed({
                                finish()
                            }, 3000)
                            return@runOnUiThread
                        }

                        showViewError(View.GONE)
                        binding.buttonSelectedTryAnother.visibility = View.VISIBLE
                        binding.textViewTittleActivity.text = it.activity
                        binding.TextViewParticipants.text = it.participants.toString()
                        binding.TextViewRandomCategoryName.text = it.type.toString()
                        val price: Float = it.price
                        binding.TextViewPrice.text = price(price)


                    }
                } else showViewError(View.VISIBLE)
            }

        }
    }

    private fun showViewError(visibility: Int) {
        binding.layoutError.root.visibility = visibility
    }

    private fun visibilityProgress(visibility: Int) {
        binding.layoutError.progressBar.visibility = visibility
    }

    private fun visibilityTextError(visibility: Int) {
        binding.layoutError.textError.visibility = visibility
    }

    private fun price(price: Float): String {
        return when (price) {
            in 0.0..0.0 -> "Free"
            in 0.1..0.4 -> "Low"
            in 0.4..0.7 -> "Medium"
            in 0.7..1.1 -> "High"
            else -> "the price is wrong"
        }
    }
}


