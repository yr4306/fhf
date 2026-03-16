import java.util.Scanner;

public class Body {
    public static void massIndex(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("体重过轻：低于18.5");
        } else if (bmi <= 24.9) {
            System.out.println("正常：介于18.5至24.9之间");
        } else if (bmi <= 29.9) {
            System.out.println("超重：介于25至29.9之间");
        } else {
            System.out.println("肥胖：30或更大");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入体重（千克）：");
        double weight = scanner.nextDouble();
        System.out.print("请输入身高（米）：");
        double height = scanner.nextDouble();
        massIndex(weight, height);
    }
}
