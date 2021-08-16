import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datas[];
        double valores[], compra=0;
        int parcelas=0;
        Scanner entrada = new Scanner(System.in);
        boolean correto = false;

        while (!correto) {
            try {
                do {
                    System.out.println("Olá, Informe o número de parcelas(o número deve ser maior que 0): ");
                    parcelas = Integer.parseInt(entrada.nextLine());
                }while(parcelas <= 0);
                correto = true;
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro: " + e.getMessage() + "\n" + e.getClass() + "\n");
            }
        }
        correto = false;
        while (!correto) {
            try {
                System.out.println("Informe o valor da compra: ");
                compra = Double.parseDouble(entrada.nextLine());
                correto = true;
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro: " + e.getMessage() + "\n" + e.getClass() + "\n");
            }
        }

        valores = new double[parcelas];
        datas = new LocalDate[parcelas];
        datas[0] = LocalDate.now();
        valores[0] = compra / parcelas;

        System.out.println("\nValor da compra: " + String.format("%.2f", compra));
        System.out.println("Total de parcelas: " + parcelas);
        System.out.println("Valor da parcela: " + String.format("%.2f", valores[0])
                + " Data do " + 1 + "º vencimento: " + datas[0].format(formato));
        for(int i=1; i<parcelas; i++){
            valores[i] = compra / parcelas;
            datas[i] = datas[i-1].plusDays(30);
            System.out.println("Valor da parcela: " + String.format("%.2f", valores[i])
                    + " Data do " + (i+1) + "º vencimento: " + datas[i].format(formato));
        }
    }
}
