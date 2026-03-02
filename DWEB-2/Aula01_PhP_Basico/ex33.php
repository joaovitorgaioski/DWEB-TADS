<?php

$nomes = ["Eren", "Jonathan", "Anya", "Eren", "Saitama", "Ranma", "Moritz", "Anya", "Jonathan", "Saitama"];

function removerDuplicatas($nomes) {
    return array_unique($nomes);
}

var_dump(removerDuplicatas($nomes));