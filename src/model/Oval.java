package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {

    public Oval(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
        instrument = 27;
        PLAYING_COLOR = new Color(35, 210, 100);
    }

    public Oval(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    // EFFECTS: return true if this Oval contains the given point p, else return false
    //[NOTE TO STUDENTS: don't spend ANY time worrying about
    // why this implementation looks the way it does.  The mathematical
    // details of how we determine if an oval contains a point are
    // not important in the context of this course!]
    @Override
    public boolean contains(Point p) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, p.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, p.y);
        }
        return  diff <= 1.0 + TOL;
    }

    // Compute square of difference
    // EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }

    @Override
    protected void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    protected void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);
    }
}
