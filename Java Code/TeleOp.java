package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOp (Blocks to Java)")
public class TeleOp extends LinearOpMode {

  private DcMotor driveMotorRight;
  private Servo gripperServoRight;
  private DcMotor driveMotorLeft;
  private Servo gripperServoLeft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    driveMotorRight = hardwareMap.get(DcMotor.class, "driveMotorRight");
    gripperServoRight = hardwareMap.get(Servo.class, "gripperServoRight");
    driveMotorLeft = hardwareMap.get(DcMotor.class, "driveMotorLeft");
    gripperServoLeft = hardwareMap.get(Servo.class, "gripperServoLeft");

    // Reverse one of the drive motors.
    // You will have to determine which motor to reverse for your robot.
    // In this example, the right motor was reversed so that positive
    // applied power makes it move the robot in the forward direction.
    driveMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
    gripperServoRight.setDirection(Servo.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      // Main Run Code
      while (opModeIsActive()) {
        // Assign Controller 1 Joysticks to each drive motor (Tank Drive)
        // The Y axis of a joystick ranges from -1 in its topmost position
        // to +1 in its bottommost position. We negate this value so that
        // the topmost position corresponds to maximum forward power.
        driveMotorLeft.setPower(gamepad1.left_stick_y);
        driveMotorRight.setPower(gamepad1.right_stick_y);
        // Encoder reset button. If start is pressed, reset the encoder and put them back in run mode
        // This logic is useful for path based auto. Push the robot, record the values, reset encoder
        if (gamepad1.start) {
          driveMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          driveMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
          driveMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
          driveMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        // Open Gripper commands. (Tune values on a per robot basis)
        if (gamepad1.left_bumper) {
          gripperServoLeft.setPosition(0.6);
          gripperServoRight.setPosition(0.4);
        }
        // Close Gripper commands. (Tune values on a per robot basis)
        if (gamepad1.right_bumper) {
          gripperServoLeft.setPosition(0.25);
          gripperServoRight.setPosition(0.25);
        }
        // Write useful data to DriverStation
        telemetry.addData("Left Pow", driveMotorLeft.getPower());
        telemetry.addData("Right Pow", driveMotorRight.getPower());
        telemetry.addData("Left Current Pos", driveMotorLeft.getCurrentPosition());
        telemetry.addData("Right Current Pos", driveMotorRight.getCurrentPosition());
        telemetry.addData("Right Gripper Pos", gripperServoRight.getPosition());
        telemetry.addData("Left Gripper Pos", gripperServoLeft.getPosition());
        telemetry.update();
      }
    }
  }
}
