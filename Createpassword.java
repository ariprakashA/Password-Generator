public class Createpassword {
    String UPPERCASE = "ABDEFGHIJKLMNOPQRSTUVWXYZ";
    String LOWERCASE = "abcdefghijklmnopqrstuvwxysz";
    String NUMBERS = "1234567890";
    String SYMBOLS = "!@#$%^&*()_+=-?\\/" ; 
   
    StringBuilder pool =new StringBuilder();
    public Createpassword ( boolean includeUpper ,boolean includeLower, boolean includeSymbol, boolean includeNumber){
     
        if(includeUpper)pool.append(UPPERCASE);
        if(includeLower)pool.append(LOWERCASE);
        if(includeSymbol)pool.append(SYMBOLS);
        if(includeNumber)pool.append(NUMBERS);
       
    }
    public  String getCreatepassword(){
    return pool.toString();
   }
   
}
