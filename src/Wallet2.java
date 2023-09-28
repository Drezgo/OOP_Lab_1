import java.util.Random;
import java.util.Scanner;
//___________________________________________МЕТОДИЧКА____________________
public class Wallet2 {
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
    public Wallet2(double activeBalanceUAH, double activeBalanceUSD, double activeBalanceEUR, double exchangeUSD, double exchangeEUR) {
        this.activeBalanceUAH = activeBalanceUAH;
        this.activeBalanceUSD = activeBalanceUSD;
        this.activeBalanceEUR = activeBalanceEUR;
        this.exchangeUSD = exchangeUSD;
        this.exchangeEUR = exchangeEUR;
    }

    //Створення початкового балансу та 16-значного коду
    void inputBalance(double bal) {
        activeBalanceUAH=bal;
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
    }


    //типізований параметризований метод (методичка)
    double buy10USD(double volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return volume * exchangeUSD;
    }


    //Статистика кожної ітерації
    void statistics() {
        System.out.println("_____________________________2ий гаманець_____________________________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + activeBalanceUAH + " гривень");
        System.out.println("Баланс Вашої 1 валютної крартки: " + activeBalanceUSD + " $");
        System.out.println("Баланс Вашої 2 валютної крартки: " + activeBalanceEUR + " €");
        System.out.println();
    }
}
