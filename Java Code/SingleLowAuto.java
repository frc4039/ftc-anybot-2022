package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "SingleLowGoalAuto (Blocks to Java)", preselectTeleOp = "TeleOp")
public class SingleLowGoalAuto extends LinearOpMode {

  private DcMotor driveMotorRight;
  private Servo gripperServoRight;
  private DcMotor driveMotorLeft;
  private Servo gripperServoLeft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    String Output;

    driveMotorRight = hardwareMap.get(DcMotor.class, "driveMotorRight");
    gripperServoRight = hardwareMap.get(Servo.class, "gripperServoRight");
    driveMotorLeft = hardwareMap.get(DcMotor.class, "driveMotorLeft");
    gripperServoLeft = hardwareMap.get(Servo.class, "gripperServoLeft");

    // Reverse 1 drive motor and 1 servo
    driveMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
    gripperServoRight.setDirection(Servo.Direction.REVERSE);
    // Reset encoder values
    driveMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    waitForStart();
    if (opModeIsActive()) {
      // Close the gripper for pushing
      gripperServoLeft.setPosition(0.6);
      gripperServoRight.setPosition(0.4);
      // Set auto speed (bigger number for faster)
      driveMotorLeft.setPower(0.4);
      driveMotorRight.setPower(0.4);
      // Set first position to drive to. (Drive straight forward to low goal)
      driveMotorLeft.setTargetPosition(-1900);
      driveMotorRight.setTargetPosition(-1900);
      // Debugging and call Move function
      Output = "Going Forward";
      Move();
      // Telemetry
      while (opModeIsActive()) {
        telemetry.addData("Right Pow - Auto", driveMotorRight.getPower());
        telemetry.addData("Right Current Pos", driveMotorRight.getCurrentPosition());
        telemetry.addData("Right TargetPos", driveMotorRight.getTargetPosition());
        telemetry.addData("Left Pow - Auto", driveMotorRight.getPower());
        telemetry.addData("Left Current Pos", driveMotorLeft.getCurrentPosition());
        telemetry.addData("Left Target Pos", driveMotorLeft.getTargetPosition());
        telemetry.addData("Debug", Output);
        telemetry.update();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Move() {
    // Re-usable move function. Useful for adding more moves to the auto
    // Tell the motors to move the the position
    driveMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    // Tolerance to the final position to remove jittering
    ((DcMotorEx) driveMotorLeft).setTargetPositionTolerance(50);
    ((DcMotorEx) driveMotorLeft).setTargetPositionTolerance(50);
  }
}
