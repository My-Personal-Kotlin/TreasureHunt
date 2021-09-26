package com.treasurehunt

import android.content.Context
import com.google.android.gms.location.GeofenceStatusCodes
import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.TimeUnit

/**
 * Returns the error string for a geofencing error code.
 */
fun errorMessage(context: Context, errorCode: Int): String {
    val resources = context.resources
    return when (errorCode) {
        GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> resources.getString(
            R.string.geofence_not_available
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> resources.getString(
            R.string.geofence_too_many_geofences
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> resources.getString(
            R.string.geofence_too_many_pending_intents
        )
        else -> resources.getString(R.string.unknown_geofence_error)
    }
}

/**
 * Stores latitude and longitude information along with a hint to help user find the location.
 */
data class LandmarkDataObject(val id: String, val hint: Int, val name: Int, val latLong: LatLng)

internal object GeofencingConstants {

    const val GEOFENCE_RADIUS_IN_METERS = 100f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"

    /**
     * Used to set an expiration time for a geofence. After this amount of time, Location services
     * stops tracking the geofence. For this sample, geofences expire after one hour.
     */
    val GEOFENCE_EXPIRATION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)

    val LANDMARK_DATA = arrayOf(
        LandmarkDataObject(
            "My_Home_Street",
            R.string.golden_gate_bridge_hint,
            R.string.golden_gate_bridge_location,
            LatLng(32.581630, 73.472745)),

        LandmarkDataObject(
            "My_Home_Main_Street",
            R.string.ferry_building_hint,
            R.string.ferry_building_location,
            LatLng(32.583685, 73.472722)),

        LandmarkDataObject(
            "Babu_Mobile_shop",
            R.string.pier_39_hint,
            R.string.pier_39_location,
            LatLng(32.585058, 73.475185)),

        LandmarkDataObject(
            "Masjid_Gulzar_e_Madina",
            R.string.union_square_hint,
            R.string.union_square_location,
            LatLng(32.585586, 73.478371))
    )
    val NUM_LANDMARKS = LANDMARK_DATA.size
}
