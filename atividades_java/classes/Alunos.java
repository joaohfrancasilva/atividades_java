package atividade_de_java.classes;
import java.util.ArrayList;

public class Alunos{
    private ArrayList<String> nomes;


    public Alunos(){
        this.nomes = new ArrayList<>();
    }


    private boolean vazio(){
        int tamanho = this.nomes.size();
        if (tamanho == 0){
            System.out.println("Não há nenhum aluno cadastrado.");
            return true;
        }
        else{
            return false;
        }
    }


    public void cadastrar_alunos(String nome){
        this.nomes.add(nome);
    }


    public void listar_alunos(){
        if (!vazio()){
            for(int i = 0; i < this.nomes.size(); i++){
                int n = i + 1;
                System.out.println("Aluno N°"+n+": "+this.nomes.get(i));
            }
        }
    }

    public void qnt_alunos(){
        int tamanho = this.nomes.size();
        System.out.println("Há "+tamanho+" alunos registrados no momento.");
    }

    public void remover_aluno(int id){
        if (!vazio()){
            if (id < this.nomes.size()){
                for(int i = 0; i < this.nomes.size(); i++){
                    int n = i + 1;
                    if (id == i){
                        System.out.println("Aluno N°"+n+": "+this.nomes.get(i));
                        this.nomes.remove(id);
                        System.out.println("Aluno removido com sucesso.");
                        break;
                    }
                }
            }
            else{
                System.out.println("ID inválido, tente novamente.");
            }
        }
    }
}
