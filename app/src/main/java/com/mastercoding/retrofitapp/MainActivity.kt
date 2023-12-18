package com.mastercoding.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textv: TextView = findViewById(R.id.hallotx)
        val retrofitservice = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumServices::class.java)

        //create a live data object
        val reponseLiveData : LiveData<Response<albums>> =
            liveData {
                val response = retrofitservice.getAlbums()

                //val response2 = retrofitService.getSpecificAlbums(6)
                emit(response)
            }
        reponseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()

            if (albumsList !=null){
                while (albumsList.hasNext()){
                    val albumItem = albumsList.next()
                    //  Log.i("TAGY",albumItem.title)

                    val result = " Album Title: ${albumItem.title} \n"

                    textv.append(result)


                }
            }
        })
    }

}