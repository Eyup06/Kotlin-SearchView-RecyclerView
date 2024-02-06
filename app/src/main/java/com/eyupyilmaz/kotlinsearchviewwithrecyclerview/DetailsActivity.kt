package com.eyupyilmaz.kotlinsearchviewwithrecyclerview

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_details.anim_toolBar
import kotlinx.android.synthetic.main.activity_details.collapsingToolBar

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val languageItem = intent.getParcelableExtra<LanguageItem>("languageItem")
        if(languageItem != null)
        {
            val detailsImage : ImageView = findViewById(R.id.detailsIV)
            //val detailsName : TextView = findViewById(R.id.detailsName)
            val detailsExplain : TextView = findViewById(R.id.detailsExplain)

            detailsImage.setImageResource(languageItem.logo)
            //detailsName.text = languageItem.title
            detailsExplain.text = languageItem.explain
        }

        setSupportActionBar(anim_toolBar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolBar.title = languageItem?.title

        var bitmap = BitmapFactory.decodeResource(resources, languageItem!!.logo)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {

                var color = palette?.getVibrantColor(com.google.android.material.R.attr.colorAccent)
                collapsingToolBar.setContentScrimColor(color!!)

                window.statusBarColor = color
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}