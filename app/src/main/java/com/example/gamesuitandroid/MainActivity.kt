package com.example.gamesuitandroid

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var imgBatuPemain: ImageView
    private lateinit var imgKertasPemain: ImageView
    private lateinit var imgGuntingPemain: ImageView
    private lateinit var imgBatuCom: ImageView
    private lateinit var imgKertasCom: ImageView
    private lateinit var imgGuntingCom: ImageView
    private lateinit var tvResultVs: TextView
    private lateinit var tvResultWin: TextView
    private lateinit var imgRestart: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //player
        imgBatuPemain = findViewById(R.id.img_batu_pemain)
        imgKertasPemain = findViewById(R.id.img_kertas_pemain)
        imgGuntingPemain = findViewById(R.id.img_gunting_pemain)
        //com
        imgBatuCom = findViewById(R.id.img_batu_com)
        imgKertasCom = findViewById(R.id.img_kertas_com)
        imgGuntingCom = findViewById(R.id.img_gunting_com)

        val imgComBatu = imgBatuCom
        val imgComKertas = imgKertasCom
        val imgComGunting = imgGuntingCom
        val choiceCom = arrayListOf<ImageView>(imgComBatu, imgComKertas, imgComGunting).random()

        tvResultVs = findViewById(R.id.tv_result_VS)
        tvResultWin = findViewById(R.id.tv_result_win)
        imgRestart = findViewById(R.id.img_restart)


        //restart Activity
        imgRestart.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
            //recreate()
        }


        //player pilih batu
        imgBatuPemain.setOnClickListener {
            tvResultVs.visibility = View.INVISIBLE
            tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                imgComBatu -> {
                    tvResultWin.text = getString(R.string.draw)
                    @Suppress("DEPRECATION")
                    tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
                }
                imgComGunting -> {
                    tvResultWin.text = getString(R.string.pemain_win)
                }
                imgKertasCom -> {
                    tvResultWin.text = getString(R.string.computer_win)
                }
            }
        }

        //player pilih gunting
        imgGuntingPemain.setOnClickListener {
            tvResultVs.visibility = View.INVISIBLE
            tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                imgComBatu -> {
                    tvResultWin.text = getString(R.string.computer_win)
                }
                imgComGunting -> {
                    tvResultWin.text = getString(R.string.draw)
                    @Suppress("DEPRECATION")
                    tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
                }
                imgKertasCom -> {
                    tvResultWin.text = getString(R.string.pemain_win)
                }
            }
        }

        //player pilih kertas
        imgKertasPemain.setOnClickListener {
            tvResultVs.visibility = View.INVISIBLE
            tvResultWin.visibility = View.VISIBLE
            when (choiceCom) {
                imgComBatu -> {
                    tvResultWin.text = getString(R.string.pemain_win)
                }
                imgComGunting -> {
                    tvResultWin.text = getString(R.string.computer_win)
                }
                imgKertasCom -> {
                    tvResultWin.text = getString(R.string.draw)
                    @Suppress("DEPRECATION")
                    tvResultWin.setBackgroundColor(resources.getColor(R.color.biru_draw))
                }
            }
        }
    }

}