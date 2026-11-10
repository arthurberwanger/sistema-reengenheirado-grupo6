# Relatório de CI/CD - Grupo 6

Este documento complementa o [Relatorio_Reengenharia_Grupo6.pdf](Relatorio_Reengenharia_Grupo6.pdf). Complete os campos de evidência depois de executar a esteira no repositório público do grupo.

## Estado da implementação (09/11/2026)

- Build Maven local: `mvn -B verify` concluído com 19 testes aprovados; JaCoCo registrou cobertura de 96,6% das linhas e 92,6% dos branches.
- Imagem Docker local: build concluído e container executado com sucesso; `docker run --rm sistema-reengenheirado:local` imprimiu `279.5`.
- Trivy local: scan do `pom.xml` e da imagem base `eclipse-temurin:17-jre-alpine` sem vulnerabilidades HIGH/CRITICAL corrigíveis, na data acima.
- GitHub Actions, Quality Gate do SonarCloud, scans Trivy no runner e publicação no Docker Hub: aguardando os commits e o push de uma tag `v*` feitos pelo líder. Nenhum push foi feito por este trabalho.
- Evidências remotas e imagem pública: pendentes. Não substituir os itens de evidência abaixo por capturas locais.

## Entrega

- Repositório GitHub público: https://github.com/arthurberwanger/sistema-reengenheirado-grupo6
- Imagem pública no Docker Hub: **[inserir link]**
- Versão publicada (tag): **[inserir tag, por exemplo v1.0.0]**

## Evidências da esteira

- SonarCloud: inserir captura do dashboard com `Complexity` (complexidade ciclomática), code smells, duplicações e status do Quality Gate.
- Trivy: inserir captura dos logs do job no GitHub Actions mostrando a tabela e o resultado do scan de dependências e imagens base.
- Publicação Docker Hub: inserir link ou captura da tag publicada automaticamente.

## Ensaio crítico final

Ao longo do semestre, vimos que a entropia de software cresce quando mudanças sucessivas tornam o sistema mais difícil de entender e quando decisões de manutenção ficam sem verificação contínua. A reengenharia do faturamento reduziu parte dessa entropia ao explicitar as regras em estratégias separadas, substituir números mágicos por constantes e concentrar a seleção das regras em uma fábrica. Isso torna as mudanças mais localizadas e deixa visível onde cada regra de negócio deve evoluir.

A esteira transforma essa disciplina em uma rotina de lançamento: a análise do Sonar acompanha complexidade, code smells e duplicações, enquanto o Trivy procura vulnerabilidades nas dependências e nas imagens base. Como o push da imagem depende da aprovação desses controles, problemas encontrados deixam de ser apenas itens conhecidos de débito técnico e passam a impedir uma nova versão até serem tratados. O processo não elimina o débito técnico por si só, mas ajuda a detectá-lo cedo e reduz a chance de ele se acumular sem ser percebido.

## Como preencher as evidências

1. Publique o projeto em um repositório GitHub público e configure os secrets e variables descritos no README.
2. Envie uma tag `v*` para iniciar o workflow.
3. Se os quality gates passarem, confirme a imagem versionada no Docker Hub.
4. Capture as telas reais do SonarCloud e dos logs Trivy e insira-as neste relatório antes de exportar para PDF.