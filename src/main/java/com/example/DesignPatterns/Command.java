// package com.example.DesignPatterns;

// // 1. Command interface
// interface Command {
//     void execute();
// }

// // 2. Receiver (người thực hiện hành động)
// class Light {
//     public void turnOn() {
//         System.out.println("💡 Đèn đã bật");
//     }

//     public void turnOff() {
//         System.out.println("💡 Đèn đã tắt");
//     }
// }

// // 3. Concrete Commands
// class TurnOnCommand implements Command {
//     private Light light;

//     public TurnOnCommand(Light light) {
//         this.light = light;
//     }

//     public void execute() {
//         light.turnOn();
//     }
// }

// class TurnOffCommand implements Command {
//     private Light light;

//     public TurnOffCommand(Light light) {
//         this.light = light;
//     }

//     public void execute() {
//         light.turnOff();
//     }
// }

// // 4. Invoker (nút bấm hoặc GUI component)
// class RemoteControl {
//     private Command command;

//     public void setCommand(Command command) {
//         this.command = command;
//     }

//     public void pressButton() {
//         command.execute();
//     }
// }

// public class Command {
//     public static void main(String[] args) {
        
//     }
// }