public class T4Main {
    public static void main(String[] args) {
        System.out.println("Reading From T3Drawing.txt");
        Window window = Window.readSpecFromFile("T3Drawing.txt");
        window.display();
    }
}
