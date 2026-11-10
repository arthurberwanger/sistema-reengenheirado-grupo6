# Sistema Reengenheirado - Grupo 6

Repositório GitHub: https://github.com/arthurberwanger/sistema-reengenheirado-grupo6

Projeto Java 8+ que refatora o cálculo de faturamento do relatório do Grupo 6 usando Strategy, Factory e dependências substituíveis. O exemplo principal mantém o resultado legado `279.5`.

## Executar localmente

Com Java 8+ e Maven instalados:

```sh
mvn -B verify
java -jar target/sistema-reengenheirado-1.0.0.jar
```

Para construir e executar a imagem Docker localmente:

```sh
docker build -t sistema-reengenheirado:local .
docker run --rm sistema-reengenheirado:local
```

## Configuração no GitHub

O workflow `.github/workflows/ci-cd.yml` só responde ao push de tags que começam com `v`. Ele compila o projeto, executa os testes e gera cobertura para o SonarCloud; depois aguarda o Quality Gate, verifica dependências e a imagem base de produção com Trivy. O job de build e push do Docker depende do sucesso integral do job de qualidade.

No SonarCloud, importe o repositório e crie as Actions variables do GitHub:

- `SONAR_ORGANIZATION`: chave da organização no SonarCloud.
- `SONAR_PROJECT_KEY`: chave do projeto no SonarCloud.

Cadastre estes GitHub Actions secrets:

- `SONAR_TOKEN`: token de análise do SonarCloud.
- `DOCKER_USERNAME`: usuário do Docker Hub.
- `DOCKER_PASSWORD`: token de acesso do Docker Hub.

Crie no Docker Hub o repositório público `sistema-reengenheirado`. Para lançar uma versão, faça commit e push normalmente e, em seguida, publique uma tag, por exemplo:

```sh
git tag v1.0.0
git push origin v1.0.0
```

Pushes de branches sem tag não acionam este workflow. O SonarCloud calcula a complexidade ciclomática (métrica exibida como `Complexity`) e relata code smells e duplicações no projeto. A configuração `sonar.qualitygate.wait=true` faz a análise falhar se o Quality Gate reprovar.

## Relatório de entrega

Use `RELATORIO_CICD.md` como complemento do PDF anterior. Ele inclui o ensaio crítico final e os itens que precisam de evidência real após a primeira execução: links públicos, captura do painel do SonarCloud e captura dos logs do Trivy. Essas evidências não podem ser preenchidas antes de criar as integrações e publicar uma tag.