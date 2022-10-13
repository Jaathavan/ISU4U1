public class TestFractions {
    public static void main (String [] args) {
      Fractions f= new Fractions (4,8);
      System.out.println("Numerator: " + f.getNumerator());
      System.out.println("Denominator: " + f.getDenominator());
      System.out.println("Value: " + f.getValue());
      System.out.println("String: " + f.toString());
      System.out.println("Mixed: " + f.toMixed());
      
      f.reciprocal();
      System.out.println("Mixed: " + f.toMixed());
  
      f.setNumerator(4);
      f.setDenominator(6);

      System.out.println("String: " + f.toString());
  
      f.setNumerator(4);
      f.setDenominator(6);
      f.add(3, 4);
      System.out.println("String: " + f.toString());
      System.out.println("String: " + f.toString());
  
      f.setNumerator(3);
      f.setDenominator(4);
      f.subtract(4, 6);
      System.out.println("String: " + f.toString());
      System.out.println("String: " + f.toString());
    }
  }
  
