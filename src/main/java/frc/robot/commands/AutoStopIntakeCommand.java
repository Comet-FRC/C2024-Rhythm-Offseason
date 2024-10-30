package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer.State;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoStopIntakeCommand extends Command {
    private final IntakeSubsystem intake;
    private final FeederSubsystem feeder;

    public AutoStopIntakeCommand(IntakeSubsystem intake, FeederSubsystem feeder) {
        this.intake = intake;
        this.feeder = feeder;
    }

    @Override
    public void initialize() {
        feeder.intake();
        intake.intake();
        Robot.getInstance().getRobotContainer().setRobotState(State.INTAKING);
    }

    @Override
    public void end(boolean interrupted) {
        feeder.stop();
        intake.stop();
        Robot.getInstance().getRobotContainer().setRobotState(State.IDLE);
    }
}
