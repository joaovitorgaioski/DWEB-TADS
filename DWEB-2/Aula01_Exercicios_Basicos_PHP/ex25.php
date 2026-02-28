<?php

function classificarIMC($peso, $altura) {
    $imc = $peso / ($altura * $altura);
    
    if ($imc <= 18) {
        return "Baixo peso";
    } elseif ($imc <= 27){
        return "Peso normal";
    }else {
        return "Sobrepeso";
    }
}

echo classificarIMC(100, 1.70);