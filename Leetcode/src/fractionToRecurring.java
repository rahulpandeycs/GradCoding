package src;

public class fractionToRecurring {

    public String fractionToDecimal(int numerator, int denominator) {

        //Check if num = 0 ? return

 //       elese decide on sign, via denomaoraoa
        //Covnert to long

        StringBuilder sb = new StringBuilder();
        int val = numerator/denominator;
        sb.append(val);

        int mod = numerator%denominator;

        if(mod == 0) return sb.toString();

        //res.append(.)
        // Else create hasmap with index it occured last, put in map(num, res.el)

        while(mod !=0){

            mod = mod*10;
            sb.append(mod/denominator);
            mod = mod%denominator;
            //if map coantians, insert ( at index and append na dretur
            //else put locaiton
        }
        return sb.toString();
    }
}
