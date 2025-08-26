class Patterns {
    
    public void pattern1(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public void pattern2(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }    
    }

    public void pattern3(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }    
    }

    public void pattern4(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }    
    }

    public void pattern5(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }    
    }

    public void pattern6(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }    
    }

    public void pattern7(int n){
        for (int i=0; i<n; i++){
            // space
            for (int j=0; j<n-i-1; j++){
                System.out.print(" " );
            }
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            for(int j=0; j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    // public void pattern8(int n){
    //     for (int i=n-2; i>=0; i--){
    //         // space
    //         for (int j=0; j<n-i-1; j++){
    //             System.out.print(" " );
    //         }
    //         for(int j=0; j<2*i+1; j++){
    //             System.out.print("*");
    //         }
    //         for(int j=0; j<n-i-1;j++){
    //             System.out.print(" ");
    //         }
    //         System.out.println();
    //     }
    // }

    public void pattern8(int n){
        for (int i=0; i<n; i++){
            // space
            for (int j=0; j<i; j++){
                System.out.print(" " );
            }
            for(int j=0; j<2*n-(2*i+1); j++){
                System.out.print("*");
            }
            for(int j=0; j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern9(int n){

        for(int i=0;i<=2*n-1;i++){
            int stars = i;
            if(i>n) stars = 2*n-i;
            for (int j=0; j<stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

public class Pattern {
    public static void main(String [] args){
        int n = 5;

        Patterns pat = new Patterns();
        // pat. pattern1(n);
        // pat.pattern2(n);
        // pat.pattern3(n);
        // pat.pattern4(n);
        // pat.pattern5(n);
        // pat.pattern6(n);
        pat.pattern7(n);
        pat.pattern8(n);
        pat.pattern9(n);
    }
}
