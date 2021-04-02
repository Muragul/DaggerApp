package com.app.daggerapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.data.model.Place
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterManager

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var clusterManager: ClusterManager<Place>
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        setUpCluster()
        map.moveCamera(CameraUpdateFactory.newLatLng(LatLng(43.225906, 76.935647)))
    }

    private fun setUpCluster() {
        clusterManager = ClusterManager(this, map)
        map.setOnCameraIdleListener(clusterManager)
        clusterManager.addItems(getPlaces())
        clusterManager.cluster()
    }

    private fun getPlaces(): List<Place> {
        val bar = Place(
            43.225906,
            76.935647,
            "Jungle",
            "Lounge bar Jungle in Almaty, Markov 61"
        )
        val bar1 = Place(
            43.233298,
            76.935089,
            "Friends bar & terrace",
            "Seifullin 617"
        )
        val bar2 = Place(
            43.253653,
            76.954647,
            "William Lawson`s 13 The Bar",
            "Bogenbai batyr 102"
        )
        val bar3 = Place(
            43.24495,
            76.956976,
            "BarFly",
            "Dostyk 52",
        )
        val bar4 = Place(
            43.252175,
            76.940158,
            "BARSTOL & KOK",
            "Jeltoksan 126"
        )
        val bar5 = Place(
            43.225636,
            76.95443,
            "COCOS RESTOBAR",
            "Kazhymukana 49"
        )
        val bar6 = Place(
            43.248353,
            76.942383,
            "Fahrenheit Bar & Grill",
            "Abylaikhana 96"
        )
        val bar7 = Place(
            43.271766,
            76.984529,
            "MansArda",
            "Shokai 37"
        )
        val list: MutableList<Place> = ArrayList()
        list.add(bar)
        list.add(bar1)
        list.add(bar2)
        list.add(bar4)
        list.add(bar5)
        list.add(bar6)
        list.add(bar7)
        list.add(bar3)
        return list
    }
}