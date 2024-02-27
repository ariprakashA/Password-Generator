   import java.util.Scanner;
    public class Generator {
    public  Createpassword  cpassword;
    //public Password p;
    public  Scanner input;
    public Generator(Scanner scanner){
      input = scanner;
    }
    public Generator(boolean includeUpper,boolean includeLower,boolean includeSymbol,boolean includeNumber){
        cpassword = new Createpassword (includeUpper,includeLower,includeSymbol,includeNumber);
    }

    public void start(){
    System.out.println("--welcome Harish password Service---");
     printMenu() ;
     
     String  userChoice ="-1";
    
     while(!userChoice.equals("4")) { 
      userChoice = input.next(); 
        switch(userChoice){
            case "1":{
              requestPassword();
              printMenu();
              break;
            }
            case "2":{
              checkPassword();
              printMenu();
              break;
            }
            case "3":{
              printUsefulInfo();
             
              printMenu();
              break;
            }case "4":{
              
              printQuitMessage();
              break;
            }default :{
              System.out.println("");
              System.out.println(" Kindly select one of the avaible commands");
            }
        
        }
      }
    }

    /*Method 1 request password------------ */  
    private  void  requestPassword(){
            
      boolean includeUpper = false;
      boolean includeLower = false;
      boolean includeNumber = false;
      boolean includeSymbol = false;
      boolean correctParams ;
       System.out.println();
       System.out.println(" Hello, Welcome to the Password Genertor \n The following questions by Yes or No ");
       do{ 
        correctParams  = false;
              String option;
             do{
               System.out.println(" Do you want UpperCase letters   ABCD..  to be used?");
               option = input.next();
               requestError(option);
              }
              while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));
              if (isInclude(option)){
               includeUpper = true;
              }
  
             
            do{
               System.out.println(" Do you want LowerCase letters \" abcd..\"  to be used?");
                option = input.next();
               requestError(option);
              }
              while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));
              if(isInclude(option)){
                includeLower = true;
              }
              
              do{
                System.out.println("Do you want Numbers  \" 1234.. \"  to be used? ");
                option = input.next();
                requestError(option);
              }
              while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));
              if(isInclude(option)){
                includeNumber = true;
              }
              
              do{
                System.out.println("Do you want Symbols  !@#%..   to be used? ");
                option = input.next();
                requestError(option);
             }
              while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"));
              if(isInclude(option)){
                includeSymbol = true;
              }if (!includeUpper && !includeLower && !includeNumber && !includeSymbol){
                System.out.println(" You have selected no characters to generate your password ,\n at least one of your answers should be Yes ");
                 correctParams = true;                         
              }
          
          }while (correctParams);
           System.out.println("Great! Now enter the length of the password");  
           int length = input.nextInt();
            Generator generate = new  Generator(includeUpper,includeLower,includeNumber,includeSymbol);
             System.out.println("Your generated password :"+ generate.GeneratePassword(length) );    
        }  
                
          /*option error cheking */ 
          public  void  requestError(String o){
            if(!o.equalsIgnoreCase("yes") && !o.equalsIgnoreCase("no")){
              System.out.println("You have entered somithing incorrect,let's go over it again");
            }
          }
          
          /*option cheking */
          public boolean isInclude( String option){
            if(option.equalsIgnoreCase("yes")){
              return true;
            }else {
              return false;
            }
         
          }

          /*main page */
          public void printMenu(){
            System.out.println(" 1: Generate New Password ");
            System.out.println(" 2: Checking Password Strength ");
            System.out.println(" 3: Instructions to Create a Password ");
            System.out.println(" 4: Exit ");
            System.out.println(" Enter Your Choice :");
          }

          /*generate password */
          public String GeneratePassword(int length){
            StringBuilder pass = new StringBuilder();
            int passwordLength  = cpassword.getCreatepassword().length();
            int max = passwordLength -1;
            int min = 0;
            int range = max - min +1 ; 
            for (int i=0;i<length;i++){
              int index = (int )(Math.random()*range)+min;
              pass.append(cpassword.getCreatepassword().charAt(index));
             
            }   
                return pass.toString();

          }

          /* Method 2 checkPassword */
        public void checkPassword(){
          String pwd;
          System.out.println("Please Enter your password");
          pwd =input.next();
          Password p =new Password(pwd);
          System.out.println(p.calculateScore());
        }

          /*Method 3 info-- */
         public void printUsefulInfo(){
           
          System.out.println("Use a minimum password length of 8 or more characters if permitted");
          System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
          System.out.println("Generate passwords randomly where feasible");
          System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
          System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
               "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
          System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
         }

          /*Method 4 quit  -------*/
          public void printQuitMessage(){
            System.out.println(" Thank you ! come again!");

          }

        
          

   }            
