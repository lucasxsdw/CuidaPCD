Passo a passo para instalação do sistema: 

Instalar programas:

	1)Baixar o Visual Studio- https://code.visualstudio.com/
	2)Baixar o java jdk 21 - https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe
	3)Baixar MySQL workbeanch- https://dev.mysql.com/downloads/installer/
	4)Baixar Workbeanch - https://dev.mysql.com/downloads/workbench/

Configurando ambiente no Visual studio: 

	1)Baixar extenção "Spring Boot Extension Pack".
	2)Baixar extenção "Extension Pack for Java".
	3)Configurar o sistema para usar o JDK21
    4)Caso queira configurar somente o vscode para usar o jdk21 sigas os seguintes passos:
    -Vá em files no canto superior esquerdo
    -Vá em preferences e depois em settings
    - pesquise Java Home e clique no edit in settings.json
    -Coloque o diretorio que foi baixado o jdk21, como no exemplo a seguir:
        "java.jdt.ls.java.home": "C:\\Program Files\\Java\\jdk-21"
    -Salve e reinicie o vscode

Configurar o mysql
	
	1) Criar um novo MySQL CONNECTIONS.
	2) Colocar algum nome na conexão.
	3) Coloca o hostname: localhost 
    3.5) Coloca o port: 3306
	4) Username: javaSQL
 	5) Senha: javinha
	
	6) Volta em alguma conexão que tem permissão root 
	7) Da as permissões de root para o usuario javaSQL com esse comando:
 	 -CREATE USER 'javaSQL'@'localhost' IDENTIFIED BY 'javinha'; 
	 -GRANT ALL PRIVILEGES ON * . * TO 'javaSQL'@'localhost';
	 -Flush Privileges;

Após dar as permissões para o usuario javaSQL , entre na conexão
	8) Após abrir, Cole e execute o script que está na pasta BD"

Após toda configuração do banco , vscode e java. 

1) Abrir o projeto "CuidaPcD" no visual studio.
2) As pastas de codifação estão na pasta "Springboot"
3) na pasta src/main estão os codigos em java e os codigos em js html css
4) Ao clicar em algum arquivo .java e carregar o java projects ira aparecer um icone a esquerda de um botão de ligar, clique nele
5) Dê play no cuidapcd
6) Digite "localhost:8080/" no navegador e utilize o site
