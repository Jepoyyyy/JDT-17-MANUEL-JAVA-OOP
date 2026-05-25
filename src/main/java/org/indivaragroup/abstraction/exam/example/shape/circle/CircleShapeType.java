package org.indivaragroup.abstraction.exam.example.shape.circle;

import org.indivaragroup.abstraction.exam.example.shape.ShapeType;

public class CircleShapeType extends ShapeType {

    int circleRadius;

    @Override
    public int getTotalShapeTypeSize() {
        return Math.abs(10) * circleRadius;
    }
}