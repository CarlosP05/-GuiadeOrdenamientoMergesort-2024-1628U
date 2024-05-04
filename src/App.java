public class App {
    public class MergeSortHeladeria {
        // Empezamos a hacer el metodo que contiene la division de las cantidades y sabores de
        public static void mergeSort(String[] sabores, int[] Cantidad){
            //me doy cuenta que todo se repite y tengo que poner un limite de repeticion desde aqui
            if (Cantidad.length < 2) {
                return;
            }
            //integramos aqui las matrices para poder realizar la division del mergerSort
            //asi aprovechando y sacamos tambien las mitades y el lado que se parte a la izquierda y a la derecha 
            //tanto las cantidades como los sabores
            int mid = Cantidad.length / 2;
            String[] SaborIzquierdo = new String[mid];
            int[] cantidadIzquierdas = new int[mid];
            String[] SaboresDerechos = new String[Cantidad.length - mid];
            int[] CantidadDerecha = new int[Cantidad.length - mid];
            //abrimos dos ciclos for uno para el lado izquierdo de los sabores y cantidades 
            //y otro para el lado derecho
            for (int i = 0; i < mid; i++) {
                SaborIzquierdo[i] = sabores[i];
                cantidadIzquierdas[i] = Cantidad[i];
            }
            for (int i = mid; i < Cantidad.length; i++) {
                SaboresDerechos[i - mid] = sabores[i];
                CantidadDerecha[i - mid] = Cantidad[i];
            }
            //llamamos al metodo uno para el lado derecho y otro para el izquierdo
            mergeSort(SaborIzquierdo, cantidadIzquierdas);
            mergeSort(SaboresDerechos, CantidadDerecha);
            // y llamamos al merge para juntarlo todo
            merge(sabores, Cantidad, SaborIzquierdo, cantidadIzquierdas, SaboresDerechos, CantidadDerecha);
         }

         // ahora se habre el metodo para juntarlo las mitades y ordenarlas
        private static void merge(String[] sabores, int[] Cantidades, String[] SaborIzquierdo, int[] cantidadIzquierdas, String[] SaborDerechos, int[] CantidadDerecha) {
            int i = 0, j = 0, k = 0;
            //en esta parte se empiezan a juntar las mitades
            while (i < cantidadIzquierdas.length && j < CantidadDerecha.length) {
                if (cantidadIzquierdas[i] <= CantidadDerecha[j]) {
                    Cantidades[k] = cantidadIzquierdas[i];
                    sabores[k] = SaborIzquierdo[i];
                    i++;
                } else {
                    Cantidades[k] = CantidadDerecha[j];
                    sabores[k] = SaborDerechos[j];
                    j++;
                }
                k++;
            }
            //empezamos a ordenarlas
            while (i < cantidadIzquierdas.length) {
                Cantidades[k] = cantidadIzquierdas[i];
                sabores[k] = SaborIzquierdo[i];
                i++;
                k++;
            }
    
            while (j < CantidadDerecha.length) {
                Cantidades[k] = CantidadDerecha[j];
                sabores[k] = SaborDerechos[j];
                j++;
                k++;
            }



   }
    public static void main(String[] args) throws Exception {
        //en el main ubicamos las variables siendo los sabores y la cantidad de el producto
        String[] sabores = {"Vainilla", "Chocolate", "Fresa", "napolitano", "Limón", "Cafe", "Ron con pasas"};
        int[] Cantidades = {18, 20, 12, 25, 13, 10, 5};
        //empezamos a mostrar nuestra matriz antes de ordenar 
        System.out.println("Cantidad de producto antes de ordenar:");

            for (int i = 0; i < Cantidades.length; i++) {
                System.out.println(sabores[i] + ": " + Cantidades[i]);
            }
            //y ahora lo ordenamos    
            mergeSort(sabores, Cantidades);    
            System.out.println("\nVentas después de ordenar:");
            for (int i = 0; i < Cantidades.length; i++) {
                System.out.println(sabores[i] + ": " + Cantidades[i]);
            }
      }  
  }
}