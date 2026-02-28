<?php

function calcularIdade($ano) {
    return (2026 - $ano >= 18);
}

echo calcularIdade(2007) ? "Verdadeiro" : "Falso";