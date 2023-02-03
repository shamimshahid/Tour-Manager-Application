package com.nadxlib.dort;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class PlaceInfo  {

    String placeName;
    int placePic;
    LatLng latLng;

    public PlaceInfo(String placeName, int placePic) {
        this.placeName = placeName;
        this.placePic = placePic;
    }

    public PlaceInfo(String placeName, int placePic, LatLng latLng) {
        this.placeName = placeName;
        this.placePic = placePic;
        this.latLng = latLng;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getPlacePic() {
        return placePic;
    }

    public void setPlacePic(int placePic) {
        this.placePic = placePic;
    }
}
