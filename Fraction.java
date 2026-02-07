/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Jordan Felker
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: Febuary, 2026
*
* Purpose
* The purpose of my program is to create a fraction class to represent fractions by 
* implementing math operations for fractions with different cases. 
* once a fraction is created GCD method is used to reduce the fractions to their lowest forms and makes sure their 
* denominator is positive as having negatives in the denominator is not allowed with fractions.
* after completing the math based on the case the main function prints the results after testing.
** 
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
* <Jordan Felker>
* <40641606>
********************************************************************/
public class Fraction {

   public long Numerator;
   public long Denominator;

   public Fraction(long num) {
    this(num,1);
   }

   public Fraction(long num, long den) {
      long gcd = GCD(num, den);
      if(gcd > 1) {
         num = num / gcd;
         den = den / gcd;
      }

      if(num == 0 && den != 0) {
         this.Numerator = 0;
         this.Denominator = 1;
      }
      else if(num < 0 && den < 0) {
         this.Numerator = -1 * num;
         this.Denominator = -1 * den;
      }
      else if(num >= 0 && den < 0) {
         this.Numerator = -1 * num;
         this.Denominator = -1 * den;
      }
      else {
         this.Numerator = num;
         this.Denominator = den;
      }
   }

   public Fraction Add(Fraction frac) {
      long num1 = this.Numerator * frac.Denominator;
      long num2 = frac.Numerator * this.Denominator;
      long den = this.Denominator * frac.Denominator;

      return new Fraction(num1+num2, den);
   }

   public Fraction Subtract(Fraction frac) {
      long num1 = this.Numerator * frac.Denominator;
      long num2 = frac.Numerator * this.Denominator;
      long den = this.Denominator * frac.Denominator;

      return new Fraction(num1-num2, den);
   }

   public Fraction Multiply(Fraction frac) {
      return new Fraction(this.Numerator * frac.Numerator, this.Denominator * frac.Denominator);
   }

   public Fraction Divide(Fraction frac) {
      return new Fraction(this.Numerator * frac.Denominator, this.Denominator * frac.Numerator);
   }

   public String toString() {
      String result;
      if(this.Numerator == 0 && this.Denominator == 0) {
         result = "NaN";
      }
      else if(this.Denominator == 0 && this.Numerator > 0) {
         result = "Infinity";
      }
      else if(this.Denominator == 0 && this.Numerator < 0) {
         result = "-Infinity";
      }
      else if(this.Denominator == 1)
      {
         result = ""+this.Numerator; }
      else {
         result = "" + this.Numerator + "/" + this.Denominator;
      }
      return result;
   }

    private static long GCD(long a, long b) {
    if (a < 0) a = -a;
    if (b < 0) b = -b;

    while (b != 0) {
        long remainder = a % b;
        a = b;
        b = remainder;
    }

    if (a == 0) return 1;
    return a;
}
    public static void main(String[] args) {
        // test cases from rubric and what they are suppose to convert to 
        Fraction f1 = new Fraction(6,-24);
        System.out.println(f1); // converts to -1/4

        Fraction f2 = new Fraction(0,8);
        System.out.println(f2); // converts to 0 

        Fraction f3 = new Fraction(8,-6);
        System.out.println(f3); // -4/3

        Fraction f4 = new Fraction(23,0);
        System.out.println(f4); // infinity 

        Fraction f5 = new Fraction(6,0);
        System.out.println(f5); // - infinity 

        Fraction f6 = new Fraction(7,1);
        System.out.println(f6); // 7

        Fraction f7 = new Fraction(0,0);
        System.out.println(f7); // NaN
        
        Fraction a = new Fraction(16);                                 // 16/1
        Fraction b = new Fraction(3, 5).Add(new Fraction(7)); // 3/5 + 7
        Fraction c = new Fraction(6, 7);                          // 6/7
        

        Fraction result = c.Multiply(a.Divide(b));
        System.out.println(result); // should be 240/133

    }
}

