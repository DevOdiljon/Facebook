package com.example.facebook.model

class Feed {
    var isHeader: Int? = null
    var stories: ArrayList<Story> = ArrayList()
    var post: Post? = null
    var profile: Profile? = null

    constructor(stories: ArrayList<Story>, num: Int){
        this.stories = stories
        isHeader = num
    }
    constructor(post: Post, num: Int){
        this.post = post
        isHeader = num
    }
    constructor(num: Int){
        isHeader = num
    }
    constructor(num: Int, profile: Profile){
        this.profile = profile
        isHeader = num
    }
}