/**
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Objects;
import java.util.Scanner;

/** Classe Pizza, herda de Comida */
public class Pizza extends Comida implements IFlyWeight{

    /** Preço base da Pizza */
    private static final double PRECO_PIZZA = 30.0;
    /** Máximo de adicionais de uma Pizza*/
    private static final int MAX_ADICIONAIS = 10;
    /** Multiplicador de adicionais (regra própria da pizza) */
    private static final double MULTIPLICADOR_ADICIONAIS = 2.0;

    /** A pizza pode ter borda recheada */
    private boolean bordaRecheada;

    private String extra;
    private boolean molho = false;
    private double addMolho;

    /**
     * Construtor. Indica pizza com borda recheada ou não
     * @param borda Booleano para borda recheada
     */
    public Pizza(boolean borda){
        super(PRECO_PIZZA,MAX_ADICIONAIS); //construtor da classe mãe
        boolean ingExtra = false;
        String chave;
        this.setDescricao("Pizza ");
        this.bordaRecheada = borda;
        System.out.println("Deseja colocar ingrediente extra? (y/n)");
        Scanner teclado = new Scanner(System.in);
        chave = teclado.nextLine();
        if (Objects.equals(chave, "y") || Objects.equals(chave, "Y")){
            this.molho = true;
            operacao();
        }
        else if (Objects.equals(chave, "n") || Objects.equals(chave, "N"))
            this.molho = false;
        else
            System.out.println("Comando não reconhecido. Tratando como falso.");
    }


    @Override
    /**
     * Preço final. Tem regras próprias do multiplicador e da borda recheada.
     */
    public double precoFinal() {

        double precoFinal = precoBase+(this.qtAdicionais * VALOR_ADICIONAL * MULTIPLICADOR_ADICIONAIS);
        if(this.bordaRecheada)
            precoFinal +=7.50;

        if (this.molho){
            precoFinal += addMolho;
        }
        return precoFinal;
    }

    public void operacao(){
        System.out.println("Adicionando molho");
        System.out.println("Selecione: 1 - para Barbecue --- 2 - para molho especial da casa --- 3 - para ambos");

        Scanner teclado = new Scanner(System.in);
        switch (teclado.nextInt()){
            case 1:
                System.out.println("Adicionando barbecue");
                this.addMolho = 1.5;
                break;

            case 2:
                System.out.println("Adicionando molho especial");
                this.addMolho = 2;
                break;

            case 3:
                System.out.println("Adicionando ambos");
                this.addMolho = 3;
                break;

            default:
                System.out.println("Náo reconhecido");
        }

    }

}
