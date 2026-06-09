<?php 

    class Jogo {

        public $fase;
        public $data;
        public $selecao1;
        public $selecao2;
        public $gols1;
        public $gols2;
        public $faltas1;
        public $faltas2;
        public $cartoes_amarelos1;
        public $cartoes_amarelos2;
        public $cartoes_vermelhos1;
        public $cartoes_vermelhos2;
        public $publico;

        public function __construct($dados) {
        
            $this->fase = $dados[0];
            $this->data = $dados[1];
            $this->selecao1 = $dados[2];
            $this->selecao2 = $dados[3];
            $this->gols1 = $dados[4];
            $this->gols2 = $dados[5];
            $this->faltas1 = $dados[6];
            $this->faltas2 = $dados[7];
            $this->cartoes_amarelos1 = $dados[8];
            $this->cartoes_amarelos2 = $dados[9];
            $this->cartoes_vermelhos1 = $dados[10];
            $this->cartoes_vermelhos2 = $dados[11];
            $this->publico = $dados[12];
        
        }

    }


?>