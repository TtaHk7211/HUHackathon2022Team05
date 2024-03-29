package events.huhackathon2022;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import events.huhackathon2022.databinding.ActivityWithMapsBinding;

public class WithMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityWithMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWithMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        double latitude  = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);
        double userLatitude  = intent.getDoubleExtra("user_latitude", 0);
        double userLongitude = intent.getDoubleExtra("user_longitude", 0);

        // Add a marker in Sydney and move the camera
        LatLng deliverPoint = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(deliverPoint).title("Marker in Deliver Point"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(deliverPoint));

        LatLng home = new LatLng(userLatitude, userLongitude);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker in Home"));
    }
}