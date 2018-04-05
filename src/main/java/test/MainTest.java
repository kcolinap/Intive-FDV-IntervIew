package test;

import metodos.Metodos;

import javax.swing.plaf.TableHeaderUI;

public class MainTest {

    public void testLink(int arg){

        Metodos m = new Metodos();
        try{

            m.abrirNavegador();
            Thread.sleep(600);

            switch (arg){
                case 0:
                    m.task1();
                    Thread.sleep(500);

                    m.task2();
                    Thread.sleep(500);

                    m.task3();
                    Thread.sleep(500);

                    m.task4();
                    Thread.sleep(500);

                    m.task5();
                    Thread.sleep(500);

                    m.task6();
                    Thread.sleep(500);

                    m.task7();
                    Thread.sleep(500);

                    m.task8();
                    Thread.sleep(500);

                    m.task9();
                    Thread.sleep(500);

                    m.task10();
                    Thread.sleep(500);

                    m.task11();
                    Thread.sleep(500);

                    m.task12();
                    Thread.sleep(500);

                    m.task14();
                    Thread.sleep(500);

                    m.checkResult(arg);
                    break;
                case 1:
                    m.task1();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 2:
                    m.task2();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 3:
                    m.task3();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 4:
                    m.task4();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 5:
                    m.task5();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 6:
                    m.task6();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 7:
                    m.task7();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 8:
                    m.task8();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 9:
                    m.task9();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 10:
                    m.task10();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 11:
                    m.task11();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 12:
                    m.task12();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                case 14:
                    m.task14();
                    Thread.sleep(500);
                    m.checkResult(arg);
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
