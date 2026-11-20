package com.mastery.corejava.oop;

public class OopConceptsDemo {

    public sealed interface Shape permits Circle, Rectangle {
        double area();
    }

    public record Circle(double radius) implements Shape {
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public record Rectangle(double width, double height) implements Shape {
        @Override
        public double area() {
            return width * height;
        }
    }

    public static String describe(Shape shape) {
        return switch (shape) {
            case Circle c -> "Circle r=" + c.radius();
            case Rectangle r -> "Rectangle " + r.width() + "x" + r.height();
        };
    }
}
