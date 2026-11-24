package com.corejava.basics;

public class JavaBasicsDemo {

    public sealed interface AccountStatus permits ActiveAccount, SuspendedAccount {}
    public record ActiveAccount(String owner, double balance) implements AccountStatus {}
    public record SuspendedAccount(String owner, String reason) implements AccountStatus {}

    public static String describeStatus(AccountStatus status) {
        if (status instanceof ActiveAccount active) {
            return "Active: " + active.owner() + " ($" + active.balance() + ")";
        } else if (status instanceof SuspendedAccount suspended) {
            return "Suspended: " + suspended.owner() + " (" + suspended.reason() + ")";
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        AccountStatus status = new ActiveAccount("Alice", 2500.00);
        System.out.println(describeStatus(status));
    }
}
