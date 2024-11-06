package com.example.order.command;

import java.util.ArrayList;
import java.util.List;

public class OrderInvoker {
    private List<OrderCommand> commandHistory = new ArrayList<>();

    public void executeCommand(OrderCommand command) {
        command.execute();
        commandHistory.add(command);
    }
}
