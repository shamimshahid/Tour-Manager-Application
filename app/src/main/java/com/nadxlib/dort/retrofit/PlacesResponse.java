package com.nadxlib.dort.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class PlacesResponse {

    public class Root implements Serializable {

        @SerializedName("results")
        public ArrayList<Result> results = new ArrayList<>();

        @SerializedName("status")
        public String status;
    }

    public class Result implements Serializable {

        @SerializedName("geometry")
        public Geometry geometry;

        @SerializedName("vicinity")
        public String vicinity;

        @SerializedName("name")
        public String name;

        @SerializedName("photos")
        public ArrayList<Photos> photos = new ArrayList<>();

        @SerializedName("place_id")
        public String place_id;

    }

    public class Photos implements Serializable{

        @SerializedName("photo_reference")
        public String photo_reference;

    }

    public class Geometry implements Serializable{

        @SerializedName("location")
        public Location location;

    }

    public class Location implements Serializable {

        @SerializedName("lat")
        public double lat;
        @SerializedName("lng")
        public double lng;


    }
}
