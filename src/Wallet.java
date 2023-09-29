import java.util.Random;
import java.util.Scanner;

public class Wallet {
    //Створюю клас з рахунками всіх карток
    double activeBalanceUAH;
    double activeBalanceUSD;
    double activeBalanceEUR;
    double exchangeUSD;
    double exchangeEUR;
    //створюю (клас)об'єкт для унікального 16-значного коду
    StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктор
    public Wallet(double activeBalanceUAH, double activeBalanceUSD, double activeBalanceEUR, double exchangeUSD, double exchangeEUR) {
        this.activeBalanceUAH = activeBalanceUAH;
        this.activeBalanceUSD = activeBalanceUSD;
        this.activeBalanceEUR = activeBalanceEUR;
        this.exchangeUSD = exchangeUSD;
        this.exchangeEUR = exchangeEUR;
    }

    //Створення початкового балансу та 16-значного коду
    void inputBalance() {
        System.out.print("Введіть суму на яку хочете поповнити баланс картки (у UAH) : ");
        activeBalanceUAH=scan.nextDouble();
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
    }

    //конвертація
    double convertToUSD() {
        System.out.print("Введіть суму яку хочете конвертувати (у UAH) : ");
        double volume=scan.nextDouble();
        activeBalanceUAH -= volume;
        activeBalanceUSD = (double) Math.round(volume / exchangeUSD * 100) /100;
        return activeBalanceUSD;
    }
    double convertToEUR() {
        System.out.print("Введіть суму яку хочете конвертувати (у UAH) : ");
        double volume=scan.nextDouble();
        activeBalanceUAH -= volume;
        activeBalanceEUR = (double) Math.round(volume / exchangeEUR * 100) /100;
        return activeBalanceEUR;
    }

    //типізований параметризований метод (методичка)
    double buy10USD(double volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return volume * exchangeUSD;
    }


    //Статистика кожної ітерації (перевантажений метод)
    void statistics() {
        System.out.println();
        System.out.println("__________________________ "+exchangeUSD+" $ / "+exchangeEUR+" € ________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1ої валютної крартки: " + activeBalanceUSD + " $");
        System.out.println("Баланс Вашої 2ої валютної крартки: " + activeBalanceEUR + " €");
        System.out.println();
    }
}
