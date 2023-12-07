package com.ruby.proprammingWithPurpose.week1;

/**
 * Type conversion. Several different formats are used to represent color. For example, the primary format for LCD displays, digital cameras, and web pages—known as the RGB format—specifies the level of red (R), green (G), and blue (B) on an integer scale from 0 to 255. The primary format for publishing books and magazines—known as the CMYK format—specifies the level of cyan (C), magenta (M), yellow (Y), and black (K) on a real scale from 0.0 to 1.0.
 * Write a program CMYKtoRGB.java that converts from CMYK format to RGB format using these mathematical formulas:
 * whiteredgreenblue=1−black=255×white×(1−cyan)=255×white×(1−magenta)=255×white×(1−yellow)
 * Your program must take four double command-line arguments cyan, magenta, yellow, and black; compute the corresponding RGB values, each rounded to the nearest integer; and print the RGB values, as in the following sample executions:
 * Test 1: check output format
 *   % java CMYKtoRGB 0.0 1.0 0.0 0.0
 *   red = 255
 *   green = 0
 *   blue = 255
 *
 *   % java CMYKtoRGB 0.0 0.4392156862745098 1.0 0.0
 *   red = 255
 *   green = 143
 *   blue = 0
 *
 * Test 3: check various inputs
 *   java CMYKtoRGB 0.0 1.0 0.0 0.0
 *   java CMYKtoRGB 0.0 0.4392156862745098 1.0 0.0
 *   java CMYKtoRGB 0.18 0.32 0.0 0.29
 *   java CMYKtoRGB 1.0 0.58 0.0 0.33
 *   java CMYKtoRGB 0.0 1.0 0.75 0.50
 *   java CMYKtoRGB 0.0 0.14 0.70 0.15
 *
 *   Test 4: check corner cases
 *   * java CMYKtoRGB 0.0 0.0 0.0 0.0
 *   * java CMYKtoRGB 1.0 0.0 0.0 0.0
 *   * java CMYKtoRGB 0.0 1.0 0.0 0.0
 *   * java CMYKtoRGB 0.0 0.0 1.0 0.0
 *   * java CMYKtoRGB 0.0 0.0 0.0 1.0
 *   * java CMYKtoRGB 1.0 1.0 0.0 0.0
 *   * java CMYKtoRGB 1.0 0.0 1.0 0.0
 *   * java CMYKtoRGB 1.0 0.0 0.0 1.0
 *   * java CMYKtoRGB 0.0 1.0 1.0 0.0
 *   * java CMYKtoRGB 0.0 1.0 0.0 1.0
 *   * java CMYKtoRGB 0.0 0.0 1.0 1.0
 *   * java CMYKtoRGB 1.0 1.0 1.0 0.0
 *   * java CMYKtoRGB 1.0 1.0 0.0 1.0
 *   * java CMYKtoRGB 1.0 0.0 1.0 1.0
 *   * java CMYKtoRGB 0.0 1.0 1.0 1.0
 *   * java CMYKtoRGB 1.0 1.0 1.0 1.0
 */
public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        double white = (1 - black); // if its turned into int at this level it leads to wrong value calculations later
        int red = (int) Math.round(255 * white * (1 - cyan));
        int green = (int) Math.round((255 * white * (1 - magenta)));
        int blue = (int) Math.round((255 * white * (1 - yellow)));
        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
}
