import java.util.Scanner;

public class abcs {

    public static void main(String[] args) {
        double rate=0, balance=0;
        int year, period=0, n;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhap lai suat, tien von, thoi han: ");
            n = 0;

            try {
                rate = scanner.nextDouble();
                balance = scanner.nextDouble();
                period = scanner.nextInt();
                n = 3;
            } catch (java.util.InputMismatchException e) {
                n = 0;
            }

            scanner.nextLine(); // Đọc dòng mới để loại bỏ ký tự Enter không được đọc

            if (n != 3) {
                System.out.println("Nhap thieu hoac nhap loi!");
            }
        } while (n != 3);

        System.out.printf("Lai suat: %.2f%%\n", rate * 100);
        System.out.printf("Von ban dau: %.2f\n", balance);
        System.out.printf("Thoi han: %d nam\n", period);
        System.out.printf("%3s%10s\n", "Nam", "Von");

        for (year = 1; year <= period; ++year) {
            balance *= 1 + rate;
            System.out.printf("%3d%10.2f\n", year, balance);
        }

        scanner.close();
    }
}
