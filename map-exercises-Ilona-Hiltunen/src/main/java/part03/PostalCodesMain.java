package part03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PostalCodesMain {

    /**
     * Implement your logic in this method. You can also add your own methods and
     * classes if needed.
     *
     * Your program should handle displaying postal codes and postal district names
     * in both directions. For example, if the user enters "00100", the program
     * should print "Helsinki". If the user enters "Helsinki" as their input, the
     * program should print "00100" along with all other postal codes for
     * Helsinki.
     *
     * The program should not handle partial matches. For example, if the user
     * enters "001", the program should not display any results. However, the
     * program should be case-insensitive. For example, the program should display
     * "00100" whether the user enters "helsinki" or "HELSINKI".
     */
    public void etsiToimipaikka(Map<String, String> postalCodes, String answer) {

        if (postalCodes.containsKey(answer)) {
        System.out.println(postalCodes.get(answer));
        } else {
        System.out.println("Postinumeroa ei löytynyt.");
        }
    }

    public void etsiPostinumerot(Map<String, String> postalCodes, String answer) {

        List<Integer> lista = new ArrayList<>();
        String vastaus;
        DecimalFormat desi = new DecimalFormat("00000");
        
         for (Map.Entry<String,String> entry : postalCodes.entrySet()) {
            if (answer.equalsIgnoreCase(entry.getValue())) {
                int postinumero = Integer.parseInt(entry.getKey());
                desi.format(postinumero);
                lista.add(postinumero);
                }
                } 

        Collections.sort(lista); 
        vastaus = lista.stream().map(String::valueOf).collect(Collectors.joining(", "));  
        
        if (lista.size() == 0) {
        System.out.println("Postinumeroita ei löytynyt. ");
        } else {
        System.out.println(vastaus);
        }
    }

    public static void main(String[] args) {
        /*
         * This map contains data that is read from the JSON file. You don't need to
         * inspect the file handling in this exercise, but you can if you want to.
         *
         * The keys in the map are postal codes and the values are postal district names.
         */
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Mitä etsitään (esim. 00100 tai Helsinki)? ");
        String answer = scanner.nextLine(); // answer may be a postal code or a postal district name
        PostalCodesMain ohjelma = new PostalCodesMain();

        try {
            Integer.parseInt(answer);
            ohjelma.etsiToimipaikka(postalCodes, answer);
        } catch (Exception e) {
            ohjelma.etsiPostinumerot(postalCodes, answer);
        }

        scanner.close();
    }
    }
    
