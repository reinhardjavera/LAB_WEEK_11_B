package com.example.lab_week_11_b

import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore

// Helper class to generate the URI and ContentValues for MediaStore
class MediaContentHelper {
    // Get the URI to store images and videos in MediaStore
    // The URI will be different for Android 10 and above
    fun getImageContentUri(): Uri =
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
    fun getVideoContentUri(): Uri =
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }

    // Generate the ContentValues to store images and videos in MediaStore
    // It contains the name, relative path, and MIME type of the file
    fun generateImageContentValues(fileInfo: FileInfo) = ContentValues().apply {
        this.put(MediaStore.Images.Media.DISPLAY_NAME, fileInfo.name)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            this.put(MediaStore.Images.Media.RELATIVE_PATH, fileInfo.relativePath)
        }
        this.put(MediaStore.Images.Media.MIME_TYPE, fileInfo.mimeType)
    }
    fun generateVideoContentValues(fileInfo: FileInfo) = ContentValues().apply {
        this.put(MediaStore.Video.Media.DISPLAY_NAME, fileInfo.name)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            this.put(MediaStore.Video.Media.RELATIVE_PATH, fileInfo.relativePath)
        }
        this.put(MediaStore.Video.Media.MIME_TYPE, fileInfo.mimeType)
    }
}