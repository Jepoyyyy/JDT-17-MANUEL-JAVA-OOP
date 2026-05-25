package org.indivaragroup.abstraction.exam.example.shape;

public abstract class ShapeType {
    String shapeType;

    public abstract int getTotalShapeTypeSize();

    void printInfo() {
        System.out.println("Size shape for type ----()" + shapeType);
    }
}