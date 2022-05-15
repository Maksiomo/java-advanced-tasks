# Maven

1. Project management
2. Maven
    - POM - project object model
    - Wrapper
3. Artifact
    - group id
    - artifact id
    - version
        - default
        - snapshot
4. Lifecycle
    - clean
    - validate
    - compile
    - test
    - package
    - verify
    - install
    - deploy
    - site
5. Plugins
6. Packaging
    - jar
    - pom
    - war
7. Properties
8. Maven archetypes
9. Multi-module project
10. Dependencies
    - scope
        - compile
        - provided
        - test
        - runtime
        - import
    - local repo
    - remote repo
11. DependenciesManagement

## Инициализация проекта

Создание проекта: `mvn archetype:generate`

Рекомендуемый архетип проекта: `maven-archetype-quickstart`

## Оболочки

### Создание оболочки используя maven:

`mvn -N wrapper:wrapper`

### Установка вручную оболочки:

1. Clone git repo: `git clone https://github.com/rassafel/java-advanced-learn.git`
2. Копировать следущие файлы/директории в корень своего репозитория:
    - .mvn
    - mvnw
    - mvnw.cmd
3. Добавить `pom.xml` в корень своего репозитория

