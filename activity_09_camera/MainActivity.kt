package edu.msudenver.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.util.Log
import android.util.Log.INFO
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.scale
import java.net.URI
import java.util.logging.Level.INFO

class MainActivity : AppCompatActivity() {

//    var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCamera = findViewById<Button>(R.id.btnCamera)

        // TODO: instantiate a "result launcher" with a callback method (as a lambda function)
        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
                result ->
                // check the status of the result
                if (result.resultCode == Activity.RESULT_OK) {

                    // extract the image bitmap from the result
                    var imgBitmap = result?.data?.extras?.get("data") as Bitmap

                    // scale the image to fit the width of the screen
                    val dm = resources.displayMetrics
                    val scaleFactor = dm.heightPixels / dm.widthPixels
                    val newHeight = dm.widthPixels * scaleFactor
                    imgBitmap = imgBitmap.scale(dm.widthPixels, newHeight)

                    // get a reference to the ImageView and use it to update the image displayed
                    val imgCamera = findViewById<ImageView>(R.id.imgCamera)
                    imgCamera.setImageBitmap(imgBitmap)
            }
        }

        // TODO: set an "onClickListener" for the camera button with an implicit intent with the "MediaStore.ACTION_IMAGE_CAPTURE" action; start the "result launcher" passing the implicit intent
        btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            resultLauncher.launch(intent)
        }
    }
}
