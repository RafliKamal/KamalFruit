package com.kamalapp.kamalfruit

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Halaman Detail"

        val tvFruitName: TextView = findViewById(R.id.tv_item_name)
        val tvFruitDescription: TextView = findViewById(R.id.tv_item_description)
        val ivFruitImage: ImageView = findViewById(R.id.img_item_photo)
        val btnShare: Button = findViewById(R.id.action_share)

        val fruit = intent.getParcelableExtra<Fruit>("EXTRA_FRUIT")

        if (fruit != null) {
            tvFruitName.text = fruit.name
            tvFruitDescription.text = fruit.description
            ivFruitImage.setImageResource(fruit.photo)

            btnShare.setOnClickListener {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Nama Buah: ${fruit.name}\nDeskripsi: ${fruit.description}")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Bagikan info buah"))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}






