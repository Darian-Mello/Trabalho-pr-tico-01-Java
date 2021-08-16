import javax.swing.*;

public class Exercicio01 {
    public static void main(String[] args) {
        String nome="", saida;
        Double salliquido, desconto, salbruto = 0.0;
        boolean acerto = false;

        while(!acerto) {
            try {
                nome = JOptionPane.showInputDialog("Olá, informe o nome da pessoa: ");
                do{
                    salbruto = Double.parseDouble(JOptionPane.showInputDialog
                            ("Informe o sálario bruto do " + nome + " para saber o desconto do INSS: "));

                    if(salbruto < 0 || salbruto > 6433.57)
                        JOptionPane.showMessageDialog(null, "O valor especificado não consta " +
                                "na tabela do INSS.\nO sálario deve estar entre R$0,00 e R$6433,57");
                }while(salbruto < 0 || salbruto > 6433.57);

                acerto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu um erro: " + e.getMessage() + "\n\n" + e.getClass());
            }
        }

        desconto = verificaDesconto(salbruto);
        desconto = (salbruto * desconto)/100;
        salliquido = salbruto - desconto;

        saida = "Nome: " + nome;
        saida += "\nSalário bruto: " + String.format("%.2f", salbruto);
        saida += "\nINSS: " + String.format("%.2f", desconto);
        saida += "\nSalário líquido: " + String.format("%.2f", salliquido);
        JOptionPane.showMessageDialog(null, saida);
    }

    public static Double verificaDesconto(Double salbruto){
        Double desconto;
        if(salbruto > 0 && salbruto <= 1100)
            desconto = 7.5;
        else if(salbruto > 1100 && salbruto <= 2203.48)
            desconto = 9.00;
        else if(salbruto > 2203.48 && salbruto <= 3305.22)
            desconto = 12.00;
        else
            desconto = 14.00;

        return desconto;
    }
}
