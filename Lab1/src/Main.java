public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("Hello world!");
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

        n = n * 3;
        n=n + Integer.parseInt("10101",2);
        n=n + Integer.parseInt("FF",16);;
        n=n * 6;

        int result=n;

        while(result>=10){
            n=result;
            result=0;
            while (n>0) {
                result = result + (n % 10);
                n = n / 10;
            }
        }

        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);

        // Homework:

        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int k=Integer.parseInt(args[2]);
        int i;

        String numbers = "k-reductable numbers: ";

        for(i=a;i<=b;i++){
            n=i;
            while(n>k && n>9){
                int red=n;
                int sum=0;
                while(red>0){
                    sum=sum+(red%10)*(red%10);
                    red=red/10;
                }
                n=sum;
            }
            if(n==k){
                String nr=String.valueOf(i);
                numbers=numbers.concat(nr);
                numbers=numbers.concat(" ");
            }
        }

        System.out.println(numbers);

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;

        System.out.println("running time of the application: " + executionTime + "ms");
    }
}