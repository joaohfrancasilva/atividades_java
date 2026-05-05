import java.util.Scanner;
public class JogoDaVelha{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] jogo = {{"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"}};
        boolean fim_do_jogo = false;
        String vencedor = "";
        do{
            int qnt_jogadas = 0;
            System.out.println("Jogo da velha: ");
            for (int i = 0; i < 3; i++){
                if (jogo[i][0] == jogo[i][1] && jogo[i][0] == jogo[i][2] && jogo[i][0] != "[ ]"){
                    fim_do_jogo = true;
                    vencedor = jogo[i][0];
                }
                for (int j = 0; j < 3; j++){
                        System.out.print(jogo[i][j]);
                        if (jogo[0][j] == jogo[1][j] && jogo[0][j] == jogo[2][j] && jogo[0][j] != "[ ]"){
                            fim_do_jogo = true;
                            vencedor = jogo[0][j];
                        }
                        if (jogo[i][j] != "[ ]"){
                            qnt_jogadas += 1;
                        }
                    }
                System.out.println();
            }
            if (jogo[1][1] != "[ ]" && ((jogo[1][1] == jogo[0][0] && jogo[1][1] == jogo[2][2]) || (jogo[1][1] == jogo[0][2] && jogo[1][1] == jogo[2][0]))){
                fim_do_jogo = true;
                vencedor = jogo[1][1];
            }
            if(qnt_jogadas == 9){
                vencedor = "velha";
                fim_do_jogo = true;
            }
            if(fim_do_jogo == true){break;}
            System.out.print("Escolha aonde você vai jogar: \nLinha: ");
            int linha = input.nextInt();
            System.out.print("Coluna: ");
            int coluna = input.nextInt();
            jogo[linha][coluna] = "[X]";
            if(jogo[1][1] == "[X]"){
                jogo[0][0] = "[O]";
                if((jogo[2][2] == "[X]" && jogo[2][0] == "[ ]") || jogo[2][0] == "[X]"){
                    jogo[0][2] = "[O]";
                    if (jogo[0][1] == "[X]"){
                        jogo[2][1] = "[O]";
                        if(jogo[1][0] == "[X]"){
                            jogo[1][2] = "[O]";
                        }
                        else{
                            jogo[1][0] = "[O]";
                        }
                    }
                    else if (qnt_jogadas != 2){
                        jogo[0][1] = "[O]";
                    }
                }
                else if(jogo[0][2] == "[X]"){
                    jogo[2][0] = "[O]";
                    if(jogo[1][0] == "[X]"){
                        jogo[1][2] = "[O]";
                        if (jogo[2][1] == "[X]"){
                            jogo[0][1] = "[O]";
                        }
                        else if (qnt_jogadas != 4){
                            jogo[2][1] = "[O]";
                        }
                    }
                    else if (qnt_jogadas != 2){
                        jogo[1][0] = "[O]";
                    }
                }
                else if (jogo[2][1] == "[X]"){
                    jogo[0][1] = "[O]";
                    if (jogo[0][2] == "[X]"){
                        jogo[2][0] = "[O]";
                        if (jogo[1][0] == "[X]"){
                            jogo[1][2] = "[O]";
                        }
                        else{
                            jogo[1][0] = "[O]";
                        }
                    }
                    else{
                        jogo[0][2] = "[O]";
                    }
                }
                else if (jogo[1][2] == "[X]"){
                    jogo[1][0] = "[O]";
                    if (jogo[2][0] == "[X]"){
                        jogo[0][2] = "[O]";
                        if (jogo[0][1] == "[X]"){
                            jogo[2][1] = "[O]";
                        }
                        else{
                            jogo[0][1] = "[O]";
                        }
                    }
                    else{
                        jogo[2][0] = "[O]";
                    }
                }
                else if (jogo[1][0] == "[X]"){
                    jogo[1][2] = "[O]";
                    if (jogo[2][0] == "[X]"){
                        jogo[0][2] = "[O]";
                        if (jogo[0][1] == "[X]"){
                            jogo[2][1] = "[O]";
                        }
                        else{
                            jogo[0][1] = "[O]";
                        }
                    }
                    if (jogo[0][2] == "[X]"){
                        jogo[2][0] = "[O]";
                        if (jogo[2][1] == "[X]"){
                            jogo[0][1] = "[O]";
                        }
                        else{
                            jogo[2][1] = "[O]";
                        }
                    }
                    if (jogo[2][1] == "[X]"){
                        jogo[0][1] = "[O]";
                        if (jogo[0][2] == "[X]"){
                            jogo[2][0] = "[O]";
                        }
                        else{
                            jogo[0][2] = "[O]";
                        }
                    }
                    if (jogo[2][2] == "[X]"){
                        jogo[0][1] = "[O]";
                        if (jogo[0][2] == "[X]"){
                            jogo[2][0] = "O";
                        }
                        else{
                            jogo[0][2] = "[O]";
                        }
                    }
                }
            }
        }while (fim_do_jogo != true);
        input.close();
        if (vencedor != "velha"){
        System.out.printf("O jogador que usava %s venceu!", vencedor);}
        else{
            System.out.println("Deu velha...");
        }
    }
}