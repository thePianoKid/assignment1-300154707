import design2.PointCP2;

import java.util.Arrays;
import java.util.Random;

public class PerformanceAnalysis {
    private static final double MIN = 0;
    private static final double MAX  = 1000;
    private static final int ITER = 100;

    public static void main(String[] args) {
        char type;

        double start2;
        double end2;
        double runTime2;
        double[] runTimes2 = new double[ITER];;

        double start3;
        double end3;
        double runTime3;
        double[] runTimes3 = new double[ITER];;

        double start5;
        double end5;
        double runTime5;
        double[] runTimes5 = new double[ITER];;

        Random random = new Random();
        double randDouble1 = MIN + random.nextDouble()*MAX;
        double randDouble2 = MIN + random.nextDouble()*MAX;
        if (random.nextDouble() > 0.5)
            type = 'C';
        else
            type = 'P';

        PointCP2 des2 = new PointCP2(type, randDouble1, randDouble2);
        PointCP2 des3 = new PointCP2(type, randDouble1, randDouble2);
        PointCP2 des5 = new PointCP2(type, randDouble1, randDouble2);

        for (int i = 0; i < ITER; i++) {;
            start2 = System.nanoTime();
            des2.getX();
            des2.getY();
            des2.getTheta();
            des2.getRho();
            des2.getDistance(new PointCP2(type, randDouble1 + randDouble2, randDouble2));
            des2.rotatePoint(45);
            des2.toString();
            end2 = System.nanoTime();
            runTime2 = end2 - start2;
            runTimes2[i] = runTime2;

            start3 = System.nanoTime();
            des3.getX();
            des3.getY();
            des3.getTheta();
            des3.getRho();
            des3.getDistance(new PointCP2(type, randDouble1 + randDouble2, randDouble2));
            des3.rotatePoint(45);
            des3.toString();
            end3 = System.nanoTime();
            runTime3 = end3 - start3;
            runTimes3[i] = runTime3;

            start5 = System.nanoTime();
            des5.getX();
            des5.getY();
            des5.getTheta();
            des5.getRho();
            des5.getDistance(new PointCP2(type, randDouble1 + randDouble2, randDouble2));
            des5.rotatePoint(45);
            des5.toString();
            end5 = System.nanoTime();
            runTime5 = end5 - start5;
            runTimes5[i] = runTime5;
        }

        for (double num  : new double[] {2, 3, 5}) {
            System.out.println("Design " + num);
            System.out.println("_______________");
            if (num == 2) {
                System.out.println("min: " + minMaxMed(runTimes2)[0]);
                System.out.println("max: " + minMaxMed(runTimes2)[1]);
                System.out.println("median: " + minMaxMed(runTimes2)[2]);
                System.out.println();
            } else if (num == 3) {
                System.out.println("min: " + minMaxMed(runTimes3)[0]);
                System.out.println("max: " + minMaxMed(runTimes3)[1]);
                System.out.println("median: " + minMaxMed(runTimes3)[2]);
                System.out.println();
            } else {
                System.out.println("min: " + minMaxMed(runTimes5)[0]);
                System.out.println("max: " + minMaxMed(runTimes5)[1]);
                System.out.println("median: " + minMaxMed(runTimes5)[2]);
                System.out.println();
            }
        }
    }

    private static double[] minMaxMed(double[] runTimes) {
        Arrays.sort(runTimes);
        double min = runTimes[0];
        double max = runTimes[ITER - 1];
        double med;
        if(ITER%2==1) {
            med = runTimes[(ITER+1)/2-1];
        }
        else {
            med = (runTimes[ITER/2-1]+runTimes[ITER/2])/2;
        }

        return new double[] {min, max, med};
    }
}
