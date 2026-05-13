package atividade_de_java.classes;
import java.util.ArrayList;

public class Livros  {
    private ArrayList<String> nomes;


    public Livros()  {
        this.nomes = new ArrayList<>();
    }


    private boolean vazio()  {
        int tamanho = this.nomes.size();
        if (tamanho == 0){return true;}
        else {return false;}
    }


    public void adicionar_livro(String nome)  {
        this.nomes.add(nome);
        System.out.println(nome + " foi registrado com sucesso!");
    }


    public void listar_livros(){
        if (!vazio())  {
            for(int i = 1; i <= this.nomes.size(); i++)  {
                System.out.println("Livro N°"+i+": " + this.nomes.get(i-1));
            }
        }
        else {
            System.out.println("Você não adicionou nenhum livro ainda.");
        }
    }

    
    public void consultar_livro(int id){
        if (!vazio()){
            for(int i = 1; i <= this.nomes.size(); i++){
                if (i == id) {
                    System.out.println("Livro N°"+i+": " + this.nomes.get(i-1));
                }
            }
        }
    }

    //faltou o editar
    public void qnt_livros(){
        int tamanho = this.nomes.size();
        System.err.println("Há "+ tamanho + "livros registrados.");
    }


    public void remover_livro(int id){
        if (!vazio()){
            for(int i = 1; i <= this.nomes.size(); i++){
                if (i == id){
                    System.out.println("Livro N°"+i+": "+this.nomes.get(i-1));
                    this.nomes.remove(i-1);
                    System.err.println("Item Removido com sucesso.");
                }
            }
        }
    }
}