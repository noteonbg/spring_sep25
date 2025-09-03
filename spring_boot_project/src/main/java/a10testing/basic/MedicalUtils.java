package a10testing.basic;


public class MedicalUtils {

    public static boolean isBloodPressureNormal(int systolic, int diastolic) {
        return systolic >= 90 && systolic <= 120 && diastolic >= 60 && diastolic <= 80;
    }

    public static double calculateBMI(double weightKg, double heightM) {
        if (heightM <= 0) throw new IllegalArgumentException("Height must be positive");
        return weightKg / (heightM * heightM);
    }
}
