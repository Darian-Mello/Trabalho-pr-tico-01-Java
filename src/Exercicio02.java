import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Exercicio02 {
    public static void main(String[] args) {
        LocalDate locacao = LocalDate.now();
        LocalDate devolucao = LocalDate.now();
        double diaria = 0;
        long total;
        boolean correto = false;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada, saida;

        while (!correto) {
            try {
                entrada = JOptionPane.showInputDialog("Informe a data de locação no formato \"dd/mm/aaaa\": ");
                locacao = LocalDate.parse(entrada, formato);
                correto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu um erro: " + e.getMessage() + "\n\n" + e.getClass());
            }
        }
        correto = false;
        while (!correto) {
            try {
                entrada = JOptionPane.showInputDialog("Informe a data de devolução no formato \"dd/mm/aaaa\": ");
                devolucao = LocalDate.parse(entrada, formato);
                correto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu um erro: " + e.getMessage() + "\n\n" + e.getClass());
            }
        }
        correto = false;
        while (!correto) {
            try {
                entrada = JOptionPane.showInputDialog("Informe o valor da diária: ");
                diaria = Integer.parseInt(entrada);
                correto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu um erro: " + e.getMessage() + "\n\n" + e.getClass());
            }
        }

        total = ChronoUnit.DAYS.between(locacao, devolucao);

        saida = "Valor da diária: " + String.format("%.2f", diaria);
        saida += "\nData de locação: " + locacao.format(formato);
        saida += "\nData de devolução: " + devolucao.format(formato);
        saida += "\nDias de locação: " + total;
        saida += "\nValor total da locação: " + String.format("%.2f", total*diaria);

        JOptionPane.showMessageDialog(null, saida);
    }
}