/*
Given a string representing an arithmetic expression with only addition and multiplication operators, return the result of the calculation. 
For example, for "2*3+4", return 10
*/

// "2*3+4" -> ["2*3", "4"] -> ["6", "4"] -> 6+4 -> 10
// "1+2*3+4*5*6" -> ["1", "2*3", "4*5*6"] -> ["1", "6", "120"] -> 1+6+120 -> 127

 public static int solution(String s) {
  int result = 0;
  // Split string using + operator
  String[] addSplit = s.split("\\+"); 
  int[] intArr = new int[addSplit.length];
  
  for(int i = 0; i < addSplit.length; i++){
    if(addSplit[i].indexOf('*') >= 0) {
      // Split string using * operator
      String[] mulSplit = addSplit[i].split("\\*");
      int res = 1;
      
      // multiply numbers separated by *
      for(int j = 0; j < mulSplit.length; j++) {
           res *= Integer.parseInt(mulSplit[j]); 
      }
     
      intArr[i] = res;
    } 
    else {
      intArr[i] = Integer.parseInt(addSplit[i]);
    }
  }
  
  // add numbers separated by +
  for(int i : intArr) {
    result += i;
  }
   
  return result;
