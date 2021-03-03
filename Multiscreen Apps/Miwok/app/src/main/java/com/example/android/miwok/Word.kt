package com.example.android.miwok

class Word (default:String, miwok:String) {
    companion object{
        const val NO_IMAGE_PROVIDE:Int = -1
        const val NO_AUDIO_PROVIDE:Int = -1
    }
    var defaultTranslation:String = default
    private set
    var miwokTranslation = miwok
    private set
    var imageResourceId:Int = NO_IMAGE_PROVIDE
    private set
    var audioResourceId:Int = NO_AUDIO_PROVIDE
    private set


    constructor(default: String, miwok: String, imageResourceId:Int) : this(default, miwok) {
        this.imageResourceId = imageResourceId

    }
    constructor(default: String, miwok: String, imageResourceId:Int, audioResourceId:Int):this(default,miwok,imageResourceId){
        this.audioResourceId = audioResourceId
    }

    fun hasImage():Boolean{
        return (imageResourceId != NO_IMAGE_PROVIDE)
    }
}