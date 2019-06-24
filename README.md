# BlueBOX Android App v1.0.0

# O que é BlueBOX?
BlueBOX é uma tecnologia assistiva com foco na aprendizagem do Braille que faz a conversão de textos em "tinta" para o Braille.

# Como a BlueBOX se comunica?
A BlueBOX se comunica através do protocolo de comunicação sem fio Bluetooth, que tem como requisito a recepção das letras em Braille/Binário (conforme coversão [BlueBOX Letter Enum](https://github.com/meyer20/BlueBOX/blob/master/app/src/main/java/com/bluebox/LetterEnum.java)).

# Requisitos mínimos
- Dispositivo Android acima da versão 4.0.3 (API level 15)
- Dispositivo Android com Bluetooth

# Ponto de atenção
Como a BlueBOX é um sistema experimental e em fase de acabamento, alguns pontos do código foram construídos de forma estática, como a conexão Bluetooth, que está sendo realizada apenas se o dispositivo concetado seja de nome "HC-05" (Nome padrão do módulo Bluetooth utilizado no dispositivo BlueBOX).

# [Dispositivo BlueBOX](https://github.com/meyer20/BlueBOX-Device)
