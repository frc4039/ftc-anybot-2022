#  [MakeShift 4039](https://4039.ca)  - FTC Anybot 2022 Software

# What is an Anybot?
In the spirit of the Robonaut's FRC "Everybot", MakeShift's goal was to provide
a starting point for rookie or low-resource FTC teams by building and
documenting a simple but effective Freight Frenzy robot. We've limited
ourselves to components in the kit plus &lt;$100 in purchased parts.  Only basic
hand tools are required for fabrication and assembly.  Game analysis, CAD,
basic code, and more are all publicly available.

# Additional Resources
This repository hosts the code for the Anybot. The rest of the documentation is
available on a google drive [HERE](https://drive.google.com/drive/folders/1BJFW_bpIrWweuW6tcFUbEHEwslD9NAR0?usp=sharing).


# About This Repository
This repository contains the the block-based, as well as java code for the MakeShift 4039 2022 Anybot. 

The TeleOp code provided allows the robot to drive in Tank Mode (Both joysticks on the controller) and open and close the gripper using the bumper buttons on the controller.

The Autonomous code provided will score on the low goal by closing the gripper, driving forward, and pushing the game piece into the goal.

For making further autos, an encoder value read-out and reset is built-in to the TeleOp. When running, pushing the robot will report the encoder values on the driver station. Pressing start on the controller will reset the values. This is useful for path-building autos.

The following folders are available in the repository:

- Block-Based Code: Contains the .blk files for the TeleOp and Autonomous code
- Block-Based Images: Contains images of the blocks for the TeleOp and Autonomous block-based code
- Java Code: Contains the Java files (Exported from block-based) for both TeleOp and Autonomous
- Hardware Configuration: Contains detailed information and hardware configuration