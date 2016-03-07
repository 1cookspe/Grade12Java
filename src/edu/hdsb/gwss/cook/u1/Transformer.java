/*
 * Created by: Spencer Cook
 Class: ICS4U
 Date: Friday, March 4, 2016
 */
package edu.hdsb.gwss.cook.u1;

import becker.xtras.imageTransformation.ITransformations;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;

public class Transformer extends Object implements ITransformations {

    public static final int MIN_NUM_TRANS = 11;
    public static final String DARKEN = "Darken";
    public static final String BRIGHTEN = "Brighten";
    public static final String INVERT = "Invert";
    public static final String FLIPX = "Flip X";
    public static final String FLIPY = "Flip Y";
    public static final String ROTATE = "Rotate";
    public static final String SCALE50 = "Scale 50%";
    public static final String MIRROR = "Mirror";
    public static final String BLUR = "Blur";
    public static final String UNDO = "Undo";
    public static final String RESET = "Reset";

    private String[] transformations = new String[MIN_NUM_TRANS];

    private int[][] pictureOriginal;
    private int[][] picture;

    ArrayList<int[][]> actions = new ArrayList<int[][]>();
    int numberOfActions = 0;
    int undos = 0;

    /**
     * Construct a Transformer object by setting the possible transformations
     * available.
     */
    public Transformer() {
        super();
        this.transformations[0] = DARKEN;
        this.transformations[1] = BRIGHTEN;
        this.transformations[2] = INVERT;
        this.transformations[3] = FLIPX;
        this.transformations[4] = FLIPY;
        this.transformations[5] = ROTATE;
        this.transformations[6] = SCALE50;
        this.transformations[7] = MIRROR;
        this.transformations[8] = BLUR;
        this.transformations[9] = UNDO;
        this.transformations[10] = RESET;
    }

    /**
     * Construct a Transformer object by setting the possible transformations
     * available and initializing the state of the image.
     *
     * @param originalPic A 2-D array representing a grey scale image. The array
     * contains values from 0 - 255.
     */
    public Transformer(int[][] originalPic) {
        this();
        this.setPixels(originalPic);
    }

    /**
     * Get the image that was transformed.
     *
     * @return The pixels representing the image.
     */
    public int[][] getPixels() {
        return this.picture;
    }

    /**
     * Set the image to be transformed to a new set of pixels.
     *
     * @param newPix The new image to be used for subsequent transformations.
     */
    public void setPixels(int[][] newPix) {
        this.pictureOriginal = newPix;
        this.picture = this.copyArray(newPix);
    }

    /**
     * A array filled with the names of the transformations implemented by this
     * class.
     *
     * @return The array of transformation names.
     */
    public String[] getTransformationNames() {
        return transformations;
    }

    public static void display(int[][] twoDArray) {
        for (int row = 0; row < twoDArray.length; row++) {
            for (int col = 0; col < twoDArray[row].length; col++) {
                if (twoDArray[row][col] == 0) {
                    System.out.print(" .");
                } else {
                    System.out.print(" O");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Perform the transformation indicated.
     *
     * @param transformationName The name of the transformation to perform. Must
     * be one of the transformation names returned by {@link #getTransformationNames
     * getTransformationNames}.
     */
    public void performTransformation(String transformationName) {

        if (DARKEN.equals(transformationName)) {
            this.picture = changeIntensity(-2, this.picture);
        } else if (BRIGHTEN.equals(transformationName)) {
            this.picture = changeIntensity(2, this.picture);
        } else if (INVERT.equals(transformationName)) {
            this.picture = invert(this.picture);
        } else if (FLIPX.equals(transformationName)) {
            this.picture = flipX(this.picture);
        } else if (FLIPY.equals(transformationName)) {
            this.picture = flipY(this.picture);
        } else if (ROTATE.equals(transformationName)) {
            this.picture = rotate(this.picture);
        } else if (MIRROR.equals(transformationName)) {
            this.picture = mirror(this.picture);
        } else if (SCALE50.equals(transformationName)) {
            this.picture = scale50(this.picture);
        } else if (BLUR.equals(transformationName)) {
            this.picture = blur(this.picture);
        } else if (RESET.equals(transformationName)) {
            this.picture = this.copyArray(this.pictureOriginal);
        } else if (UNDO.equals(transformationName)) {
            this.picture = this.undo();
        } else {
            throw new Error("Invalid transformation requested.");
        }
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] copyArray(int[][] a) {
        // Create another copy of array
        int[][] copy = new int[a.length][a[0].length];
        for (int r = 0; r < copy.length; r++) {
            for (int c = 0; c < copy[r].length; c++) {
                copy[r][c] = a[r][c];
            }
        }

        return copy;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] undo() {
        // Count how many undo's the user has done and create new array to hold the pixels of the "undone" action
        
        int[][] array = {};

        // Check if there are actions left in the array
        if (!actions.isEmpty() && actions.size() != 1 && numberOfActions - undos > 0) {
            //numberOfActions -= undos;
            array = actions.get(numberOfActions - undos - 1);
            if (numberOfActions - undos >= 0 && numberOfActions > 0) {
                for (int i = numberOfActions - 1; i > numberOfActions - undos; i--) {
                    System.out.println(i);
                    actions.remove(actions.get(i - 1));
                }
            }

        } else {
            // Just return orignal photo if all actions have been undone or do not exist
            return copyArray(pictureOriginal);
        }
        
        undos++;

        return array;

    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] changeIntensity(double percent, int[][] sourcePixels) {
        // TO DO  
        boolean dark = false;

        // Loop through each pixel
        for (int r = 0; r < sourcePixels.length; r++) {
            for (int c = 0; c < sourcePixels[r].length; c++) {
                if (percent == 2) { // Darken
                    // Add 10 to each pixel to darken
                    if (sourcePixels[r][c] + 10 < 256) {
                        sourcePixels[r][c] += 10;
                        dark = true;
                    }
                } else { // Lighten
                    if (sourcePixels[r][c] - 10 > -1) {
                        // Subtract 10 from each pixel to lighten
                        sourcePixels[r][c] -= 10;
                        dark = false;
                    }
                }
            }
        }

        // Add a copy of sourcePixels to actions array
        actions.add(copyArray(sourcePixels));
        numberOfActions++;

        return sourcePixels;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] invert(int[][] sourcePixels) {

        // Loop through each pixel
        for (int r = 0; r < sourcePixels.length; r++) {
            for (int c = 0; c < sourcePixels[r].length; c++) {
                // Set pixel value to opposite (by the other spectrum within 255)
                sourcePixels[r][c] = 255 - sourcePixels[r][c];
            }
        }

        // Add copy of sourcePixels to actions array
        actions.add(copyArray(sourcePixels));
        numberOfActions++;

        return sourcePixels;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] flipX(int[][] sourcePixels) {

        // Loop through array
        for (int r = 0; r < sourcePixels.length; r++) {
            for (int c = 0; c < sourcePixels[r].length / 2; c++) {
                // Swap values on the far column with the current column
                int temp = sourcePixels[r][sourcePixels[r].length - c - 1];
                sourcePixels[r][sourcePixels[r].length - c - 1] = sourcePixels[r][c];
                sourcePixels[r][c] = temp;

            }
        }

        // Add copy of sourcePixels to actions array
        actions.add(copyArray(sourcePixels));
        numberOfActions++;

        return sourcePixels;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] flipY(int[][] sourcePixels) {

        // Loop through array
        for (int r = 0; r < sourcePixels.length / 2; r++) {
            for (int c = 0; c < sourcePixels[r].length; c++) {
                // Swap value in opposite row with current row and column
                int temp = sourcePixels[sourcePixels.length - r - 1][c];
                sourcePixels[sourcePixels.length - r - 1][c] = sourcePixels[r][c];
                sourcePixels[r][c] = temp;
            }
        }

        // Add copy of sourcePixels to array of actions 
        actions.add(copyArray(sourcePixels));
        numberOfActions++;

        return sourcePixels;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] rotate(int[][] sourcePixels) {
        // Loop through each pixel
        // Create new array to hold the rotated image, its size opposite of sourcePixels
        int[][] transformedPixels = new int[sourcePixels[0].length][sourcePixels.length];
        for (int r = 0; r < transformedPixels.length; r++) {
            for (int c = 0; c < transformedPixels[r].length; c++) {
                // Set value of transformedPixels to that of the opposite orientation of sourcePixels
                transformedPixels[r][c] = sourcePixels[c][r];

            }
        }

        actions.add(copyArray(transformedPixels));
        numberOfActions++;

        // Flip transformedPixels in the y orientation in order to properly obtain a 90 degrees rotated image
        return flipY(transformedPixels);

    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] mirror(int[][] sourcePixels) {
        // Create new array, doubleArray, that is double the width of sourcePixels, in order to hold the doubled mirror image
        int[][] doubleArray = new int[sourcePixels.length][sourcePixels[0].length * 2];

        // Loop through array
        for (int r = 0; r < sourcePixels.length; r++) {
            for (int c = 0; c < sourcePixels[r].length; c++) {
                doubleArray[r][c] = sourcePixels[r][c];
                // Set the second half of double array to a flipped version of sourcePixels
                doubleArray[r][c + sourcePixels[0].length] = sourcePixels[r][sourcePixels[0].length - 1 - c];
            }
        }

        // Add copy of doubleArray to actions array
        actions.add(copyArray(doubleArray));
        numberOfActions++;

        return doubleArray;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] scale50(int[][] sourcePixels) {
        // Create new array, scaledArray, to hold half the values of sourcePixels, in order to scale the array by half (50%)

        int[][] scaledArray = new int[sourcePixels.length / 2][sourcePixels[0].length / 2];

        // Check that the array still exists in size
        if (scaledArray.length > 0) {
            // Loop through array
            for (int r = 0; r < scaledArray.length; r++) {
                for (int c = 0; c < scaledArray[r].length; c++) {
                    // Set the value of each pixel of scaled array to that of the values at double the index in sourcePixels
                    scaledArray[r][c] = sourcePixels[r * 2][c * 2];
                }
            }

            // add copy of scaledArray to the actions array
            actions.add(copyArray(scaledArray));
            numberOfActions++;
            return scaledArray;
        }

        return sourcePixels;
    }

    /**
     * TODO: ICS4U - TODO
     */
    private int[][] blur(int[][] sourcePixels) {
        int[][] blurredPixels = {};
        boolean normal;
        int[][] flippedPixels = new int[sourcePixels[0].length][sourcePixels.length];

        if (sourcePixels.length < sourcePixels[0].length) {
            blurredPixels = new int[sourcePixels.length][sourcePixels[0].length];
            System.out.println("normal");
            normal = true;

//
        } else {
            System.out.println("rotated");
            blurredPixels = new int[sourcePixels[0].length][sourcePixels.length];
            normal = false;

            for (int r = 0; r < sourcePixels[0].length; r++) {
                for (int c = 0; c < sourcePixels.length; c++) {
                    flippedPixels[r][c] = sourcePixels[c][r];
                }
            }

        }

        System.out.println("rows = " + sourcePixels.length);
        System.out.println("cols = " + sourcePixels[0].length);
        System.out.println("rows = " + blurredPixels.length);
        System.out.println("cols = " + blurredPixels[0].length);

        int average = 0;

        // Calculate average of pixels surrounding each pixel, and then set the value of that pixel to the average (for inside of the outer rows and columns)
        for (int r = 1; r < blurredPixels.length - 1; r++) {
            for (int c = 1; c < blurredPixels[r].length - 1; c++) {
                if (normal) {
                    average = (sourcePixels[r - 1][c - 1] + sourcePixels[r - 1][c] + sourcePixels[r - 1][c + 1] + sourcePixels[r][c - 1] + sourcePixels[r][c] + sourcePixels[r][c + 1] + sourcePixels[r + 1][c - 1] + sourcePixels[r + 1][c] + sourcePixels[r + 1][c + 1]) / 9;
                } else {
                    average = (flippedPixels[r - 1][c - 1] + flippedPixels[r - 1][c] + flippedPixels[r - 1][c + 1] + flippedPixels[r][c - 1] + flippedPixels[r][c] + flippedPixels[r][c + 1] + flippedPixels[r + 1][c - 1] + flippedPixels[r + 1][c] + flippedPixels[r + 1][c + 1]) / 9;
                }
                blurredPixels[r][c] = average;
            }
        }

//         ADD CASES FOR END ROWS
//         - For far left and far right row
//         - Work from top to bottom
        int rowCount = 0;
        int colCount = 0;

        // Set row and column values for both a normal and rotated image, which vary due to their orientation
        if (normal) { // Normal orientation
            colCount = sourcePixels[0].length;
            rowCount = sourcePixels.length;
        } else { // Rotated orientation
            System.out.println("Different");
            colCount = sourcePixels.length;
            rowCount = sourcePixels[0].length;
        }
        
        // Add special cases for first and last column
        for (int c = 0; c < colCount; c = c + colCount - 1) {
            System.out.println(c);
            for (int r = 0; r < rowCount; r++) {
                System.out.println(r);
                // Check if pixel is in the first column
                if (c == 0 && r > 0 && r < rowCount - 1) {
                    // Use two different if statements for a normal oriented image and rotated image
                    if (normal) {
                        average = (sourcePixels[r - 1][0] + sourcePixels[r - 1][1] + sourcePixels[r][1] + sourcePixels[r][0] + sourcePixels[r + 1][1] + sourcePixels[r + 1][0]) / 6;
                    } else {
                        average = (flippedPixels[0][r - 1] + flippedPixels[1][r - 1] + flippedPixels[1][r] + flippedPixels[0][r] + flippedPixels[1][r + 1] + flippedPixels[0][r + 1]) / 6;
                    }
                    blurredPixels[r][0] = average;
                    
                    // Check if the pixel is in the last column
                } else if (c == colCount - 1 && r > 0 && r < rowCount - 1) {
                    if (normal) {
                        average = (sourcePixels[r - 1][sourcePixels[0].length - 1] + sourcePixels[r - 1][sourcePixels[0].length - 2] + sourcePixels[r][sourcePixels[0].length - 2] + sourcePixels[r][sourcePixels[0].length - 1] + sourcePixels[r + 1][sourcePixels[0].length - 2] + sourcePixels[r + 1][sourcePixels[0].length - 1]) / 6;
                    } else {
                        average = (flippedPixels[r - 1][colCount - 1] + flippedPixels[r - 1][colCount - 2] + flippedPixels[r][colCount - 2] + flippedPixels[r][colCount - 1] + flippedPixels[r + 1][colCount - 2] + flippedPixels[r + 1][colCount - 1]) / 6;
                        System.out.println(average);
                    }
                    blurredPixels[r][colCount - 1] = average;
                    
                    // check if pixel is in the first row and first column (top left corner)
                } else if (r == 0 && c == 0) {
                    if (normal) {
                        average = (sourcePixels[r][c] + sourcePixels[r][c + 1] + sourcePixels[r + 1][c] + sourcePixels[r + 1][c + 1]) / 4;
                    } else {
                        average = (flippedPixels[r][c] + flippedPixels[r][c + 1] + flippedPixels[r + 1][c] + flippedPixels[r + 1][c + 1]) / 4;
                    }
                    blurredPixels[r][c] = average;
                    
                    // Check if the pixel is in first row and last column (top right corner)
                } else if (r == 0 && c == colCount - 1) {
                    if (normal) {
                        average = (sourcePixels[r][c] + sourcePixels[r][c - 1] + sourcePixels[r + 1][c] + sourcePixels[r + 1][c - 1]) / 4;
                    } else {
                        average = (flippedPixels[r][c] + flippedPixels[r][c - 1] + flippedPixels[r + 1][c] + flippedPixels[r + 1][c - 1]) / 4;
                    }
                    blurredPixels[r][c] = average;
                    
                    // Check if the pixel is in the last row and first column (bottom left corner)
                } else if (r == (rowCount - 1) && c == 0) {
                    if (normal) {
                    average = (sourcePixels[r][c] + sourcePixels[r - 1][c] + sourcePixels[r - 1][c + 1] + sourcePixels[r][c + 1]) / 4;
                    } else {
                        average = (flippedPixels[r][c] + flippedPixels[r - 1][c] + flippedPixels[r - 1][c + 1] + flippedPixels[r][c + 1]) / 4;
                    }
                    blurredPixels[r][c] = average;
                    
                    // Check if pixel is in last row and last column (bottom right corner)
                } else if (r == (rowCount - 1) && c == (colCount - 1)) {
                    if (normal) {
                    average = (sourcePixels[r][c] + sourcePixels[r - 1][c] + sourcePixels[r - 1][c - 1] + sourcePixels[r][c - 1]) / 4;
                    } else {
                        average = (flippedPixels[r][c] + flippedPixels[r - 1][c] + flippedPixels[r - 1][c - 1] + flippedPixels[r][c - 1]) / 4;
                    }
                    blurredPixels[r][c] = average;
                }
            }
        }
////
////        // - From top to bottom
////        // - Work from left to right
        int increment = 0;

        if (normal) {
            rowCount = sourcePixels.length;
            colCount = sourcePixels[0].length - 1;
            increment = sourcePixels.length - 1;
        } else {
            rowCount = sourcePixels[0].length - 1;
            colCount = sourcePixels.length;
            increment = sourcePixels[0].length - 1;
        }

        // Add special cases for first and last row
        for (int r = 0; r < rowCount; r = r + increment) {
            for (int c = 0; c < colCount; c++) {
                if (c > 0 && r == 0 && c < colCount - 1) {
                    if (normal) {
                        average = (sourcePixels[0][c] + sourcePixels[0][c - 1] + sourcePixels[0][c + 1] + sourcePixels[1][c] + sourcePixels[1][c - 1] + sourcePixels[1][c + 1]) / 6;
                    } else {
                        average = (flippedPixels[0][c] + flippedPixels[0][c - 1] + flippedPixels[0][c + 1] + flippedPixels[1][c] + flippedPixels[1][c - 1] + flippedPixels[1][c + 1]) / 6;
                    }
                    blurredPixels[r][c] = average;
                } else if (r == increment && c > 0) {

                    average = (sourcePixels[sourcePixels.length - 1][c] + sourcePixels[sourcePixels.length - 1][c - 1] + sourcePixels[sourcePixels.length - 1][c + 1] + sourcePixels[sourcePixels.length - 2][c] + sourcePixels[sourcePixels.length - 2][c - 1] + sourcePixels[sourcePixels.length - 2][c + 1]) / 6;
                    blurredPixels[r][c] = average;

                    // 
                }
            }
        }
        // Add copy of blurredPixels to actions array
        actions.add(copyArray(blurredPixels));
        numberOfActions++;

        if (normal) {
            return blurredPixels;
        } else {
            return flipY(rotate(blurredPixels));
        }
    }

    /**
     * TODO: ICS4U - TODO
     */
    public static void main(String[] args) {

        int[][] myPicture = new int[4][15];

        myPicture[0][0] = 1;
        myPicture[1][1] = 1;
        myPicture[2][2] = 1;
        myPicture[3][3] = 1;
        myPicture[2][4] = 1;
        myPicture[1][5] = 1;
        myPicture[2][6] = 1;
        myPicture[3][7] = 1;
        myPicture[2][8] = 1;
        myPicture[1][9] = 1;
        myPicture[0][10] = 1;

//       Construct the test object
        Transformer test = new Transformer(myPicture);

//       Display Original Image
        System.out.println("Original\n");
        display(myPicture);

//       Test flip on X-axis
        System.out.println("\nFlipped on the X axis.\n");
        test.performTransformation(FLIPX);
        display(test.getPixels());

//       Test flip on Y-axis
        System.out.println("\nFlipped on the Y axis.\n");
        test.performTransformation(FLIPY);
        display(test.getPixels());

//       Test Rotate 90 degrees
        System.out.println("\nRotated 90 degrees.\n");
        test.performTransformation(ROTATE);
        display(test.getPixels());

//       Test Rotate Scale 50%
        System.out.println("\nScaled 50%.\n");
        test.performTransformation(SCALE50);
        display(test.getPixels());

//       Test Mirror Image
        System.out.println("\nMirror image.\n");
        test.performTransformation(MIRROR);
        display(test.getPixels());

//       Test Reset
        System.out.println("\nReset image.\n");
        test.performTransformation(RESET);
        display(test.getPixels());

    }

}
