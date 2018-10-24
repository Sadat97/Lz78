package Lz78;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class decoder {
    public static void main(String[] args){
        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        userInput = sc.nextLine();// Example <0,'A'>,<0,'B'>,<1,'A'>,<2,'A'>,<4,'A'>,<4,'B'>,<2,'B'>,<7,'B'>,<8,'B'>,<0,'A'>
        String decoded = decode(userInput);
        System.out.println(decoded);

    }

    public static String decode(String data){
        //initialize the dictionary
        Dictionary dic = new Hashtable();
        int key_count =  0;
        dic.put(key_count++,"");

        //init variables
        String decoded_data = "";
        String string_from_dic = "" , char_to_print ="";

        int key ;
        //builds the data given to readable data to loop on it
        String [] tags = stringBuilder(data);

        //loops on the tags and building the dictionary on the run
        for (int i = 0 ; i < tags.length ; i++) {
            key = Integer.parseInt(String.valueOf(tags[i].charAt(0)));
            string_from_dic = String.valueOf(dic.get(key));
            char_to_print = String.valueOf(tags[i].charAt(1));
            dic.put(key_count++,string_from_dic + char_to_print);
            decoded_data += string_from_dic + char_to_print;
        }

        return decoded_data;

    }

    public static String []  stringBuilder(String data){
        String[] tags = data.split(">");
        for (int i =0 ; i < tags.length ; i++ )
            tags[i] = tags[i].replace("<", "").replace(",", "").replace("'", "");
        return tags;
    }
}
