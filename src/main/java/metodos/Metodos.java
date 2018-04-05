package metodos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Metodos {

    WebDriver driver;
    WebElement element, btn;
    WebDriverWait wait;
    String txt="";

    public void abrirNavegador() throws Exception{

        ;

        /*
            Este metodo setea el property del ChromeDriver y abre el navegador con la url dada.

         */

        //Cambiar aqui direccion del driver
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromeDriver\\chromedriver.exe");

        driver= new ChromeDriver();
        driver.get("http://exercises.fdvs.com.ar/semisenior.html");
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"answer1\"]")));
        driver.manage().window().maximize();
        Thread.sleep(500);

    }

    public void task1(){

        String pageTitle="";
        pageTitle = driver.getTitle();

        element= driver.findElement(By.xpath("//*[@id=\"answer1\"]"));
        element.sendKeys(pageTitle);
    }

    public void task2(){

        String name = driver.findElement(By.xpath("/html/body/ol/li[2]/b")).getText();

        element = driver.findElement(By.id("name"));
        element.sendKeys(name);
    }

    public void task3(){

        String txtOcupacion, valor;
        txtOcupacion = driver.findElement(By.xpath("/html/body/ol/li[3]/b")).getText();

        //Evaluo que ocupacion esta establecida para seleccionarla en el form
        if (txtOcupacion.equals("Developer")){
            valor="dev";
        }else if (txtOcupacion.equals("Scrum Master")){
            valor="sm";
        }else if (txtOcupacion.equals("QA Automation")){
            valor="qa";
        }else{
            valor="pm";
        }

        //Se establece la ocupacion definida en la tarea
        element = driver.findElement(By.id("occupation"));
        Select ocupacion = new Select(element);
        ocupacion.selectByValue(valor);
    }

    public void task4(){


        int nroBlackBoxes;
        String intToString;

        //Evaluo cantidad de elementos blackBox hay
        nroBlackBoxes = driver.findElements(By.className("blackbox")).size();

        intToString = String.valueOf(nroBlackBoxes);
        element=driver.findElement(By.id("answer4"));
        element.sendKeys(intToString);
    }

    public void task5(){

        String txtLink="";
        txt= driver.findElement(By.xpath("/html/body/ol/li[5]/b")).getText();

        if (txt.equals("Link 1")){
            txtLink="link1";
        }else if (txt.equals("Link 2")){
            txtLink="link2";
        }else {
            txtLink="clickme";
        }

        element = driver.findElement(By.id(txtLink));
        element.click();
    }

    public void task6(){

        //Capturamos el valor del atributo class
        txt = driver.findElement(By.id("redbox")).getAttribute("class");

        //Escribimos el valor en la caja de texto respectiva
        element = driver.findElement(By.id("answer6"));
        element.sendKeys(txt);
    }

    public void task7(){

        //Capturamos el valor de la posicion del empleado
        txt = driver.findElement(By.xpath("/html/body/ol/li[7]/b")).getText();

        element = driver.findElement(By.cssSelector("input[value='"+txt+"']"));
        element.click();
    }

    public void task8(){

        txt = driver.findElement(By.id("redbox")).getText();

        element = driver.findElement(By.id("answer8"));
        element.sendKeys(txt);
    }

    public void task9(){

        //Capturamos las coordenadas de los elementos a evlauar
        Point pGreen, pOrange;
        pGreen = driver.findElement(By.id("greenbox")).getLocation();
        pOrange = driver.findElement(By.id("orangebox")).getLocation();

        //Evaluo las coordenadas YY de los elementos
        txt= (pGreen.getY() > pOrange.getY()) ? "orange" : "green";

        //Escribimos el color del elemento que esta mas arriba
        element = driver.findElement(By.id("answer9"));
        element.sendKeys(txt);
    }

    public void task10(){

        try {
            //Buscamos el elemento
            element = driver.findElement(By.id("IAmHere"));

            //establecemos la respuesta en el campo de texto respectivo
            element = driver.findElement(By.id("answer10"));
            element.sendKeys("YES");

        }catch (Exception e){
            //Si lanza una excepcion, significa que el elemento no esta presente, y escribomos NO en el
            //Campo de texto respectivo
            element = driver.findElement(By.id("answer10"));
            element.sendKeys("NO");
        }

    }

    public void task11(){

        //Buscamos el elemento
        element = driver.findElement(By.id("purplebox"));

        //Evaluamos si esta presente el elemento
        txt = (element.isDisplayed()) ? "YES" : "NO";
        element = driver.findElement(By.id("answer11"));
        element.sendKeys(txt);

    }

    public void task12(){

        boolean enable=false;

        //Buscamos el link "wait" y hacemos click en el
        element = driver.findElement(By.linkText("Wait"));
        element.click();

        //Esperamos hasta que aparezca el nuevo link y damos click en el
        do{
            try {
                driver.findElement(By.linkText("Click After Wait")).click();
                enable = true;
            }catch (Exception e){
                continue;
            }
        }while (enable==false);

        //Damos ok en el Alert
        System.out.println("Tiempo del click: "+ driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

    public void task14(){

        //Buscamos el elemento
        element = driver.findElement(By.id("submitbutton"));
        element.click();
    }

    public void checkResult(int task){

        btn = driver.findElement(By.xpath("//*[@id=\"checkresults\"]"));
        btn.click();
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showresults")));

        switch (task){
            case 0:
                List<WebElement> labels;

                labels = driver.findElements(By.xpath("/html/body/ol/li"));

                //Recorremos todos los elemntos  id=ok*
                int i=1;
                for (WebElement label:labels) {

                    label = driver.findElement(By.id("ok_"+i));
                    if (label.getText().equals("OK")){
                        System.out.println("Paso "+i+" ejecutado correctamente");
                    }else{
                        System.out.println("Paso "+i+" ejecutado incorrectamente");
                    }
                    i++;
                }
                break;
            case 1:
                txt = driver.findElement(By.id("ok_1")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 2:
                txt = driver.findElement(By.id("ok_2")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 3:
                txt = driver.findElement(By.id("ok_3")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 4:
                txt = driver.findElement(By.id("ok_4")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 5:
                txt = driver.findElement(By.id("ok_5")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 6:
                txt = driver.findElement(By.id("ok_6")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 7:
                txt = driver.findElement(By.id("ok_7")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 8:
                txt = driver.findElement(By.id("ok_8")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 9:
                txt = driver.findElement(By.id("ok_9")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 10:
                txt = driver.findElement(By.id("ok_10")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 11:
                txt = driver.findElement(By.id("ok_11")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 12:
                txt = driver.findElement(By.id("ok_12")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }

                txt = driver.findElement(By.id("ok_13")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso 13 ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            case 14:
                txt = driver.findElement(By.id("ok_14")).getText();
                if (txt.equals("OK")){
                    System.out.println("Paso "+task+" ejecutado correctamente");
                }else{
                    System.out.println("Paso "+task+" ejecutado incorrectamente");
                }
                break;
            default:
                break;
        }
    }
}
