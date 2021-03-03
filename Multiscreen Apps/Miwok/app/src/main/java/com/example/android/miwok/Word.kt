package com.example.android.miwok

class Word (default:String, miwok:String) {
    private val NO_IMAGE_PROVIDE:Int = -1
    var defaultTranslation:String = default
    private set
    var miwokTranslation = miwok
    private set
    var imageResourceId:Int = NO_IMAGE_PROVIDE
    private set
    constructor(default: String, miwok: String, imageResourceId:Int) : this(default, miwok) {
        this.imageResourceId = imageResourceId
    }
    fun hasImage():Boolean{
        return (imageResourceId != NO_IMAGE_PROVIDE)
    }
}