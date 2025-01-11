package com.lldbackend.splitwise_05012025.commands;

public interface Command {
    boolean validate(String inputCommand);
    void execute(String inputCommand);

}
