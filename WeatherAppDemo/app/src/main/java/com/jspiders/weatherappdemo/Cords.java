package com.jspiders.weatherappdemo;

/**
 * Created by mhs on 4/17/2016.
 */
public class Cords {
    /**
     * lon : 77.6
     * lat : 12.98
     */

    private CoordBean coord;

    public CoordBean getCoord() {
        return coord;
    }

    public void setCoord(CoordBean coord) {
        this.coord = coord;
    }

    public static class CoordBean {
        private double lon;
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }
}
