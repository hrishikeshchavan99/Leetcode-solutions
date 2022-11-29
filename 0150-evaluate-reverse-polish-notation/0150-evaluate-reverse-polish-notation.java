class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> st = new Stack<>();
        String op = "+-*/";
        int num1, num2;
        for (String str: tokens){
            if (op.contains(str)){
                num1 = st.pop();
                num2 = st.pop();
                st.add(cal(num1, num2, str));
            }
            else
                st.add(Integer.parseInt(str));
        }
        return st.pop();
    }
    private Integer cal(Integer num1, Integer num2, String str){
        switch(str){
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
                                
        
        }
        return 0;
    }
}