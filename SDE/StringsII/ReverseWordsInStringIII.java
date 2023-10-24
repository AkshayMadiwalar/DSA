public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char ch[] = s.toCharArray();

        while(i<ch.length){

            while(j<ch.length && ch[j]!=' ')
                j++;

            reverse(ch,i,j-1);
            i=j+1;
            j=i;
        }

        return new String(ch);
    }

    public void reverse(char[] ch, int i, int j){
        while(i<=j){
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }
    }