package principal;

import test.MainTest;


public class EjecutarTest {

   public static void main(String[] args){

       MainTest mt = new MainTest();

       /*
            Coloque como parametro el numero correpondiente a la tarea que desea ejecutar
            Si quiere ejecutar todas las tareas, coloque 0 como argumento

        */

       try {
           mt.testLink(0);
       }catch (Exception e){
           e.printStackTrace();
       }

   }

}
