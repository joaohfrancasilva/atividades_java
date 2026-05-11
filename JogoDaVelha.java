import java.util.Scanner;

public class JogoDaVelha{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] jogo = {{"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"}};
        boolean fim_do_jogo = false;
        boolean velha = false;
        boolean vezJogador;
        System.out.println("Jogo da velha: ");
        do{
            int qnt_jogadas = 0;
            vezJogador = true;
            int linha = -1, coluna = -1;
            for (int i = 0; i < 3; i++){
                if (jogo[i][0] == jogo[i][1] && jogo[i][0] == jogo[i][2] && jogo[i][0] != "[ ]"){
                    fim_do_jogo = true;
                }
                for (int j = 0; j < 3; j++){
                        System.out.print(jogo[i][j]);
                        if (jogo[0][j] == jogo[1][j] && jogo[0][j] == jogo[2][j] && jogo[0][j] != "[ ]"){
                            fim_do_jogo = true;
                        }
                        if (jogo[i][j] != "[ ]"){
                            qnt_jogadas++;
                        }
                    }
                System.out.println();
            }
            if (jogo[1][1] != "[ ]" && ((jogo[1][1] == jogo[0][0] && jogo[1][1] == jogo[2][2]) || (jogo[1][1] == jogo[0][2] && jogo[1][1] == jogo[2][0]))){
                fim_do_jogo = true;
            }
            if(qnt_jogadas == 9){
                fim_do_jogo = true;
                System.out.println("Deu velha...");
                velha = true;
            }
            if(fim_do_jogo){break;}
            System.out.println("Escolha aonde você vai jogar:");
            while(linha > 2 || linha < 0){
                System.out.print("Linha (0 até 2): ");
                linha = input.nextInt();
            }
            while(coluna > 2 || coluna < 0){
                System.out.print("Coluna (0 até 2): ");
                coluna = input.nextInt();
            }
            if(jogo[linha][coluna] == "[ ]"){
                jogo[linha][coluna] = "[X]";
                qnt_jogadas++;
                vezJogador = false;
            }
            //Se há possibilidade de ganhar nessa jogada, ganhe.
            if(qnt_jogadas >= 4){
                for(int i = 0; i < 3; i++){
                    if (jogo[i][0] == "[O]" && jogo[i][1] == "[O]" && vezJogador == false && jogo[i][2] == "[ ]"){
                        jogo[i][2] = "[O]"; vezJogador=true; qnt_jogadas++;}

                    if (jogo[i][0] == "[O]" && jogo[i][2] == "[O]" && vezJogador == false && jogo[i][1] == "[ ]"){
                        jogo[i][1] = "[O]"; vezJogador=true; qnt_jogadas++;}

                    if (jogo[i][1] == "[O]" && jogo[i][2] == "[O]" && vezJogador == false && jogo[i][0] == "[ ]"){
                        jogo[i][0] = "[O]"; vezJogador=true; qnt_jogadas++;}

                    if (jogo[0][i] == "[O]" && jogo[1][i] == "[O]" && vezJogador == false && jogo[2][i] == "[ ]"){
                        jogo[2][i] = "[O]"; vezJogador=true; qnt_jogadas++;}

                    if (jogo[0][i] == "[O]" && jogo[2][i] == "[O]" && vezJogador == false && jogo[1][i] == "[ ]"){
                        jogo[1][i] = "[O]"; vezJogador=true; qnt_jogadas++;}

                    if (jogo[1][i] == "[O]" && jogo[2][i] == "[O]" && vezJogador == false && jogo[0][i] == "[ ]"){
                        jogo[0][i] = "[O]"; vezJogador=true; qnt_jogadas++;}
                }
                
                if(jogo[1][1] == "[O]"){
                    if(jogo[0][2] == "[O]" && jogo[2][0] == "[ ]" && vezJogador == false){
                        jogo[2][0] = "[O]"; qnt_jogadas++; vezJogador = true;
                    }
                    else if(jogo[0][0] == "[O]" && jogo[2][2] == "[ ]" && vezJogador == false){
                        jogo[2][2] = "[O]"; qnt_jogadas++; vezJogador = true;
                    }
                    else if(jogo[2][0] == "[O]" && jogo[0][2] == "[ ]" && vezJogador == false){
                        jogo[0][2] = "[O]"; qnt_jogadas++; vezJogador = true;
                    }
                    else if(jogo[2][2] == "[O]" && jogo[0][0] == "[ ]" && vezJogador == false){
                        jogo[0][0] = "[O]"; qnt_jogadas++; vezJogador = true;
                    }
                }
            }
            //Se há possibilidade de evitar a perda na próxima jogada, não perca.
            if(qnt_jogadas >= 2){
                for(int i = 0; i < 3; i++){
                    if(vezJogador == false){
                        if (jogo[i][0] == "[X]" && jogo[i][1] == "[X]" && vezJogador == false && jogo[i][2] == "[ ]"){
                            jogo[i][2] = "[O]"; vezJogador=true; qnt_jogadas++;}
                        if (jogo[i][0] == "[X]" && jogo[i][2] == "[X]" && vezJogador == false && jogo[i][1] == "[ ]"){
                            jogo[i][1] = "[O]"; vezJogador=true; qnt_jogadas++;}
                        if (jogo[i][1] == "[X]" && jogo[i][2] == "[X]" && vezJogador == false && jogo[i][0] == "[ ]"){
                            jogo[i][0] = "[O]"; vezJogador=true; qnt_jogadas++;}
                        if (jogo[0][i] == "[X]" && jogo[1][i] == "[X]" && vezJogador == false && jogo[2][i] == "[ ]"){
                            jogo[2][i] = "[O]"; vezJogador=true; ++qnt_jogadas;}
                        if (jogo[0][i] == "[X]" && jogo[2][i] == "[X]" && vezJogador == false && jogo[1][i] == "[ ]"){
                            jogo[1][i] = "[O]"; vezJogador=true; qnt_jogadas++;}
                        if (jogo[1][i] == "[X]" && jogo[2][i] == "[X]" && vezJogador == false && jogo[0][i] == "[ ]"){
                            jogo[0][i] = "[O]"; vezJogador=true; qnt_jogadas++;}
                    }
                }
                
                if(((jogo[0][0] == "[X]" && jogo[2][2] == "[X]") || (jogo[0][2] == "[X]" && jogo[2][0] == "[X]")) && vezJogador == false && jogo[1][1] == "[X]"){
                    jogo[1][1] = "[O]";
                    qnt_jogadas++;
                }
                if (jogo[1][1] == jogo[0][0] && jogo[1][1] == "[X]" && jogo[2][2] == "[ ]"){
                    jogo[2][2] = "[O]";
                    qnt_jogadas++;
                }
                if (jogo[1][1] == jogo[2][0] && jogo[1][1] == "[X]" && jogo[0][2] == "[ ]"){
                    jogo[0][2] = "[O]";
                    qnt_jogadas++;
                }
                if (jogo[1][1] == jogo[0][2] && jogo[1][1] == "[X]" && jogo[2][0] == "[ ]"){
                    jogo[2][0] = "[O]";
                    qnt_jogadas++;
                }
                if (jogo[1][1] == jogo[2][2] && jogo[1][1] == "[X]" && jogo[0][0] == "[ ]"){
                    jogo[0][0] = "[O]";
                    qnt_jogadas++;
                } 
            }
            //Outras jogadas:
            if(qnt_jogadas == 7){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(jogo[i][j] == "[ ]" && vezJogador == false){
                            jogo[i][j] = "[O]";
                            qnt_jogadas++;
                            vezJogador = true;
                            break;
                        }
                    }
                }
            }
            if (jogo[1][1] == "[ ]" && qnt_jogadas == 1){jogo[1][1] = "[O]";qnt_jogadas++;}
            if(jogo[1][1] == "[X]"){
                if(qnt_jogadas == 1){jogo[0][0] = "[O]"; qnt_jogadas++;}
                if(qnt_jogadas == 5  && jogo[0][1] == "[X]" && jogo[2][2] == "[X]"){
                    jogo[2][0] = "[O]";
                    qnt_jogadas++;
                }
                else if((qnt_jogadas == 5 || qnt_jogadas == 6) && jogo[2][2] == "[X]" && vezJogador == false){
                    jogo[0][1] = "[O]";
                    qnt_jogadas++;
                }
                if(qnt_jogadas == 3 && jogo[2][2] == "[X]"){
                    jogo[0][2] = "[O]";
                    qnt_jogadas++;
                }
            }
            else{
                if(qnt_jogadas == 3){
                    if((jogo[0][0] == "[X]" && jogo[2][2] == "[X]") || (jogo[0][2] == jogo[2][0] && jogo[2][0] == "[X]")){
                        jogo[0][1] = "[O]";
                        qnt_jogadas++;
                        vezJogador = true;
                    }
                    if(jogo[0][0] == "[X]" && (jogo[2][1] == "[X]" || jogo[1][2] == "[X]")){
                        jogo[2][2] = "[O]";
                        qnt_jogadas++;
                    }
                    if (jogo[0][1] == "[X]"){
                        if(jogo[1][0] == "[X]"){
                            jogo[0][2] = "[O]";
                            qnt_jogadas++;
                        }
                        else if(jogo[1][2] == "[X]"){
                            jogo[0][0] = "[O]";
                            qnt_jogadas++;
                        }
                        else if(jogo[2][1] == "[X]"){
                            jogo[1][0] = "[O]";
                            qnt_jogadas++;
                        }
                        else if (jogo[2][0] == "[X]"){
                            jogo[0][2] = "[O]";
                            qnt_jogadas++;
                            vezJogador = true;
                        }
                        else{
                            jogo[0][0] = "[O]";
                            qnt_jogadas++;
                        }
                    }
                    if (jogo[1][0] == "[X]"){
                        if (jogo[0][2] == "[X]") {
                            jogo[2][0] = "[O]";
                            qnt_jogadas++;
                        }
                        else if(jogo[1][2] == "[X]"){
                            jogo[0][1] = "[O]";
                            qnt_jogadas++;
                        }
                        if(jogo[2][2] == "[X]" || jogo[2][1] == "[X]"){
                            jogo[0][0] = "[O]";
                            qnt_jogadas++;
                        }
                    }
                    if(jogo[2][1] == "[X]"){
                        if(jogo[0][2] == "[X]"){
                            jogo[2][0] = "[O]";
                            qnt_jogadas++;
                        }
                        if(jogo[1][2] == "[X]"){
                            jogo[0][2] = "[O]";
                            qnt_jogadas++;;
                        }
                    }
                    if ((jogo[2][0] == "[X]" || jogo[1][2] == "[X]") && vezJogador == false){
                            jogo[0][2] = "[O]";
                            qnt_jogadas++;
                        }
                }
                if(qnt_jogadas == 5){
                    if(jogo[0][1] == "[X]"){
                        if(jogo[2][1] == "[X]" && jogo[1][2] == "[X]" && jogo[0][0] == "[ ]"){
                            jogo[0][0] = "[O]";
                            qnt_jogadas++;
                        }
                        else if(jogo[2][2] == "[X]" && jogo[2][0] == "[ ]"){
                            jogo[2][0] = "[O]";
                            qnt_jogadas++;
                        }
                        else if(jogo[2][0] == "[X]" && jogo[2][2] == "[ ]"){
                            jogo[2][2] = "[O]";
                            qnt_jogadas++;
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++){
                        if (qnt_jogadas == 5 && vezJogador == false && jogo[i][j] == "[ ]"){
                            jogo[i][j] = "[O]";
                            qnt_jogadas++;
                            vezJogador = true;
                        }
                    }
                }
            }
        }while (fim_do_jogo != true);
        input.close();
        if (velha == false){
        System.out.printf("O jogador que usava [O] venceu!");}
    }
}
