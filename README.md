## 💫 Sobre o projeto

Trata-se de uma aplicação criada com base nas duas primeiras Aulas do evento Imersão Java promovida pela Alura, nas aulas são apresentados alguns conceitos basilares da linguagem Java e também realizamos o consumo de uma API externa e criação de Figurinhas para WhatsApp/Telegram sem utilizar nenhuma biblioteca, apenas o bom e velho Java☕.

---

## 🤓 Tecnologias utilizadas

* 🔤 Lang - JAVA

---

## 🖼🖌Telas do projeto

* Menu.

![Menu_](https://user-images.githubusercontent.com/61207420/180113004-5e8682a2-b70e-4ed2-b3a2-027ce5e549c8.gif)

* Listando Melhores Filmes.

![ShowMovies_](https://user-images.githubusercontent.com/61207420/180113425-8bf5bf4f-d117-4e31-ab37-75a75a8ca819.gif)

* Listando Melhores Séries.

![ShowSeries_](https://user-images.githubusercontent.com/61207420/180113430-0bc04d3d-21ae-4fc2-9931-7098751ba326.gif)

* Realizando Voto em um título.

![Vote_](https://user-images.githubusercontent.com/61207420/180113613-88e9a400-9076-46d4-bff3-cdd210a03197.gif)

* Gerando Stickers.

![GenStickers_](https://user-images.githubusercontent.com/61207420/180113441-72b981fb-1953-4282-ab6c-19f2fe7fc589.gif)

* Validações de Input.

![Validacoes_](https://user-images.githubusercontent.com/61207420/180113446-b00b6490-c146-4275-ada3-0c80622a1958.gif)

* Saindo da aplicação.

![Exit_](https://user-images.githubusercontent.com/61207420/180113459-8587af6d-f934-457e-8869-ec59837d8dcf.gif)

---

## 🎯 Desafios da 1 Aula

1. Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.

>Resolução: Utilizei um mock da API do The Movie Database para trazer as melhores Séries.

---

2. Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!

>Resolução: Hehe como visto nas telas da aplicação ficou show! 💯

---

3. Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente

>Resolução: Minha abordagem nesse desafio foi de utilizar [váriaveis de ambiente](https://pt.stackoverflow.com/questions/339476/o-que-s%C3%A3o-vari%C3%A1veis-de-ambiente) para externalizar as "chaves da API" que nesse caso foram as rotas.

<br/>
⚠️⚠️⚠️ ATENÇÃO - Caso for testar a aplicação definir a seguintes variáveis de ambiente:

```bash
export PATH_SERIES='01949919-1500-4617-8ba6-e3470e7eafe7'
export PATH_MOVIES='31f67bc7-2e21-406d-bcd0-4bd49369fd30'
```
Não se tratam de dados sensíveis no meu contexto, são apenas a rota de cada API, mas essa abordagem você poderia estar utilizando para isso.

---

4. Mudar o JsonParser para usar uma biblioteca de parsing de JSON como Jackson ou GSON.

>Resolução: Como meu intuito com esse projeto era não utilizar nenhuma lib irei solucionar esse desafio em outro repositório e usando o framework [Quarkus](https://quarkus.io/).

---

5. **Desafio supremo**: criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.

>Resolução: Desenvolvida lógica para receber com [Classe Scanner](https://www.devmedia.com.br/como-funciona-a-classe-scanner-do-java/28448) os inputs do usuário para ir somando votos utilizando o objeto ItemDto para armazenar esses votos em memória. 

---

## 🧑‍💻 Como iniciar a aplicação

Basta possuir uma JDK superior a 9 e realizar os comandos no diretório do projeto:
```
javac -d bin -cp .:src/ src/App.java 
```
```
cd bin && java App
```

Comandos válidos no Linux com a distro Ubuntu.

Ou você também pode executar com enorme facilidade em uma IDE ou no VS Code.

---

## 📃 Licença

Este projeto está sobre a licença [MIT](LICENSE).
