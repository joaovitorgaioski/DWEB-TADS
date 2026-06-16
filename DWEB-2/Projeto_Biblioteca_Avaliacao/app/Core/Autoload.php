<?php
spl_autoload_register(function ($classe) {
    $baseDir = __DIR__ . '/../';
    $classe = str_replace('App\\', '', $classe);
    $arquivo = $baseDir . str_replace('\\', '/', $classe) . '.php';

    if (file_exists($arquivo)) {
        require $arquivo;
    }
});
