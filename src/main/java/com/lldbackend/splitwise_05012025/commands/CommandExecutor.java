package com.lldbackend.splitwise_05012025.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();
    public void addCommand(Command command) {
        commands.add(command);
    }
    public void removeCommand(Command command) {
        commands.remove(command);
    }
    public void executeCommand(String inputCommand) {
        for (Command command : commands) {
            if (command.validate(inputCommand)) {
                command.execute(inputCommand);
                break;
            }
        }
    }
}
