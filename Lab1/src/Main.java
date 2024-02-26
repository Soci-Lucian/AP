public class Main {
    public static void main(String[] args) {
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
    }
}