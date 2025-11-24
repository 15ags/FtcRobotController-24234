package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="auto", group="auto")
public class auto extends LinearOpMode {

    /* Declare OpMode members. */

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx LBMotor = null;
    private DcMotorEx RBMotor = null;
    private DcMotorEx LFMotor = null;
    private DcMotorEx RFMotor = null;

    // The motors for the ball throwing bloody thing
    // TODO: Read documentation to change to ideal motor for speed
    private DcMotorEx intake = null;


    // You are not allowed to judge I am sleep deprived
    private DcMotorEx Launch = null;
    private DcMotorEx middle = null;

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        LBMotor  = hardwareMap.get(DcMotorEx.class, "LBMotor");
        RBMotor  = hardwareMap.get(DcMotorEx.class, "RBMotor");
        LFMotor  = hardwareMap.get(DcMotorEx.class, "LFMotor");
        RFMotor  = hardwareMap.get(DcMotorEx.class, "RFMotor");

        // Initializing the Motors to the correct entry
        intake = hardwareMap.get(DcMotorEx.class,"intake");
        Launch = hardwareMap.get(DcMotorEx.class, "Launch");
        middle = hardwareMap.get(DcMotorEx.class, "middle");





        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        LBMotor.setDirection(DcMotorEx.Direction.FORWARD);
        RBMotor.setDirection(DcMotorEx.Direction.REVERSE);
        LFMotor.setDirection(DcMotorEx.Direction.REVERSE);
        RFMotor.setDirection(DcMotorEx.Direction.FORWARD);

        // Directions for the throwing motors
        middle.setDirection(DcMotorEx.Direction.FORWARD);
        Launch.setDirection(DcMotorEx.Direction.FORWARD);
        intake.setDirection(DcMotorEx.Direction.FORWARD);


        middle.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Launch.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        middle.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        Launch.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        middle.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        Launch.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        intake.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        intake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        intake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        LBMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        LFMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        RBMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        RFMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        LBMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        LFMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        // FIRST MOVE - 1000 ticks
        Launch.setPower(-1);

        // WAIT FOR 3 SECONDS WHILE PELVIS/LAUNCH ACCELERATE
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 3.0) {
            // Just wait for 3 seconds
        }

        // START PICKUP MOTOR AT 2500 VELOCITY
        middle.setPower(-1);

        // WAIT FOR 1 SECOND WHILE PICKUP ACCELERATES
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 1.5) {
            // Just wait for 1 second
        }

        intake.setPower(1);

        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 2.5) {
            // Just wait for 1 second

        }


        // STOP ALL MOTORS
        Launch.setVelocity(0);
        middle.setVelocity(0);
        intake.setVelocity(0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }
}


