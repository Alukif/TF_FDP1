package CASO2;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

import static java.lang.System.exit;

public class Principal_facts {

    static String menu(String productos[],Double precios[]){
        System.out.println("Los productos disponibles son: ");
        for(int i=0;i<productos.length;i++){
            System.out.println(i+1+". "+productos[i]+"........"+precios[i]);
        }
        return "Listo";
    };
    static double descuento(String producto, double precio, double cantidad) {
        switch (producto) {
            case "platano":
                if (10 < cantidad && cantidad < 25) {
                    precio = precio - (precio * 0.05);
                    return precio;
                } else if (24 < cantidad && cantidad < 50) {
                    precio = precio - (precio * 0.10);
                    return precio;
                } else if (49 < cantidad) {
                    precio = precio - (precio * 0.15);
                    return precio;
                } else {
                    return precio;
                }

            case "naranja":
                if (20 < cantidad && cantidad < 35) {
                    precio = precio - (precio * 0.10);
                    return precio;
                } else if (34 < cantidad && cantidad < 60) {
                    precio = precio - (precio * 0.17);
                    return precio;
                } else if (59 < cantidad) {
                    precio = precio - (precio * 0.25);
                    return precio;
                } else {
                    return precio;
                }
        }
        return precio;
    }



    public static void main(String[] args) {
        //USO DE GIT AL TERMINAR EL CODIGO
      //Escaner:
        Scanner userInput = new Scanner(System.in);
        //Productos
        String[] productos = {"manzana","platano","pera","naranja"};
        Double[] precios={5.0,3.0,6.0,5.0};
        //Lista vacias
        List<String> compra_user=new ArrayList<>();
        List<Double> cantidad_user=new ArrayList<>();
        //REPETIDOR DE MENU
        String menu_op="y";
        while (Objects.equals(menu_op, "y")) {
            //MENU COMPRAR O MOSTRAR
            System.out.println("MENU");
            System.out.println("1. MOSTRAR (lista de productos)");
            System.out.println("2. COMPRAR");
            System.out.println("3. SALIR");
            System.out.println("Que desea hacer: ");
            String opcion = userInput.nextLine();
            System.out.println("--------------------------------");
            switch (opcion) {
                case "MOSTRAR":
                    menu(productos, precios);
                    //COMPRA, REPETIDOR
                case "COMPRAR":
                    String i = "y";
                    while (Objects.equals(i,"y")){
                        String compra="";
                        double cantidad =0;
                        System.out.println("QUE QUIERES COMPRAR:");
                        compra=userInput.nextLine();
                        System.out.println("CUANTOS VAS A COMPRAR: ");
                        cantidad=userInput.nextDouble();
                        compra_user.add(compra);
                        cantidad_user.add(cantidad);
                        System.out.println("Desea continuar (y/n): ");
                        userInput.nextLine();
                        i= userInput.nextLine();
                        System.out.println("-------------------------------------------");
                    }
                    //FIN DEL REPETIDOR/COMPRA/MUESTRA DE COMPRA
                    System.out.println("Su lista de compra es esta");
                    System.out.println(compra_user);
                    System.out.println(cantidad_user);
                    //CONSEGUIR EL NUMERO DE REPETECIONES QUE SE HARA PARA RECORRER LAS LISTAS
                    int num_repet = compra_user.size();
                    //Declarando algunas variables
                    double precio_final=0;
                    //IMPRESION DEL RECIBO
                    System.out.println("Recibo de compra:");
                    //RECORRER LISTA DE COMPRA:
                    for (int a=0;a<num_repet;a++){
                        for (int b=0;b<productos.length;b++){
                            String comp_1= compra_user.get(a);
                            String comp_2= productos[b];
                            double precio = 0;
                            //COMPRARNDO LOS PRODUCTOS DE CADA LISTA PARA CONSEGUIR MAS DATOS
                            if (Objects.equals(comp_1,comp_2)){
                                double x = precios[b];
                                double y = cantidad_user.get(a);
                                //CONSIGUE LOS PRECIOS Y CANTIDAD PARA HACER EL CALCULO del precio
                                precio = x*y;
                                precio=descuento(comp_2,precio,y);
                               //ACUMULACION DEL PRECIO FIANL
                                precio_final=precio_final+precio;
                                //IMPRESION DE PRODUCTOS
                                System.out.println((a+1)+". "+comp_1.substring(0,2)+"..........."+" $"+precio);
                            }else {
                            }
                            }
                        }
                    System.out.println("Costo ........................."+precio_final);
                case "SALIR":
                    exit(0);
            }
            }
            System.out.println("Desea continuar (y/n): ");
            menu_op= userInput.nextLine();
        }
    }

