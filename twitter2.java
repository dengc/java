/*
 * Complete the function below.
 */

    static int findMutationDistance(String start, String end, String[] bank) {
        int diff = diff(start, end);
        int l = bank.length;
        int count = Integer.MAX_VALUE;
        int index = -1;
        Stack<String> stack = new Stack<String>();
        stack.push(start);
        boolean flag = false;
        for(int i = 0; i < l; i++){
            if(bank[i].equals(end)){
                flag = true;
                break;
            }
        }
        if(!flag){
            return -1;
        }
        while(!stack.isEmpty()){
            for(int i = index+1; i < l; i++){
                String str = bank[i];
                if(diff(stack.peek(), str) == 1){
                    if(str.equals(end)){
                        if(diff == stack.size()){
                            return diff;
                        }
                        count = Math.min(count, stack.size());
                    }else{
                        stack.push(str);
                        index = i;
                    }
                }
            }
            stack.pop();
        }
        if(count < Integer.MAX_VALUE){
            return count;
        }
        return diff;
    }
    static int diff(String s1, String s2){
        int count = 0;
        int l = s1.length();
        for(int i = 0; i < l; i++){
            if(!s1.substring(i, i + 1).equals(s2.substring(i, i + 1))){
                count++;
            }
        }
        return count;
    }

