/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Core;

import static gladusmath.BasicMath.resultCalculation;
import static gladusutil.GladusUtil.containsIgnoraCase;
import static gladusutil.GladusUtil.getInteger;
import static gladusutil.GladusUtil.getValueNumeric;
import static gladusutil.GladusUtil.indexOfIgnoreCase;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author csqueiroz
 */
public class MainCore {

    private boolean isWaitingComand = true;
    private String comand;
    private String comandTyped;

    public void mainLoopCore() {
        while (isWaitingComand) {
            Scanner scanner = new Scanner(System.in);
            comand = scanner.nextLine();
            analyserComand();
        }
    }

    private void analyserComand() {
        if (containsIgnoraCase(comand, "parar")) {
            stopListenning();
        }
        solveFunction();
        resolveFunction(getFunction());
    }

    private void resolveFunction(String function) {
        String resultado = String.valueOf(result(function, getValues(function)));
        System.out.println(resultado);
    }

    private void stopListenning() {
        isWaitingComand = false;
    }
    
    private void solveFunction(){
        boolean isOperatorDeclared = true;
        while(isOperatorDeclared){
            if(comand.contains("+")
                    ||comand.contains("-")
                    ||comand.contains("/")
                    ||comand.contains("*")){
                solveOperator();
                
            }else{
                isOperatorDeclared = false;
            }
            
        }
    }
    
    private void solveOperator(){
        int inicialPos;
        if(comand.contains("(")){
            inicialPos = comand.indexOf("(");
        }else{
            
        }
        
    }
    
    private HashMap getParentesis(){
        
    }
    
    private void preSolveOperator(int inicialPos){
        
    }

    private String getFunction() {
        if (containsIgnoraCase(comand, "somar")) {
            comandTyped = "somar";
            return "somar";
        }
        if (containsIgnoraCase(comand, "some")) {
            comandTyped = "some";
            return "somar";
        }
        if (containsIgnoraCase(comand, "subtraia")) {
            comandTyped = "subtraia";
            return "Subtrair";
        }
        if (containsIgnoraCase(comand, "multiplique")) {
            comandTyped = "multiplique";
            return "Multiplicar";
        }
        if (containsIgnoraCase(comand, "divida")) {
            comandTyped = "divida";
            return "Dividir";
        }
        if (containsIgnoraCase(comand, "subtrair")) {
            comandTyped = "subtrair";
            return "Subtrair";
        }
        if (containsIgnoraCase(comand, "Multiplicar")) {
            comandTyped = "Multiplicar";
            return "Multiplicar";
        }
        if (containsIgnoraCase(comand, "Dividir")) {
            comandTyped = "Dividir";
            return "Dividir";
        }

        return "";
    }

    private HashMap getValues(String function) {
        HashMap values = new HashMap();
        int posFunction = indexOfIgnoreCase(comand, comandTyped) + comandTyped.length();
        int initialPosFunction = posFunction;
        int qtdValues = 0;
        boolean isNumericFunction = false;
        boolean isBasicMath = false;
        if (function.equalsIgnoreCase("Somar")
                || function.equalsIgnoreCase("Subtrair")
                || function.equalsIgnoreCase("Dividir")
                || function.equalsIgnoreCase("Multiplicar")) {
            isNumericFunction = true;
            isBasicMath = true;
            qtdValues = 2;
        }
        if (isNumericFunction) {
            for (int x = 0; x < qtdValues; x++) {
                HashMap retorno = getValueNumeric(posFunction, comand);
                String data = "VALUE" + (x + 1);
                values.put(data, retorno.get("VALUE"));
                posFunction = getInteger(retorno.get("LAST_POS"));
            }
        }
        return values;
    }

    private Object result(String function, HashMap values) {
        boolean isNumericFunction = false;
        boolean isBasicMath = false;
        switch (function.toUpperCase()) {
            case "SOMAR": {
                isNumericFunction = true;
                isBasicMath = true;
                break;
            }
            case "SUBTRAIR": {
                isNumericFunction = true;
                isBasicMath = true;
                break;
            }
            case "MULTIPLICAR": {
                isNumericFunction = true;
                isBasicMath = true;
                break;
            }
            case "DIVIDIR": {
                isNumericFunction = true;
                isBasicMath = true;
                break;
            }

        }

        if (isNumericFunction) {
            if (isBasicMath) {
                return resultCalculation(function, values);
            }
        }
        return null;
    }

}
