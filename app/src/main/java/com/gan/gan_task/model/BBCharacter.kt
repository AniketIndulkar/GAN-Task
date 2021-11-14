package com.gan.gan_task.model


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
}
* */
data class BBCharacter(
    var char_id: Int,
    var name: String,
    var birthday : String,
    var occupation : List<String>,
    var img : String,
    var status : String,
    var nickname: String,
    var appearance : List<Int>,
    var portrayed: String,
    var category: String,
    var better_call_saul_appearance: List<Int>
)