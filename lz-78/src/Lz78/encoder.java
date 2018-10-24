package Lz78;
import java.util.*;

public class encoder {

    public static void main(String[] args){
        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        userInput = sc.nextLine();
        System.out.println(encode(userInput)); //example of data to be encoded ABAABABAABABBBBBBBBBBA
    }

    public static String encode(String data){
        //initializes the variables
        Dictionary dic = new Hashtable();
        int key_count =  0;
        int isItinDic = -1 , last_dic_key = 0;
        boolean cont_search = false;
        String encoded_data = "" ,current_character="";


        //initializes the first place in the dictionary with nil
        dic.put(key_count++,"");



        //loops on the data given
        for(int i = 0; i < data.length(); i++)
        {

            current_character = cont_search ? current_character + Character.toString(data.charAt(i)): Character.toString(data.charAt(i));
            int key_in_dic = inDictionary(dic,current_character);

            if( (key_in_dic == -1) || (i == data.length() -1 ) ) {
                dic.put(key_count++,current_character);
                encoded_data += "<"+last_dic_key+","+ "'"+current_character.substring(current_character.length() - 1)+"'"+">";

                if (i != data.length() -1)
                    encoded_data += ',';

                last_dic_key = 0;
                cont_search = false;
            }
            else {
                last_dic_key = key_in_dic;
                cont_search = true;
            }

        }

        return encoded_data;
    }

    // searches in the dictionary for a given string and returns it's key if found or -1
    public static int inDictionary(Dictionary d,String value){

        int key = -1;
        for (Enumeration k = d.keys(); k.hasMoreElements();)
        {

            int temp = (int)k.nextElement();
            if (value.equals(d.get(temp))){
                key = temp;
            }
        }
        return key;
    }
}
