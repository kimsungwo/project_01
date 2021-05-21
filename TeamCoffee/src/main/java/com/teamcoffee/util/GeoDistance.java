package com.teamcoffee.util;

import java.text.DecimalFormat;

public class GeoDistance {
	public static double geoDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		DecimalFormat df = new DecimalFormat("#.##");
		if((latitude1 == latitude2) && (longitude1 == longitude2)) {
			return 0;
		}
		else {
			double theta = longitude1 - longitude2;
			double distance = Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) + 
					Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(theta));
			distance = Math.acos(distance);
			distance = Math.toDegrees(distance);
			distance = distance * 60 * 1.1515;
			//km단위
			distance = distance * 1609.344;
			
			//distance 0보다 클 경우
			if(0 < distance) {
				distance = Double.valueOf(df.format(distance));
				
			}
			else {
				distance = 0;
			}
			return distance;
		}
	}
}
