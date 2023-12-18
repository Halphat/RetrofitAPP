package com.mastercoding.retrofitapp

import com.google.gson.annotations.SerializedName


//1-Data class(POJO)
data class albumitem(

//Add annotation called Serialize
@SerializedName("id")
    val id:Int,
  @SerializedName("userid")
val userid:Int,
   @SerializedName("title")
    val title:String

    //Seriallize annotation name annotation can be used to serialise a field with differnt name instead of the actual field name



)
