package Les_10_RegularExpressions.Ex5_Example_IPVerification;

//Метод проверки ip, который состоит из 4-х чисел разделенных точкой в интервале 0-255.0-255.0-255.0-255
//Pattern.matches(regex, ip) - сверяет String и regex и возвращает boolean
import java.util.regex.Pattern;

public class IPVerification {

    public void checkIP(String ip){
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}" +
                "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
        System.out.println(ip + " is ok? " + Pattern.matches(regex, ip));
    }

// 25[0-5]     |  2[0-4]\d  |  [01]?\d?\d       (\.)       {3}
// 250-255     |   200-249  |   0-199           точка   повтори 3 раза

    public static void main(String[] args) {
        String ip1 = "255.38.92.99";
        String ip2 = "182.262.91.05";

        IPVerification ipVerification = new IPVerification();
        ipVerification.checkIP(ip1);
        ipVerification.checkIP(ip2);
    }
}
