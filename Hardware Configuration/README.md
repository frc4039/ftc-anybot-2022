#  [MakeShift 4039](https://4039.ca)  - FTC Anybot 2022 Hardware Configuration

The purpose of this document is the detail the hardware configuration present on the ControlHub for use with the code provided in the repository.

There are only 4 actuation devices that need to be added to the hardware configuration. These are:

##### Drive Motors
- Drive Motor A
- Drive Motor B
##### Gripper Servos
- Gripper Servo A
- Gripper Servo B

## Drive Motor Configuration
##### Drive Motor A:
- Side: Robot Left
- Port: 0
- Motor: Tetrix Motor
- Variable Name: driveMotorLeft

##### Drive Motor B:
- Side: Robot Right
- Port: 1
- Motor: Tetrix Motor
- Variable Name: driveMotorRight

## Servo Motor Configuration
##### Gripper A:
- Side: Robot Left
- Port: 0
- Servo: Servo
- Variable Name: gripperServoLeft

##### Gripper B:
- Side: Robot Right
- Port: 1
- Servo: Servo
- Variable Name: gripperServoRight

##### Note: "Robot Left" and "Robot Right" are distinguished when by looking at the robot from the rear

