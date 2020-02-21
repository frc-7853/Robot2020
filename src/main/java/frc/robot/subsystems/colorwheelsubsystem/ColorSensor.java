/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.colorwheelsubsystem;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensor extends SubsystemBase {
  /**
   * Creates a new ColorSensor.
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatcher;
  private final Color kBlueTarget;
  private final Color kGreenTarget;
  private final Color kRedTarget;
  private final Color kYellowTarget;
  Color detectedColor;
  String colorString;
  ColorMatchResult match;
  public ColorSensor() {
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }
  public void colorMatch(){
    detectedColor = m_colorSensor.getColor();
    match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
  }
  public void putData(){
    /*
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    */
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
