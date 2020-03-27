package ch.epfl.sdp.map;

public interface LocationProvider {

    public boolean isInit();
    public double getLatitude();
    public double getLongitude();
    public void updateLocation();



}
