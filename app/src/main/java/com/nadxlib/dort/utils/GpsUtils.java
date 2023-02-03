package com.nadxlib.dort.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;

public class GpsUtils {

    private String TAG = "GPS";

    private Context context;
    private SettingsClient mSettingsClient;
    private LocationSettingsRequest mLocationSettingsRequest;
    private LocationManager locationManager;
    private LocationRequest locationRequest;

    // The entry point to the Fused Location Provider.
    private FusedLocationProviderClient fusedLocationProviderClient;

    // Location Update Listner
    private LocationUpdateListener locationUpdateListener;
    private boolean repeatUpdate = false;

    public static final int GPS_REQUEST = 101;

    public GpsUtils(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        mSettingsClient = LocationServices.getSettingsClient(context);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10 * 1000);
        locationRequest.setFastestInterval(5 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        mLocationSettingsRequest = builder.build();
        //**************************
        builder.setAlwaysShow(true); //this is the key ingredient
        //**************************

        // Construct a FusedLocationProviderClient.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }

    public void stop() {
        if(locationCallback != null) fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    // method for turn on GPS
    public void turnGPSOn(onGpsListener onGpsListener) {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (onGpsListener != null) {
                onGpsListener.gpsStatus(true);
            }
        } else {
            mSettingsClient
                    .checkLocationSettings(mLocationSettingsRequest)
                    .addOnSuccessListener((Activity) context, locationSettingsResponse -> {
                        if (onGpsListener != null) {
                            onGpsListener.gpsStatus(true);
                        }
                    })
                    .addOnFailureListener((Activity) context, e -> {
                        int statusCode = ((ApiException) e).getStatusCode();
                        Log.e(TAG, "Status code " + statusCode);
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult((Activity) context, GPS_REQUEST);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);
                                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    public void getLocationUpdate(LocationUpdateListener locationUpdateListener, boolean repeatUpdate) {
        this.locationUpdateListener = locationUpdateListener;
        this.repeatUpdate = repeatUpdate;
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    public interface onGpsListener {
        void gpsStatus(boolean isGPSEnable);
    }

    public interface LocationUpdateListener {
        void onLocationResult(LocationResult locationResult);
    }

    private LocationCallback locationCallback = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if(locationUpdateListener != null) locationUpdateListener.onLocationResult(locationResult);
            if(!repeatUpdate) fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    };
}
