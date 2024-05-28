package nikkol;
import robocode.*;
import robocode.Robot;

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
            turnGunLeft(5);
        }
    }    
    public void onScannedRobot(ScannedRobotEvent e){
        fire(0.5);
    }
}
