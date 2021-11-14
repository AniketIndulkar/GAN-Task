package com.gan.gan_task.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/*
* {
	"char_id": 1,
	"name": "Walter White",
	"birthday": "09-07-1958",
	"occupation": ["High School Chemistry Teacher", "Meth King Pin"],
	"img": "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg",
	"status": "Presumed dead",
	"nickname": "Heisenberg",
	"appearance": [1, 2, 3, 4, 5],
	"portrayed": "Bryan Cranston",
	"category": "Breaking Bad",
	"better_call_saul_appearance": []
}
* */
data class BBCharacterNetworkEntity (
    @SerializedName("char_id")
    @Expose
    var char_id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("birthday")
    @Expose
    var birthday : String,

    @SerializedName("occupation")
    @Expose
    var occupation : List<String>,

    @SerializedName("img")
    @Expose
    var img : String,

    @SerializedName("status")
    @Expose
    var status : String,

    @SerializedName("nickname")
    @Expose
    var nickname: String,

    @SerializedName("appearance")
    @Expose
    var appearance : List<Int>,

    @SerializedName("portrayed")
    @Expose
    var portrayed: String,

    @SerializedName("category")
    @Expose
    var category: String,

    @SerializedName("better_call_saul_appearance")
    @Expose
    var better_call_saul_appearance: List<Int>
        )