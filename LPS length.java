import java.util.Scanner;
class Main
{
    static int max(int x,int y)
    {
        return x>y?x:y;
    }
    static int LPSlength(String word1, String word2,int m)
    {
        int [][] LPS =new int [m+1][m+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0||j==0)
                    LPS[i][j]=0;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    LPS[i][j]=1+LPS[i-1][j-1];
                else
                    LPS[i][j]=max(LPS[i-1][j],LPS[i][j-1]);
            }
        }
        return LPS[m][m];
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        StringBuilder word2 = new StringBuilder(word1);
        word2.reverse();
        String revword=word2.toString();
        int m=word1.length();
        System.out.println("Length of longest palindromic substring is "+LPSlength(word1,revword,m));
        
    }
}

