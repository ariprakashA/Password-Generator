1  public class Password {
    String value ;
    int length;

    public Password(String s){
      value = s;
      length = s.length();

    }
    public String calculateScore(){
         int score = PasswordStrength();
         if(score == 6){
          return "This is a very good password ";
         }if(score >= 4){
          return "This is a good password";
         }if(score >= 3){
          return "This is a medium password";
         }else{
          return "This is a weak password ";
         }
    }

   public int  PasswordStrength(){
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedSymbol = false;
        boolean usedNumber = false;
        int type ;
        int score =0;
        for (int i=0;i<length;i++){
          char c = value.charAt(i);
          type = ChartType(c);
          if ( type == 1) usedUpper = true;
          if ( type == 2) usedLower = true;
          if ( type == 3) usedSymbol = true;
          if ( type == 4) usedNumber = true;
        }
        if (usedUpper)score += 1;
        if (usedLower)score +=1;
        if (usedSymbol)score +=1;
        if (usedNumber)score +=1;

        if(length>=8)score +=1;
        if(length>=16)score +=1;

            return  score;
    } 
    
    public int ChartType(char c){
      int val;
      if((int )c>=65 && (int)c<=90){
           val = 1;
      }else if((int )c>=97 && (int)c<=122){
        val =  2;
      }else if((int)c>= 60 && (int)c<= 71){
        val = 3;
      }
      else{
        val = 4;
      }
      return val;
    }
   
}
