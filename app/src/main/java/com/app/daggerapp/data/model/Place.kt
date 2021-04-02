package com.app.daggerapp.data.model

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class Place(
    private val latitude: Double,
    private val longitude: Double,
    private val title: String,
    private val snippet: String,
): ClusterItem {
    private val position: LatLng = LatLng(latitude, longitude)

    override fun getPosition(): LatLng = position

    override fun getTitle(): String = title

    override fun getSnippet(): String = snippet
}
