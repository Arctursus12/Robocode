package nikkol;
import robocode.*;
import robocode.Robot;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.*;
public class NikKol extends Robot{
    int count;
    double gunTurn;
    String tracking;
    public void run(){
        setBodyColor(new Color(237, 231, 230));
		setGunColor(new Color(181, 173, 172));
		setRadarColor(new Color(150, 144, 145));
		setBulletColor(new Color(224, 40, 50));
		setScanColor(new Color(255, 0, 85));
        setAdjustGunForRobotTurn(true);
        while(true){
			turnGunRight(gunTurn);
			count++;
			if (count > 2) {
				gunTurn = -30;
			}
			if (count > 5) {
				gunTurn = 30;
			}
			if (count > 11) {
				tracking = null;
            }
        }
    }    
    public void onScannedRobot(ScannedRobotEvent e) {
		if (tracking != null && !e.getName().equals(tracking)) {
			return;
		}
		if (tracking == null) {
			tracking = e.getName();
		}
		count = 0;
		if (e.getDistance() > 150) {
			gunTurn = normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
			turnGunRight(gunTurn); 
			return;
		}
		gunTurn = normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
		turnGunRight(gunTurn);
		fire(3);
		scan();
	}
}
