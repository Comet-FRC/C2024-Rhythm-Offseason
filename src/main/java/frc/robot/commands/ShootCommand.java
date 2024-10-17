package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
    ShooterSubsystem shooter;

    public ShootCommand(ShooterSubsystem shooter) {
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
        shooter.shoot();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
