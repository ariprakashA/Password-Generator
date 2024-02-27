import java.util.Scanner;
  class Main{
    public static void main (String  args []){
    Scanner input = new Scanner(System.in);
    Generator generate = new Generator(input);
    generate.start();
    input.close();
    //Password j = new Password();
   // System.out.println("guregure");
    }
}