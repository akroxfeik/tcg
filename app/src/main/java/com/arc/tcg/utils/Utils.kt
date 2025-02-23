package com.arc.tcg.utils

enum class ImageQuality {
    HIGH,
    LOW
}
fun getImage(url: String?, quality: ImageQuality = ImageQuality.LOW): String {
    return when (quality) {
        ImageQuality.HIGH -> "$url/high.png"
        else -> "$url/low.png"
    }
}