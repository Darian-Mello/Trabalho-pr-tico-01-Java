import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.now();
        boolean correto = false;
        Scanner entrada = new Scanner(System.in);

        while (!correto) {
            try {
                System.out.print("Informe a data inicial \"dd/mm/aaaa\": ");
                data = LocalDate.parse(entrada.nextLine(), formato);
                correto = true;
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro: " + e.getMessage() + "\n" + e.getClass() + "\n");
            }
        }

        System.out.println("\n\nData informada: " + data.format(formato));
        for(int i=0; i<5; i++){
            data = data.plusDays(7);
            System.out.println("Data de pagamento: " + data.format(formato));
        }
    }
}
