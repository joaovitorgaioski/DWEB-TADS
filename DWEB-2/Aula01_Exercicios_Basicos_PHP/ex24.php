<?php

function saudar($nome, $periodo) {
    switch ($periodo){
        case "manha":
            echo "Bom dia!"; break;
        
        case "tarde":
            echo "Boa tarde!"; break;
            
        case "noite":
            echo "Boa noite!"; break;
        
        default:
            echo "Olá!"; break;
    }

    echo " " . $nome;
}

saudar("João", "tarde");