import java.util.Objects;
import java.util.Scanner;

public class ComidaSimpleFactory {
    public static Comida createFood(String escolha){
        Comida nova = null;
        boolean aux = false;
        String chave;

        Scanner teclado = new Scanner(System.in);
        switch (escolha){
            case "1":
                System.out.println("Pizza");
                System.out.println("Recheio na borda? (y/n)");
                chave = teclado.nextLine();
                if (Objects.equals(chave, "y") || Objects.equals(chave, "Y"))
                    aux = true;
                else if (Objects.equals(chave, "n") || Objects.equals(chave, "N"))
                    aux = false;
                else
                    System.out.println("Comando não reconhecido. Tratando como falso.");

                nova = new Pizza(aux);
                break;

            default:
                System.out.println("Comando não reconhecido");

            case "2":
                System.out.println("Sanduiche");
                System.out.println("Dobro? (y/n)");
                chave = teclado.nextLine();
                if (Objects.equals(chave, "y") || Objects.equals(chave, "Y"))
                    aux = true;
                 else if (Objects.equals(chave, "n") || Objects.equals(chave, "N"))
                    aux = false;
                 else
                    System.out.println("Comando não reconhecido. Tratando como falso.");

                nova = new Sanduiche(aux);
                break;

        }

        System.out.print("Quantos adicionais: ");
        int quantos = Integer.parseInt(teclado.nextLine());
        for(int i=0; i<quantos;i++)
            nova.addIngrediente("adicional "+(i+1)+" ");

        return nova;
    }
}
