package com.example.facebook.model

class Story{
    var image: Int? = null
    var fullname: String? = null
    var background: Int? = null

    constructor(image: Int, fullname: String, background: Int){
        this.image = image
        this.fullname = fullname
        this.background = background
    }
    constructor()
}
