package com.nadxlib.dort;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nadxlib.dort.retrofit.ApiClient;
import com.nadxlib.dort.retrofit.ApiInterface;
import com.nadxlib.dort.retrofit.PlacesResponse;
import com.nadxlib.dort.utils.GpsUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceMapActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener{

    private static final String TAG = MapsActivity.class.getSimpleName();

    private GoogleMap mMap;

    // A default location (Sydney, Australia) and default zoom to use when location permission is
    // not granted.
    private static final int DEFAULT_ZOOM = 7;
    private static final int PERMISSIONS_REQUEST_CODE = 1;
    private boolean locationPermissionGranted;

    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location lastKnownLocation;

    // Keys for storing activity state.
    // [START maps_current_place_state_keys]
    private static final String KEY_LOCATION = "location";
    // [END maps_current_place_state_keys]

    // Permissions those are required for Current Location
    // [START permission_array]
    private String[] requiredPermissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    // [END permission_array]

    private GpsUtils gpsUtils;
    private boolean isGPS = false;

    private ApiInterface apiInterface;

    private AppCompatButton btnHotel, btnRestaurant, btnBank, btnATM;

    double latitudePlace,longitudePlace;
    LatLng latLngPlace;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        locationPermissionGranted = false;

        // [START maps_current_place_on_create_save_instance_state]
        // Retrieve location and camera position from saved instance state.
        if (savedInstanceState != null) {
            lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
        }
        // [END maps_current_place_on_create_save_instance_state]

        // Build the map.
        // [START maps_current_place_map_fragment]
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) mapFragment.getMapAsync(this);
        // [END maps_current_place_on_create]

        gpsUtils = new GpsUtils(this);

        latitudePlace = getIntent().getDoubleExtra("lat",0);
        longitudePlace = getIntent().getDoubleExtra("long",0);
        name = getIntent().getStringExtra("name");

        latLngPlace = new LatLng(latitudePlace,longitudePlace);
        Log.d("kak","asda"+latLngPlace.latitude);

       // latLngs.add(latLngPlace);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnHotel = findViewById(R.id.btnHotel);
        btnRestaurant = findViewById(R.id.btnRestaurant);
        btnBank = findViewById(R.id.btnBank);
        btnATM = findViewById(R.id.btnATM);

        btnHotel.setVisibility(View.GONE);
        btnATM.setVisibility(View.GONE);
        btnBank.setVisibility(View.GONE);
        btnRestaurant.setVisibility(View.GONE);

        btnHotel.setOnClickListener(this);
        btnRestaurant.setOnClickListener(this);
        btnBank.setOnClickListener(this);
        btnATM.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gpsUtils.turnGPSOn(isGPSEnable -> {
            isGPS = isGPSEnable;
            Log.e(TAG, "Is GPS enabled : " + isGPS);
        });
        gpsUtils.getLocationUpdate(locationUpdateListener, false);

        locationPermissionGranted = checkAndRequestPermissions();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gpsUtils.stop();
    }

    /**
     * Saves the state of the map when the activity is paused.
     */
    // [START maps_current_place_on_save_instance_state]
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (mMap != null) {
            outState.putParcelable(KEY_LOCATION, lastKnownLocation);
        }
        super.onSaveInstanceState(outState);
    }
    // [END maps_current_place_on_save_instance_state]


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // If we found last location
        moveToLastLocation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GpsUtils.GPS_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                isGPS = true; // flag maintain before get location
                Log.e(TAG, "Is GPS enabled by user");
            } else {
                finish();
            }
        }
        Log.e(TAG, "Request code " + requestCode + ", " + resultCode);
    }

    @Override
    public void onClick(View view) {
        if (view == btnHotel) searchNearbyPlaces("hotel");
        else if (view == btnRestaurant) searchNearbyPlaces("restaurant");
        else if (view == btnBank) searchNearbyPlaces("bank");
        else if (view == btnATM) searchNearbyPlaces("atm");

        disableEnableControls(findViewById(R.id.containerBtn), view.getId());
    }

    /**
     * Check and request user for required permissions
     */
    // [START check_and_request_runtime_permissions]
    private boolean checkAndRequestPermissions() {

        // Check which permissions are needed
        ArrayList<String> listPermissionNeeded = new ArrayList<>();
        for (String perm : requiredPermissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    perm
            ) != PackageManager.PERMISSION_GRANTED
            ) listPermissionNeeded.add(perm);
        }

        // Asks for non-granted permissions
        if (!listPermissionNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),
                    PERMISSIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * Handles the result of the request for location permissions.
     */
    // [START maps_current_place_on_request_permissions_result]
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        locationPermissionGranted = false;
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationPermissionGranted = true;
            }

            HashMap<String, Integer> permissionResult = new HashMap<>();
            int deniedCount = 0;

            // Gather permission grant results
            for (int i = 0; i < grantResults.length; i++) {

                // Add only permissions which are denied
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    permissionResult.put(permissions[i], grantResults[i]);
                    deniedCount++;
                }
            }

            // Check if all permissions are granted
            if (deniedCount > 0) {
                for (Map.Entry<String, Integer> entry : permissionResult.entrySet()) {

                    String permName = entry.getKey();

                    // Permission is denied
                    ActivityCompat.shouldShowRequestPermissionRationale(this, permName);
                }
            }
        }
    }
    // [END maps_current_place_on_request_permissions_result]

    /**
     * Updates the map's UI settings based on whether the user has granted location permission.
     */
    // [START maps_current_place_update_location_ui]
    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (locationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                lastKnownLocation = null;
            }
        } catch (SecurityException e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }
    // [END maps_current_place_update_location_ui]

    // Move camera to last known location
    // [START move_camera_to_last_known_location]
    private void moveToLastLocation() {
        if (lastKnownLocation != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(lastKnownLocation.getLatitude(),
                            lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
            //searchNearbyPlaces("restaurant");
            mMap.addMarker(new MarkerOptions()
                    .position(latLngPlace)
                    .title(name));
        }
        updateLocationUI();
    }
    // [END move_camera_to_last_known_location]

    /**
     * Callback implementation if location result found
     */
    // [START location_callback_update]
    private GpsUtils.LocationUpdateListener locationUpdateListener = new GpsUtils.LocationUpdateListener() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult == null) {
                return;
            }

            for (Location location : locationResult.getLocations()) {
                if (location != null) {
                    lastKnownLocation = location;
                    moveToLastLocation();
                    Log.d(TAG, "Updated location  -> " + location.getLatitude() + ", " + location.getLongitude());
                } else Log.d(TAG, "Updated location is NULL.");
            }
        }
    };
    // [END location_callback_update]

    /**
     * Search Nearby Places
     */
    private void searchNearbyPlaces(String palceType) {
        if (lastKnownLocation == null) return;

        apiInterface.searchNearby(lastKnownLocation.getLatitude() + "," + lastKnownLocation.getLongitude(), 500, placeType, ApiClient.GOOGLE_PLACE_API_KEY).enqueue(
                new Callback<PlacesResponse.Root>() {
                    @Override
                    public void onResponse(Call<PlacesResponse.Root> call, Response<PlacesResponse.Root> response) {
                        PlacesResponse.Root root = response.body();
                        if (response.isSuccessful() && root != null) {
                            switch (root.status) {
                                case "OK": {
                                    if (!root.results.isEmpty())
                                        mMap.clear();
                                    for (PlacesResponse.Result res : root.results) {
                                        mMap.addMarker(new MarkerOptions().position(new LatLng(res.geometry.location.lat, res.geometry.location.lng)).title(res.name));
                                    }
                                }
                                break;

                                case "ZERO_RESULTS":
                                    Toast.makeText(getApplicationContext(), "No matches found near you", Toast.LENGTH_SHORT).show();
                                    break;

                                case "OVER_QUERY_LIMIT":
                                    Toast.makeText(getApplicationContext(), "You have reached the Daily Quota of Requests", Toast.LENGTH_SHORT).show();
                                    break;

                                default:
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PlacesResponse.Root> call, Throwable t) {

                    }
                }
        );
    }

    /**
     * Method to select/deselect views
     * */
    private void disableEnableControls(ViewGroup vg, int id) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View child = vg.getChildAt(i);
            if (child.getId() == id) child.setSelected(true);
            else child.setSelected(false);
            if (child instanceof ViewGroup) {
                disableEnableControls((ViewGroup) child, id);
            }
        }
    }


}