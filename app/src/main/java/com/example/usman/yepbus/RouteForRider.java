package com.example.usman.yepbus;

import android.app.Dialog;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class RouteForRider extends Fragment {

    MapView mMapView;
    private GoogleMap mgoogleMap;
    GoogleApiClient mGoogleApiClient;
    MarkerOptions options;
    Marker marker1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_route_for_rider, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw = (android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        mMapView = (MapView) rootView.findViewById(R.id.mapFragment1);
//        mMapView.getMapAsync(this);


        Toast.makeText(getActivity(), "Perfect !!!!", Toast.LENGTH_SHORT).show();

        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mgoogleMap = mMap;

                if (mgoogleMap != null) {
                    mgoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(LatLng latLng) {
                            ImageView im=(ImageView) rootView.findViewById(R.id.addButton);
                            TextView tv=(TextView)  rootView.findViewById(R.id.textBelowButton);
                            im.setVisibility(View.GONE);
                            tv.setVisibility(View.GONE);
                        }
                    });
                    mgoogleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                        @Override
                        public void onMapLongClick(LatLng latLng) {
                            if (marker1 == null) {
                                options = new MarkerOptions()
                                        .draggable(true)
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker_white))
                                        .position(new LatLng(latLng.latitude, latLng.longitude))
                                        .snippet("i m here");
                                marker1 = mgoogleMap.addMarker(options);
                            } else {
                                removeEverything();
                                options = new MarkerOptions()
                                        .draggable(true)
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker_white))
                                        .position(new LatLng(latLng.latitude, latLng.longitude))
                                        .snippet("i m here");
                                marker1 = mgoogleMap.addMarker(options);

                            }
                        }
                    });
                    mgoogleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                        @Override
                        public void onMarkerDragStart(Marker marker) {

                        }

                        @Override
                        public void onMarkerDrag(Marker marker) {

                        }

                        @Override
                        public void onMarkerDragEnd(Marker marker) {

                        }
                    });
                }

                // For showing a move to my location button


                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mgoogleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map

                //LatLng sydney = new LatLng(31.558144, 74.329787);
//                mgoogleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
//
//                // For zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//                mgoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        return rootView;

        //current location code
//        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        mgoogleMap.setMyLocationEnabled(true);


    }

    private void removeEverything() {

        marker1.remove();
    }


//    private void initMap(View rt) {
//        com.google.android.gms.maps.MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment1);
//        mapFragment.getMapAsync(this);//now they try to load map asynchronasly in map we could get map object directly
//    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//        mgoogleMap = googleMap;
//
//        if (mgoogleMap != null) {
//
//            mgoogleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
//                @Override
//                public void onMapLongClick(LatLng latLng) {
//                    //modifications on above commented code
////                    if (markers.size() == 2) {
////                        drawLines();
////                    }
//                    if (marker1 == null) {
//                        options = new MarkerOptions()
//                                .draggable(true)
//                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker_white))
//                                .position(new LatLng(latLng.latitude, latLng.longitude))
//                                .snippet("i m here");
//                        marker1 = mgoogleMap.addMarker(options);
//                    } else {
//                        removeEverything();
//                        marker1 = mgoogleMap.addMarker(options);
//
//                    }
//
//                }
//            });
//
//
//            //handling marker after a drag on a screen
//            googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
//                @Override
//                public void onMarkerDragStart(Marker marker) {
//
//                }
//
//                @Override
//                public void onMarkerDrag(Marker marker) {
//
//                }
//
//                @Override
//                public void onMarkerDragEnd(Marker marker) {
//
//                }
//            });
//
//
//            //making custom snippet
//            //that window which comes on click
////            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
////                                                @Override
////                                                public View getInfoWindow(Marker marker) {
////                                                    return null;
////                                                }
////
////                                                @Override
////                                                public View getInfoContents(Marker marker) {
////
////                                                    View v = getLayoutInflater().inflate(R.layout.info_cusom_window, null);
////
////                                                    TextView locality = (TextView) v.findViewById(R.id.localtity);
////                                                    TextView lat = (TextView) v.findViewById(R.id.latitude);
////                                                    TextView longii = (TextView) v.findViewById(R.id.longitudee);
////                                                    TextView snippet = (TextView) v.findViewById(R.id.snipppett);
////
////                                                    LatLng ll = marker.getPosition();
////                                                    locality.setText(marker.getTitle());
////                                                    lat.setText("Latitude :" + ll.latitude);
////                                                    longii.setText("Longitude :" + ll.longitude);
////                                                    snippet.setText(marker.getSnippet());
////
////                                                    return v;
////                                                }
////                                            }
//
//
////            );
//        }

    //   }


//
//    LocationRequest mLocationRequest;//will request user location
//    public boolean googleServicesAvailable() {
//
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance().getInstance();
//        int isAvailable = apiAvailability.isGooglePlayServicesAvailable(getActivity());//it will send us three kind og code success,error,and error tha can be resovlable
//        if (isAvailable == ConnectionResult.SUCCESS) {
//            return true;
//        } else if (apiAvailability.isUserResolvableError(isAvailable)) {
//            Dialog dialog = apiAvailability.getErrorDialog(getActivity(), isAvailable, 0);
//            dialog.show();
//        } else {
//            Toast.makeText(getActivity(), "Cant connect to play Services", Toast.LENGTH_SHORT).show();
//        }
//
//        return false;
//    }
//
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        mLocationRequest = LocationRequest.create();
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        mLocationRequest.setInterval(100); // i want after every second to refresh the user location
//
//        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//
//        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        if (location == null) {
//            Toast.makeText(getActivity(), "cant get your location", Toast.LENGTH_SHORT).show();
//        } else {
//            Geocoder gc = new Geocoder(getActivity());
//            //List<Address> li = gc.getFromLocationName(, 1);//Address class has set of number which will represent our location
//
//            LatLng l1 = new LatLng(location.getLatitude(), location.getLongitude());
//            List<Address> li = null;
//
//
//            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(l1, 20);
//
//            mgoogleMap.animateCamera(update);
//
//        }
//    }


    //        mMapView = (MapView) rootView.findViewById(R.id.mapFragment1);
//        mMapView.onCreate(savedInstanceState);
//
//        mMapView.onResume(); // needed to get the map to display immediately
//
//        try {
//            MapsInitializer.initialize(getActivity().getApplicationContext());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        mMapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap mMap) {
//                googleMap = mMap;
//
//                // For showing a move to my location button
//
//                // googleMap.setMyLocationEnabled(true);
//
//                // For dropping a marker at a point on the Map
//                LatLng sydney = new LatLng(31.558144, 74.329787);
//                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
//
//                // For zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//            }
//        });
//
//        return rootView;
//    }
//
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}

//public class fragement_event_location_details extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//
//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        View rootView = parent.inflate(R.layout.activity_fragement_event_location_details,attrs, false);
//
//
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//
//
//        /**
//         * Manipulates the map once available.
//         * This callback is triggered when the map is ready to be used.
//         * This is where we can add markers or lines, add listeners or move the camera. In this case,
//         * we just add a marker near Sydney, Australia.
//         * If Google Play services is not installed on the device, the user will be prompted to install
//         * it inside the SupportMapFragment. This method will only be triggered once the user has
//         * installed Google Play services and returned to the app.
//         */
//
//        return rootView;
//    }
//
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }







