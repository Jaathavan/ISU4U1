public class Fractions {
    //attributes
    private int numerator;
    private int denominator;
    
    //constructor
    public Fractions (int num, int deno) {
      numerator = num;
      denominator = deno;
    }
    
    //mutators
    public void setNumerator(int num) {
      numerator = num;
    }
    
    public void setDenominator(int deno) {
      denominator = deno;
    }
    
    public void reduce(int num, int deno) {
      int cfactor = 1;
      for (int i=0; i < num; i++) {
        if (num%i==0 && deno%i==0) {
          cfactor = i;
        }
      }
      setNumerator(getNumerator()/cfactor);
      setDenominator(getDenominator()/cfactor);
    }
    
    public void add(int num, int deno) {
      setDenominator(getDenominator()*deno);
      setNumerator(getNumerator()*deno + getDenominator()*num);
      reduce(getNumerator(), getDenominator());
    }
    
    public void subtract(int num, int deno) {
      add(-1*num, deno);
    }
    
    public void multiply(int num, int deno) {
      setDenominator(getDenominator()*deno);
      setNumerator(getNumerator()*num);
      reduce(getNumerator(), getDenominator());
    }
    
    public void divide(int num, int deno) {
      multiply(deno, num);
    }
  
    public void reciprocal() {
      int temp = getNumerator();
      setNumerator(getDenominator());
      setDenominator(temp);
    }
    
    //accessors
    public int getNumerator() {
      return numerator;
    }
    
    public int getDenominator() {
      return denominator;
    }
    
    public double getValue() {
      double doubleNum = getNumerator();
      double doubleDeno = getDenominator();
      return doubleNum / doubleDeno;
    }
    
    public String toString() {
      return getNumerator() + "/" + getDenominator();
    }
    
    public String toMixed() {
      if (getNumerator() >= getDenominator()) {
        int mixedNum = getNumerator() / getDenominator();
        return mixedNum + " " + getNumerator()%getDenominator() + "/" + getDenominator();
      }
      else {
        return toString();
      }
    }
  }
  