package atividade_de_java.classes;
public class Conta{
    private double saldo;
    private String titular;

    public Conta(double saldo, String titular){
        this.saldo = saldo;
        this.titular = titular;
    }

    public Conta(double saldo){
        this.saldo = saldo;
        this.titular = "Anônimo";
    }
    
    public Conta(String titular){
        this.saldo = 0;
        this.titular = titular;
    }

    public void sacar(double qnt){
        if (saldo > 0 && saldo >= qnt){
            saldo -= qnt;
            System.out.println("Saque de R$" + qnt + " autorizado com sucesso.");
        }
        else{
            System.out.println("Saque não autorizado.");
        }
    }

    public void depositar(double qnt){
        saldo += qnt;
    }

    public void transferir(double qnt, Conta conta){
        if (this.saldo >= qnt && this.saldo > 0){
            this.sacar(qnt);
            conta.depositar(qnt);
            System.out.println("O titular: " + this.titular + " transferiu R$" + qnt + "para o titular: " + conta.titular);
        }
    }

    public double getSaldo(){
        return this.saldo;
    }
    public String getTitular(){
        return this.titular;
    }

    public void informacoes(){
        System.out.println("Titular: " + this.getTitular()+" | Saldo: R$" + this.getSaldo());
    }
}