public class AugmentedMatrixTester 
{
  
  public static void main(String args[])
  { 
    AugmentedMatrix.userinterface();
   /** 
    testclear();
    testscale();
    testinterchange();
    testreplace();
   // testdoubleToFraction();
    
        // random matrix
    int rows = 3;
    int cols = 3;
    AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
        toTest.set(i,j,(int) (Math.random()*100));
    }
    
    /** 
     //inconsistent matrix
     int rows = 2, cols = 3;
     AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
     toTest.set(0, 0, 2);
     toTest.set(0, 1, 2);
     toTest.set(0, 2, 5);
     toTest.set(1, 0, -2);
     toTest.set(1, 1, -2);
     toTest.set(1, 2, 3);
     **/
    
    /**
     //matrix with rows of zeros
     int rows = 3, cols = 4;
     AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
     toTest.set(0, 0, 1);
     toTest.set(0, 1, 2);
     toTest.set(0, 2, 6);
     toTest.set(0, 3, 5);
     
     toTest.set(1, 0, 1);
     toTest.set(1, 1, 2);
     toTest.set(1, 2, 6);
     toTest.set(1, 3, 5);
     
     toTest.set(2, 0, 1);
     toTest.set(2, 1, -4);
     toTest.set(2, 2, -2);
     toTest.set(2, 3, 1);

    
    toTest.rowReduce();
    **/
  }
  
  private static boolean testclear()
  {
    int rows = 3;
    int cols = 4;
    AugmentedMatrix toTest = new AugmentedMatrix(3,4);
    toTest.clear();
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++)
      {
        if( toTest.get(i,j) != 0 )
        {
          System.out.println("FAILED testclear()");
          return false;
        }
      }
    }
    System.out.println("PASSED testclear()");
    return true;
  }
  
  private static boolean testscale()
  {
    int rows = 3;
    int cols = 4;
    AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
    for (int i = 0, val = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++, val++)
        toTest.set(i,j,val);
    }
    
    toTest.scale(0,0);
    if( toTest.get(0,0) != 0 || toTest.get(0,1) != 0 || toTest.get(0,2) != 0 ||
       toTest.get(0,3) != 0 )
    {
      System.out.println("FAILED testscale()");
      return false;
    }
    
    toTest.scale(1,2);
    if( toTest.get(1,0) != 8 || toTest.get(1,1) != 10 || toTest.get(1,2) != 12 ||
       toTest.get(1,3) != 14 )
    {
      System.out.println("FAILED testscale()");
      return false;
    }
    
    toTest.scale(2,10);
    if( toTest.get(2,0) != 80 || toTest.get(2,1) != 90 || toTest.get(2,2) != 100 ||
       toTest.get(2,3) != 110 )
    {
      System.out.println("FAILED testscale()");
      return false;
    }
    System.out.println("PASSED testscale()");
    return true;
  }
  
  private static boolean testinterchange()
  {
    int rows = 3;
    int cols = 4;
    AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
    for (int i = 0, val = 0; i < rows; i++)
    {
      for (int j = 0; j < cols; j++, val++)
        toTest.set(i,j,val);
    }
    
    toTest.interchange(0,2);
    if( toTest.get(0,0) != 8 || toTest.get(0,1) != 9 || toTest.get(0,2) != 10 ||
       toTest.get(0,3) != 11 || toTest.get(2,0) != 0 || toTest.get(2,1) != 1 || toTest.get(2,2) != 2 ||
       toTest.get(2,3) != 3 )
    {
      System.out.println("FAILED testinterchange()");
      return false;
    }
    System.out.println("PASSED testinterchange()");
    return true;
  }
  
  private static boolean testreplace()
  {
    int rows = 3;
    int cols = 4;
    AugmentedMatrix toTest =  new AugmentedMatrix(rows,cols);
    for (int i = 0, val = 1; i < rows; i++)
    {
      for (int j = 0; j < cols; j++, val++)
        toTest.set(i,j,val);
    }
    
    toTest.replace(1,-5,0);
    toTest.replace(2,-9,0);
    if(toTest.get(1,0) != 0 || toTest.get(2,0) != 0)
    {
      System.out.println("FAILED testreplace()");
      return false;
    }
    
    
    System.out.println("PASSED testreplace()");
    return true;
  }
}