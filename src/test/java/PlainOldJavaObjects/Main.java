package PlainOldJavaObjects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String capital = getCountryCapital(sc);
        System.out.println(capital);
        String ask = getUserAskForContinue(sc);
        boolean next = true;
        while(next){
            if ("yes".equals(ask)) {
                System.out.println(getCountryCapital(sc));
                ask = getUserAskForContinue(sc);
            } else if ("not".equals(ask) || "no".equals(ask)) {
                next = false;
            }
            else if( Character.isDigit( ask.charAt(0) ) ) {
                System.out.println(Country.countryCode(ask));
                ask = getUserAskForContinue(sc);
            }else{
                System.out.println(Country.capitalCity(ask));
                ask = getUserAskForContinue(sc);
            }
        }

    }

    public static String getCountryCapital(Scanner scanner){
        System.out.println("Enter the country name or country code : ");
        String input = scanner.next();
        return Character.isDigit( input.charAt(0)) ? Country.countryCode(input) : Country.capitalCity(input);
    }

    public static String getUserAskForContinue(Scanner scanner){
        System.out.println("Do you wish to continue with different county name or country code? (yes/no) : ");
        return scanner.next().toLowerCase().trim();
    }
}