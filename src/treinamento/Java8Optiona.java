package treinamento;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optiona {

    public static void main(String[] args){

        String s = "1dd";
        //Optional<Integer> é um objeto que pode conter um inteiro ou não, por isso é opicional;
        Optional<Integer> numero = converteStringemNumero(s);
        //Se um valor é presente, ele imprime.
        numero.ifPresent(n -> System.out.println(n));

        //Se não tiver um valor, ele vai imprimir o que está dentro do orElse, como se fosse um valor default
        System.out.println(numero.orElse(2));

        //orElseGet recebe uma função lambda
        System.out.println(numero.orElseGet(() -> {return operacaoPesada();}));

        //orElseThrow recebe uma função lambda para lançar uma exceção.
        System.out.println(numero.orElseThrow(() -> new NullPointerException("Valor Vazio")));


        //Também é possível usar Optional em stream.
        Stream.of(1, 2, 3, 4, 5, 6)
                .findFirst()
                .ifPresent((n) -> System.out.println(n));


        //Usando Optional com tipos primitivos
        int numeroPrimitivo = converteEmNumeroPrimitivo(s)
                .orElseThrow(() -> new NullPointerException("Valor vazio"));

        System.out.println(numeroPrimitivo);

    }

    public static Optional<Integer> converteStringemNumero(String numeroStr){
        try {
            Integer number = Integer.valueOf(numeroStr);
            return Optional.of(number);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    public static OptionalInt converteEmNumeroPrimitivo(String numero){
        try {
            int inteiro = Integer.parseInt(numero);
            return OptionalInt.of(inteiro);
        } catch (Exception e){
            return OptionalInt.empty();
        }
    }

    public static Integer operacaoPesada(){
        return 987654321;
    }

}
