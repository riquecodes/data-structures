import java.util.Scanner;

public class CardsOutDataEstructure {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n != 0) {
            TADList lista = new TADList();

            for (int i = 1; i <= n; i++) {
                lista.insertFinal(i);
            }

            StringBuilder discarded = new StringBuilder("Discarded cards: ");

            boolean firstDiscard = true;

            while (lista.length() > 1) {
                if (!firstDiscard) discarded.append(", ");
                discarded.append(lista.access(0));
                lista.deleteFirst();
                firstDiscard = false;

                int card = lista.access(0);
                lista.deleteFirst();
                lista.insertFinal(card);
            }

            System.out.println(discarded);
            System.out.println("Remaining card: " + lista.access(0));

            n = sc.nextInt();
        }
    }
}
