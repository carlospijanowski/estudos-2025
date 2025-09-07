package br.com.seteideias.functional_interfaces;

import java.util.function.Supplier;

public class InterfacesFuncionais {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> convert(1);
        System.out.println(supplier.get());
    }

    public static String convert (Integer number){
        return number.toString();
    }
}
