/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    //Converter converts from a letter to a number. and if it is a number return a.
    //It is known in the function that you only put A-G or 0-9
        public static int Converter(char a){

            if(a=='A')
                return 10;
            if(a=='B')
                return 11;
            if(a=='C')
                return 12;
            if(a=='D')
                return 13;
            if(a=='E')
                return 14;
            if(a=='F')
                return 15;
            if(a=='G')
                return 16;
            return Integer.parseInt(String.valueOf(a));
        }
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * If the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            if(!(isNumber(num)))//if the num isn't in the format. send back -1
                return ans;
            if(num.indexOf('b')==-1)//if the num doesn't have b it means the string is only made with digits. so it's already represented as decimal
                return Integer.parseInt(num);
            int basis= Converter(num.charAt(num.indexOf('b')+1));//converts the basis into a number
            int order = 0;
            ans = 0; //reset ans to see the answer
            for(int i=num.indexOf('b')-1; i>=0;i--)//loops runs from the index right of b until the MSB
            {
                ans+=Converter(num.charAt(i))*(Math.pow(basis,order)); //converts each index into number and multiplies it with the basis power to the order of the number. Therefor ans becomes num represented as decimal.
                order++;
            }
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            char c;
            if (a.isEmpty()|| a==null) //checks if the string is null or empty
                ans = false;
            try{ // if there is more than 1 b, (a.indexOf(b)) will send error, therefor if there is error. return false. because it means there is more than 1 b. and i know the rest of the code won't send an error, already checked with every non format option.
                if(a.indexOf('b')==-1 && !a.matches("\\d+")) //if 'b' isn't in the string (a). check if all the characters are digits.
                ans = false;
                if(a.indexOf('b')==-1 && a.matches("\\d+")) //if 'b' isn't in the string (a).and all the characters ARE digits. return true.
                    return true;
                if(a.indexOf('b')== a.length()-1 || a.indexOf('b') == 0) //checks if there isn't a number before b or after b
                    return false;
                if(a.charAt(a.indexOf('b')+1)=='0' || a.charAt(a.indexOf('b')+1)=='1')//checks if the base is 0 or 1
                    ans = false;
                for(int i=0; i<a.length()-1; i++)//checks if every character is either A-G or b or 0-9
                {
                    c = a.charAt(i);
                    if(!(Character.isDigit(c)) && !(c >= 'A' && c <= 'G') && (c!='b'))// checks if every digit is either 0-9 or A-B
                        return false;
                }
                for (int j = 0; j < a.length()-1; j++) {
                    c = a.charAt(j);
                    if(c!='b')
                    {
                        if (Converter(c)>=Converter(a.charAt(a.indexOf('b')+1)))//checks if what is before b greater than the base.
                            ans = false;
                    }
                }
            }
            catch(Exception e){
                return false;
            }

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if(num<0 || base<2 || base>16)//checks if base isn't right if it isn't send back ""
                return ans;
            String Sbase=String.valueOf(base);//to get the String value of the int base( A=10...G=16)
            while(num>0){
               if(num%base>9){//if the rest of the divider is above 9 convert it into a letter than add.
                   if(num%base==10)
                       ans+= 'A';
                   if(num%base==11)
                       ans+= 'B';
                   if(num%base==12)
                       ans+= 'C';
                   if(num%base==13)
                       ans+= 'D';
                   if(num%base==14)
                       ans+= 'E';
                   if(num%base==15)
                       ans+= 'F';
               }
               else {// if it isn't above 9 just add to ans
                   ans+= (char)num%base;
               }
                num/=base;
            }
            if(base==10)
                Sbase = "A";
            if(base==11)
                Sbase = "B";
            if(base==12)
                Sbase = "C";
            if(base==13)
                Sbase = "D";
            if(base==14)
                Sbase = "E";
            if(base==15)
                Sbase = "F";
            if(base==16)
                Sbase = "G";
            return new StringBuilder(ans).reverse().toString()+"b"+Sbase; //turn around the string. since we're dividing and make it look like the format
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true if the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            if(number2Int(n1)!=number2Int(n2)){ //checks if the decimal presentation of the 2 nums are equal. if it isn't return false.
                ans = false;
            }
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            for(int i=0; i<arr.length-1; i++) {
                if (!isNumber(arr[i]))//checks if any of the elements are not in the format
                    return ans;
            }
            for(int j=0; j<arr.length; j++){
                if(number2Int(arr[j])>ans)
                    ans = number2Int(arr[j]);
            }
            return ans;
        }
}
