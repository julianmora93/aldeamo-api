package com.aldeamo.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.dto.DefaultResponseDto;
import com.aldeamo.dto.InterationDto;
import com.aldeamo.dto.ProcessResponse;
import com.aldeamo.entity.ArrayEntity;
import com.aldeamo.service.IArrayService;

@Service
public class Bar implements IBar {

    @Autowired
    IArrayService arrayService;

    public DefaultResponseDto<List<Integer>> executeProcess(Integer iterations, Integer dataStackId){
        DefaultResponseDto<List<Integer>> response = new DefaultResponseDto<List<Integer>>(
            true,
            "0x000",
            "OK",
            new ArrayList<>()
        );

        try{
            //-- Valida que el numero de iteraciones no sea absurdamente grande
            if(iterations >= 10000){
                response.setStatus(false);
                response.setMessage("El número de iteraciones excede lo permitido: 10000");
                response.setCodeStatus("0x001");
                return response;
            }

            //-- Valida que el id de la pila de datos este en el rango de 1 a 5
            if(dataStackId < 1 || dataStackId > 5){
                response.setStatus(false);
                response.setMessage("El número de la pila de datos debe estar en un rango del 1 al 5");
                response.setCodeStatus("0x002");
                return response;
            }

            //-- Valida que el numero de iteraciones sea mayor a 0
            if(iterations < 1){
                response.setStatus(false);
                response.setMessage("El número de iteraciones debe ser mayor a 0");
                response.setCodeStatus("0x003");
                return response;
            }

            Optional<ArrayEntity> dataDb = arrayService.getById(dataStackId);

            //-- Valida que la pila de datos se encuentra disponible en la DB
            if(dataDb == null){
                response.setStatus(false);
                response.setMessage("La pila de datos no se encontró");
                response.setCodeStatus("0x004");
                return response;
            }

            //-- Arreglo de numeros primos
            List<Integer> arrayP = getPrimeNumbers(iterations);

            //-- Arreglo de vasosque se obtiene del resultado de la consulta de la base de datos
            List<Integer> arrayA = parseInputArrayToIntArray(dataDb.get().getInput_array());

            List<Integer> finalArray = new ArrayList<>();


            for(Integer q = 0; q < iterations; q++){
                //-- Arreglo de numeros divisibles
                List<Integer> arrayB = new ArrayList<>();

                //-- Arreglo de numeros no divisibles
                List<Integer> arrayAi = new ArrayList<>();

                for (int value : arrayA) {
                    //-- Verifica si el numero de la iteracion es divisible por el numero primo de la iteracion principal
                    if (value % arrayP.get(q) == 0) {
                        arrayB.add(value);
                    } else {
                        arrayAi.add(value);
                    }
                }
                //-- Agrega todos los numeros divisibles a la respuesta final
                finalArray.addAll(arrayB);

                //-- Determina el nuevo arreglo que se debe iterar
                arrayA = parseArrayInt(arrayAi.stream().mapToInt(Integer::intValue).toArray());
            }

            //-- Registra los numeros de la ultima iteracion a la respuesta final
            for (int item : arrayA) {
                finalArray.add(item);
            }

            response.setData(finalArray);

            return response;
        }catch(Exception ex){
            response.setStatus(false);
            response.setCodeStatus("0x990");
            response.setMessage(ex.getMessage());
            return response;
        }
    }

    public DefaultResponseDto<ProcessResponse> executeCompleteProcess(Integer iterations, Integer dataStackId){
        DefaultResponseDto<ProcessResponse> response = new DefaultResponseDto<ProcessResponse>(
            true,
            "0x000",
            "OK",
            new ProcessResponse()
        );

        try{
            //-- Valida que el numero de iteraciones no sea absurdamente grande
            if(iterations >= 10000){
                response.setStatus(false);
                response.setMessage("El número de iteraciones excede lo permitido: 10000");
                response.setCodeStatus("0x001");
                return response;
            }

            //-- Valida que el id de la pila de datos este en el rango de 1 a 5
            if(dataStackId < 1 || dataStackId > 5){
                response.setStatus(false);
                response.setMessage("El número de la pila de datos debe estar en un rango del 1 al 5");
                response.setCodeStatus("0x002");
                return response;
            }

            //-- Valida que el numero de iteraciones sea mayor a 0
            if(iterations < 1){
                response.setStatus(false);
                response.setMessage("El número de iteraciones debe ser mayor a 0");
                response.setCodeStatus("0x003");
                return response;
            }

            Optional<ArrayEntity> dataDb = arrayService.getById(dataStackId);

            //-- Valida que la pila de datos se encuentra disponible en la DB
            if(dataDb == null){
                response.setStatus(false);
                response.setMessage("La pila de datos no se encontró");
                response.setCodeStatus("0x004");
                return response;
            }

            //-- Arreglo de numeros primos
            List<Integer> arrayP = getPrimeNumbers(iterations);

            //-- Arreglo de vasos que se obtiene del resultado de la consulta de la base de datos
            List<Integer> arrayA = parseInputArrayToIntArray(dataDb.get().getInput_array());

            //-- Arreglo que contiene la respuesta solicitada
            List<Integer> finalArray = new ArrayList<>();

            //-- Arreglo de la traza del proceso
            List<InterationDto> interactions = new ArrayList<>();

            for(Integer q = 0; q < iterations; q++){
                //-- Arreglo de numeros divisibles
                List<Integer> arrayB = new ArrayList<>();

                //-- Arreglo de numeros no divisibles
                List<Integer> arrayAi = new ArrayList<>();

                for (int value : arrayA) {
                    //-- Verifica si el numero de la iteracion es divisible por el numero primo de la iteracion principal
                    if (value % arrayP.get(q) == 0) {
                        arrayB.add(value);
                    } else {
                        arrayAi.add(value);
                    }
                }

                List<Integer> responseArray = new ArrayList<>();
                responseArray.addAll(finalArray);

                //-- Agrega todos los numeros divisibles a la respuesta final
                finalArray.addAll(arrayB);
                responseArray.addAll(arrayB);

                interactions.add(new InterationDto(arrayB, arrayAi, responseArray));

                //-- Determina el nuevo arreglo que se debe iterar
                arrayA = parseArrayInt(arrayAi.stream().mapToInt(Integer::intValue).toArray());
            }

            //-- Registra los numeros de la ultima iteracion a la respuesta final
            for (int item : arrayA) {
                finalArray.add(item);
            }
            
            response.getData().setProcess(interactions);
            response.getData().setResponse(finalArray);
            return response;
        }catch(Exception ex){
            response.setStatus(false);
            response.setCodeStatus("0x990");
            response.setMessage(ex.getMessage());
            return response;
        }
    }

    private static List<Integer> getPrimeNumbers(Integer to){
        List<Integer> intList = new ArrayList<>();
        Integer numberToEvaluate = 2;

        while (intList.size() < to) {
            if (isPrimeNumber(numberToEvaluate)) {
                intList.add(numberToEvaluate);
            }
            numberToEvaluate++;
        }

        List<Integer> arrayResult = new ArrayList<>();
        for (Integer i = 0; i < intList.size(); i++) {
            arrayResult.add(intList.get(i));
        }
        return arrayResult;
    }

    private static boolean isPrimeNumber(Integer number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int limit = (int) Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static List<Integer> parseInputArrayToIntArray(String inputArray) {
        String[] dataSplitted = inputArray.split(",");
        List<Integer> dataReturn = new ArrayList<>();
        for (Integer i = 0; i < dataSplitted.length; i++) {
            dataReturn.add(Integer.parseInt(dataSplitted[i]));
        }
        Collections.sort(dataReturn, Collections.reverseOrder());
        return dataReturn;
    }

    private static List<Integer> parseArrayInt(int[] array){
        List<Integer> dataReturn = new ArrayList<>();
        for (int item : array) {
            dataReturn.add(item);
        }
        return dataReturn;
    }
}