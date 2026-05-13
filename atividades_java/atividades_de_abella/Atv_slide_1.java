package atividade_de_java.atividades_de_abella;
import atividade_de_java.classes.Conta;

public class Atv_slide_1{
    public static void main(String[] args){
        Conta conta1 = new Conta(1000,"zezin");
        Conta conta2 = new Conta(0, "junin");
        conta1.transferir(100, conta2);
        conta1.informacoes();
    }
}