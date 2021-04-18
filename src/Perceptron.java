import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for Perceptron (Part 3) for assignment 1.
 * This class takes in data from the "image.data" file
 * to train itself to determine whether the image is
 * an "X" or an "O".
 *
 * @author alfredabra 300509598
 **/

public class Perceptron {
    private static final List<ImageObj> imageObjList = new ArrayList<>();
    private static final List<FeatureSet> features = new ArrayList<>();
    private static final List<Double> weightList = new ArrayList<>();

    /**
     * Main method for the Perceptron class.
     * Includes the load function for
     * the "image.data" training file.
     *
     * @return args args
     **/
    public static void main(String[] args) {
        new Perceptron();

        try {
            FileReader fileReader = new FileReader(args[0]);
            System.out.println("Reading data from file "+ args[0]);
            Scanner sc = new Scanner(fileReader);
            while(sc.hasNext()) {
                String firstLine = sc.nextLine();
                String secondLine= sc.nextLine();
                int row = sc.nextInt();
                int col = sc.nextInt();
                sc.nextLine();
                boolean[][] pixelArray = new boolean[row][col];
                String pixelLine1 = sc.nextLine()+sc.nextLine();
                int index = 0;
                for(int rowI = 0; rowI < row; rowI++) {
                    for (int colJ = 0; colJ < col; colJ++) {
                        int char1 = pixelLine1.charAt(index);
                        if(char1 == '1') { pixelArray [rowI][colJ] = true; }
                        else if(char1 == '0') { pixelArray [rowI][colJ] = false; }
                        index++;
                    }
                }
                ImageObj img = new ImageObj(firstLine,secondLine,row,col,pixelArray);
                imageObjList.add(img);
            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        randomizer();
        featureCalculator();
        weightGain();
        training();
        imageClassifier();

        System.out.println("Randomly generated features: ");
        for(FeatureSet feat: features) { System.out.println(feat.toString()); }
        System.out.println("Final weights: ");
        for(double w: weightList){ System.out.println(w); }
    }

    /**
     * Randomizer method which generates a random number for
     * the feature set.
     **/
    private static void randomizer() {
        for(int count = 0; count < 50; count++) {
            int[] row = new int[3];
            int[] col = new int[3];
            boolean[] sgn = new boolean[3];
            for(int i = 0; i < 3; i++) {
                row[i] = new java.util.Random().nextInt(10);
                col[i] = new java.util.Random().nextInt(10);
                sgn[i] = new java.util.Random().nextBoolean();
            }
            FeatureSet feat = new FeatureSet(row, col, sgn);
            features.add(feat);
        }
    }

    /**
     * Method which handles the calculation for the features
     * and stores it in an arraylist.
     **/
    private static void featureCalculator() {
        for(ImageObj img: imageObjList) {
            List<Integer> integerArrayList = new ArrayList<>();
            integerArrayList.add(1); // dummy
            for(FeatureSet feat: features) {
                int num = feat.value(img.getPixelArr());
                integerArrayList.add(num);
            }
            img.setFeatureVector(integerArrayList);
        }
    }

    /**
     * Method which handles the calculation for
     * the weight values.
     **/
    private static void weightGain() {
        weightList.add(1.0);
        for(int i = 0; i < 50; i++) {
            double doub = (new java.util.Random().nextDouble()*2.0)-1.0;
            weightList.add(doub);
        }
    }

    /**
     * Method which handles the classification for
     * the images. Makes sure if the guess is
     * either an "X" or an "O".
     **/
    private static void imageClassifier() {
        int correct = 0;

        for(ImageObj img: imageObjList) {
            double sum = 0.0;
            for(int i = 0; i < features.size(); i++) { sum += img.getFeatureVector().get(i)*weightList.get(i); }
            if(sum > 0) {
                String guess = "#X";
                if(guess.equalsIgnoreCase(img.getSecondLine())) {
                    correct++;
                }
            } else {
                String guess = "#O";
                if(guess.equalsIgnoreCase(img.getSecondLine())) {
                    correct++;
                }
            }
        }
        System.out.println("Accuracy: " + correct + ": " + (double)correct/(double)imageObjList.size()*100 + "%");
        System.out.println("Incorrect: " + (imageObjList.size()-correct));
    }

    /**
     * Method which trains the perceptron
     * and generates a success rate.
     * Result depends on the training data.
     **/
    private static void training() {
        boolean success = false;
        int correct = 0;
        int count = 0;

        while(count < 200 && !success) {
            correct = 0;
            for(ImageObj img: imageObjList) {
                int guessAns; // y
                int realAns; // d
                double sum = 0.0;

                for(int i = 0; i < features.size(); i++) { sum += img.getFeatureVector().get(i)*weightList.get(i); }
                if(sum > 0) {
                    guessAns = 1;
                    if(img.getSecondLine().equalsIgnoreCase("#X")) {
                        realAns = 1;
                        correct++;
                    } else {
                        realAns = 0;
                        for(int j = 0; j < weightList.size(); j++) {
                            double w = weightList.get(j)+0.7*(realAns-guessAns)*img.getFeatureVector().get(j);
                            weightList.set(j, w);
                        }
                    }
                } else {
                    guessAns = 0;
                    if(img.getSecondLine().equalsIgnoreCase("#O")){
                        realAns = 0;
                        correct++;
                    } else {
                        realAns = 1;
                        for(int j = 0; j < weightList.size(); j++) {
                            double w = weightList.get(j)+0.7*(realAns-guessAns)*img.getFeatureVector().get(j);
                            weightList.set(j, w);
                        }
                    }
                }
            }
            count++;
            if(correct == 100) { success = true; }
        }
        System.out.println("Number of iterations: " + count);
    }
}
